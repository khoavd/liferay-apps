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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimalTagEntryLocalService}.
 *
 * @author khoavu
 * @see AnimalTagEntryLocalService
 * @generated
 */
public class AnimalTagEntryLocalServiceWrapper
	implements AnimalTagEntryLocalService,
			   ServiceWrapper<AnimalTagEntryLocalService> {

	public AnimalTagEntryLocalServiceWrapper(
		AnimalTagEntryLocalService animalTagEntryLocalService) {

		_animalTagEntryLocalService = animalTagEntryLocalService;
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry addAnimalTag(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel
			animalTagMapperModel,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _animalTagEntryLocalService.addAnimalTag(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry addAnimalTagEntry(
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		return _animalTagEntryLocalService.addAnimalTagEntry(animalTagEntry);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		addAnimalTags(
			long customerId, long creatorId, String[] names,
			com.liferay.portal.kernel.service.ServiceContext context) {

		return _animalTagEntryLocalService.addAnimalTags(
			customerId, creatorId, names, context);
	}

	@Override
	public void addDogEntryAnimalTagEntries(
		long dogId,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		_animalTagEntryLocalService.addDogEntryAnimalTagEntries(
			dogId, animalTagEntries);
	}

	@Override
	public void addDogEntryAnimalTagEntries(long dogId, long[] animalTagIds) {
		_animalTagEntryLocalService.addDogEntryAnimalTagEntries(
			dogId, animalTagIds);
	}

	@Override
	public void addDogEntryAnimalTagEntry(
		long dogId,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		_animalTagEntryLocalService.addDogEntryAnimalTagEntry(
			dogId, animalTagEntry);
	}

	@Override
	public void addDogEntryAnimalTagEntry(long dogId, long animalTagId) {
		_animalTagEntryLocalService.addDogEntryAnimalTagEntry(
			dogId, animalTagId);
	}

	@Override
	public void addPetEntryAnimalTagEntries(
		long petId,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		_animalTagEntryLocalService.addPetEntryAnimalTagEntries(
			petId, animalTagEntries);
	}

	@Override
	public void addPetEntryAnimalTagEntries(long petId, long[] animalTagIds) {
		_animalTagEntryLocalService.addPetEntryAnimalTagEntries(
			petId, animalTagIds);
	}

	@Override
	public void addPetEntryAnimalTagEntry(
		long petId,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		_animalTagEntryLocalService.addPetEntryAnimalTagEntry(
			petId, animalTagEntry);
	}

	@Override
	public void addPetEntryAnimalTagEntry(long petId, long animalTagId) {
		_animalTagEntryLocalService.addPetEntryAnimalTagEntry(
			petId, animalTagId);
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry approvalAnimalTag(
			long creatorId, long tagId, String status,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.approvalAnimalTag(
			creatorId, tagId, status, context);
	}

	@Override
	public void clearDogEntryAnimalTagEntries(long dogId) {
		_animalTagEntryLocalService.clearDogEntryAnimalTagEntries(dogId);
	}

	@Override
	public void clearPetEntryAnimalTagEntries(long petId) {
		_animalTagEntryLocalService.clearPetEntryAnimalTagEntries(petId);
	}

	@Override
	public int countAnimalTagByName(long customerId, String name) {
		return _animalTagEntryLocalService.countAnimalTagByName(
			customerId, name);
	}

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		createAnimalTagEntry(long animalTagId) {

		return _animalTagEntryLocalService.createAnimalTagEntry(animalTagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		deleteAnimalTagEntry(
			com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		return _animalTagEntryLocalService.deleteAnimalTagEntry(animalTagEntry);
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
			deleteAnimalTagEntry(long animalTagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.deleteAnimalTagEntry(animalTagId);
	}

	@Override
	public void deleteDogEntryAnimalTagEntries(
		long dogId,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		_animalTagEntryLocalService.deleteDogEntryAnimalTagEntries(
			dogId, animalTagEntries);
	}

	@Override
	public void deleteDogEntryAnimalTagEntries(
		long dogId, long[] animalTagIds) {

		_animalTagEntryLocalService.deleteDogEntryAnimalTagEntries(
			dogId, animalTagIds);
	}

	@Override
	public void deleteDogEntryAnimalTagEntry(
		long dogId,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		_animalTagEntryLocalService.deleteDogEntryAnimalTagEntry(
			dogId, animalTagEntry);
	}

	@Override
	public void deleteDogEntryAnimalTagEntry(long dogId, long animalTagId) {
		_animalTagEntryLocalService.deleteDogEntryAnimalTagEntry(
			dogId, animalTagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deletePetEntryAnimalTagEntries(
		long petId,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		_animalTagEntryLocalService.deletePetEntryAnimalTagEntries(
			petId, animalTagEntries);
	}

	@Override
	public void deletePetEntryAnimalTagEntries(
		long petId, long[] animalTagIds) {

		_animalTagEntryLocalService.deletePetEntryAnimalTagEntries(
			petId, animalTagIds);
	}

	@Override
	public void deletePetEntryAnimalTagEntry(
		long petId,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		_animalTagEntryLocalService.deletePetEntryAnimalTagEntry(
			petId, animalTagEntry);
	}

	@Override
	public void deletePetEntryAnimalTagEntry(long petId, long animalTagId) {
		_animalTagEntryLocalService.deletePetEntryAnimalTagEntry(
			petId, animalTagId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _animalTagEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _animalTagEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animalTagEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _animalTagEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _animalTagEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _animalTagEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _animalTagEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _animalTagEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		fetchAnimalTagEntry(long animalTagId) {

		return _animalTagEntryLocalService.fetchAnimalTagEntry(animalTagId);
	}

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		fetchAnimalTagEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _animalTagEntryLocalService.
			fetchAnimalTagEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAnimalTagEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		fetchAnimalTagEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _animalTagEntryLocalService.fetchAnimalTagEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal tag entry matching the UUID and group.
	 *
	 * @param uuid the animal tag entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		fetchAnimalTagEntryByUuidAndGroupId(String uuid, long groupId) {

		return _animalTagEntryLocalService.fetchAnimalTagEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		findAnimalTagByName(long customerId, String name) {

		return _animalTagEntryLocalService.findAnimalTagByName(
			customerId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animalTagEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getAnimalTagEntries(int start, int end) {

		return _animalTagEntryLocalService.getAnimalTagEntries(start, end);
	}

	/**
	 * Returns all the animal tag entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal tag entries
	 * @param companyId the primary key of the company
	 * @return the matching animal tag entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getAnimalTagEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _animalTagEntryLocalService.
			getAnimalTagEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getAnimalTagEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.AnimalTagEntry>
					orderByComparator) {

		return _animalTagEntryLocalService.
			getAnimalTagEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	@Override
	public int getAnimalTagEntriesCount() {
		return _animalTagEntryLocalService.getAnimalTagEntriesCount();
	}

	/**
	 * Returns the animal tag entry with the primary key.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws PortalException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry getAnimalTagEntry(
			long animalTagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.getAnimalTagEntry(animalTagId);
	}

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry
	 * @throws PortalException if a matching animal tag entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
			getAnimalTagEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.
			getAnimalTagEntryByExternalReferenceCode(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
			getAnimalTagEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.getAnimalTagEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getDogEntryAnimalTagEntries(long dogId) {

		return _animalTagEntryLocalService.getDogEntryAnimalTagEntries(dogId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getDogEntryAnimalTagEntries(long dogId, int start, int end) {

		return _animalTagEntryLocalService.getDogEntryAnimalTagEntries(
			dogId, start, end);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getDogEntryAnimalTagEntries(
			long dogId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.AnimalTagEntry>
					orderByComparator) {

		return _animalTagEntryLocalService.getDogEntryAnimalTagEntries(
			dogId, start, end, orderByComparator);
	}

	@Override
	public int getDogEntryAnimalTagEntriesCount(long dogId) {
		return _animalTagEntryLocalService.getDogEntryAnimalTagEntriesCount(
			dogId);
	}

	/**
	 * Returns the dogIds of the dog entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the dogIds of dog entries associated with the animal tag entry
	 */
	@Override
	public long[] getDogEntryPrimaryKeys(long animalTagId) {
		return _animalTagEntryLocalService.getDogEntryPrimaryKeys(animalTagId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _animalTagEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animalTagEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animalTagEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getPetEntryAnimalTagEntries(long petId) {

		return _animalTagEntryLocalService.getPetEntryAnimalTagEntries(petId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getPetEntryAnimalTagEntries(long petId, int start, int end) {

		return _animalTagEntryLocalService.getPetEntryAnimalTagEntries(
			petId, start, end);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
		getPetEntryAnimalTagEntries(
			long petId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.AnimalTagEntry>
					orderByComparator) {

		return _animalTagEntryLocalService.getPetEntryAnimalTagEntries(
			petId, start, end, orderByComparator);
	}

	@Override
	public int getPetEntryAnimalTagEntriesCount(long petId) {
		return _animalTagEntryLocalService.getPetEntryAnimalTagEntriesCount(
			petId);
	}

	/**
	 * Returns the petIds of the pet entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the petIds of pet entries associated with the animal tag entry
	 */
	@Override
	public long[] getPetEntryPrimaryKeys(long animalTagId) {
		return _animalTagEntryLocalService.getPetEntryPrimaryKeys(animalTagId);
	}

	@Override
	public boolean hasDogEntryAnimalTagEntries(long dogId) {
		return _animalTagEntryLocalService.hasDogEntryAnimalTagEntries(dogId);
	}

	@Override
	public boolean hasDogEntryAnimalTagEntry(long dogId, long animalTagId) {
		return _animalTagEntryLocalService.hasDogEntryAnimalTagEntry(
			dogId, animalTagId);
	}

	@Override
	public boolean hasPetEntryAnimalTagEntries(long petId) {
		return _animalTagEntryLocalService.hasPetEntryAnimalTagEntries(petId);
	}

	@Override
	public boolean hasPetEntryAnimalTagEntry(long petId, long animalTagId) {
		return _animalTagEntryLocalService.hasPetEntryAnimalTagEntry(
			petId, animalTagId);
	}

	@Override
	public void setDogEntryAnimalTagEntries(long dogId, long[] animalTagIds) {
		_animalTagEntryLocalService.setDogEntryAnimalTagEntries(
			dogId, animalTagIds);
	}

	@Override
	public void setPetEntryAnimalTagEntries(long petId, long[] animalTagIds) {
		_animalTagEntryLocalService.setPetEntryAnimalTagEntries(
			petId, animalTagIds);
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry updateAnimalTag(
			long creatorId, long tagId,
			com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel
				animalTagMapperModel,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalTagEntryLocalService.updateAnimalTag(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalTagEntry
		updateAnimalTagEntry(
			com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		return _animalTagEntryLocalService.updateAnimalTagEntry(animalTagEntry);
	}

	@Override
	public AnimalTagEntryLocalService getWrappedService() {
		return _animalTagEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AnimalTagEntryLocalService animalTagEntryLocalService) {

		_animalTagEntryLocalService = animalTagEntryLocalService;
	}

	private AnimalTagEntryLocalService _animalTagEntryLocalService;

}