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

import com.dogoo.sample.pet.service.model.DogEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DogEntry. This utility wraps
 * <code>com.dogoo.sample.pet.service.service.impl.DogEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavu
 * @see DogEntryLocalService
 * @generated
 */
public class DogEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.sample.pet.service.service.impl.DogEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries) {

		getService().addAnimalTagEntryDogEntries(animalTagId, dogEntries);
	}

	public static void addAnimalTagEntryDogEntries(
		long animalTagId, long[] dogIds) {

		getService().addAnimalTagEntryDogEntries(animalTagId, dogIds);
	}

	public static void addAnimalTagEntryDogEntry(
		long animalTagId, DogEntry dogEntry) {

		getService().addAnimalTagEntryDogEntry(animalTagId, dogEntry);
	}

	public static void addAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		getService().addAnimalTagEntryDogEntry(animalTagId, dogId);
	}

	/**
	 * Adds the dog entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was added
	 */
	public static DogEntry addDogEntry(DogEntry dogEntry) {
		return getService().addDogEntry(dogEntry);
	}

	public static DogEntry addDogEntry(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.DogMapperModel dogMapperModel,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addDogEntry(
			customerId, creatorId, dogMapperModel, context);
	}

	public static DogEntry approvalDogEntry(
			long creatorId, long entryId, String status,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().approvalDogEntry(
			creatorId, entryId, status, context);
	}

	public static void clearAnimalTagEntryDogEntries(long animalTagId) {
		getService().clearAnimalTagEntryDogEntries(animalTagId);
	}

	public static int countByName(long customerId, String name) {
		return getService().countByName(customerId, name);
	}

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	public static DogEntry createDogEntry(long dogId) {
		return getService().createDogEntry(dogId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries) {

		getService().deleteAnimalTagEntryDogEntries(animalTagId, dogEntries);
	}

	public static void deleteAnimalTagEntryDogEntries(
		long animalTagId, long[] dogIds) {

		getService().deleteAnimalTagEntryDogEntries(animalTagId, dogIds);
	}

	public static void deleteAnimalTagEntryDogEntry(
		long animalTagId, DogEntry dogEntry) {

		getService().deleteAnimalTagEntryDogEntry(animalTagId, dogEntry);
	}

	public static void deleteAnimalTagEntryDogEntry(
		long animalTagId, long dogId) {

		getService().deleteAnimalTagEntryDogEntry(animalTagId, dogId);
	}

	/**
	 * Deletes the dog entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was removed
	 */
	public static DogEntry deleteDogEntry(DogEntry dogEntry) {
		return getService().deleteDogEntry(dogEntry);
	}

	/**
	 * Deletes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	public static DogEntry deleteDogEntry(long dogId) throws PortalException {
		return getService().deleteDogEntry(dogId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
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

	public static DogEntry fetchDogEntry(long dogId) {
		return getService().fetchDogEntry(dogId);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchDogEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDogEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDogEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DogEntry fetchDogEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchDogEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchDogEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDogEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<DogEntry> findByName(long customerId, String name) {
		return getService().findByName(customerId, name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DogEntry> getAnimalTagEntryDogEntries(long animalTagId) {
		return getService().getAnimalTagEntryDogEntries(animalTagId);
	}

	public static List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end) {

		return getService().getAnimalTagEntryDogEntries(
			animalTagId, start, end);
	}

	public static List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getService().getAnimalTagEntryDogEntries(
			animalTagId, start, end, orderByComparator);
	}

	public static int getAnimalTagEntryDogEntriesCount(long animalTagId) {
		return getService().getAnimalTagEntryDogEntriesCount(animalTagId);
	}

	/**
	 * Returns the animalTagIds of the animal tag entries associated with the dog entry.
	 *
	 * @param dogId the dogId of the dog entry
	 * @return long[] the animalTagIds of animal tag entries associated with the dog entry
	 */
	public static long[] getAnimalTagEntryPrimaryKeys(long dogId) {
		return getService().getAnimalTagEntryPrimaryKeys(dogId);
	}

	/**
	 * Returns a range of all the dog entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of dog entries
	 */
	public static List<DogEntry> getDogEntries(int start, int end) {
		return getService().getDogEntries(start, end);
	}

	/**
	 * Returns all the dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @return the matching dog entries, or an empty list if no matches were found
	 */
	public static List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDogEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dog entries, or an empty list if no matches were found
	 */
	public static List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getService().getDogEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	public static int getDogEntriesCount() {
		return getService().getDogEntriesCount();
	}

	/**
	 * Returns the dog entry with the primary key.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	public static DogEntry getDogEntry(long dogId) throws PortalException {
		return getService().getDogEntry(dogId);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	public static DogEntry getDogEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDogEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	public static DogEntry getDogEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDogEntryByUuidAndGroupId(uuid, groupId);
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

	public static boolean hasAnimalTagEntryDogEntries(long animalTagId) {
		return getService().hasAnimalTagEntryDogEntries(animalTagId);
	}

	public static boolean hasAnimalTagEntryDogEntry(
		long animalTagId, long dogId) {

		return getService().hasAnimalTagEntryDogEntry(animalTagId, dogId);
	}

	public static void setAnimalTagEntryDogEntries(
		long animalTagId, long[] dogIds) {

		getService().setAnimalTagEntryDogEntries(animalTagId, dogIds);
	}

	/**
	 * Updates the dog entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was updated
	 */
	public static DogEntry updateDogEntry(DogEntry dogEntry) {
		return getService().updateDogEntry(dogEntry);
	}

	public static DogEntry updateDogEntry(
			long customerId, long entryId, long creatorId,
			com.dogoo.sample.pet.service.mapper.model.DogMapperModel
				dogMapperModel,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updateDogEntry(
			customerId, entryId, creatorId, dogMapperModel, context);
	}

	public static DogEntryLocalService getService() {
		return _service;
	}

	private static volatile DogEntryLocalService _service;

}