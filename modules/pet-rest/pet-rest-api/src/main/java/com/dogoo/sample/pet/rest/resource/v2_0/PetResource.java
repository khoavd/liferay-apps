package com.dogoo.sample.pet.rest.resource.v2_0;

import com.dogoo.sample.pet.rest.dto.v2_0.Pet;
import com.dogoo.sample.pet.rest.dto.v2_0.PetApproval;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/dogoo/pet-rest/v2.0
 *
 * @author khoavu
 * @generated
 */
@Generated("")
@ProviderType
public interface PetResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<Pet> getPetsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public Pet postPet(Pet pet) throws Exception;

	public Response postPetBatch(String callbackURL, Object object)
		throws Exception;

	public void deletePet(Long petId) throws Exception;

	public Response deletePetBatch(String callbackURL, Object object)
		throws Exception;

	public Pet getPet(Long petId) throws Exception;

	public Pet putPet(Long petId, Pet pet) throws Exception;

	public Response putPetBatch(String callbackURL, Object object)
		throws Exception;

	public void deletePetByExternalReferenceCode(String externalReferenceCode)
		throws Exception;

	public Pet getPetByExternalReferenceCode(String externalReferenceCode)
		throws Exception;

	public Pet putPetByExternalReferenceCode(
			String externalReferenceCode, Pet pet)
		throws Exception;

	public PetApproval putPetApproval(Long petId, PetApproval petApproval)
		throws Exception;

	public PetApproval putPetApprovalByExternalReferenceCode(
			String externalReferenceCode, PetApproval petApproval)
		throws Exception;

	public void deleteGroupPets(Long groupId, Long[] longs) throws Exception;

	public Page<Pet> getGroupPetsPage(
			Long groupId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception;

	public void postGroupPets(Long groupId, Long[] longs) throws Exception;

	public void deleteGroupPetsByExternalReferenceCode(
			Long groupId, String[] strings)
		throws Exception;

	public void postGroupPetsByExternalReferenceCode(
			Long groupId, String[] strings)
		throws Exception;

	public void moveGroupMovePets(
			Long sourceGroupId, Long targetGroupId, Long[] longs)
		throws Exception;

	public void moveGroupMovePetsByExternalReferenceCode(
			Long sourceGroupId, Long targetGroupId, String[] strings)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert);

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService);

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public default Filter toFilter(String filterString) {
		return toFilter(
			filterString, Collections.<String, List<String>>emptyMap());
	}

	public default Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		return null;
	}

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public PetResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder httpServletResponse(
			HttpServletResponse httpServletResponse);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}