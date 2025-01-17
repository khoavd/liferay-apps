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

import com.dogoo.sample.pet.service.model.AnimalGroupEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the animal group entry service. This utility wraps <code>com.dogoo.sample.pet.service.service.persistence.impl.AnimalGroupEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see AnimalGroupEntryPersistence
 * @generated
 */
public class AnimalGroupEntryUtil {

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
	public static void clearCache(AnimalGroupEntry animalGroupEntry) {
		getPersistence().clearCache(animalGroupEntry);
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
	public static Map<Serializable, AnimalGroupEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnimalGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnimalGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnimalGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnimalGroupEntry update(AnimalGroupEntry animalGroupEntry) {
		return getPersistence().update(animalGroupEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnimalGroupEntry update(
		AnimalGroupEntry animalGroupEntry, ServiceContext serviceContext) {

		return getPersistence().update(animalGroupEntry, serviceContext);
	}

	/**
	 * Returns all the animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByUuid_First(
			String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUuid_First(
		String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByUuid_Last(
			String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry[] findByUuid_PrevAndNext(
			long animalGroupId, String uuid,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			animalGroupId, uuid, orderByComparator);
	}

	/**
	 * Removes all the animal group entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal group entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the animal group entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal group entry that was removed
	 */
	public static AnimalGroupEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry[] findByUuid_C_PrevAndNext(
			long animalGroupId, String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			animalGroupId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the animal group entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal group entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByG_(long groupId) {
		return getPersistence().findByG_(groupId);
	}

	/**
	 * Returns a range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end) {

		return getPersistence().findByG_(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByG__First(
			long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByG__First(
		long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByG__First(groupId, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByG__Last(
			long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByG__Last(
		long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByG__Last(groupId, orderByComparator);
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry[] findByG__PrevAndNext(
			long animalGroupId, long groupId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByG__PrevAndNext(
			animalGroupId, groupId, orderByComparator);
	}

	/**
	 * Removes all the animal group entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByG_(long groupId) {
		getPersistence().removeByG_(groupId);
	}

	/**
	 * Returns the number of animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	public static int countByG_(long groupId) {
		return getPersistence().countByG_(groupId);
	}

	/**
	 * Returns all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByC_N(
		long customerId, String name) {

		return getPersistence().findByC_N(customerId, name);
	}

	/**
	 * Returns a range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return getPersistence().findByC_N(customerId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	public static List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().fetchByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry[] findByC_N_PrevAndNext(
			long animalGroupId, long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByC_N_PrevAndNext(
			animalGroupId, customerId, name, orderByComparator);
	}

	/**
	 * Removes all the animal group entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public static void removeByC_N(long customerId, String name) {
		getPersistence().removeByC_N(customerId, name);
	}

	/**
	 * Returns the number of animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal group entries
	 */
	public static int countByC_N(long customerId, String name) {
		return getPersistence().countByC_N(customerId, name);
	}

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public static AnimalGroupEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the animal group entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal group entry that was removed
	 */
	public static AnimalGroupEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of animal group entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal group entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the animal group entry in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntry the animal group entry
	 */
	public static void cacheResult(AnimalGroupEntry animalGroupEntry) {
		getPersistence().cacheResult(animalGroupEntry);
	}

	/**
	 * Caches the animal group entries in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntries the animal group entries
	 */
	public static void cacheResult(List<AnimalGroupEntry> animalGroupEntries) {
		getPersistence().cacheResult(animalGroupEntries);
	}

	/**
	 * Creates a new animal group entry with the primary key. Does not add the animal group entry to the database.
	 *
	 * @param animalGroupId the primary key for the new animal group entry
	 * @return the new animal group entry
	 */
	public static AnimalGroupEntry create(long animalGroupId) {
		return getPersistence().create(animalGroupId);
	}

	/**
	 * Removes the animal group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry that was removed
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry remove(long animalGroupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().remove(animalGroupId);
	}

	public static AnimalGroupEntry updateImpl(
		AnimalGroupEntry animalGroupEntry) {

		return getPersistence().updateImpl(animalGroupEntry);
	}

	/**
	 * Returns the animal group entry with the primary key or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry findByPrimaryKey(long animalGroupId)
		throws com.dogoo.sample.pet.service.exception.
			NoSuchAnimalGroupEntryException {

		return getPersistence().findByPrimaryKey(animalGroupId);
	}

	/**
	 * Returns the animal group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry, or <code>null</code> if a animal group entry with the primary key could not be found
	 */
	public static AnimalGroupEntry fetchByPrimaryKey(long animalGroupId) {
		return getPersistence().fetchByPrimaryKey(animalGroupId);
	}

	/**
	 * Returns all the animal group entries.
	 *
	 * @return the animal group entries
	 */
	public static List<AnimalGroupEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of animal group entries
	 */
	public static List<AnimalGroupEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal group entries
	 */
	public static List<AnimalGroupEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animal group entries
	 */
	public static List<AnimalGroupEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the animal group entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of animal group entries.
	 *
	 * @return the number of animal group entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnimalGroupEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AnimalGroupEntryPersistence _persistence;

}