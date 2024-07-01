package com.dogoo.sample.pet.rest.internal.resource.v2_0;

import com.dogoo.sample.pet.rest.dto.v2_0.Pet;
import com.dogoo.sample.pet.rest.dto.v2_0.PetApproval;
import com.dogoo.sample.pet.rest.internal.mapper.PetMapper;
import com.dogoo.sample.pet.rest.internal.odata.v2_0.PetEntryModel;
import com.dogoo.sample.pet.rest.internal.service.PetService;
import com.dogoo.sample.pet.rest.internal.util.LanguageKeys;
import com.dogoo.sample.pet.rest.internal.validator.PetValidator;
import com.dogoo.sample.pet.rest.resource.v2_0.PetResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
	properties = "OSGI-INF/liferay/rest/v2_0/pet.properties",
	scope = ServiceScope.PROTOTYPE, service = PetResource.class
)
public class PetResourceImpl extends BasePetResourceImpl {

	private final long CUSTOMER_ID = 1l;

	private final long USER_ID = 1l;

	private PetEntryModel petEntryModel = new PetEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return petEntryModel;
	}

	@Override
	public Page<Pet> getPetsPage(String search,
								 Filter filter,
								 Pagination pagination,
								 Sort[] sorts) throws Exception {

		String node = contextHttpServletRequest.getLocalName();

		return _petService.getPetsPage(
				CUSTOMER_ID,
				search,
				node,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public Pet postPet(Pet pet) throws Exception {
		_validator.validateForAdd(
				USER_ID,
				pet,
				getLocale());
		String node = contextHttpServletRequest.getLocalName();

		return _petService.addPet(
				CUSTOMER_ID,
				USER_ID,
				node,
				pet,
				getServiceContext());
	}

	@Override
	public void deletePet(Long petId) throws Exception {

		_validator.validatePetEntryExist(
				petId,
				getLocale());

		_petService.deletePet(petId);
	}

	@Override
	public Pet getPet(Long petId) throws Exception {
		_validator.validatePetEntryExist(
				petId,
				getLocale());

		return _petService.getPetById(petId);
	}

	@Override
	public Pet putPet(Long petId, Pet pet) throws Exception {

		_validator.validateForUpdate(
				CUSTOMER_ID,
				petId,
				pet,
				getLocale());

		return _petService.updatePet(
				USER_ID,
				petId,
				pet,
				getServiceContext());
	}

	@Override
	public void deletePetByExternalReferenceCode(String externalReferenceCode)
			throws Exception {

		long petId = _mapper.getPetEntryId(externalReferenceCode);

		deletePet(petId);
	}

	@Override
	public Pet getPetByExternalReferenceCode(String externalReferenceCode)
			throws Exception {
		long petId = _mapper.getPetEntryId(externalReferenceCode);

		return getPet(petId);
	}

	@Override
	public Pet putPetByExternalReferenceCode(
			String externalReferenceCode,
			Pet pet) throws Exception {

		long petId = _mapper.getPetEntryId(externalReferenceCode);

		return putPet(petId, pet);
	}

	@Override
	public PetApproval putPetApproval(
			Long petId,
			PetApproval petApproval)
			throws Exception {

		_validator.validateForApproval(
				petId,
				petApproval,
				getLocale());

		return _petService.approvalPet(
				USER_ID,
				petId,
				petApproval,
				getServiceContext());
	}

	@Override
	public PetApproval putPetApprovalByExternalReferenceCode(
			String externalReferenceCode,
			PetApproval petApproval)
			throws Exception {

		long petId = _mapper.getPetEntryId(externalReferenceCode);

		return putPetApproval(petId, petApproval);
	}

	@Override
	public void deleteGroupPets(Long groupId, 
								Long[] longs) throws Exception {
		
		_validator.validatePetActionByGroupIdBatch(
				groupId,
				GetterUtil.getLongValues(longs), 
				getLocale());
		
		_petService.deletePetBatch(
				USER_ID,
				GetterUtil.getLongValues(longs), 
				getServiceContext());
	}

	@Override
	public Page<Pet> getGroupPetsPage(
			Long groupId,
			String search,
			Filter filter,
			Pagination pagination,
			Sort[] sorts) throws Exception {

		_validator.validatePetByGroupId(groupId, getLocale());

		return _petService.getPetsPageByGroupId(
				CUSTOMER_ID,
				groupId,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public void postGroupPets(Long groupId,
							  Long[] longs) throws Exception {

		_validator.validatePetActionByGroupIdBatch(
				groupId,
				GetterUtil.getLongValues(longs),
				getLocale());

		_petService.addPetsToGroup(
				USER_ID,
				groupId,
				GetterUtil.getLongValues(longs),
				getServiceContext());
	}

	@Override
	public void deleteGroupPetsByExternalReferenceCode(
			Long groupId,
			String[] strings) throws Exception {

		Long [] petIds = _mapper.getPetEntryIds(strings);

		deleteGroupPets(groupId, petIds);
	}

	@Override
	public void postGroupPetsByExternalReferenceCode(
			Long groupId,
			String[] strings) throws Exception {

		Long [] petIds = _mapper.getPetEntryIds(strings);

		postGroupPets(groupId, petIds);
	}

	@Override
	public void moveGroupMovePets(Long sourceGroupId,
								  Long targetGroupId,
								  Long[] longs) throws Exception {

		_validator.validatePetByGroupId(sourceGroupId, getLocale());
		_validator.validatePetByGroupId(targetGroupId, getLocale());

		postGroupPets(targetGroupId, longs);
	}

	@Override
	public void moveGroupMovePetsByExternalReferenceCode(Long sourceGroupId,
														 Long targetGroupId,
														 String[] strings) throws Exception {
		Long [] petIds = _mapper.getPetEntryIds(strings);

		moveGroupMovePets(sourceGroupId, targetGroupId, petIds);
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
	private PetService _petService;

	@Reference
	private PetValidator _validator;

	@Reference
	private PetMapper _mapper;
}