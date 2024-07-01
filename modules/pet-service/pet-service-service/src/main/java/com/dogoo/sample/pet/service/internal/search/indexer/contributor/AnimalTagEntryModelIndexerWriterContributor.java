package com.dogoo.sample.pet.service.internal.search.indexer.contributor;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = "indexer.class.name=com.dogoo.sample.pet.service.model.AnimalTagEntry",
    service = ModelIndexerWriterContributor.class
)
public class AnimalTagEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<AnimalTagEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (AnimalTagEntry animalEntry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(animalEntry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _animalTagEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AnimalTagEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private AnimalTagEntryLocalService _animalTagEntryLocalService;
}
