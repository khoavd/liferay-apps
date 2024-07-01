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

import com.dogoo.sample.pet.service.exception.NoSuchAnimalTagEntryException;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the animal tag entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see AnimalTagEntryUtil
 * @generated
 */
@ProviderType
public interface AnimalTagEntryPersistence
	extends BasePersistence<AnimalTagEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnimalTagEntryUtil} to access the animal tag entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal tag entries
	 */
	public java.util.List<AnimalTagEntry> findByUuid(String uuid);

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
	public java.util.List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public java.util.List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public AnimalTagEntry[] findByUuid_PrevAndNext(
			long animalTagId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Removes all the animal tag entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal tag entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the animal tag entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal tag entry that was removed
	 */
	public AnimalTagEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal tag entries
	 */
	public java.util.List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public java.util.List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public AnimalTagEntry[] findByUuid_C_PrevAndNext(
			long animalTagId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Removes all the animal tag entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal tag entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal tag entries
	 */
	public java.util.List<AnimalTagEntry> findByG_(long groupId);

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
	public java.util.List<AnimalTagEntry> findByG_(
		long groupId, int start, int end);

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
	public java.util.List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public java.util.List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByG__First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByG__Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public AnimalTagEntry[] findByG__PrevAndNext(
			long animalTagId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Removes all the animal tag entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByG_(long groupId);

	/**
	 * Returns the number of animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	public int countByG_(long groupId);

	/**
	 * Returns all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal tag entries
	 */
	public java.util.List<AnimalTagEntry> findByC_N(
		long customerId, String name);

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
	public java.util.List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end);

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
	public java.util.List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public java.util.List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByC_N_First(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByC_N_First(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByC_N_Last(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByC_N_Last(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public AnimalTagEntry[] findByC_N_PrevAndNext(
			long animalTagId, long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
				orderByComparator)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Removes all the animal tag entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public void removeByC_N(long customerId, String name);

	/**
	 * Returns the number of animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal tag entries
	 */
	public int countByC_N(long customerId, String name);

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	public AnimalTagEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal tag entry that was removed
	 */
	public AnimalTagEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the number of animal tag entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal tag entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the animal tag entry in the entity cache if it is enabled.
	 *
	 * @param animalTagEntry the animal tag entry
	 */
	public void cacheResult(AnimalTagEntry animalTagEntry);

	/**
	 * Caches the animal tag entries in the entity cache if it is enabled.
	 *
	 * @param animalTagEntries the animal tag entries
	 */
	public void cacheResult(java.util.List<AnimalTagEntry> animalTagEntries);

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	public AnimalTagEntry create(long animalTagId);

	/**
	 * Removes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public AnimalTagEntry remove(long animalTagId)
		throws NoSuchAnimalTagEntryException;

	public AnimalTagEntry updateImpl(AnimalTagEntry animalTagEntry);

	/**
	 * Returns the animal tag entry with the primary key or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	public AnimalTagEntry findByPrimaryKey(long animalTagId)
		throws NoSuchAnimalTagEntryException;

	/**
	 * Returns the animal tag entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry, or <code>null</code> if a animal tag entry with the primary key could not be found
	 */
	public AnimalTagEntry fetchByPrimaryKey(long animalTagId);

	/**
	 * Returns all the animal tag entries.
	 *
	 * @return the animal tag entries
	 */
	public java.util.List<AnimalTagEntry> findAll();

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
	public java.util.List<AnimalTagEntry> findAll(int start, int end);

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
	public java.util.List<AnimalTagEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

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
	public java.util.List<AnimalTagEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the animal tag entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of pet entries associated with the animal tag entry
	 */
	public long[] getPetEntryPrimaryKeys(long pk);

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the animal tag entries associated with the pet entry
	 */
	public java.util.List<AnimalTagEntry> getPetEntryAnimalTagEntries(long pk);

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
	public java.util.List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end);

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
	public java.util.List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the number of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of pet entries associated with the animal tag entry
	 */
	public int getPetEntriesSize(long pk);

	/**
	 * Returns <code>true</code> if the pet entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 * @return <code>true</code> if the pet entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	public boolean containsPetEntry(long pk, long petEntryPK);

	/**
	 * Returns <code>true</code> if the animal tag entry has any pet entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with pet entries
	 * @return <code>true</code> if the animal tag entry has any pet entries associated with it; <code>false</code> otherwise
	 */
	public boolean containsPetEntries(long pk);

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	public void addPetEntry(long pk, long petEntryPK);

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	public void addPetEntry(
		long pk, com.dogoo.sample.pet.service.model.PetEntry petEntry);

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	public void addPetEntries(long pk, long[] petEntryPKs);

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	public void addPetEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.PetEntry> petEntries);

	/**
	 * Clears all associations between the animal tag entry and its pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated pet entries from
	 */
	public void clearPetEntries(long pk);

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	public void removePetEntry(long pk, long petEntryPK);

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	public void removePetEntry(
		long pk, com.dogoo.sample.pet.service.model.PetEntry petEntry);

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	public void removePetEntries(long pk, long[] petEntryPKs);

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	public void removePetEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.PetEntry> petEntries);

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries to be associated with the animal tag entry
	 */
	public void setPetEntries(long pk, long[] petEntryPKs);

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries to be associated with the animal tag entry
	 */
	public void setPetEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.PetEntry> petEntries);

	/**
	 * Returns the primaryKeys of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of dog entries associated with the animal tag entry
	 */
	public long[] getDogEntryPrimaryKeys(long pk);

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the animal tag entries associated with the dog entry
	 */
	public java.util.List<AnimalTagEntry> getDogEntryAnimalTagEntries(long pk);

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
	public java.util.List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end);

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
	public java.util.List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalTagEntry>
			orderByComparator);

	/**
	 * Returns the number of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of dog entries associated with the animal tag entry
	 */
	public int getDogEntriesSize(long pk);

	/**
	 * Returns <code>true</code> if the dog entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 * @return <code>true</code> if the dog entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	public boolean containsDogEntry(long pk, long dogEntryPK);

	/**
	 * Returns <code>true</code> if the animal tag entry has any dog entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with dog entries
	 * @return <code>true</code> if the animal tag entry has any dog entries associated with it; <code>false</code> otherwise
	 */
	public boolean containsDogEntries(long pk);

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	public void addDogEntry(long pk, long dogEntryPK);

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	public void addDogEntry(
		long pk, com.dogoo.sample.pet.service.model.DogEntry dogEntry);

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	public void addDogEntries(long pk, long[] dogEntryPKs);

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	public void addDogEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries);

	/**
	 * Clears all associations between the animal tag entry and its dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated dog entries from
	 */
	public void clearDogEntries(long pk);

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	public void removeDogEntry(long pk, long dogEntryPK);

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	public void removeDogEntry(
		long pk, com.dogoo.sample.pet.service.model.DogEntry dogEntry);

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	public void removeDogEntries(long pk, long[] dogEntryPKs);

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	public void removeDogEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries);

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries to be associated with the animal tag entry
	 */
	public void setDogEntries(long pk, long[] dogEntryPKs);

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries to be associated with the animal tag entry
	 */
	public void setDogEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.DogEntry> dogEntries);

}