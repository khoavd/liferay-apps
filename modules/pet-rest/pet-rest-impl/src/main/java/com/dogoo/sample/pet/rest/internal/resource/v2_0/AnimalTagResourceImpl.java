package com.dogoo.sample.pet.rest.internal.resource.v2_0;

import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTag;
import com.dogoo.sample.pet.rest.dto.v2_0.AnimalTagApproved;
import com.dogoo.sample.pet.rest.internal.mapper.AnimalTagMapper;
import com.dogoo.sample.pet.rest.internal.odata.v2_0.AnimalTagEntryModel;
import com.dogoo.sample.pet.rest.internal.service.AnimalTagService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.rest.internal.validator.AnimalTagValidator;
import com.dogoo.sample.pet.rest.resource.v2_0.AnimalTagResource;
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
	properties = "OSGI-INF/liferay/rest/v2_0/animal-tag.properties",
	scope = ServiceScope.PROTOTYPE, service = AnimalTagResource.class
)
public class AnimalTagResourceImpl extends BaseAnimalTagResourceImpl {

	private final long CUSTOMER_ID = 1l;

	private final long USER_ID = 1l;

	private AnimalTagEntryModel animalTagEntryModel = new AnimalTagEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return animalTagEntryModel;
	}

	@Override
	public Page<AnimalTag> getAnimalTagsPage(String search,
											 Filter filter,
											 Pagination pagination,
											 Sort[] sorts) throws Exception {

		return _service.getPetsPage(
				CUSTOMER_ID,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public AnimalTag postAnimalTag(AnimalTag animalTag) throws Exception {

		_validator.validateForAddAnimalTag(
				USER_ID,
				animalTag,
				getLocale());

		return _service.addAnimalTag(
				CUSTOMER_ID,
				USER_ID,
				animalTag,
				getServiceContext());
	}

	@Override
	public void deleteAnimalTag(Long animalTagId) throws Exception {

		_validator.validateAnimalTagExist(animalTagId, getLocale());

		_service.deleteAnimalTag(animalTagId);
	}

	@Override
	public AnimalTag getAnimalTag(Long animalTagId) throws Exception {

		_validator.validateAnimalTagExist(animalTagId, getLocale());

		return _service.getAnimalTag(animalTagId);
	}

	@Override
	public AnimalTag putAnimalTag(Long animalTagId,
								  AnimalTag animalTag) throws Exception {

		_validator.validateForUpdateAnimalTag(
				CUSTOMER_ID,
				animalTagId,
				animalTag,
				getLocale());

		return _service.updateAnimalTag(
				USER_ID,
				animalTagId,
				animalTag,
				getServiceContext());
	}

	@Override
	public void deleteAnimalTagByExternalReferenceCode(String externalReferenceCode) throws Exception {

		long tagId = _mapper.getAnimalTagEntryId(externalReferenceCode);

		deleteAnimalTag(tagId);
	}

	@Override
	public AnimalTag getAnimalTagByExternalReferenceCode(String externalReferenceCode) throws Exception {

		long tagId = _mapper.getAnimalTagEntryId(externalReferenceCode);

		return getAnimalTag(tagId);
	}

	@Override
	public AnimalTag putAnimalTagByExternalReferenceCode(String externalReferenceCode,
														 AnimalTag animalTag) throws Exception {

		long tagId = _mapper.getAnimalTagEntryId(externalReferenceCode);

		return putAnimalTag(tagId, animalTag);
	}

	@Override
	public AnimalTagApproved putAnimalTagApprovedByExternalReferenceCode(
			String externalReferenceCode,
			AnimalTagApproved animalTagApproved)
			throws Exception {

		long tagId = _mapper.getAnimalTagEntryId(externalReferenceCode);

		return approvalAnimalTag(tagId, animalTagApproved);

	}

	@Override
	public AnimalTagApproved approvalAnimalTag(
			Long animalTagId,
			AnimalTagApproved animalTagApproved) throws Exception {

		_validator.validateForApprovalAnimalTag(
				animalTagId,
				animalTagApproved,
				getLocale());

		return _service.approvalAnimalTag(
				USER_ID,
				animalTagId,
				animalTagApproved,
				getServiceContext());

	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	public Locale getLocale() {

		Locale locale = contextHttpServletRequest.getLocale();

		if (locale.getLanguage().isEmpty()) {
			locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
		}

		return locale;
	}

	@Reference
	private AnimalTagService _service;

	@Reference
	private AnimalTagValidator _validator;

	@Reference
	private AnimalTagMapper _mapper;
}