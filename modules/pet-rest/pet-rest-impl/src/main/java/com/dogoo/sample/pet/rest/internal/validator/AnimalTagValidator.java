package com.dogoo.sample.pet.rest.internal.validator;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTagApproved;
import com.dogoo.sample.pet.rest.internal.exception.DG_FieldRequiredException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NameDuplicateException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NoSuchEntryException;
import com.dogoo.sample.pet.rest.internal.service.LanguageService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;

@Component(
        immediate = true,
        service = AnimalTagValidator.class
)
public class AnimalTagValidator {

    public void validateForApprovalAnimalTag(long animalTagId,
                                             AnimalTagApproved animalTag,
                                             Locale locale)
            throws DG_NoSuchEntryException, DG_FieldRequiredException {

        validateAnimalTagExist(animalTagId, locale);

        if (animalTag.getStatus() == null) {
            throw new DG_FieldRequiredException(
                    _languageService.getMessage(locale, LanguageKeys.ANIMAL_TAG_STATUS_NOT_PROVIDED ));
        }
    }

    public void validateForUpdateAnimalTag(long customerId,
                                           long animalTagId,
                                           AnimalTag animalTag,
                                           Locale locale)
            throws DG_NoSuchEntryException, DG_FieldRequiredException, DG_NameDuplicateException {

        validateAnimalTagExist(animalTagId, locale);

        isNotPopulated(animalTag.getName(), LanguageKeys.ANIMAL_TAG_NAME_NOT_PROVIDED, locale);

        validateDuplicateNameForUpdate(customerId, animalTagId, animalTag, locale);
    }

    public void validateForAddAnimalTag(long customerId,
                                        AnimalTag animalTag,
                                        Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException {

        isNotPopulated(
                animalTag.getName(),
                LanguageKeys.ANIMAL_TAG_NAME_NOT_PROVIDED,
                locale);

        validateDuplicateNameForAdd(customerId, animalTag, locale);
    }

    public void validateAnimalTagExist(long animalTagId,
                                       Locale locale)
            throws DG_NoSuchEntryException {

        AnimalTagEntry tagEntry =
                _animalTagEntryLocalService.fetchAnimalTagEntry(animalTagId);

        if (Validator.isNotNull(tagEntry)) { return; }

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_TAG_NOT_FOUND));
    }

    private void validateDuplicateNameForUpdate(long customerId,
                                                long animalTagId,
                                                AnimalTag animalTag,
                                                Locale locale) throws DG_NameDuplicateException {

        List<AnimalTagEntry> entries =
                _animalTagEntryLocalService.findAnimalTagByName(customerId, animalTag.getName());

        if (entries.size() == 0) {
            return;
        }

        if (entries.stream().anyMatch(entry -> entry.getAnimalTagId() == animalTagId)) {
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_TAG_NOT_FOUND));
    }

    private void validateDuplicateNameForAdd(long customerId,
                                             AnimalTag animalTag,
                                             Locale locale) throws DG_NameDuplicateException {

        int count = _animalTagEntryLocalService
                .countAnimalTagByName(customerId, animalTag.getName());

        if (count == 0) { return; }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_TAG_NAME_DUPLICATE));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey,
                                Locale locale) throws DG_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;

    @Reference
    private LanguageService _languageService;
}
