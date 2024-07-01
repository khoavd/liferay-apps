package com.dogoo.sample.pet.rest.internal.resource.v2_0;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalGroup;
import com.dogoo.sample.pet.rest.internal.mapper.AnimalGroupMapper;
import com.dogoo.sample.pet.rest.internal.odata.v2_0.AnimalGroupEntryModel;
import com.dogoo.sample.pet.rest.internal.service.AnimalGroupService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.rest.internal.validator.AnimalGroupValidator;
import com.dogoo.sample.pet.rest.resource.v2_0.AnimalGroupResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Locale;

/**
 * @author khoavu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/animal-group.properties",
	scope = ServiceScope.PROTOTYPE, service = AnimalGroupResource.class
)
public class AnimalGroupResourceImpl extends BaseAnimalGroupResourceImpl {

	private final long CUSTOMER_ID = 1l;

	private final long USER_ID = 1l;

	private AnimalGroupEntryModel animalGroupEntryModel = new AnimalGroupEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return animalGroupEntryModel;
	}

	@Override
	public Page<AnimalGroup> getAnimalGroupsPage(
			String search,
			Filter filter,
			Pagination pagination,
			Sort[] sorts) throws Exception {

		return _service.getAnimalGroupsPage(
				CUSTOMER_ID,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public AnimalGroup postAnimalGroup(
			AnimalGroup animalGroup) throws Exception {

		_validator.validateForAddAnimalGroup(
				CUSTOMER_ID,
				animalGroup,
				getLocale());

		return _service.addAnimalGroup(
				CUSTOMER_ID,
				USER_ID,
				animalGroup,
				getServiceContext());
	}

	@Override
	public void deleteAnimalGroup(Long animalGroupId) throws Exception {

		_validator.validateAnimalGroupExist(
				animalGroupId,
				getLocale());

		_service.deleteAnimalGroup(animalGroupId);
	}

	@Override
	public AnimalGroup getAnimalGroup(Long animalGroupId) throws Exception {

		_validator.validateAnimalGroupExist(animalGroupId, getLocale());

		return _service.getAnimalGroup(animalGroupId);
	}

	@Override
	public AnimalGroup putAnimalGroup(Long animalGroupId, AnimalGroup animalGroup) throws Exception {

		_validator.validatorForUpdateAnimalGroup(
				CUSTOMER_ID,
				animalGroupId,
				animalGroup,
				getLocale());

		return _service.updateAnimalGroup(
				USER_ID,
				animalGroupId,
				animalGroup,
				getServiceContext());
	}

	@Override
	public void deleteAnimalGroupByExternalReferenceCode(
			String externalReferenceCode) throws Exception {

		long groupId = _mapper.getAnimalGroupEntryId(externalReferenceCode);

		deleteAnimalGroup(groupId);
	}

	@Override
	public AnimalGroup getAnimalGroupByExternalReferenceCode(
			String externalReferenceCode) throws Exception {

		long groupId = _mapper.getAnimalGroupEntryId(externalReferenceCode);

		return getAnimalGroup(groupId);
	}

	@Override
	public AnimalGroup putAnimalGroupByExternalReferenceCode(
			String externalReferenceCode,
			AnimalGroup animalGroup) throws Exception {

		long groupId = _mapper.getAnimalGroupEntryId(externalReferenceCode);

		return putAnimalGroup(groupId, animalGroup);
	}

	public Locale getLocale() {

		Locale locale = contextHttpServletRequest.getLocale();

		if (locale.getLanguage().isEmpty()) {
			locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
		}

		return locale;
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}


	@Reference
	private AnimalGroupService _service;

	@Reference
	private AnimalGroupValidator _validator;

	@Reference
	private AnimalGroupMapper _mapper;
}