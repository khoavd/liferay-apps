package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = "indexer.class.name=com.dogoo.sample.pet.service.model.AnimalTagEntry",
    service = ModelDocumentContributor.class
)
public class AnimalTagEntryModelDocumentContributor
        implements ModelDocumentContributor<AnimalTagEntry> {

    private final String CUSTOMER_ID = "customerId";

    private final String CREATOR_ID = "creatorId";

    private final String STATUS = "status";

    private final String STATUS_DATE = "statusDate";

    @Override
    public void contribute(Document doc, AnimalTagEntry baseModel) {

        doc.addKeyword(CUSTOMER_ID, baseModel.getCustomerId());
        doc.addKeyword(CREATOR_ID, baseModel.getCreatorId());
        doc.addText(Field.NAME, baseModel.getName());
        doc.addText(Field.DESCRIPTION, baseModel.getDescription());
        doc.addText(STATUS, baseModel.getStatus());
        doc.addDateSortable(STATUS_DATE, baseModel.getStatusDate());
    }

}
