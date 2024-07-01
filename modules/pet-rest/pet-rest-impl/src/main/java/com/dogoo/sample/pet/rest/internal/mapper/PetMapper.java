package com.dogoo.sample.pet.rest.internal.mapper;

import com.dogoo.sample.pet.service.mapper.model.PetMapperModel;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.Pet;
import com.dogoo.sample.pet.rest.dto.v2_0.PetApproval;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.dogoo.sample.pet.service.service.PetEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = PetMapper.class
)
public class PetMapper {

    public PetApproval mapPetApprovalFromPetEntry(PetEntry from) {
        PetApproval to = new PetApproval();

        to.setId(from.getPrimaryKey());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setBrief(from.getBrief());
        to.setGender(GetterUtil.getLong(from.getGender()));
        to.setVaccine(GetterUtil.getBoolean(from.getVaccine()));
        to.setWeight(GetterUtil.getLong(from.getWeight()));
        to.setBirthOfDate(from.getBirthOfDate());
        to.setStatus(PetApproval.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());
        to.setCreatedDate(from.getCreateDate());

        to.setAnimalGroupNew(
                _animalGroupMapper
                        .mapAnimalGroupFromAnimalGroupEntry(
                                _animalGroupEntryLocalService
                                        .fetchAnimalGroupEntry(from.getAnimalGroupId())));
        to.setAnimalTags(
                TransformUtil.transformToArray(
                        _animalTagEntryLocalService.getPetEntryAnimalTagEntries(from.getPetId()),
                        tagEntry -> _animalTagMapper.mapAnimalTagFromAnimalTagEntry(tagEntry),
                        AnimalTag.class));
        return to;
    }

    public Pet mapPetFromPetEntry(PetEntry from, String node) {
        Pet pet = mapPetFromPetEntry(from);
        pet.setNodeName(node);

        return pet;
    }

    public Pet mapPetFromPetEntry(PetEntry from) {
        Pet to = new Pet();

        to.setId(from.getPrimaryKey());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setBrief(from.getBrief());
        to.setGender(GetterUtil.getLong(from.getGender()));
        to.setVaccine(GetterUtil.getBoolean(from.getVaccine()));
        to.setWeight(GetterUtil.getLong(from.getWeight()));
        to.setBirthOfDate(from.getBirthOfDate());
        to.setStatus(Pet.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());
        to.setCreatedDate(from.getCreateDate());

        to.setAnimalGroup(
                _animalGroupMapper
                        .mapAnimalGroupFromAnimalGroupEntry(
                                _animalGroupEntryLocalService
                                        .fetchAnimalGroupEntry(from.getAnimalGroupId())));
        to.setAnimalTags(
                TransformUtil.transformToArray(
                        _animalTagEntryLocalService.getPetEntryAnimalTagEntries(from.getPetId()),
                        tagEntry -> _animalTagMapper.mapAnimalTagFromAnimalTagEntry(tagEntry),
                        AnimalTag.class));
        return to;
    }

    public PetMapperModel mapPetMapperModelFromPet(Pet from){
        PetMapperModel to = new PetMapperModel();

        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setBrief(from.getBrief());
        to.setWeight(from.getWeight());
        to.setGender(GetterUtil.getInteger(from.getGender()));
        to.setVaccine(from.getVaccine());
        to.setBirthOfDate(from.getBirthOfDate());
        to.setStatus(Pet.Status.PENDING.getValue());
        to.setAnimalGroupId(from.getAnimalGroupId());
        to.setAnimalTags(GetterUtil.getLongValues(from.getAnimalTags(), new long[]{}));

        return to;
    }

    public Long [] getPetEntryIds(String [] referenceCodes) {
        return TransformUtil.transform(
                referenceCodes,
                code -> getPetEntryId(code),
                Long.class);
    }

    public long getPetEntryId(String referenceCode) {
        PetEntry entry = getObject(referenceCode);

        if (Validator.isNull(entry)) {return 0l;}

        return entry.getPetId();
    }

    public PetEntry getObject(String referenceCode) {
        PetEntry petEntry =
                _petEntryLocalService.fetchPetEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode);

        if (petEntry == null) {
            petEntry = _petEntryLocalService
                    .fetchPetEntry(GetterUtil.getLong(referenceCode));
        }

        return petEntry;
    }

    @Reference
    private PetEntryLocalService _petEntryLocalService;

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;

    @Reference
    private AnimalGroupMapper _animalGroupMapper;

    @Reference
    private AnimalTagMapper _animalTagMapper;
}
