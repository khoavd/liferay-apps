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

package com.dogoo.poc.upgradeservice.cat.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CatUsaEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CatUsaEntryLocalService
 * @generated
 */
public class CatUsaEntryLocalServiceWrapper
	implements CatUsaEntryLocalService,
			   ServiceWrapper<CatUsaEntryLocalService> {

	public CatUsaEntryLocalServiceWrapper(
		CatUsaEntryLocalService catUsaEntryLocalService) {

		_catUsaEntryLocalService = catUsaEntryLocalService;
	}

	/**
	 * Adds the cat usa entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatUsaEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catUsaEntry the cat usa entry
	 * @return the cat usa entry that was added
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
		addCatUsaEntry(
			com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
				catUsaEntry) {

		return _catUsaEntryLocalService.addCatUsaEntry(catUsaEntry);
	}

	/**
	 * Creates a new cat usa entry with the primary key. Does not add the cat usa entry to the database.
	 *
	 * @param catId the primary key for the new cat usa entry
	 * @return the new cat usa entry
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
		createCatUsaEntry(long catId) {

		return _catUsaEntryLocalService.createCatUsaEntry(catId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catUsaEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cat usa entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatUsaEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catUsaEntry the cat usa entry
	 * @return the cat usa entry that was removed
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
		deleteCatUsaEntry(
			com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
				catUsaEntry) {

		return _catUsaEntryLocalService.deleteCatUsaEntry(catUsaEntry);
	}

	/**
	 * Deletes the cat usa entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatUsaEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry that was removed
	 * @throws PortalException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
			deleteCatUsaEntry(long catId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catUsaEntryLocalService.deleteCatUsaEntry(catId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catUsaEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _catUsaEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _catUsaEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catUsaEntryLocalService.dynamicQuery();
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

		return _catUsaEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.upgradeservice.cat.service.model.impl.CatUsaEntryModelImpl</code>.
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

		return _catUsaEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.upgradeservice.cat.service.model.impl.CatUsaEntryModelImpl</code>.
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

		return _catUsaEntryLocalService.dynamicQuery(
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

		return _catUsaEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _catUsaEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
		fetchCatUsaEntry(long catId) {

		return _catUsaEntryLocalService.fetchCatUsaEntry(catId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _catUsaEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the cat usa entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.upgradeservice.cat.service.model.impl.CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @return the range of cat usa entries
	 */
	@Override
	public java.util.List
		<com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry>
			getCatUsaEntries(int start, int end) {

		return _catUsaEntryLocalService.getCatUsaEntries(start, end);
	}

	/**
	 * Returns the number of cat usa entries.
	 *
	 * @return the number of cat usa entries
	 */
	@Override
	public int getCatUsaEntriesCount() {
		return _catUsaEntryLocalService.getCatUsaEntriesCount();
	}

	/**
	 * Returns the cat usa entry with the primary key.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry
	 * @throws PortalException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
			getCatUsaEntry(long catId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catUsaEntryLocalService.getCatUsaEntry(catId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _catUsaEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _catUsaEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catUsaEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cat usa entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatUsaEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catUsaEntry the cat usa entry
	 * @return the cat usa entry that was updated
	 */
	@Override
	public com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
		updateCatUsaEntry(
			com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry
				catUsaEntry) {

		return _catUsaEntryLocalService.updateCatUsaEntry(catUsaEntry);
	}

	@Override
	public CatUsaEntryLocalService getWrappedService() {
		return _catUsaEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CatUsaEntryLocalService catUsaEntryLocalService) {

		_catUsaEntryLocalService = catUsaEntryLocalService;
	}

	private CatUsaEntryLocalService _catUsaEntryLocalService;

}