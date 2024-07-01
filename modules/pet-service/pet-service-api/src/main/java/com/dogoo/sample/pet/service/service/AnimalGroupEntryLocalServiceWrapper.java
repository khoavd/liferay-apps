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
 * Provides a wrapper for {@link AnimalGroupEntryLocalService}.
 *
 * @author khoavu
 * @see AnimalGroupEntryLocalService
 * @generated
 */
public class AnimalGroupEntryLocalServiceWrapper
	implements AnimalGroupEntryLocalService,
			   ServiceWrapper<AnimalGroupEntryLocalService> {

	public AnimalGroupEntryLocalServiceWrapper(
		AnimalGroupEntryLocalService animalGroupEntryLocalService) {

		_animalGroupEntryLocalService = animalGroupEntryLocalService;
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry addAnimalGroup(
		long customerId, long creatorId,
		com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel
			animalGroupMapperModel,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _animalGroupEntryLocalService.addAnimalGroup(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		addAnimalGroupEntry(
			com.dogoo.sample.pet.service.model.AnimalGroupEntry
				animalGroupEntry) {

		return _animalGroupEntryLocalService.addAnimalGroupEntry(
			animalGroupEntry);
	}

	@Override
	public int countAnimalGroupByName(long customerId, String name) {
		return _animalGroupEntryLocalService.countAnimalGroupByName(
			customerId, name);
	}

	/**
	 * Creates a new animal group entry with the primary key. Does not add the animal group entry to the database.
	 *
	 * @param animalGroupId the primary key for the new animal group entry
	 * @return the new animal group entry
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		createAnimalGroupEntry(long animalGroupId) {

		return _animalGroupEntryLocalService.createAnimalGroupEntry(
			animalGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		deleteAnimalGroupEntry(
			com.dogoo.sample.pet.service.model.AnimalGroupEntry
				animalGroupEntry) {

		return _animalGroupEntryLocalService.deleteAnimalGroupEntry(
			animalGroupEntry);
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
			deleteAnimalGroupEntry(long animalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.deleteAnimalGroupEntry(
			animalGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _animalGroupEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _animalGroupEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animalGroupEntryLocalService.dynamicQuery();
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

		return _animalGroupEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _animalGroupEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _animalGroupEntryLocalService.dynamicQuery(
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

		return _animalGroupEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _animalGroupEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		fetchAnimalGroupEntry(long animalGroupId) {

		return _animalGroupEntryLocalService.fetchAnimalGroupEntry(
			animalGroupId);
	}

	/**
	 * Returns the animal group entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal group entry's external reference code
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		fetchAnimalGroupEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _animalGroupEntryLocalService.
			fetchAnimalGroupEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAnimalGroupEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		fetchAnimalGroupEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _animalGroupEntryLocalService.
			fetchAnimalGroupEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal group entry matching the UUID and group.
	 *
	 * @param uuid the animal group entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		fetchAnimalGroupEntryByUuidAndGroupId(String uuid, long groupId) {

		return _animalGroupEntryLocalService.
			fetchAnimalGroupEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalGroupEntry>
		findAnimalGroupByName(long customerId, String name) {

		return _animalGroupEntryLocalService.findAnimalGroupByName(
			customerId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animalGroupEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalGroupEntry>
		getAnimalGroupEntries(int start, int end) {

		return _animalGroupEntryLocalService.getAnimalGroupEntries(start, end);
	}

	/**
	 * Returns all the animal group entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal group entries
	 * @param companyId the primary key of the company
	 * @return the matching animal group entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalGroupEntry>
		getAnimalGroupEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _animalGroupEntryLocalService.
			getAnimalGroupEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.dogoo.sample.pet.service.model.AnimalGroupEntry>
		getAnimalGroupEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.sample.pet.service.model.AnimalGroupEntry>
					orderByComparator) {

		return _animalGroupEntryLocalService.
			getAnimalGroupEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal group entries.
	 *
	 * @return the number of animal group entries
	 */
	@Override
	public int getAnimalGroupEntriesCount() {
		return _animalGroupEntryLocalService.getAnimalGroupEntriesCount();
	}

	/**
	 * Returns the animal group entry with the primary key.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws PortalException if a animal group entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
			getAnimalGroupEntry(long animalGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.getAnimalGroupEntry(animalGroupId);
	}

	/**
	 * Returns the animal group entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal group entry's external reference code
	 * @return the matching animal group entry
	 * @throws PortalException if a matching animal group entry could not be found
	 */
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
			getAnimalGroupEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.
			getAnimalGroupEntryByExternalReferenceCode(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
			getAnimalGroupEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.
			getAnimalGroupEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _animalGroupEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animalGroupEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animalGroupEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
			updateAnimalGroup(
				long creatorId, long animalGroupId,
				com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel
					animalGroupMapperModel,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalGroupEntryLocalService.updateAnimalGroup(
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
	@Override
	public com.dogoo.sample.pet.service.model.AnimalGroupEntry
		updateAnimalGroupEntry(
			com.dogoo.sample.pet.service.model.AnimalGroupEntry
				animalGroupEntry) {

		return _animalGroupEntryLocalService.updateAnimalGroupEntry(
			animalGroupEntry);
	}

	@Override
	public AnimalGroupEntryLocalService getWrappedService() {
		return _animalGroupEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AnimalGroupEntryLocalService animalGroupEntryLocalService) {

		_animalGroupEntryLocalService = animalGroupEntryLocalService;
	}

	private AnimalGroupEntryLocalService _animalGroupEntryLocalService;

}