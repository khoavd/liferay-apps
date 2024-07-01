package com.dogoo.sample.pet.rest.internal.service;

import com.dogoo.sample.pet.rest.dto.v2_0.Dog;
import com.dogoo.sample.pet.rest.dto.v2_0.DogApproval;
import com.dogoo.sample.pet.rest.internal.mapper.DogMapper;
import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.mapper.model.DogMapperModel;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.DogEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(
        immediate = true,
        service = DogService.class
)
public class DogService {

    public Page<Dog> getDogsPage(long customerId,
                                 String search,
                                 Filter filter,
                                 Pagination pagination,
                                 Sort[] sorts,
                                 ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.CUSTOMER_ID, String.valueOf(customerId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                DogEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long dogId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _dogMapper.mapDogFromDogEntry(
                            _dogEntryLocalService.getDogEntry(dogId));
                });
    }

    public Dog addDog(long customerId,
                      long creatorId,
                      Dog dog,
                      ServiceContext serviceContext){

        DogMapperModel dogMapperModel = _dogMapper.mapDogMapperModelFromDog(dog);

        DogEntry entry = _dogEntryLocalService.addDogEntry(
                customerId,
                creatorId,
                dogMapperModel,
                serviceContext);

        return _dogMapper.mapDogFromDogEntry(entry);
    }

    public Dog updateDog(long customerId,
                         long creatorId,
                         long dogId,
                         Dog dog,
                         ServiceContext serviceContext) throws PortalException {

        DogMapperModel dogMapperModel = _dogMapper.mapDogMapperModelFromDog(dog);

        DogEntry entry = _dogEntryLocalService.updateDogEntry(
                customerId,
                dogId,
                creatorId,
                dogMapperModel,
                serviceContext);

        return _dogMapper.mapDogFromDogEntry(entry);
    }

    public DogApproval approvalDog(long creatorId,
                                   long dogId,
                                   DogApproval dogApproval,
                                   ServiceContext serviceContext) throws PortalException {

        DogEntry entry =
                _dogEntryLocalService.approvalDogEntry(
                        creatorId,
                        dogId,
                        dogApproval.getStatus().getValue(),
                        serviceContext);

        return _dogMapper.mapDogApprovalFromDogEntry(entry);
    }

    public Dog getDogById(long dogId) throws PortalException {
        DogEntry entry = _dogEntryLocalService.getDogEntry(dogId);

        return _dogMapper.mapDogFromDogEntry(entry);
    }

    public void deleteDog(long dogId) throws PortalException {
        _dogEntryLocalService.deleteDogEntry(dogId);
    }

    @Reference
    private DogMapper _dogMapper;

    @Reference
    private DogEntryLocalService _dogEntryLocalService;
}
