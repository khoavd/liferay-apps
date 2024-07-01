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

import com.dogoo.sample.pet.service.model.PetEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet entry service. This utility wraps <code>com.dogoo.sample.pet.service.service.persistence.impl.PetEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see PetEntryPersistence
 * @generated
 */
public class PetEntryUtil {

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
	public static void clearCache(PetEntry petEntry) {
		getPersistence().clearCache(petEntry);
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
	public static Map<Serializable, PetEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetEntry update(PetEntry petEntry) {
		return getPersistence().update(petEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetEntry update(
		PetEntry petEntry, ServiceContext serviceContext) {

		return getPersistence().update(petEntry, serviceContext);
	}

	/**
	 * Returns all the pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet entries
	 */
	public static List<PetEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public static List<PetEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByUuid_First(
			String uuid, OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUuid_First(
		String uuid, OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByUuid_Last(
			String uuid, OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry[] findByUuid_PrevAndNext(
			long petId, String uuid,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			petId, uuid, orderByComparator);
	}

	/**
	 * Removes all the pet entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the pet entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet entry that was removed
	 */
	public static PetEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of pet entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet entries
	 */
	public static List<PetEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public static List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			petId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the pet entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the matching pet entries
	 */
	public static List<PetEntry> findByC_V(long customerId, boolean vaccine) {
		return getPersistence().findByC_V(customerId, vaccine);
	}

	/**
	 * Returns a range of all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public static List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end) {

		return getPersistence().findByC_V(customerId, vaccine, start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findByC_V(
			customerId, vaccine, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_V(
			customerId, vaccine, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByC_V_First(
			long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_V_First(
			customerId, vaccine, orderByComparator);
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_V_First(
		long customerId, boolean vaccine,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByC_V_First(
			customerId, vaccine, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByC_V_Last(
			long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_V_Last(
			customerId, vaccine, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_V_Last(
		long customerId, boolean vaccine,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByC_V_Last(
			customerId, vaccine, orderByComparator);
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry[] findByC_V_PrevAndNext(
			long petId, long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_V_PrevAndNext(
			petId, customerId, vaccine, orderByComparator);
	}

	/**
	 * Removes all the pet entries where customerId = &#63; and vaccine = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 */
	public static void removeByC_V(long customerId, boolean vaccine) {
		getPersistence().removeByC_V(customerId, vaccine);
	}

	/**
	 * Returns the number of pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the number of matching pet entries
	 */
	public static int countByC_V(long customerId, boolean vaccine) {
		return getPersistence().countByC_V(customerId, vaccine);
	}

	/**
	 * Returns all the pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the matching pet entries
	 */
	public static List<PetEntry> findByA_G(long animalGroupId) {
		return getPersistence().findByA_G(animalGroupId);
	}

	/**
	 * Returns a range of all the pet entries where animalGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param animalGroupId the animal group ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public static List<PetEntry> findByA_G(
		long animalGroupId, int start, int end) {

		return getPersistence().findByA_G(animalGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries where animalGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param animalGroupId the animal group ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findByA_G(
			animalGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries where animalGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param animalGroupId the animal group ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByA_G(
			animalGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByA_G_First(
			long animalGroupId, OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByA_G_First(
			animalGroupId, orderByComparator);
	}

	/**
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByA_G_First(
		long animalGroupId, OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByA_G_First(
			animalGroupId, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByA_G_Last(
			long animalGroupId, OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByA_G_Last(
			animalGroupId, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByA_G_Last(
		long animalGroupId, OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByA_G_Last(
			animalGroupId, orderByComparator);
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry[] findByA_G_PrevAndNext(
			long petId, long animalGroupId,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByA_G_PrevAndNext(
			petId, animalGroupId, orderByComparator);
	}

	/**
	 * Removes all the pet entries where animalGroupId = &#63; from the database.
	 *
	 * @param animalGroupId the animal group ID
	 */
	public static void removeByA_G(long animalGroupId) {
		getPersistence().removeByA_G(animalGroupId);
	}

	/**
	 * Returns the number of pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the number of matching pet entries
	 */
	public static int countByA_G(long animalGroupId) {
		return getPersistence().countByA_G(animalGroupId);
	}

	/**
	 * Returns all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching pet entries
	 */
	public static List<PetEntry> findByC_N(long customerId, String name) {
		return getPersistence().findByC_N(customerId, name);
	}

	/**
	 * Returns a range of all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public static List<PetEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return getPersistence().findByC_N(customerId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public static List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_N(
			customerId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByC_N_First(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().fetchByC_N_Last(
			customerId, name, orderByComparator);
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry[] findByC_N_PrevAndNext(
			long petId, long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_N_PrevAndNext(
			petId, customerId, name, orderByComparator);
	}

	/**
	 * Removes all the pet entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public static void removeByC_N(long customerId, String name) {
		getPersistence().removeByC_N(customerId, name);
	}

	/**
	 * Returns the number of pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching pet entries
	 */
	public static int countByC_N(long customerId, String name) {
		return getPersistence().countByC_N(customerId, name);
	}

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public static PetEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the pet entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the pet entry that was removed
	 */
	public static PetEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of pet entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching pet entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the pet entry in the entity cache if it is enabled.
	 *
	 * @param petEntry the pet entry
	 */
	public static void cacheResult(PetEntry petEntry) {
		getPersistence().cacheResult(petEntry);
	}

	/**
	 * Caches the pet entries in the entity cache if it is enabled.
	 *
	 * @param petEntries the pet entries
	 */
	public static void cacheResult(List<PetEntry> petEntries) {
		getPersistence().cacheResult(petEntries);
	}

	/**
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	public static PetEntry create(long petId) {
		return getPersistence().create(petId);
	}

	/**
	 * Removes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry remove(long petId)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().remove(petId);
	}

	public static PetEntry updateImpl(PetEntry petEntry) {
		return getPersistence().updateImpl(petEntry);
	}

	/**
	 * Returns the pet entry with the primary key or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public static PetEntry findByPrimaryKey(long petId)
		throws com.dogoo.sample.pet.service.exception.NoSuchPetEntryException {

		return getPersistence().findByPrimaryKey(petId);
	}

	/**
	 * Returns the pet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry, or <code>null</code> if a pet entry with the primary key could not be found
	 */
	public static PetEntry fetchByPrimaryKey(long petId) {
		return getPersistence().fetchByPrimaryKey(petId);
	}

	/**
	 * Returns all the pet entries.
	 *
	 * @return the pet entries
	 */
	public static List<PetEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of pet entries
	 */
	public static List<PetEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet entries
	 */
	public static List<PetEntry> findAll(
		int start, int end, OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet entries
	 */
	public static List<PetEntry> findAll(
		int start, int end, OrderByComparator<PetEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the pet entry
	 */
	public static long[] getAnimalTagEntryPrimaryKeys(long pk) {
		return getPersistence().getAnimalTagEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the pet entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the pet entries associated with the animal tag entry
	 */
	public static List<PetEntry> getAnimalTagEntryPetEntries(long pk) {
		return getPersistence().getAnimalTagEntryPetEntries(pk);
	}

	/**
	 * Returns all the pet entry associated with the animal tag entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of pet entries associated with the animal tag entry
	 */
	public static List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end) {

		return getPersistence().getAnimalTagEntryPetEntries(pk, start, end);
	}

	/**
	 * Returns all the pet entry associated with the animal tag entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet entries associated with the animal tag entry
	 */
	public static List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getPersistence().getAnimalTagEntryPetEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the number of animal tag entries associated with the pet entry
	 */
	public static int getAnimalTagEntriesSize(long pk) {
		return getPersistence().getAnimalTagEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the pet entry; <code>false</code> otherwise
	 */
	public static boolean containsAnimalTagEntry(
		long pk, long animalTagEntryPK) {

		return getPersistence().containsAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Returns <code>true</code> if the pet entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the pet entry to check for associations with animal tag entries
	 * @return <code>true</code> if the pet entry has any animal tag entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAnimalTagEntries(long pk) {
		return getPersistence().containsAnimalTagEntries(pk);
	}

	/**
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public static void addAnimalTagEntry(long pk, long animalTagEntryPK) {
		getPersistence().addAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	public static void addAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		getPersistence().addAnimalTagEntry(pk, animalTagEntry);
	}

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public static void addAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		getPersistence().addAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries
	 */
	public static void addAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().addAnimalTagEntries(pk, animalTagEntries);
	}

	/**
	 * Clears all associations between the pet entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry to clear the associated animal tag entries from
	 */
	public static void clearAnimalTagEntries(long pk) {
		getPersistence().clearAnimalTagEntries(pk);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public static void removeAnimalTagEntry(long pk, long animalTagEntryPK) {
		getPersistence().removeAnimalTagEntry(pk, animalTagEntryPK);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	public static void removeAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry) {

		getPersistence().removeAnimalTagEntry(pk, animalTagEntry);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public static void removeAnimalTagEntries(
		long pk, long[] animalTagEntryPKs) {

		getPersistence().removeAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries
	 */
	public static void removeAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().removeAnimalTagEntries(pk, animalTagEntries);
	}

	/**
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the pet entry
	 */
	public static void setAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		getPersistence().setAnimalTagEntries(pk, animalTagEntryPKs);
	}

	/**
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries to be associated with the pet entry
	 */
	public static void setAnimalTagEntries(
		long pk,
		List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries) {

		getPersistence().setAnimalTagEntries(pk, animalTagEntries);
	}

	public static PetEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetEntryPersistence _persistence;

}