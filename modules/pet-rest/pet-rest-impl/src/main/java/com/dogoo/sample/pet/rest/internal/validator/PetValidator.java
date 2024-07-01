package com.dogoo.sample.pet.rest.internal.validator;

import com.dogoo.sample.pet.rest.dto.v2_0.Pet;
import com.dogoo.sample.pet.rest.dto.v2_0.PetApproval;
import com.dogoo.sample.pet.rest.internal.exception.DG_FieldRequiredException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NameDuplicateException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NoSuchEntryException;
import com.dogoo.sample.pet.rest.internal.service.LanguageService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.service.PetEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;

@Component(
        immediate = true,
        service = PetValidator.class
)
public class PetValidator {

    public void validateForAdd(long customerId,
                               Pet pet,
                               Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException, DG_NoSuchEntryException {

        isNotPopulated(pet.getName(), LanguageKeys.PET_ENTRY_NAME_NOT_PROVIDED, locale);
        isNotPopulated(pet.getDescription(), LanguageKeys.PET_ENTRY_DESC_NOT_PROVIDED, locale);

        validateNameForAdd(customerId, pet, locale);

        validatePetByGroupId(pet.getAnimalGroupId(), locale);

        validatePetByTagIds(pet.getAnimalTagIds(), locale);
    }

    public void validateForUpdate(long customerId,
                                  long petId,
                                  Pet pet,
                                  Locale locale)
            throws DG_NoSuchEntryException, DG_FieldRequiredException, DG_NameDuplicateException {


        validatePetEntryExist(petId, locale);

        isNotPopulated(pet.getName(), LanguageKeys.PET_ENTRY_NAME_NOT_PROVIDED, locale);
        isNotPopulated(pet.getDescription(), LanguageKeys.PET_ENTRY_DESC_NOT_PROVIDED, locale);

        validateNameForUpdate(customerId, petId, pet, locale);

        validatePetByGroupId(pet.getAnimalGroupId(), locale);

        validatePetByTagIds(pet.getAnimalTagIds(), locale);
    }

    public void validateForApproval(long petId,
                                    PetApproval petApproval,
                                    Locale locale)
            throws DG_NoSuchEntryException, DG_FieldRequiredException {

        validatePetEntryExist(petId, locale);

        if (petApproval.getStatus() == null) {
            throw new DG_FieldRequiredException(
                    _languageService.getMessage(locale, LanguageKeys.PET_ENTRY_STATUS_NOT_PROVIDED ));
        }
    }

    public void validatePetActionByGroupIdBatch(long groupId,
                                                 long [] petIds,
                                                 Locale locale)
            throws DG_NoSuchEntryException {

        for (long petId : petIds) {
            validatePetActionByGroupId(groupId, petId, locale);
        }
    }

    public void validatePetActionByGroupId(long groupId,
                                            long petId,
                                            Locale locale)
            throws DG_NoSuchEntryException {

        _animalGroupValidator.validateAnimalGroupExist(groupId, locale);

        validatePetEntryExist(petId, locale);
    }

    public void validatePetByTagIds(Long [] tagIds,
                                    Locale locale)
            throws DG_NoSuchEntryException {

        for(long tagId : tagIds) {
            _animalTagValidator.validateAnimalTagExist(tagId, locale);
        }
    }

    public void validatePetByGroupId(long groupId,
                                            Locale locale)
            throws DG_NoSuchEntryException {

        _animalGroupValidator.validateAnimalGroupExist(groupId, locale);
    }

    public void validateNameForUpdate(long customerId,
                                      long petId,
                                      Pet pet,
                                      Locale locale)
            throws DG_NameDuplicateException {

        List<PetEntry> entries =
                _petEntryLocalService.findByName(customerId, pet.getName());

        if (entries.size() == 0) {
            return;
        }

        if (entries.stream().anyMatch(entry -> entry.getPetId() == petId)) {
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.PET_ENTRY_NAME_DUPLICATE));
    }

    private void validateNameForAdd(long customerId,
                                    Pet pet,
                                    Locale locale)
            throws DG_NameDuplicateException {

        if (_petEntryLocalService.countByName(customerId, pet.getName()) == 0) {return;}

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.PET_ENTRY_NAME_DUPLICATE));
    }

    public void validatePetEntryExist(long petId,
                                      Locale locale) throws DG_NoSuchEntryException {
        PetEntry petEntry = _petEntryLocalService.fetchPetEntry(petId);

        if(Validator.isNotNull(petEntry)) {return;}

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(locale, LanguageKeys.PET_ENTRY_NOT_FOUND));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey,
                                Locale locale) throws DG_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private PetEntryLocalService _petEntryLocalService;

    @Reference
    private AnimalGroupValidator _animalGroupValidator;

    @Reference
    private AnimalTagValidator _animalTagValidator;
}
