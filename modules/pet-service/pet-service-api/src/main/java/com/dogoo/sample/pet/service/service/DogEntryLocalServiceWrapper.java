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
 * Provides a wrapper for {@link DogEntryLocalService}.
 *
 * @author khoavu
 * @see DogEntryLocalService
 * @generated
 */
public class DogEntryLocalServiceWrapper
	implements DogEntryLocalService, ServiceWrapper<DogEntryLocalService> {

	public DogEntryLocalServiceWrapper(
		DogEntryLocalService dogEntryLocalService) {

		_dogEntryLocalService = dogEntryLocalService;
	}

	@Override
	public void addAnimalTagEntryDogEntries(
		long animalTagId,
		java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
			dogEntries) {

		_dogEntryLocalService.addAnimalTagEntryDogEntries(
			animalTagId, dogEntries);
	}

	@Override
	public void addAnimalTagEntryDogEntries(long animalTagId, long[] dogIds) {
		_dogEntryLocalService.addAnimalTagEntryDogEntries(animalTagId, dogIds);
	}

	@Override
	public void addAnimalTagEntryDogEntry(
		long animalTagId,
		com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		_dogEntryLocalService.addAnimalTagEntryDogEntry(animalTagId, dogEntry);
	}

	@Override
	public void addAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		_dogEntryLocalService.addAnimalTagEntryDogEntry(animalTagId, dogId);
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
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry addDogEntry(
		com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		return _dogEntryLocalService.addDogEntry(dogEntry);
	}

	@Override
	public com.dogoo.sample.pet.service.model.DogEntry addDogEntry(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.DogMapperModel dogMapperModel,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _dogEntryLocalService.addDogEntry(
			customerId, creatorId, dogMapperModel, context);
	}

	@Override
	public com.dogoo.sample.pet.service.model.DogEntry approvalDogEntry(
			long creatorId, long entryId, String status,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.approvalDogEntry(
			creatorId, entryId, status, context);
	}

	@Override
	public void clearAnimalTagEntryDogEntries(long animalTagId) {
		_dogEntryLocalService.clearAnimalTagEntryDogEntries(animalTagId);
	}

	@Override
	public int countByName(long customerId, String name) {
		return _dogEntryLocalService.countByName(customerId, name);
	}

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry createDogEntry(
		long dogId) {

		return _dogEntryLocalService.createDogEntry(dogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAnimalTagEntryDogEntries(
		long animalTagId,
		java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
			dogEntries) {

		_dogEntryLocalService.deleteAnimalTagEntryDogEntries(
			animalTagId, dogEntries);
	}

	@Override
	public void deleteAnimalTagEntryDogEntries(
		long animalTagId, long[] dogIds) {

		_dogEntryLocalService.deleteAnimalTagEntryDogEntries(
			animalTagId, dogIds);
	}

	@Override
	public void deleteAnimalTagEntryDogEntry(
		long animalTagId,
		com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		_dogEntryLocalService.deleteAnimalTagEntryDogEntry(
			animalTagId, dogEntry);
	}

	@Override
	public void deleteAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		_dogEntryLocalService.deleteAnimalTagEntryDogEntry(animalTagId, dogId);
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
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry deleteDogEntry(
		com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		return _dogEntryLocalService.deleteDogEntry(dogEntry);
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
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry deleteDogEntry(
			long dogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.deleteDogEntry(dogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dogEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dogEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dogEntryLocalService.dynamicQuery();
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

		return _dogEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dogEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dogEntryLocalService.dynamicQuery(
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

		return _dogEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dogEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.sample.pet.service.model.DogEntry fetchDogEntry(
		long dogId) {

		return _dogEntryLocalService.fetchDogEntry(dogId);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry
		fetchDogEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dogEntryLocalService.fetchDogEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDogEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry
		fetchDogEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _dogEntryLocalService.fetchDogEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry
		fetchDogEntryByUuidAndGroupId(String uuid, long groupId) {

		return _dogEntryLocalService.fetchDogEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		findByName(long customerId, String name) {

		return _dogEntryLocalService.findByName(customerId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dogEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getAnimalTagEntryDogEntries(long animalTagId) {

		return _dogEntryLocalService.getAnimalTagEntryDogEntries(animalTagId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getAnimalTagEntryDogEntries(long animalTagId, int start, int end) {

		return _dogEntryLocalService.getAnimalTagEntryDogEntries(
			animalTagId, start, end);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getAnimalTagEntryDogEntries(
			long animalTagId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.DogEntry>
					orderByComparator) {

		return _dogEntryLocalService.getAnimalTagEntryDogEntries(
			animalTagId, start, end, orderByComparator);
	}

	@Override
	public int getAnimalTagEntryDogEntriesCount(long animalTagId) {
		return _dogEntryLocalService.getAnimalTagEntryDogEntriesCount(
			animalTagId);
	}

	/**
	 * Returns the animalTagIds of the animal tag entries associated with the dog entry.
	 *
	 * @param dogId the dogId of the dog entry
	 * @return long[] the animalTagIds of animal tag entries associated with the dog entry
	 */
	@Override
	public long[] getAnimalTagEntryPrimaryKeys(long dogId) {
		return _dogEntryLocalService.getAnimalTagEntryPrimaryKeys(dogId);
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getDogEntries(int start, int end) {

		return _dogEntryLocalService.getDogEntries(start, end);
	}

	/**
	 * Returns all the dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @return the matching dog entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getDogEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _dogEntryLocalService.getDogEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.DogEntry>
		getDogEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.DogEntry>
					orderByComparator) {

		return _dogEntryLocalService.getDogEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	@Override
	public int getDogEntriesCount() {
		return _dogEntryLocalService.getDogEntriesCount();
	}

	/**
	 * Returns the dog entry with the primary key.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry getDogEntry(long dogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.getDogEntry(dogId);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry
			getDogEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.getDogEntryByExternalReferenceCode(
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
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry
			getDogEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.getDogEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dogEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dogEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dogEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAnimalTagEntryDogEntries(long animalTagId) {
		return _dogEntryLocalService.hasAnimalTagEntryDogEntries(animalTagId);
	}

	@Override
	public boolean hasAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		return _dogEntryLocalService.hasAnimalTagEntryDogEntry(
			animalTagId, dogId);
	}

	@Override
	public void setAnimalTagEntryDogEntries(long animalTagId, long[] dogIds) {
		_dogEntryLocalService.setAnimalTagEntryDogEntries(animalTagId, dogIds);
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
	@Override
	public com.dogoo.sample.pet.service.model.DogEntry updateDogEntry(
		com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		return _dogEntryLocalService.updateDogEntry(dogEntry);
	}

	@Override
	public com.dogoo.sample.pet.service.model.DogEntry updateDogEntry(
			long customerId, long entryId, long creatorId,
			com.dogoo.sample.pet.service.mapper.model.DogMapperModel
				dogMapperModel,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dogEntryLocalService.updateDogEntry(
			customerId, entryId, creatorId, dogMapperModel, context);
	}

	@Override
	public DogEntryLocalService getWrappedService() {
		return _dogEntryLocalService;
	}

	@Override
	public void setWrappedService(DogEntryLocalService dogEntryLocalService) {
		_dogEntryLocalService = dogEntryLocalService;
	}

	private DogEntryLocalService _dogEntryLocalService;

}