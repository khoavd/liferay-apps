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

import com.dogoo.sample.pet.service.exception.NoSuchDogEntryException;
import com.dogoo.sample.pet.service.model.DogEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dog entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see DogEntryUtil
 * @generated
 */
@ProviderType
public interface DogEntryPersistence extends BasePersistence<DogEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DogEntryUtil} to access the dog entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dog entries
	 */
	public java.util.List<DogEntry> findByUuid(String uuid);

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
	public java.util.List<DogEntry> findByUuid(String uuid, int start, int end);

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
	public java.util.List<DogEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public java.util.List<DogEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public DogEntry[] findByUuid_PrevAndNext(
			long dogId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Removes all the dog entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dog entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDogEntryException;

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dog entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dog entry that was removed
	 */
	public DogEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDogEntryException;

	/**
	 * Returns the number of dog entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dog entries
	 */
	public java.util.List<DogEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public java.util.List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public DogEntry[] findByUuid_C_PrevAndNext(
			long dogId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Removes all the dog entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dog entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dog entries
	 */
	public java.util.List<DogEntry> findByG_(long groupId);

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
	public java.util.List<DogEntry> findByG_(long groupId, int start, int end);

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
	public java.util.List<DogEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public java.util.List<DogEntry> findByG_(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByG__First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByG__First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByG__Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByG__Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public DogEntry[] findByG__PrevAndNext(
			long dogId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Removes all the dog entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByG_(long groupId);

	/**
	 * Returns the number of dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	public int countByG_(long groupId);

	/**
	 * Returns all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching dog entries
	 */
	public java.util.List<DogEntry> findByC_N(long customerId, String name);

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
	public java.util.List<DogEntry> findByC_N(
		long customerId, String name, int start, int end);

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
	public java.util.List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public java.util.List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByC_N_First(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByC_N_First(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByC_N_Last(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByC_N_Last(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public DogEntry[] findByC_N_PrevAndNext(
			long dogId, long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
				orderByComparator)
		throws NoSuchDogEntryException;

	/**
	 * Removes all the dog entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public void removeByC_N(long customerId, String name);

	/**
	 * Returns the number of dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching dog entries
	 */
	public int countByC_N(long customerId, String name);

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	public DogEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchDogEntryException;

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	public DogEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the dog entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dog entry that was removed
	 */
	public DogEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchDogEntryException;

	/**
	 * Returns the number of dog entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dog entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the dog entry in the entity cache if it is enabled.
	 *
	 * @param dogEntry the dog entry
	 */
	public void cacheResult(DogEntry dogEntry);

	/**
	 * Caches the dog entries in the entity cache if it is enabled.
	 *
	 * @param dogEntries the dog entries
	 */
	public void cacheResult(java.util.List<DogEntry> dogEntries);

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	public DogEntry create(long dogId);

	/**
	 * Removes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public DogEntry remove(long dogId) throws NoSuchDogEntryException;

	public DogEntry updateImpl(DogEntry dogEntry);

	/**
	 * Returns the dog entry with the primary key or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	public DogEntry findByPrimaryKey(long dogId) throws NoSuchDogEntryException;

	/**
	 * Returns the dog entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry, or <code>null</code> if a dog entry with the primary key could not be found
	 */
	public DogEntry fetchByPrimaryKey(long dogId);

	/**
	 * Returns all the dog entries.
	 *
	 * @return the dog entries
	 */
	public java.util.List<DogEntry> findAll();

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
	public java.util.List<DogEntry> findAll(int start, int end);

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
	public java.util.List<DogEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

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
	public java.util.List<DogEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dog entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the dog entry
	 */
	public long[] getAnimalTagEntryPrimaryKeys(long pk);

	/**
	 * Returns all the dog entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the dog entries associated with the animal tag entry
	 */
	public java.util.List<DogEntry> getAnimalTagEntryDogEntries(long pk);

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
	public java.util.List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end);

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
	public java.util.List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DogEntry>
			orderByComparator);

	/**
	 * Returns the number of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the number of animal tag entries associated with the dog entry
	 */
	public int getAnimalTagEntriesSize(long pk);

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the dog entry; <code>false</code> otherwise
	 */
	public boolean containsAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Returns <code>true</code> if the dog entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the dog entry to check for associations with animal tag entries
	 * @return <code>true</code> if the dog entry has any animal tag entries associated with it; <code>false</code> otherwise
	 */
	public boolean containsAnimalTagEntries(long pk);

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public void addAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	public void addAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry);

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public void addAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	public void addAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

	/**
	 * Clears all associations between the dog entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry to clear the associated animal tag entries from
	 */
	public void clearAnimalTagEntries(long pk);

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public void removeAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	public void removeAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry);

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public void removeAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	public void removeAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the dog entry
	 */
	public void setAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries to be associated with the dog entry
	 */
	public void setAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

}