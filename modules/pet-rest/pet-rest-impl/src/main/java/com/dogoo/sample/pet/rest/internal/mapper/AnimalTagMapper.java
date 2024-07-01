package com.dogoo.sample.pet.rest.internal.mapper;

import com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTagApproved;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = AnimalTagMapper.class
)
public class AnimalTagMapper {

    public AnimalTagApproved mapAnimalTagApprovedFromAnimalTagEntry(AnimalTagEntry from) {
        AnimalTagApproved to = new AnimalTagApproved();

        to.setId(from.getAnimalTagId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setCreatedDate(from.getCreateDate());
        to.setStatus(AnimalTagApproved.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());

        return to;
    }

    public AnimalTag mapAnimalTagFromAnimalTagEntry(AnimalTagEntry from) {
        AnimalTag to = new AnimalTag();

        to.setId(from.getAnimalTagId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setCreatedDate(from.getCreateDate());
        to.setStatus(AnimalTag.Status.create(from.getStatus()));
        to.setStatusDate(from.getStatusDate());

        return to;
    }

    public AnimalTagMapperModel mapAnimalTagMapperModelFromAnimalTag(AnimalTag from){
        AnimalTagMapperModel to = new AnimalTagMapperModel();

        to.setName(from.getName());
        to.setDesc(from.getDescription());
        to.setStatus(AnimalTag.Status.PENDING.getValue());

        return to;
    }

    public long getAnimalTagEntryId(String extRefCode) {
        AnimalTagEntry entry = getObject(extRefCode);

        if (Validator.isNull(entry)) {return 0l;}

        return entry.getAnimalTagId();
    }

    public AnimalTagEntry getObject(String extRefCode) {
        AnimalTagEntry animalTagEntry =
                _animalTagEntryLocalService.fetchAnimalTagEntryByExternalReferenceCode(
                        CompanyThreadLocal.getCompanyId(), extRefCode);

        if (animalTagEntry == null) {
            animalTagEntry = _animalTagEntryLocalService.fetchAnimalTagEntry(GetterUtil.getLong(extRefCode));
        }

        return animalTagEntry;
    }

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;
}
