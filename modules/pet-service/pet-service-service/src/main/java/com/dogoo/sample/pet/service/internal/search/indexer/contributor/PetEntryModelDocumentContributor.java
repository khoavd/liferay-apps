package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = SearchFields.PET_INDEXER_CLASS,
    service = ModelDocumentContributor.class
)
public class PetEntryModelDocumentContributor
        implements ModelDocumentContributor<PetEntry> {

    private final String CUSTOMER_ID = "customerId";

    private final String CREATOR_ID = "creatorId";

    private final String STATUS = "status";

    private final String STATUS_DATE = "statusDate";

    @Override
    public void contribute(Document document, PetEntry baseModel) {

        document.addKeyword(CUSTOMER_ID, baseModel.getCustomerId());
        document.addKeyword(CREATOR_ID, baseModel.getCreatorId());
        document.addText(Field.NAME, baseModel.getName());
        document.addText(Field.DESCRIPTION, baseModel.getDescription());
        document.addText(STATUS, baseModel.getStatus());
        document.addDateSortable(STATUS_DATE, baseModel.getStatusDate());

        document.addText(SearchFields.BRIEF, baseModel.getBrief());
        document.addNumber(SearchFields.GENDER, baseModel.getGender());
        document.addKeyword(SearchFields.VACCINE, baseModel.getVaccine());
        document.addNumber(SearchFields.WEIGHT, baseModel.getWeight());
        document.addDateSortable(SearchFields.BIRTH_OF_DATE, baseModel.getBirthOfDate());
        document.addKeyword(SearchFields.ANIMAL_GROUP_ID, baseModel.getAnimalGroupId());
        document.addKeyword(SearchFields.ANIMAL_TAG_IDS, _getAnimalTagIds(baseModel.getPrimaryKey()));
    }

    private long [] _getAnimalTagIds(long petId) {
        return ListUtil.toLongArray(
                _animalTagEntryLocalService.getPetEntryAnimalTagEntries(petId),
                AnimalTagEntry.ANIMAL_TAG_ID_ACCESSOR);
    }

    @Reference
    AnimalTagEntryLocalService _animalTagEntryLocalService;
}
