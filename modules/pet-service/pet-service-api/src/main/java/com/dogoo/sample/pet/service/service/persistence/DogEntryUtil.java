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

package com.dogoo.sample.pet.service.service.persistence;

import com.dogoo.sample.pet.service.model.DogEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dog entry service. This utility wraps <code>com.dogoo.sample.pet.service.service.persistence.impl.DogEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see DogEntryPersistence
 * @generated
 */
public class DogEntryUtil {

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
	public static void clearCache(DogEntry dogEntry) {
		getPersistence().clearCache(dogEntry);
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
	public static Map<Serializable, DogEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DogEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DogEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DogEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DogEntry update(DogEntry dogEntry) {
		return getPersistence().update(dogEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DogEntry update(
		DogEntry dogEntry, ServiceContext serviceContext) {

		return getPersistence().update(dogEntry, serviceContext);
	}

	/**
	 * Returns all the dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dog entries
	 */
	public static List<DogEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dog entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of matching dog entries
	 */
	public static List<DogEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dog entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dog entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByUuid_First(
			String uuid, OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUuid_First(
		String uuid, OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByUuid_Last(
			String uuid, OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry[] findByUuid_PrevAndNext(
			long dogId, String uuid,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			dogId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dog entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dog entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dog entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dog entry that was removed
	 */
	public static DogEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dog entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dog entries
	 */
	public static List<DogEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of matching dog entries
	 */
	public static List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry[] findByUuid_C_PrevAndNext(
			long dogId, String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dogId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dog entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dog entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dog entries
	 */
	public static List<DogEntry> findByG_(long groupId) {
		return getPersistence().findByG_(groupId);
	}

	/**
	 * Returns a range of all the dog entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of matching dog entries
	 */
	public static List<DogEntry> findByG_(long groupId, int start, int end) {
		return getPersistence().findByG_(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the dog entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dog entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByG__First(
			long groupId, OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByG__First(
		long groupId, OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByG__Last(
			long groupId, OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByG__Last(
		long groupId, OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry[] findByG__PrevAndNext(
			long dogId, long groupId,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByG__PrevAndNext(
			dogId, groupId, orderByComparator);
	}

	/**
	 * Removes all the dog entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByG_(long groupId) {
		getPersistence().removeByG_(groupId);
	}

	/**
	 * Returns the number of dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	public static int countByG_(long groupId) {
		return getPersistence().countByG_(groupId);
	}

	/**
	 * Returns all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching dog entries
	 */
	public static List<DogEntry> findByC_N(long customerId, String name) {
		return getPersistence().findByC_N(customerId, name);
	}

	/**
	 * Returns a range of all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of matching dog entries
	 */
	public static List<DogEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return getPersistence().findByC_N(customerId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dog entries
	 */
	public static List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().fetchByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry[] findByC_N_PrevAndNext(
			long dogId, long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByC_N_PrevAndNext(
			dogId, customerId, name, orderByComparator);
	}

	/**
	 * Removes all the dog entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public static void removeByC_N(long customerId, String name) {
		getPersistence().removeByC_N(customerId, name);
	}

	/**
	 * Returns the number of dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching dog entries
	 */
	public static int countByC_N(long customerId, String name) {
		return getPersistence().countByC_N(customerId, name);
	}

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public static DogEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public static DogEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the dog entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dog entry that was removed
	 */
	public static DogEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of dog entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dog entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the dog entry in the entity cache if it is enabled.
	 *
	 * @param dogEntry the dog entry
	 */
	public static void cacheResult(DogEntry dogEntry) {
		getPersistence().cacheResult(dogEntry);
	}

	/**
	 * Caches the dog entries in the entity cache if it is enabled.
	 *
	 * @param dogEntries the dog entries
	 */
	public static void cacheResult(List<DogEntry> dogEntries) {
		getPersistence().cacheResult(dogEntries);
	}

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	public static DogEntry create(long dogId) {
		return getPersistence().create(dogId);
	}

	/**
	 * Removes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry remove(long dogId)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().remove(dogId);
	}

	public static DogEntry updateImpl(DogEntry dogEntry) {
		return getPersistence().updateImpl(dogEntry);
	}

	/**
	 * Returns the dog entry with the primary key or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public static DogEntry findByPrimaryKey(long dogId)
		throws com.dogoo.sample.pet.service.exception.NoSuchDogEntryException {

		return getPersistence().findByPrimaryKey(dogId);
	}

	/**
	 * Returns the dog entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry, or <code>null</code> if a dog entry with the primary key could not be found
	 */
	public static DogEntry fetchByPrimaryKey(long dogId) {
		return getPersistence().fetchByPrimaryKey(dogId);
	}

	/**
	 * Returns all the dog entries.
	 *
	 * @return the dog entries
	 */
	public static List<DogEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dog entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of dog entries
	 */
	public static List<DogEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dog entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dog entries
	 */
	public static List<DogEntry> findAll(
		int start, int end, OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dog entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dog entries
	 */
	public static List<DogEntry> findAll(
		int start, int end, OrderByComparator<DogEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dog entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the dog entry
	 */
	public static long[] getAnimalTagEntryPrimaryKeys(long pk) {
		return getPersistence().getAnimalTagEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the dog entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the dog entries associated with the animal tag entry
	 */
	public static List<DogEntry> getAnimalTagEntryDogEntries(long pk) {
		return getPersistence().getAnimalTagEntryDogEntries(pk);
	}

	/**
	 * Returns all the dog entry associated with the animal tag entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of dog entries associated with the animal tag entry
	 */
	public static List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end) {

		return getPersistence().getAnimalTagEntryDogEntries(pk, start, end);
	}

	/**
	 * Returns all the dog entry associated with the animal tag entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dog entries associated with the animal tag entry
	 */
	public static List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return getPersistence().getAnimalTagEntryDogEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the number of animal tag entries associated with the dog entry
	 */
	public static int getAnimalTagEntriesSize(long pk) {
		return getPersistence().getAnimalTagEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the dog entry; <code>false</code> otherwise
	 */
	public static boolean containsAnimalTagEntry(
		long pk, long animalTagEntryPK) {

		return getPersistence().containsAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Returns <code>true</code> if the dog entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the dog entry to check for associations with animal tag entries
	 * @return <code>true</code> if the dog entry has any animal tag entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAnimalTagEntries(long pk) {
		return getPersistence().containsAnimalTagEntries(pk);
	}

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public static void addAnimalTagEntry(long pk, long animalTagEntryPK) {
		getPersistence().addAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	public static void addAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		getPersistence().addAnimalTagEntry(pk, animalTagEntry);
	}

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public static void addAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		getPersistence().addAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	public static void addAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().addAnimalTagEntries(pk, animalTagEntries);
	}

	/**
	 * Clears all associations between the dog entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry to clear the associated animal tag entries from
	 */
	public static void clearAnimalTagEntries(long pk) {
		getPersistence().clearAnimalTagEntries(pk);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public static void removeAnimalTagEntry(long pk, long animalTagEntryPK) {
		getPersistence().removeAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	public static void removeAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		getPersistence().removeAnimalTagEntry(pk, animalTagEntry);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public static void removeAnimalTagEntries(
		long pk, long[] animalTagEntryPKs) {

		getPersistence().removeAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	public static void removeAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().removeAnimalTagEntries(pk, animalTagEntries);
	}

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the dog entry
	 */
	public static void setAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		getPersistence().setAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries to be associated with the dog entry
	 */
	public static void setAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().setAnimalTagEntries(pk, animalTagEntries);
	}

	public static DogEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DogEntryPersistence _persistence;

}