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

package com.dogoo.poc.upgradeservice.cat.service.service.persistence;

import com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cat usa entry service. This utility wraps <code>com.dogoo.poc.upgradeservice.cat.service.service.persistence.impl.CatUsaEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatUsaEntryPersistence
 * @generated
 */
public class CatUsaEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CatUsaEntry catUsaEntry) {
		getPersistence().clearCache(catUsaEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CatUsaEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CatUsaEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatUsaEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatUsaEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CatUsaEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CatUsaEntry update(CatUsaEntry catUsaEntry) {
		return getPersistence().update(catUsaEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CatUsaEntry update(
		CatUsaEntry catUsaEntry, ServiceContext serviceContext) {

		return getPersistence().update(catUsaEntry, serviceContext);
	}

	/**
	 * Returns all the cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cat usa entries
	 */
	public static List<CatUsaEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cat usa entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @return the range of matching cat usa entries
	 */
	public static List<CatUsaEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cat usa entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cat usa entries
	 */
	public static List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatUsaEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat usa entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cat usa entries
	 */
	public static List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatUsaEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	public static CatUsaEntry findByUuid_First(
			String uuid, OrderByComparator<CatUsaEntry> orderByComparator)
		throws com.dogoo.poc.upgradeservice.cat.service.exception.
			NoSuchCatUsaEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	public static CatUsaEntry fetchByUuid_First(
		String uuid, OrderByComparator<CatUsaEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	public static CatUsaEntry findByUuid_Last(
			String uuid, OrderByComparator<CatUsaEntry> orderByComparator)
		throws com.dogoo.poc.upgradeservice.cat.service.exception.
			NoSuchCatUsaEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	public static CatUsaEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CatUsaEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cat usa entries before and after the current cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param catId the primary key of the current cat usa entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public static CatUsaEntry[] findByUuid_PrevAndNext(
			long catId, String uuid,
			OrderByComparator<CatUsaEntry> orderByComparator)
		throws com.dogoo.poc.upgradeservice.cat.service.exception.
			NoSuchCatUsaEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			catId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cat usa entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cat usa entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the cat usa entry in the entity cache if it is enabled.
	 *
	 * @param catUsaEntry the cat usa entry
	 */
	public static void cacheResult(CatUsaEntry catUsaEntry) {
		getPersistence().cacheResult(catUsaEntry);
	}

	/**
	 * Caches the cat usa entries in the entity cache if it is enabled.
	 *
	 * @param catUsaEntries the cat usa entries
	 */
	public static void cacheResult(List<CatUsaEntry> catUsaEntries) {
		getPersistence().cacheResult(catUsaEntries);
	}

	/**
	 * Creates a new cat usa entry with the primary key. Does not add the cat usa entry to the database.
	 *
	 * @param catId the primary key for the new cat usa entry
	 * @return the new cat usa entry
	 */
	public static CatUsaEntry create(long catId) {
		return getPersistence().create(catId);
	}

	/**
	 * Removes the cat usa entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry that was removed
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public static CatUsaEntry remove(long catId)
		throws com.dogoo.poc.upgradeservice.cat.service.exception.
			NoSuchCatUsaEntryException {

		return getPersistence().remove(catId);
	}

	public static CatUsaEntry updateImpl(CatUsaEntry catUsaEntry) {
		return getPersistence().updateImpl(catUsaEntry);
	}

	/**
	 * Returns the cat usa entry with the primary key or throws a <code>NoSuchCatUsaEntryException</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public static CatUsaEntry findByPrimaryKey(long catId)
		throws com.dogoo.poc.upgradeservice.cat.service.exception.
			NoSuchCatUsaEntryException {

		return getPersistence().findByPrimaryKey(catId);
	}

	/**
	 * Returns the cat usa entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry, or <code>null</code> if a cat usa entry with the primary key could not be found
	 */
	public static CatUsaEntry fetchByPrimaryKey(long catId) {
		return getPersistence().fetchByPrimaryKey(catId);
	}

	/**
	 * Returns all the cat usa entries.
	 *
	 * @return the cat usa entries
	 */
	public static List<CatUsaEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cat usa entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @return the range of cat usa entries
	 */
	public static List<CatUsaEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cat usa entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cat usa entries
	 */
	public static List<CatUsaEntry> findAll(
		int start, int end, OrderByComparator<CatUsaEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat usa entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatUsaEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat usa entries
	 * @param end the upper bound of the range of cat usa entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cat usa entries
	 */
	public static List<CatUsaEntry> findAll(
		int start, int end, OrderByComparator<CatUsaEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cat usa entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cat usa entries.
	 *
	 * @return the number of cat usa entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CatUsaEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CatUsaEntryPersistence _persistence;

}