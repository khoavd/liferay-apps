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

import com.dogoo.sample.pet.service.model.AnimalTagEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AnimalTagEntry. This utility wraps
 * <code>com.dogoo.sample.pet.service.service.impl.AnimalTagEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavu
 * @see AnimalTagEntryLocalService
 * @generated
 */
public class AnimalTagEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.sample.pet.service.service.impl.AnimalTagEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AnimalTagEntry addAnimalTag(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel
			animalTagMapperModel,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addAnimalTag(
			customerId, creatorId, animalTagMapperModel, context);
	}

	/**
	 * Adds the animal tag entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was added
	 */
	public static AnimalTagEntry addAnimalTagEntry(
		AnimalTagEntry animalTagEntry) {

		return getService().addAnimalTagEntry(animalTagEntry);
	}

	public static List<AnimalTagEntry> addAnimalTags(
		long customerId, long creatorId, String[] names,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().addAnimalTags(
			customerId, creatorId, names, context);
	}

	public static void addDogEntryAnimalTagEntries(
		long dogId, List<AnimalTagEntry> animalTagEntries) {

		getService().addDogEntryAnimalTagEntries(dogId, animalTagEntries);
	}

	public static void addDogEntryAnimalTagEntries(
		long dogId, long[] animalTagIds) {

		getService().addDogEntryAnimalTagEntries(dogId, animalTagIds);
	}

	public static void addDogEntryAnimalTagEntry(
		long dogId, AnimalTagEntry animalTagEntry) {

		getService().addDogEntryAnimalTagEntry(dogId, animalTagEntry);
	}

	public static void addDogEntryAnimalTagEntry(long dogId, long animalTagId) {
		getService().addDogEntryAnimalTagEntry(dogId, animalTagId);
	}

	public static void addPetEntryAnimalTagEntries(
		long petId, List<AnimalTagEntry> animalTagEntries) {

		getService().addPetEntryAnimalTagEntries(petId, animalTagEntries);
	}

	public static void addPetEntryAnimalTagEntries(
		long petId, long[] animalTagIds) {

		getService().addPetEntryAnimalTagEntries(petId, animalTagIds);
	}

	public static void addPetEntryAnimalTagEntry(
		long petId, AnimalTagEntry animalTagEntry) {

		getService().addPetEntryAnimalTagEntry(petId, animalTagEntry);
	}

	public static void addPetEntryAnimalTagEntry(long petId, long animalTagId) {
		getService().addPetEntryAnimalTagEntry(petId, animalTagId);
	}

	public static AnimalTagEntry approvalAnimalTag(
			long creatorId, long tagId, String status,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().approvalAnimalTag(
			creatorId, tagId, status, context);
	}

	public static void clearDogEntryAnimalTagEntries(long dogId) {
		getService().clearDogEntryAnimalTagEntries(dogId);
	}

	public static void clearPetEntryAnimalTagEntries(long petId) {
		getService().clearPetEntryAnimalTagEntries(petId);
	}

	public static int countAnimalTagByName(long customerId, String name) {
		return getService().countAnimalTagByName(customerId, name);
	}

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	public static AnimalTagEntry createAnimalTagEntry(long animalTagId) {
		return getService().createAnimalTagEntry(animalTagId);
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
	 * Deletes the animal tag entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was removed
	 */
	public static AnimalTagEntry deleteAnimalTagEntry(
		AnimalTagEntry animalTagEntry) {

		return getService().deleteAnimalTagEntry(animalTagEntry);
	}

	/**
	 * Deletes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws PortalException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry deleteAnimalTagEntry(long animalTagId)
		throws PortalException {

		return getService().deleteAnimalTagEntry(animalTagId);
	}

	public static void deleteDogEntryAnimalTagEntries(
		long dogId, List<AnimalTagEntry> animalTagEntries) {

		getService().deleteDogEntryAnimalTagEntries(dogId, animalTagEntries);
	}

	public static void deleteDogEntryAnimalTagEntries(
		long dogId, long[] animalTagIds) {

		getService().deleteDogEntryAnimalTagEntries(dogId, animalTagIds);
	}

	public static void deleteDogEntryAnimalTagEntry(
		long dogId, AnimalTagEntry animalTagEntry) {

		getService().deleteDogEntryAnimalTagEntry(dogId, animalTagEntry);
	}

	public static void deleteDogEntryAnimalTagEntry(
		long dogId, long animalTagId) {

		getService().deleteDogEntryAnimalTagEntry(dogId, animalTagId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deletePetEntryAnimalTagEntries(
		long petId, List<AnimalTagEntry> animalTagEntries) {

		getService().deletePetEntryAnimalTagEntries(petId, animalTagEntries);
	}

	public static void deletePetEntryAnimalTagEntries(
		long petId, long[] animalTagIds) {

		getService().deletePetEntryAnimalTagEntries(petId, animalTagIds);
	}

	public static void deletePetEntryAnimalTagEntry(
		long petId, AnimalTagEntry animalTagEntry) {

		getService().deletePetEntryAnimalTagEntry(petId, animalTagEntry);
	}

	public static void deletePetEntryAnimalTagEntry(
		long petId, long animalTagId) {

		getService().deletePetEntryAnimalTagEntry(petId, animalTagId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
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

	public static AnimalTagEntry fetchAnimalTagEntry(long animalTagId) {
		return getService().fetchAnimalTagEntry(animalTagId);
	}

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchAnimalTagEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAnimalTagEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAnimalTagEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static AnimalTagEntry fetchAnimalTagEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchAnimalTagEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal tag entry matching the UUID and group.
	 *
	 * @param uuid the animal tag entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchAnimalTagEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAnimalTagEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<AnimalTagEntry> findAnimalTagByName(
		long customerId, String name) {

		return getService().findAnimalTagByName(customerId, name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of animal tag entries
	 */
	public static List<AnimalTagEntry> getAnimalTagEntries(int start, int end) {
		return getService().getAnimalTagEntries(start, end);
	}

	/**
	 * Returns all the animal tag entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal tag entries
	 * @param companyId the primary key of the company
	 * @return the matching animal tag entries, or an empty list if no matches were found
	 */
	public static List<AnimalTagEntry> getAnimalTagEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAnimalTagEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of animal tag entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal tag entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching animal tag entries, or an empty list if no matches were found
	 */
	public static List<AnimalTagEntry> getAnimalTagEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getService().getAnimalTagEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	public static int getAnimalTagEntriesCount() {
		return getService().getAnimalTagEntriesCount();
	}

	/**
	 * Returns the animal tag entry with the primary key.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws PortalException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry getAnimalTagEntry(long animalTagId)
		throws PortalException {

		return getService().getAnimalTagEntry(animalTagId);
	}

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry
	 * @throws PortalException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry getAnimalTagEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getAnimalTagEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal tag entry matching the UUID and group.
	 *
	 * @param uuid the animal tag entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal tag entry
	 * @throws PortalException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry getAnimalTagEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAnimalTagEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(long dogId) {
		return getService().getDogEntryAnimalTagEntries(dogId);
	}

	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long dogId, int start, int end) {

		return getService().getDogEntryAnimalTagEntries(dogId, start, end);
	}

	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long dogId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getService().getDogEntryAnimalTagEntries(
			dogId, start, end, orderByComparator);
	}

	public static int getDogEntryAnimalTagEntriesCount(long dogId) {
		return getService().getDogEntryAnimalTagEntriesCount(dogId);
	}

	/**
	 * Returns the dogIds of the dog entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the dogIds of dog entries associated with the animal tag entry
	 */
	public static long[] getDogEntryPrimaryKeys(long animalTagId) {
		return getService().getDogEntryPrimaryKeys(animalTagId);
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

	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(long petId) {
		return getService().getPetEntryAnimalTagEntries(petId);
	}

	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long petId, int start, int end) {

		return getService().getPetEntryAnimalTagEntries(petId, start, end);
	}

	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long petId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getService().getPetEntryAnimalTagEntries(
			petId, start, end, orderByComparator);
	}

	public static int getPetEntryAnimalTagEntriesCount(long petId) {
		return getService().getPetEntryAnimalTagEntriesCount(petId);
	}

	/**
	 * Returns the petIds of the pet entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the petIds of pet entries associated with the animal tag entry
	 */
	public static long[] getPetEntryPrimaryKeys(long animalTagId) {
		return getService().getPetEntryPrimaryKeys(animalTagId);
	}

	public static boolean hasDogEntryAnimalTagEntries(long dogId) {
		return getService().hasDogEntryAnimalTagEntries(dogId);
	}

	public static boolean hasDogEntryAnimalTagEntry(
		long dogId, long animalTagId) {

		return getService().hasDogEntryAnimalTagEntry(dogId, animalTagId);
	}

	public static boolean hasPetEntryAnimalTagEntries(long petId) {
		return getService().hasPetEntryAnimalTagEntries(petId);
	}

	public static boolean hasPetEntryAnimalTagEntry(
		long petId, long animalTagId) {

		return getService().hasPetEntryAnimalTagEntry(petId, animalTagId);
	}

	public static void setDogEntryAnimalTagEntries(
		long dogId, long[] animalTagIds) {

		getService().setDogEntryAnimalTagEntries(dogId, animalTagIds);
	}

	public static void setPetEntryAnimalTagEntries(
		long petId, long[] animalTagIds) {

		getService().setPetEntryAnimalTagEntries(petId, animalTagIds);
	}

	public static AnimalTagEntry updateAnimalTag(
			long creatorId, long tagId,
			com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel
				animalTagMapperModel,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().updateAnimalTag(
			creatorId, tagId, animalTagMapperModel, context);
	}

	/**
	 * Updates the animal tag entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was updated
	 */
	public static AnimalTagEntry updateAnimalTagEntry(
		AnimalTagEntry animalTagEntry) {

		return getService().updateAnimalTagEntry(animalTagEntry);
	}

	public static AnimalTagEntryLocalService getService() {
		return _service;
	}

	private static volatile AnimalTagEntryLocalService _service;

}