package com.dogoo.sample.pet.rest.internal.mapper;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.Dog;
import com.dogoo.sample.pet.rest.dto.v2_0.DogApproval;
import com.dogoo.sample.pet.service.mapper.model.DogMapperModel;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.dogoo.sample.pet.service.service.DogEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = DogMapper.class
)
public class DogMapper {

    public Dog mapDogFromDogEntry(DogEntry from){
        Dog to = new Dog();

        to.setId(from.getPrimaryKey());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setTitle(from.getTitle());
        to.setWeight(GetterUtil.getLong(from.getWeight()));
        to.setColor(from.getColor());
        to.setStatus(Dog.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());
        to.setCreatedDate(from.getCreateDate());

        to.setAnimalGroup(
                _animalGroupMapper.mapAnimalGroupFromAnimalGroupEntry(
                        _animalGroupEntryLocalService
                                .fetchAnimalGroupEntry(from.getAnimalGroupId())));
        to.setAnimalTags(
                TransformUtil.transformToArray(
                        _animalTagEntryLocalService.getDogEntryAnimalTagEntries(from.getDogId()),
                        tagEntry -> _animalTagMapper.mapAnimalTagFromAnimalTagEntry(tagEntry),
                        AnimalTag.class));

        return to;
    }

    public DogApproval mapDogApprovalFromDogEntry(DogEntry from){
        DogApproval to = new DogApproval();

        to.setId(from.getPrimaryKey());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setTitle(from.getTitle());
        to.setWeight(GetterUtil.getLong(from.getWeight()));
        to.setColor(from.getColor());
        to.setStatus(DogApproval.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());
        to.setCreatedDate(from.getCreateDate());

        to.setAnimalGroupNew(
                _animalGroupMapper.mapAnimalGroupFromAnimalGroupEntry(
                        _animalGroupEntryLocalService
                                .fetchAnimalGroupEntry(from.getAnimalGroupId())));
                                
        to.setAnimalTags(
                TransformUtil.transformToArray(
                        _animalTagEntryLocalService.getDogEntryAnimalTagEntries(from.getDogId()),
                        tagEntry -> _animalTagMapper.mapAnimalTagFromAnimalTagEntry(tagEntry),
                        AnimalTag.class));

        return to;
    }

    public DogMapperModel mapDogMapperModelFromDog(Dog from){
        DogMapperModel to = new DogMapperModel();

        to.setName(from.getName());
        to.setColor(from.getColor());
        to.setTitle(from.getTitle());
        to.setWeight(from.getWeight());
        to.setAnimalGroupId(from.getAnimalGroupId());
        to.setAnimalTags(GetterUtil.getStringValues(from.getAnimalTagNames(), new String[]{}));
        to.setStatus(Dog.Status.PENDING.getValue());

        return to;
    }

    public long getDogEntryId(String referenceCode){
        DogEntry entry = getObject(referenceCode);

        if(Validator.isNull(entry)) {
            return 0l;
        }

        return entry.getDogId();
    }

    public DogEntry getObject(String referenceCode){
        DogEntry entry =
                _dogEntryLocalService.fetchDogEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(),
                        referenceCode);

        return entry;
    }

    @Reference
    private DogEntryLocalService _dogEntryLocalService;

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;

    @Reference
    private AnimalGroupMapper _animalGroupMapper;

    @Reference
    private AnimalTagMapper _animalTagMapper;
}
