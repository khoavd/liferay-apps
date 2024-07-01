/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.sample.pet.service.service;

import com.dogoo.sample.pet.service.model.AnimalGroupEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AnimalGroupEntry. This utility wraps
 * <code>com.dogoo.sample.pet.service.service.impl.AnimalGroupEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavu
 * @see AnimalGroupEntryLocalService
 * @generated
 */
public class AnimalGroupEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.sample.pet.service.service.impl.AnimalGroupEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AnimalGroupEntry addAnimalGroup(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel
			animalGroupMapperModel,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addAnimalGroup(
			customerId, creatorId, animalGroupMapperModel, serviceContext);
	}

	/**
	 * Adds the animal group entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalGroupEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalGroupEntry the animal group entry
	 * @return the animal group entry that was added
	 */
	public static AnimalGroupEntry addAnimalGroupEntry(
		AnimalGroupEntry animalGroupEntry) {

		return getService().addAnimalGroupEntry(animalGroupEntry);
	}

	public static int countAnimalGroupByName(long customerId, String name) {
		return getService().countAnimalGroupByName(customerId, name);
	}

	/**
	 * Creates a new animal group entry with the primary key. Does not add the animal group entry to the database.
	 *
	 * @param animalGroupId the primary key for the new animal group entry
	 * @return the new animal group entry
	 */
	public static AnimalGroupEntry createAnimalGroupEntry(long animalGroupId) {
		return getService().createAnimalGroupEntry(animalGroupId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the animal group entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalGroupEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalGroupEntry the animal group entry
	 * @return the animal group entry that was removed
	 */
	public static AnimalGroupEntry deleteAnimalGroupEntry(
		AnimalGroupEntry animalGroupEntry) {

		return getService().deleteAnimalGroupEntry(animalGroupEntry);
	}

	/**
	 * Deletes the animal group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalGroupEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry that was removed
	 * @throws PortalException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry deleteAnimalGroupEntry(long animalGroupId)
		throws PortalException {

		return getService().deleteAnimalGroupEntry(animalGroupId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AnimalGroupEntry fetchAnimalGroupEntry(long animalGroupId) {
		return getService().fetchAnimalGroupEntry(animalGroupId);
	}

	/**
	 * Returns the animal group entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal group entry's external reference code
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchAnimalGroupEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAnimalGroupEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAnimalGroupEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static AnimalGroupEntry fetchAnimalGroupEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAnimalGroupEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal group entry matching the UUID and group.
	 *
	 * @param uuid the animal group entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchAnimalGroupEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAnimalGroupEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<AnimalGroupEntry> findAnimalGroupByName(
		long customerId, String name) {

		return getService().findAnimalGroupByName(customerId, name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of animal group entries
	 */
	public static List<AnimalGroupEntry> getAnimalGroupEntries(
		int start, int end) {

		return getService().getAnimalGroupEntries(start, end);
	}

	/**
	 * Returns all the animal group entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal group entries
	 * @param companyId the primary key of the company
	 * @return the matching animal group entries, or an empty list if no matches were found
	 */
	public static List<AnimalGroupEntry>
		getAnimalGroupEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAnimalGroupEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of animal group entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal group entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching animal group entries, or an empty list if no matches were found
	 */
	public static List<AnimalGroupEntry>
		getAnimalGroupEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getService().getAnimalGroupEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal group entries.
	 *
	 * @return the number of animal group entries
	 */
	public static int getAnimalGroupEntriesCount() {
		return getService().getAnimalGroupEntriesCount();
	}

	/**
	 * Returns the animal group entry with the primary key.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws PortalException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry getAnimalGroupEntry(long animalGroupId)
		throws PortalException {

		return getService().getAnimalGroupEntry(animalGroupId);
	}

	/**
	 * Returns the animal group entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal group entry's external reference code
	 * @return the matching animal group entry
	 * @throws PortalException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry getAnimalGroupEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getAnimalGroupEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal group entry matching the UUID and group.
	 *
	 * @param uuid the animal group entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal group entry
	 * @throws PortalException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry getAnimalGroupEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAnimalGroupEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static AnimalGroupEntry updateAnimalGroup(
			long creatorId, long animalGroupId,
			com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel
				animalGroupMapperModel,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAnimalGroup(
			creatorId, animalGroupId, animalGroupMapperModel, serviceContext);
	}

	/**
	 * Updates the animal group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalGroupEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalGroupEntry the animal group entry
	 * @return the animal group entry that was updated
	 */
	public static AnimalGroupEntry updateAnimalGroupEntry(
		AnimalGroupEntry animalGroupEntry) {

		return getService().updateAnimalGroupEntry(animalGroupEntry);
	}

	public static AnimalGroupEntryLocalService getService() {
		return _service;
	}

	private static volatile AnimalGroupEntryLocalService _service;

}