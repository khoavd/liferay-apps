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

import com.dogoo.sample.pet.service.model.AnimalTagEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the animal tag entry service. This utility wraps <code>com.dogoo.sample.pet.service.service.persistence.impl.AnimalTagEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see AnimalTagEntryPersistence
 * @generated
 */
public class AnimalTagEntryUtil {

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
	public static void clearCache(AnimalTagEntry animalTagEntry) {
		getPersistence().clearCache(animalTagEntry);
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
	public static Map<Serializable, AnimalTagEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnimalTagEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnimalTagEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnimalTagEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnimalTagEntry update(AnimalTagEntry animalTagEntry) {
		return getPersistence().update(animalTagEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnimalTagEntry update(
		AnimalTagEntry animalTagEntry, ServiceContext serviceContext) {

		return getPersistence().update(animalTagEntry, serviceContext);
	}

	/**
	 * Returns all the animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByUuid_First(
			String uuid, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUuid_First(
		String uuid, OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByUuid_Last(
			String uuid, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry[] findByUuid_PrevAndNext(
			long animalTagId, String uuid,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			animalTagId, uuid, orderByComparator);
	}

	/**
	 * Removes all the animal tag entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal tag entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the animal tag entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal tag entry that was removed
	 */
	public static AnimalTagEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry[] findByUuid_C_PrevAndNext(
			long animalTagId, String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			animalTagId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the animal tag entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal tag entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByG_(long groupId) {
		return getPersistence().findByG_(groupId);
	}

	/**
	 * Returns a range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByG_(
		long groupId, int start, int end) {

		return getPersistence().findByG_(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByG__First(
			long groupId, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByG__First(
		long groupId, OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByG__Last(
			long groupId, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByG__Last(
		long groupId, OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry[] findByG__PrevAndNext(
			long animalTagId, long groupId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByG__PrevAndNext(
			animalTagId, groupId, orderByComparator);
	}

	/**
	 * Removes all the animal tag entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByG_(long groupId) {
		getPersistence().removeByG_(groupId);
	}

	/**
	 * Returns the number of animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	public static int countByG_(long groupId) {
		return getPersistence().countByG_(groupId);
	}

	/**
	 * Returns all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByC_N(long customerId, String name) {
		return getPersistence().findByC_N(customerId, name);
	}

	/**
	 * Returns a range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return getPersistence().findByC_N(customerId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	public static List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().fetchByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry[] findByC_N_PrevAndNext(
			long animalTagId, long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByC_N_PrevAndNext(
			animalTagId, customerId, name, orderByComparator);
	}

	/**
	 * Removes all the animal tag entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public static void removeByC_N(long customerId, String name) {
		getPersistence().removeByC_N(customerId, name);
	}

	/**
	 * Returns the number of animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal tag entries
	 */
	public static int countByC_N(long customerId, String name) {
		return getPersistence().countByC_N(customerId, name);
	}

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public static AnimalTagEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal tag entry that was removed
	 */
	public static AnimalTagEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of animal tag entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal tag entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the animal tag entry in the entity cache if it is enabled.
	 *
	 * @param animalTagEntry the animal tag entry
	 */
	public static void cacheResult(AnimalTagEntry animalTagEntry) {
		getPersistence().cacheResult(animalTagEntry);
	}

	/**
	 * Caches the animal tag entries in the entity cache if it is enabled.
	 *
	 * @param animalTagEntries the animal tag entries
	 */
	public static void cacheResult(List<AnimalTagEntry> animalTagEntries) {
		getPersistence().cacheResult(animalTagEntries);
	}

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	public static AnimalTagEntry create(long animalTagId) {
		return getPersistence().create(animalTagId);
	}

	/**
	 * Removes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry remove(long animalTagId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().remove(animalTagId);
	}

	public static AnimalTagEntry updateImpl(AnimalTagEntry animalTagEntry) {
		return getPersistence().updateImpl(animalTagEntry);
	}

	/**
	 * Returns the animal tag entry with the primary key or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry findByPrimaryKey(long animalTagId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalTagEntryException {

		return getPersistence().findByPrimaryKey(animalTagId);
	}

	/**
	 * Returns the animal tag entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry, or <code>null</code> if a animal tag entry with the primary key could not be found
	 */
	public static AnimalTagEntry fetchByPrimaryKey(long animalTagId) {
		return getPersistence().fetchByPrimaryKey(animalTagId);
	}

	/**
	 * Returns all the animal tag entries.
	 *
	 * @return the animal tag entries
	 */
	public static List<AnimalTagEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of animal tag entries
	 */
	public static List<AnimalTagEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries
	 */
	public static List<AnimalTagEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animal tag entries
	 */
	public static List<AnimalTagEntry> findAll(
		int start, int end, OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the animal tag entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of pet entries associated with the animal tag entry
	 */
	public static long[] getPetEntryPrimaryKeys(long pk) {
		return getPersistence().getPetEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the animal tag entries associated with the pet entry
	 */
	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(long pk) {
		return getPersistence().getPetEntryAnimalTagEntries(pk);
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the pet entry
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of animal tag entries associated with the pet entry
	 */
	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end) {

		return getPersistence().getPetEntryAnimalTagEntries(pk, start, end);
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the pet entry
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries associated with the pet entry
	 */
	public static List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().getPetEntryAnimalTagEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of pet entries associated with the animal tag entry
	 */
	public static int getPetEntriesSize(long pk) {
		return getPersistence().getPetEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the pet entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 * @return <code>true</code> if the pet entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	public static boolean containsPetEntry(long pk, long petEntryPK) {
		return getPersistence().containsPetEntry(pk, petEntryPK);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry has any pet entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with pet entries
	 * @return <code>true</code> if the animal tag entry has any pet entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPetEntries(long pk) {
		return getPersistence().containsPetEntries(pk);
	}

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	public static void addPetEntry(long pk, long petEntryPK) {
		getPersistence().addPetEntry(pk, petEntryPK);
	}

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	public static void addPetEntry(
		long pk, com.dogoo.sample.pet.service.model.PetEntry petEntry) {

		getPersistence().addPetEntry(pk, petEntry);
	}

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	public static void addPetEntries(long pk, long[] petEntryPKs) {
		getPersistence().addPetEntries(pk, petEntryPKs);
	}

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	public static void addPetEntries(
		long pk, List<com.dogoo.sample.pet.service.model.PetEntry> petEntries) {

		getPersistence().addPetEntries(pk, petEntries);
	}

	/**
	 * Clears all associations between the animal tag entry and its pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated pet entries from
	 */
	public static void clearPetEntries(long pk) {
		getPersistence().clearPetEntries(pk);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	public static void removePetEntry(long pk, long petEntryPK) {
		getPersistence().removePetEntry(pk, petEntryPK);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	public static void removePetEntry(
		long pk, com.dogoo.sample.pet.service.model.PetEntry petEntry) {

		getPersistence().removePetEntry(pk, petEntry);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	public static void removePetEntries(long pk, long[] petEntryPKs) {
		getPersistence().removePetEntries(pk, petEntryPKs);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	public static void removePetEntries(
		long pk, List<com.dogoo.sample.pet.service.model.PetEntry> petEntries) {

		getPersistence().removePetEntries(pk, petEntries);
	}

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries to be associated with the animal tag entry
	 */
	public static void setPetEntries(long pk, long[] petEntryPKs) {
		getPersistence().setPetEntries(pk, petEntryPKs);
	}

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries to be associated with the animal tag entry
	 */
	public static void setPetEntries(
		long pk, List<com.dogoo.sample.pet.service.model.PetEntry> petEntries) {

		getPersistence().setPetEntries(pk, petEntries);
	}

	/**
	 * Returns the primaryKeys of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of dog entries associated with the animal tag entry
	 */
	public static long[] getDogEntryPrimaryKeys(long pk) {
		return getPersistence().getDogEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the animal tag entries associated with the dog entry
	 */
	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(long pk) {
		return getPersistence().getDogEntryAnimalTagEntries(pk);
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the dog entry
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of animal tag entries associated with the dog entry
	 */
	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end) {

		return getPersistence().getDogEntryAnimalTagEntries(pk, start, end);
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the dog entry
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries associated with the dog entry
	 */
	public static List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return getPersistence().getDogEntryAnimalTagEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of dog entries associated with the animal tag entry
	 */
	public static int getDogEntriesSize(long pk) {
		return getPersistence().getDogEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the dog entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 * @return <code>true</code> if the dog entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	public static boolean containsDogEntry(long pk, long dogEntryPK) {
		return getPersistence().containsDogEntry(pk, dogEntryPK);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry has any dog entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with dog entries
	 * @return <code>true</code> if the animal tag entry has any dog entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsDogEntries(long pk) {
		return getPersistence().containsDogEntries(pk);
	}

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	public static void addDogEntry(long pk, long dogEntryPK) {
		getPersistence().addDogEntry(pk, dogEntryPK);
	}

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	public static void addDogEntry(
		long pk, com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		getPersistence().addDogEntry(pk, dogEntry);
	}

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	public static void addDogEntries(long pk, long[] dogEntryPKs) {
		getPersistence().addDogEntries(pk, dogEntryPKs);
	}

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	public static void addDogEntries(
		long pk, List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries) {

		getPersistence().addDogEntries(pk, dogEntries);
	}

	/**
	 * Clears all associations between the animal tag entry and its dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated dog entries from
	 */
	public static void clearDogEntries(long pk) {
		getPersistence().clearDogEntries(pk);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	public static void removeDogEntry(long pk, long dogEntryPK) {
		getPersistence().removeDogEntry(pk, dogEntryPK);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	public static void removeDogEntry(
		long pk, com.dogoo.sample.pet.service.model.DogEntry dogEntry) {

		getPersistence().removeDogEntry(pk, dogEntry);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	public static void removeDogEntries(long pk, long[] dogEntryPKs) {
		getPersistence().removeDogEntries(pk, dogEntryPKs);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	public static void removeDogEntries(
		long pk, List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries) {

		getPersistence().removeDogEntries(pk, dogEntries);
	}

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries to be associated with the animal tag entry
	 */
	public static void setDogEntries(long pk, long[] dogEntryPKs) {
		getPersistence().setDogEntries(pk, dogEntryPKs);
	}

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries to be associated with the animal tag entry
	 */
	public static void setDogEntries(
		long pk, List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries) {

		getPersistence().setDogEntries(pk, dogEntries);
	}

	public static AnimalTagEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AnimalTagEntryPersistence _persistence;

}