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

import com.dogoo.sample.pet.service.exception.NoSuchAnimalGroupEntryException;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the animal group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see AnimalGroupEntryUtil
 * @generated
 */
@ProviderType
public interface AnimalGroupEntryPersistence
	extends BasePersistence<AnimalGroupEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnimalGroupEntryUtil} to access the animal group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal group entries
	 */
	public java.util.List<AnimalGroupEntry> findByUuid(String uuid);

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
	public java.util.List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public java.util.List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public AnimalGroupEntry[] findByUuid_PrevAndNext(
			long animalGroupId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Removes all the animal group entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal group entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the animal group entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal group entry that was removed
	 */
	public AnimalGroupEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the number of animal group entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal group entries
	 */
	public java.util.List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public java.util.List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public AnimalGroupEntry[] findByUuid_C_PrevAndNext(
			long animalGroupId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Removes all the animal group entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal group entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal group entries
	 */
	public java.util.List<AnimalGroupEntry> findByG_(long groupId);

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
	public java.util.List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end);

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
	public java.util.List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public java.util.List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByG__First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByG__Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public AnimalGroupEntry[] findByG__PrevAndNext(
			long animalGroupId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Removes all the animal group entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByG_(long groupId);

	/**
	 * Returns the number of animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	public int countByG_(long groupId);

	/**
	 * Returns all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal group entries
	 */
	public java.util.List<AnimalGroupEntry> findByC_N(
		long customerId, String name);

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
	public java.util.List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end);

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
	public java.util.List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public java.util.List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByC_N_First(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByC_N_First(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByC_N_Last(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByC_N_Last(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public AnimalGroupEntry[] findByC_N_PrevAndNext(
			long animalGroupId, long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
				orderByComparator)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Removes all the animal group entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public void removeByC_N(long customerId, String name);

	/**
	 * Returns the number of animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal group entries
	 */
	public int countByC_N(long customerId, String name);

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	public AnimalGroupEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the animal group entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal group entry that was removed
	 */
	public AnimalGroupEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the number of animal group entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal group entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the animal group entry in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntry the animal group entry
	 */
	public void cacheResult(AnimalGroupEntry animalGroupEntry);

	/**
	 * Caches the animal group entries in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntries the animal group entries
	 */
	public void cacheResult(
		java.util.List<AnimalGroupEntry> animalGroupEntries);

	/**
	 * Creates a new animal group entry with the primary key. Does not add the animal group entry to the database.
	 *
	 * @param animalGroupId the primary key for the new animal group entry
	 * @return the new animal group entry
	 */
	public AnimalGroupEntry create(long animalGroupId);

	/**
	 * Removes the animal group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry that was removed
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public AnimalGroupEntry remove(long animalGroupId)
		throws NoSuchAnimalGroupEntryException;

	public AnimalGroupEntry updateImpl(AnimalGroupEntry animalGroupEntry);

	/**
	 * Returns the animal group entry with the primary key or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	public AnimalGroupEntry findByPrimaryKey(long animalGroupId)
		throws NoSuchAnimalGroupEntryException;

	/**
	 * Returns the animal group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry, or <code>null</code> if a animal group entry with the primary key could not be found
	 */
	public AnimalGroupEntry fetchByPrimaryKey(long animalGroupId);

	/**
	 * Returns all the animal group entries.
	 *
	 * @return the animal group entries
	 */
	public java.util.List<AnimalGroupEntry> findAll();

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
	public java.util.List<AnimalGroupEntry> findAll(int start, int end);

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
	public java.util.List<AnimalGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator);

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
	public java.util.List<AnimalGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalGroupEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the animal group entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of animal group entries.
	 *
	 * @return the number of animal group entries
	 */
	public int countAll();

}