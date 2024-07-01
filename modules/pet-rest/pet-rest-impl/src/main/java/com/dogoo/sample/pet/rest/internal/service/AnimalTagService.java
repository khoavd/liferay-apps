package com.dogoo.sample.pet.rest.internal.service;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTagApproved;
import com.dogoo.sample.pet.rest.internal.mapper.AnimalTagMapper;
import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
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
        service = AnimalTagService.class
)
public class AnimalTagService {
    
    public Page<AnimalTag> getPetsPage(long customerId,
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
                AnimalTagEntry.class.getName(),
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
                    long animalTagId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _mapper.mapAnimalTagFromAnimalTagEntry(
                            _animalTagEntryLocalService.getAnimalTagEntry(animalTagId));
                });
    }

    public AnimalTag addAnimalTag(long customerId,
                                  long creatorId,
                                  AnimalTag animalTag,
                                  ServiceContext context) {

        AnimalTagMapperModel animalTagMapperModel =
                _mapper.mapAnimalTagMapperModelFromAnimalTag(animalTag);

        AnimalTagEntry animalTagEntry =
                _animalTagEntryLocalService.addAnimalTag(
                        customerId,
                        creatorId,
                        animalTagMapperModel,
                        context);

        return _mapper.mapAnimalTagFromAnimalTagEntry(animalTagEntry);
    }

    public AnimalTag updateAnimalTag(long creatorId,
                                     long tagId,
                                     AnimalTag animalTag,
                                     ServiceContext context) throws PortalException {

        AnimalTagMapperModel animalTagMapperModel =
                _mapper.mapAnimalTagMapperModelFromAnimalTag(animalTag);

        AnimalTagEntry animalTagEntry =
                _animalTagEntryLocalService.updateAnimalTag(
                        creatorId,
                        tagId,
                        animalTagMapperModel,
                        context);

        return _mapper.mapAnimalTagFromAnimalTagEntry(animalTagEntry);
    }

    public AnimalTagApproved approvalAnimalTag(long creatorId,
                                       long tagId,
                                       AnimalTagApproved animalTagApproved,
                                       ServiceContext context) throws PortalException {

        AnimalTagEntry animalTagEntry =
                _animalTagEntryLocalService.approvalAnimalTag(
                        creatorId,
                        tagId,
                        animalTagApproved.getStatus().getValue(),
                        context);

        return _mapper.mapAnimalTagApprovedFromAnimalTagEntry(animalTagEntry);
    }

    public void deleteAnimalTag(long tagId) throws PortalException {
        _animalTagEntryLocalService.deleteAnimalTagEntry(tagId);
    }

    public AnimalTag getAnimalTag(long tagId) throws PortalException {
        AnimalTagEntry animalTagEntry = _animalTagEntryLocalService.getAnimalTagEntry(tagId);

        return _mapper.mapAnimalTagFromAnimalTagEntry(animalTagEntry);
    }

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;

    @Reference
    private AnimalTagMapper _mapper;
}
