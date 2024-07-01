package com.dogoo.sample.pet.rest.internal.mapper;

import com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalGroup;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = AnimalGroupMapper.class
)
public class AnimalGroupMapper {

    public AnimalGroup mapAnimalGroupFromAnimalGroupEntry(AnimalGroupEntry from) {
        AnimalGroup to = new AnimalGroup();

        to.setId(from.getAnimalGroupId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setCreatedDate(from.getCreateDate());

        return to;
    }

    public AnimalGroupMapperModel mapAnimalGroupMapperModelFromAnimalGroup(AnimalGroup from){
        AnimalGroupMapperModel to = new AnimalGroupMapperModel();

        to.setName(from.getName());
        to.setDescription(from.getDescription());

        return to;
    }

    public long getAnimalGroupEntryId(String extRefCode) {
        AnimalGroupEntry entry = getObject(extRefCode);

        if (Validator.isNull(entry)) {return 0l;}

        return entry.getAnimalGroupId();
    }

    public AnimalGroupEntry getObject(String extRefCode) {
        AnimalGroupEntry animalGroupEntry =
                _animalGroupEntryLocalService.fetchAnimalGroupEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(), extRefCode);

        if (animalGroupEntry == null) {
            animalGroupEntry = _animalGroupEntryLocalService.fetchAnimalGroupEntry(GetterUtil.getLong(extRefCode));
        }

        return animalGroupEntry;
    }

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;
}
