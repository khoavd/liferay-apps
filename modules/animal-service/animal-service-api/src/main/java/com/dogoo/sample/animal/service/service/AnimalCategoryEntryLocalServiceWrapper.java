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

package com.dogoo.sample.animal.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimalCategoryEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnimalCategoryEntryLocalService
 * @generated
 */
public class AnimalCategoryEntryLocalServiceWrapper
	implements AnimalCategoryEntryLocalService,
			   ServiceWrapper<AnimalCategoryEntryLocalService> {

	public AnimalCategoryEntryLocalServiceWrapper(
		AnimalCategoryEntryLocalService animalCategoryEntryLocalService) {

		_animalCategoryEntryLocalService = animalCategoryEntryLocalService;
	}

	/**
	 * Adds the animal category entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalCategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalCategoryEntry the animal category entry
	 * @return the animal category entry that was added
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
		addAnimalCategoryEntry(
			com.dogoo.sample.animal.service.model.AnimalCategoryEntry
				animalCategoryEntry) {

		return _animalCategoryEntryLocalService.addAnimalCategoryEntry(
			animalCategoryEntry);
	}

	/**
	 * Creates a new animal category entry with the primary key. Does not add the animal category entry to the database.
	 *
	 * @param animalId the primary key for the new animal category entry
	 * @return the new animal category entry
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
		createAnimalCategoryEntry(long animalId) {

		return _animalCategoryEntryLocalService.createAnimalCategoryEntry(
			animalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalCategoryEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the animal category entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalCategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalCategoryEntry the animal category entry
	 * @return the animal category entry that was removed
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
		deleteAnimalCategoryEntry(
			com.dogoo.sample.animal.service.model.AnimalCategoryEntry
				animalCategoryEntry) {

		return _animalCategoryEntryLocalService.deleteAnimalCategoryEntry(
			animalCategoryEntry);
	}

	/**
	 * Deletes the animal category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalCategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry that was removed
	 * @throws PortalException if a animal category entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
			deleteAnimalCategoryEntry(long animalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalCategoryEntryLocalService.deleteAnimalCategoryEntry(
			animalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalCategoryEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _animalCategoryEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _animalCategoryEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animalCategoryEntryLocalService.dynamicQuery();
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

		return _animalCategoryEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.animal.service.model.impl.AnimalCategoryEntryModelImpl</code>.
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

		return _animalCategoryEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.animal.service.model.impl.AnimalCategoryEntryModelImpl</code>.
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

		return _animalCategoryEntryLocalService.dynamicQuery(
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

		return _animalCategoryEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _animalCategoryEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
		fetchAnimalCategoryEntry(long animalId) {

		return _animalCategoryEntryLocalService.fetchAnimalCategoryEntry(
			animalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animalCategoryEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the animal category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.animal.service.model.impl.AnimalCategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal category entries
	 * @param end the upper bound of the range of animal category entries (not inclusive)
	 * @return the range of animal category entries
	 */
	@Override
	public java.util.List
		<com.dogoo.sample.animal.service.model.AnimalCategoryEntry>
			getAnimalCategoryEntries(int start, int end) {

		return _animalCategoryEntryLocalService.getAnimalCategoryEntries(
			start, end);
	}

	/**
	 * Returns the number of animal category entries.
	 *
	 * @return the number of animal category entries
	 */
	@Override
	public int getAnimalCategoryEntriesCount() {
		return _animalCategoryEntryLocalService.getAnimalCategoryEntriesCount();
	}

	/**
	 * Returns the animal category entry with the primary key.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry
	 * @throws PortalException if a animal category entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
			getAnimalCategoryEntry(long animalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalCategoryEntryLocalService.getAnimalCategoryEntry(
			animalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animalCategoryEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animalCategoryEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animalCategoryEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the animal category entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalCategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalCategoryEntry the animal category entry
	 * @return the animal category entry that was updated
	 */
	@Override
	public com.dogoo.sample.animal.service.model.AnimalCategoryEntry
		updateAnimalCategoryEntry(
			com.dogoo.sample.animal.service.model.AnimalCategoryEntry
				animalCategoryEntry) {

		return _animalCategoryEntryLocalService.updateAnimalCategoryEntry(
			animalCategoryEntry);
	}

	@Override
	public AnimalCategoryEntryLocalService getWrappedService() {
		return _animalCategoryEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AnimalCategoryEntryLocalService animalCategoryEntryLocalService) {

		_animalCategoryEntryLocalService = animalCategoryEntryLocalService;
	}

	private AnimalCategoryEntryLocalService _animalCategoryEntryLocalService;

}