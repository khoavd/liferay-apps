package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = SearchFields.ANIMAL_GROUP_INDEXER_CLASS,
    service = ModelDocumentContributor.class
)
public class AnimalGroupEntryModelDocumentContributor
        implements ModelDocumentContributor<AnimalGroupEntry> {

    private final String CUSTOMER_ID = "customerId";
    private final String CREATOR_ID = "creatorId";

    @Override
    public void contribute(Document doc, AnimalGroupEntry baseModel) {

        doc.addKeyword(CUSTOMER_ID, baseModel.getCustomerId());
        doc.addKeyword(CREATOR_ID, baseModel.getCreatorId());
        doc.addText(Field.NAME, baseModel.getName());
        doc.addText(Field.DESCRIPTION, baseModel.getDescription());

    }

}
