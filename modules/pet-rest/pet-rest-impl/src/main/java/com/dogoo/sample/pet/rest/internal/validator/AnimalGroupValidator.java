package com.dogoo.sample.pet.rest.internal.validator;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalGroup;
import com.dogoo.sample.pet.rest.internal.exception.DG_FieldRequiredException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NameDuplicateException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NoSuchEntryException;
import com.dogoo.sample.pet.rest.internal.service.LanguageService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Locale;

@Component(
        immediate = true,
        service = AnimalGroupValidator.class
)
public class AnimalGroupValidator {

    public void validatorForUpdateAnimalGroup(long customerId,
                                              long animalGroupId,
                                              AnimalGroup animalGroup,
                                              Locale locale)
            throws DG_FieldRequiredException, DG_NoSuchEntryException, DG_NameDuplicateException {

        isNotPopulated(animalGroup.getName(), LanguageKeys.ANIMAL_GROUP_NAME_NOT_PROVIDED, locale);
        validateAnimalGroupExist(animalGroupId, locale);
        validateDuplicateNameForUpdate(customerId, animalGroupId, animalGroup, locale);
    }

    public void validateForAddAnimalGroup(long customerId,
                                          AnimalGroup animalGroup,
                                          Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException {

        isNotPopulated(
                animalGroup.getName(),
                LanguageKeys.ANIMAL_GROUP_NAME_NOT_PROVIDED,
                locale);

        validateDuplicateNameForAdd(customerId, animalGroup, locale);
    }

    public void validateAnimalGroupExist(long animalGroupId,
                                         Locale locale)
            throws DG_NoSuchEntryException {

        AnimalGroupEntry groupEntry =
                _animalGroupEntryLocalService.fetchAnimalGroupEntry(animalGroupId);

        if (Validator.isNotNull(groupEntry)) { return; }

        throw new DG_NoSuchEntryException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_GROUP_NOT_FOUND));
    }

    private void validateDuplicateNameForUpdate(long customerId,
                                                long animalGroupId,
                                                AnimalGroup animalGroup,
                                                Locale locale) throws DG_NameDuplicateException {

        List<AnimalGroupEntry> entries =
                _animalGroupEntryLocalService.findAnimalGroupByName(
                        customerId, animalGroup.getName());

        if (entries.size() == 0) {
            return;
        }

        if (entries.stream().anyMatch(entry -> entry.getAnimalGroupId() == animalGroupId)) {
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_GROUP_NAME_DUPLICATE));
    }

    private void validateDuplicateNameForAdd(long customerId,
                                             AnimalGroup animalGroup,
                                             Locale locale) throws DG_NameDuplicateException {

        int count = _animalGroupEntryLocalService
                        .countAnimalGroupByName(customerId, animalGroup.getName());

        if (count == 0) { return; }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_GROUP_NAME_DUPLICATE));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey,
                                Locale locale) throws DG_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;

    @Reference
    private LanguageService _languageService;
}
