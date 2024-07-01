package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.AnimalGroupEntryLocalService;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = SearchFields.ANIMAL_GROUP_INDEXER_CLASS,
    service = ModelIndexerWriterContributor.class
)
public class AnimalGroupEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<AnimalGroupEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (AnimalGroupEntry groupEntry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(groupEntry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _animalGroupEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AnimalGroupEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private AnimalGroupEntryLocalService _animalGroupEntryLocalService;
}
