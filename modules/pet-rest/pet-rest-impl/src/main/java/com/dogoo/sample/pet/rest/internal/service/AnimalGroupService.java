package com.dogoo.sample.pet.rest.internal.service;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalGroup;
import com.dogoo.sample.pet.rest.internal.mapper.AnimalGroupMapper;
import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
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
        service = AnimalGroupService.class
)
public class AnimalGroupService {
    
    public Page<AnimalGroup> getAnimalGroupsPage(long customerId,
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
                AnimalGroupEntry.class.getName(),
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
                    long animalGroupId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _mapper.mapAnimalGroupFromAnimalGroupEntry(
                            _animalGroupEntryLocalService.getAnimalGroupEntry(animalGroupId));
                });
    }

    public AnimalGroup addAnimalGroup(long customerId,
                                      long creatorId,
                                      AnimalGroup animalGroup,
                                      ServiceContext context) {

        AnimalGroupMapperModel animalGroupMapperModel =
                _mapper.mapAnimalGroupMapperModelFromAnimalGroup(animalGroup);

        AnimalGroupEntry animalGroupEntry =
                _animalGroupEntryLocalService.addAnimalGroup(
                        customerId,
                        creatorId,
                        animalGroupMapperModel,
                        context);

        return _mapper.mapAnimalGroupFromAnimalGroupEntry(animalGroupEntry);
    }

    public AnimalGroup updateAnimalGroup(long creatorId,
                                         long animalGroupId,
                                         AnimalGroup animalGroup,
                                         ServiceContext context) throws PortalException {

        AnimalGroupMapperModel animalGroupMapperModel =
                _mapper.mapAnimalGroupMapperModelFromAnimalGroup(animalGroup);

        AnimalGroupEntry animalGroupEntry =
                _animalGroupEntryLocalService.updateAnimalGroup(
                        creatorId,
                        animalGroupId,
                        animalGroupMapperModel,
                        context);

        return _mapper.mapAnimalGroupFromAnimalGroupEntry(animalGroupEntry);
    }

    public void deleteAnimalGroup(long animalGroupId) throws PortalException {
        _animalGroupEntryLocalService.deleteAnimalGroupEntry(animalGroupId);
    }

    public AnimalGroup getAnimalGroup(long animalGroupId) throws PortalException {
        AnimalGroupEntry animalGroupEntry = _animalGroupEntryLocalService.getAnimalGroupEntry(animalGroupId);

        return _mapper.mapAnimalGroupFromAnimalGroupEntry(animalGroupEntry);
    }

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;

    @Reference
    private AnimalGroupMapper _mapper;
}
