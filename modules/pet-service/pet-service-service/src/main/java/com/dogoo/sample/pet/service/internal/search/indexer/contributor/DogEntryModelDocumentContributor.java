package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.DOG_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class DogEntryModelDocumentContributor
        implements ModelDocumentContributor<DogEntry> {

    @Override
    public void contribute(Document document, DogEntry baseModel) {

        document.addKeyword(SearchFields.CUSTOMER_ID, Long.toString(baseModel.getCustomerId()));
        document.addKeyword(SearchFields.CREATOR_ID, Long.toString(baseModel.getCreatorId()));

        document.addKeyword(SearchFields.STATUS, baseModel.getStatus());

        document.addText(Field.NAME, baseModel.getName());
        document.addText(Field.TITLE, baseModel.getTitle());
        document.addNumber(SearchFields.WEIGHT, baseModel.getWeight());
        document.addText(SearchFields.COLOR, baseModel.getColor());

        document.addKeyword(SearchFields.ANIMAL_GROUP_ID, baseModel.getAnimalGroupId());
        document.addKeyword(SearchFields.ANIMAL_TAG_IDS, _getAnimalTagIds(baseModel.getPrimaryKey()));
    }

    private long[] _getAnimalTagIds(long dogId){
        return ListUtil.toLongArray(
                _animalTagEntryLocalService.getDogEntryAnimalTagEntries(dogId),
                AnimalTagEntry.ANIMAL_TAG_ID_ACCESSOR);
    }

    @Reference
    AnimalTagEntryLocalService _animalTagEntryLocalService;
}
