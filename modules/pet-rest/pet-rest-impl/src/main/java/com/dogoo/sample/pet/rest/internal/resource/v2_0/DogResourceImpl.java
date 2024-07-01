package com.dogoo.sample.pet.rest.internal.resource.v2_0;

import com.dogoo.sample.pet.rest.dto.v2_0.Dog;
import com.dogoo.sample.pet.rest.dto.v2_0.DogApproval;
import com.dogoo.sample.pet.rest.internal.mapper.DogMapper;
import com.dogoo.sample.pet.rest.internal.odata.v2_0.DogEntryModel;
import com.dogoo.sample.pet.rest.internal.service.DogService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.rest.internal.validator.DogValidator;
import com.dogoo.sample.pet.rest.resource.v2_0.DogResource;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Locale;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author khoavu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/dog.properties",
	scope = ServiceScope.PROTOTYPE, service = DogResource.class
)
public class DogResourceImpl extends BaseDogResourceImpl {
	private DogEntryModel dogEntryModel = new DogEntryModel();

	private final long CUSTOMER_ID = 1l;

	private final long USER_ID = 1l;

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap){
		return dogEntryModel;
	}

	@Override
	public Page<Dog> getDogsPage(String search,
								 Filter filter,
								 Pagination pagination,
								 Sort[] sorts) throws Exception {

		return _dogService.getDogsPage(
				CUSTOMER_ID,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public Dog postDog(Dog dog) throws Exception {

		_dogValidator.validateForAdd(
				CUSTOMER_ID,
				dog,
				getLocale());

		return _dogService.addDog(
				CUSTOMER_ID,
				USER_ID,
				dog,
				getServiceContext());
	}

	@Override
	public Dog putDog(Long dogId, Dog dog) throws Exception {

		_dogValidator.validateForUpdate(
				CUSTOMER_ID,
				dogId,
				dog,
				getLocale());

		return _dogService.updateDog(
				CUSTOMER_ID,
				USER_ID,
				dogId,
				dog,
				getServiceContext());
	}

	@Override
	public void deleteDog(Long dogId) throws Exception {

		_dogValidator.validateDogEntryExist(dogId, getLocale());

		_dogService.deleteDog(dogId);
	}

	@Override
	public Dog getDog(Long dogId) throws Exception {

		return _dogService.getDogById(dogId);
	}

	@Override
	public DogApproval putDogApproval(
			Long dogId,
			DogApproval dogApproval) throws Exception {

		_dogValidator.validateForApproval(
				dogId,
				dogApproval,
				getLocale());

		return _dogService.approvalDog(
				USER_ID,
				dogId,
				dogApproval,
				getServiceContext());
	}

	@Override
	public Dog getDogByExternalReferenceCode(
			String externalReferenceCode) throws Exception {

		long dogId = _dogMapper.getDogEntryId(externalReferenceCode);

		return getDog(dogId);
	}

	@Override
	public Dog putDogByExternalReferenceCode(
			String externalReferenceCode,
			Dog dog) throws Exception {

		long dogId = _dogMapper.getDogEntryId(externalReferenceCode);

		return putDog(dogId, dog);
	}

	@Override
	public void deleteDogByExternalReferenceCode(
			String externalReferenceCode) throws Exception {

		long dogId = _dogMapper.getDogEntryId(externalReferenceCode);

		deleteDog(dogId);
	}

	@Override
	public DogApproval putDogApprovalByExternalReferenceCode(
			String externalReferenceCode,
			DogApproval dogApproval) throws Exception {

		long dogId = _dogMapper.getDogEntryId(externalReferenceCode);

		return putDogApproval(dogId, dogApproval);
	}

	public Locale getLocale(){

		Locale locale = contextHttpServletRequest.getLocale();

		if(locale.getLanguage().isEmpty()){
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
	private DogMapper _dogMapper;

	@Reference
	private DogService _dogService;

	@Reference
	private DogValidator _dogValidator;
}