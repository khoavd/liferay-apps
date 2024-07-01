package com.dogoo.sample.animal.rest.internal.resource.v1_0;

import com.dogoo.sample.animal.rest.dto.v1_0.AnimalCategory;
import com.dogoo.sample.animal.rest.resource.v1_0.AnimalCategoryResource;

import com.dogoo.sample.animal.service.exception.DG_AnimalNotFoundException;
import com.dogoo.sample.animal.service.model.AnimalCategoryEntry;
import com.dogoo.sample.animal.service.service.AnimalCategoryEntryLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author khoavu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/animal-category.properties",
	scope = ServiceScope.PROTOTYPE, service = AnimalCategoryResource.class
)
public class AnimalCategoryResourceImpl extends BaseAnimalCategoryResourceImpl {

	private final Log _log = LogFactoryUtil.getLog(AnimalCategory.class.getName());

	@Override
	public AnimalCategory getPet(Long cateId) throws Exception {

		_log.info(cateId);

		AnimalCategoryEntry entry = service.fetchAnimalCategoryEntry(cateId);

		if (Validator.isNull(entry)) {
			throw new DG_AnimalNotFoundException("Does not found any category in the datasource");
		}

		AnimalCategory resp = new AnimalCategory();

		resp.setId(entry.getAnimalId());
		resp.setName(entry.getName());

		return resp;
	}

	@Override
	public void deleteAnimalCategory(Long cateId) throws Exception {
		AnimalCategoryEntry entry = service.fetchAnimalCategoryEntry(cateId);

		if (Validator.isNull(entry)) {
			throw new DG_AnimalNotFoundException("Does not found any category in the datasource");
		}

		service.deleteAnimalCategoryEntry(entry);
	}

	@Reference
	private AnimalCategoryEntryLocalService service;
}