package com.dogoo.sample.pet.rest.internal.odata.v2_0;

import com.dogoo.sample.pet.service.constant.SearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class PetEntryModel implements EntityModel {

    public PetEntryModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        Field.NAME, locale -> Field.getSortableFieldName(Field.NAME)),
                new StringEntityField(
                        Field.STATUS, locale -> Field.getSortableFieldName(Field.STATUS)),
                new StringEntityField(
                        SearchFields.GENDER, locale -> Field.getSortableFieldName(SearchFields.GENDER)),
                new StringEntityField(
                        SearchFields.VACCINE, locale -> Field.getSortableFieldName(SearchFields.VACCINE)),
                new StringEntityField(
                        SearchFields.STATUS, locale -> Field.getSortableFieldName(SearchFields.STATUS))
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}
