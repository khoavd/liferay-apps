package com.dogoo.sample.pet.rest.internal.validator;

import com.dogoo.sample.pet.rest.dto.v2_0.Dog;
import com.dogoo.sample.pet.rest.dto.v2_0.DogApproval;
import com.dogoo.sample.pet.rest.internal.exception.DG_FieldRequiredException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NameDuplicateException;
import com.dogoo.sample.pet.rest.internal.exception.DG_NoSuchEntryException;
import com.dogoo.sample.pet.rest.internal.service.LanguageService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.service.exception.NoSuchDogEntryException;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.dogoo.sample.pet.service.service.DogEntryLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component(
        immediate = true,
        service = DogValidator.class
)
public class DogValidator {

    public void validateForAdd(long customerId,
                               Dog dog,
                               Locale locale)
            throws DG_FieldRequiredException, DG_NameDuplicateException, DG_NoSuchEntryException {

        isNotPopulated(dog.getName(), LanguageKeys.DOG_ENTRY_NAME_NOT_PROVIDED, locale);
        isNotPopulated(dog.getTitle(), LanguageKeys.DOG_ENTRY_TITLE_NOT_PROVIDED, locale);

        validateDuplicateNameForAdd(customerId, dog, locale);
        validateDogByGroupId(dog.getAnimalGroupId(), locale);
        validateDogByTagNames(customerId, dog.getAnimalTagNames(), locale);
    }

    public void validateForUpdate(long customerId,
                                  long dogId,
                                  Dog dog,
                                  Locale locale)
            throws
            NoSuchDogEntryException,
            DG_FieldRequiredException,
            DG_NameDuplicateException, DG_NoSuchEntryException {

        validateDogEntryExist(dogId, locale);

        isNotPopulated(dog.getName(), LanguageKeys.DOG_ENTRY_NAME_NOT_PROVIDED, locale);
        isNotPopulated(dog.getTitle(), LanguageKeys.DOG_ENTRY_TITLE_NOT_PROVIDED, locale);

        validateDuplicateNameForUpdate(customerId, dogId, dog, locale);
        validateDogByGroupId(dog.getAnimalGroupId(), locale);
        validateDogByTagNames(customerId, dog.getAnimalTagNames(), locale);
    }

    public void validateForApproval(long dogId,
                                    DogApproval dogApproval,
                                    Locale locale)
            throws
            NoSuchDogEntryException,
            DG_FieldRequiredException {

        validateDogEntryExist(dogId, locale);

        if(dogApproval.getStatus() == null){
            throw new DG_FieldRequiredException(
                    _languageService.getMessage(locale, LanguageKeys.DOG_ENTRY_STATUS_NOT_PROVIDED));
        }
    }

    private void validateDogByGroupId(long groupId,
                                      Locale locale)
            throws  DG_NoSuchEntryException {

        _animalGroupValidator.validateAnimalGroupExist(groupId, locale);
    }

    private void validateDogByTagNames(long customerId,
                                       String[] tagNames,
                                       Locale locale) throws DG_NameDuplicateException{

        List<Boolean> checkValidate = new ArrayList<>();

        Arrays.stream(tagNames).forEach(name -> {
            List<AnimalTagEntry> animalTagEntries =
                    _animalTagEntryLocalService.findAnimalTagByName(customerId, name);
            if(animalTagEntries.size() == 0){
                checkValidate.add(true);
            }else{
                checkValidate.add(false);
            }
        });

        if(checkValidate.stream().allMatch(check -> check)){
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.ANIMAL_TAG_NAME_DUPLICATE));
    }

    private void validateDuplicateNameForAdd(long customerId,
                                    Dog dog,
                                    Locale locale)
            throws DG_NameDuplicateException {

        if(_dogEntryLocalService.countByName(customerId, dog.getName()) == 0){
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DOG_ENTRY_NAME_DUPLICATE));
    }

    private void validateDuplicateNameForUpdate(long customerId,
                                       long dogId,
                                       Dog dog,
                                       Locale locale)
            throws DG_NameDuplicateException {

        List<DogEntry> dogEntries =
                _dogEntryLocalService.findByName(customerId, dog.getName());

        if(dogEntries.size() == 0){
            return;
        }

        if(dogEntries.stream().anyMatch(dogEntry -> dogEntry.getDogId() == dogId)){
            return;
        }

        throw new DG_NameDuplicateException(
                _languageService.getMessage(locale, LanguageKeys.DOG_ENTRY_NAME_DUPLICATE));
    }

    public void validateDogEntryExist(long dogId,
                                       Locale locale)
            throws NoSuchDogEntryException {

        DogEntry dogEntry = _dogEntryLocalService.fetchDogEntry(dogId);

        if(Validator.isNotNull(dogEntry)){
            return;
        }

        throw new NoSuchDogEntryException(
                _languageService.getMessage(locale, LanguageKeys.DOG_ENTRY_NOT_FOUND));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey,
                                Locale locale)
            throws DG_FieldRequiredException {

        if(null == value || value.trim().isEmpty()){
            throw new DG_FieldRequiredException(_languageService.getMessage(locale, errorMsgKey));
        }
    }

    @Reference
    private LanguageService _languageService;

    @Reference
    private DogEntryLocalService _dogEntryLocalService;

    @Reference
    private AnimalGroupValidator _animalGroupValidator;

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;

}
