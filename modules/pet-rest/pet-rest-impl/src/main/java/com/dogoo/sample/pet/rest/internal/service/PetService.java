package com.dogoo.sample.pet.rest.internal.service;

import com.dogoo.sample.pet.rest.dto.v2_0.Pet;
import com.dogoo.sample.pet.rest.dto.v2_0.PetApproval;
import com.dogoo.sample.pet.rest.internal.mapper.PetMapper;
import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.mapper.model.PetMapperModel;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.service.PetEntryLocalService;
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
        service = PetService.class
)
public class PetService {

    public Page<Pet> getPetsPage(long customerId,
                                 String search,
                                 String node,
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
                PetEntry.class.getName(),
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
                    long petId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _petMapper.mapPetFromPetEntry(
                            _petEntryLocalService.getPetEntry(petId), node);
                });

    }

    public Page<Pet> getPetsPageByGroupId(long customerId,
                                          long groupId,
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

                    TermFilter groupIdFilter =
                            new TermFilter(SearchFields.ANIMAL_GROUP_ID, String.valueOf(groupId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                    booleanFilter.add(groupIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                PetEntry.class.getName(),
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
                    long petId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return _petMapper.mapPetFromPetEntry(
                            _petEntryLocalService.getPetEntry(petId));
                });
    }

    public Pet addPet(long customerId,
                      long creatorId,
                      String node,
                      Pet pet,
                      ServiceContext context) {

        PetMapperModel petMapperModel = _petMapper.mapPetMapperModelFromPet(pet);

        PetEntry entry = _petEntryLocalService.addPetEntry(
                customerId,
                creatorId,
                petMapperModel,
                context);

        return _petMapper.mapPetFromPetEntry(entry, node);
    }

    public Pet updatePet(long creatorId,
                         long petId,
                         Pet pet,
                         ServiceContext context)
            throws PortalException {

        PetMapperModel petMapperModel = _petMapper.mapPetMapperModelFromPet(pet);

        PetEntry entry = _petEntryLocalService.updatePetEntry(
                creatorId,
                petId,
                petMapperModel,
                context);

        return _petMapper.mapPetFromPetEntry(entry);
    }

    public PetApproval approvalPet(long creatorId,
                                   long petId,
                                   PetApproval petApproval,
                                   ServiceContext context)
            throws PortalException {

        PetEntry entry =
                _petEntryLocalService.approvalPetEntry(
                        creatorId,
                        petId,
                        petApproval.getStatus().getValue(),
                        context);

        return _petMapper.mapPetApprovalFromPetEntry(entry);
    }

    public Pet getPetById(long petId) throws PortalException {

        PetEntry entry = _petEntryLocalService.getPetEntry(petId);

        return _petMapper.mapPetFromPetEntry(entry);
    }

    public void deletePet(long petId) throws PortalException {
        _petEntryLocalService.deletePetEntry(petId);
    }

    public void deletePetBatch(long creatorId,
                               long [] petIds,
                               ServiceContext context)
            throws PortalException {

        _petEntryLocalService.removeAnimalGroupBatch(creatorId, petIds, context);
    }

    public void addPetsToGroup(long creatorId,
                               long groupId,
                               long [] petIds,
                               ServiceContext context)
            throws PortalException {
        _petEntryLocalService.changeAnimalGroupBatch(creatorId, petIds, groupId, context);
    }

    @Reference
    private PetMapper _petMapper;

    @Reference
    private PetEntryLocalService _petEntryLocalService;
}
