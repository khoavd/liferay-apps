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

import com.dogoo.sample.pet.service.exception.NoSuchPetEntryException;
import com.dogoo.sample.pet.service.model.PetEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @see PetEntryUtil
 * @generated
 */
@ProviderType
public interface PetEntryPersistence extends BasePersistence<PetEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetEntryUtil} to access the pet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid(String uuid);

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
	public java.util.List<PetEntry> findByUuid(String uuid, int start, int end);

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
	public java.util.List<PetEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry[] findByUuid_PrevAndNext(
			long petId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException;

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pet entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet entry that was removed
	 */
	public PetEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException;

	/**
	 * Returns the number of pet entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public PetEntry[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByC_V(long customerId, boolean vaccine);

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
	public java.util.List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end);

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
	public java.util.List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByC_V_First(
			long customerId, boolean vaccine,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_V_First(
		long customerId, boolean vaccine,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByC_V_Last(
			long customerId, boolean vaccine,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_V_Last(
		long customerId, boolean vaccine,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public PetEntry[] findByC_V_PrevAndNext(
			long petId, long customerId, boolean vaccine,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where customerId = &#63; and vaccine = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 */
	public void removeByC_V(long customerId, boolean vaccine);

	/**
	 * Returns the number of pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the number of matching pet entries
	 */
	public int countByC_V(long customerId, boolean vaccine);

	/**
	 * Returns all the pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByA_G(long animalGroupId);

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
	public java.util.List<PetEntry> findByA_G(
		long animalGroupId, int start, int end);

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
	public java.util.List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByA_G_First(
			long animalGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByA_G_First(
		long animalGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByA_G_Last(
			long animalGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByA_G_Last(
		long animalGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry[] findByA_G_PrevAndNext(
			long petId, long animalGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where animalGroupId = &#63; from the database.
	 *
	 * @param animalGroupId the animal group ID
	 */
	public void removeByA_G(long animalGroupId);

	/**
	 * Returns the number of pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the number of matching pet entries
	 */
	public int countByA_G(long animalGroupId);

	/**
	 * Returns all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByC_N(long customerId, String name);

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
	public java.util.List<PetEntry> findByC_N(
		long customerId, String name, int start, int end);

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
	public java.util.List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByC_N_First(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_N_First(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByC_N_Last(
			long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_N_Last(
		long customerId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public PetEntry[] findByC_N_PrevAndNext(
			long petId, long customerId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	public void removeByC_N(long customerId, String name);

	/**
	 * Returns the number of pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching pet entries
	 */
	public int countByC_N(long customerId, String name);

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPetEntryException;

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the pet entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the pet entry that was removed
	 */
	public PetEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPetEntryException;

	/**
	 * Returns the number of pet entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching pet entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the pet entry in the entity cache if it is enabled.
	 *
	 * @param petEntry the pet entry
	 */
	public void cacheResult(PetEntry petEntry);

	/**
	 * Caches the pet entries in the entity cache if it is enabled.
	 *
	 * @param petEntries the pet entries
	 */
	public void cacheResult(java.util.List<PetEntry> petEntries);

	/**
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	public PetEntry create(long petId);

	/**
	 * Removes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry remove(long petId) throws NoSuchPetEntryException;

	public PetEntry updateImpl(PetEntry petEntry);

	/**
	 * Returns the pet entry with the primary key or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry findByPrimaryKey(long petId) throws NoSuchPetEntryException;

	/**
	 * Returns the pet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry, or <code>null</code> if a pet entry with the primary key could not be found
	 */
	public PetEntry fetchByPrimaryKey(long petId);

	/**
	 * Returns all the pet entries.
	 *
	 * @return the pet entries
	 */
	public java.util.List<PetEntry> findAll();

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
	public java.util.List<PetEntry> findAll(int start, int end);

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
	public java.util.List<PetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

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
	public java.util.List<PetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the pet entry
	 */
	public long[] getAnimalTagEntryPrimaryKeys(long pk);

	/**
	 * Returns all the pet entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the pet entries associated with the animal tag entry
	 */
	public java.util.List<PetEntry> getAnimalTagEntryPetEntries(long pk);

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
	public java.util.List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end);

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
	public java.util.List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the number of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the number of animal tag entries associated with the pet entry
	 */
	public int getAnimalTagEntriesSize(long pk);

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the pet entry; <code>false</code> otherwise
	 */
	public boolean containsAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Returns <code>true</code> if the pet entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the pet entry to check for associations with animal tag entries
	 * @return <code>true</code> if the pet entry has any animal tag entries associated with it; <code>false</code> otherwise
	 */
	public boolean containsAnimalTagEntries(long pk);

	/**
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public void addAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	public void addAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry);

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public void addAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries
	 */
	public void addAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

	/**
	 * Clears all associations between the pet entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry to clear the associated animal tag entries from
	 */
	public void clearAnimalTagEntries(long pk);

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	public void removeAnimalTagEntry(long pk, long animalTagEntryPK);

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	public void removeAnimalTagEntry(
		long pk,
		com.dogoo.sample.pet.service.model.AnimalTagEntry animalTagEntry);

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	public void removeAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries
	 */
	public void removeAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

	/**
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the pet entry
	 */
	public void setAnimalTagEntries(long pk, long[] animalTagEntryPKs);

	/**
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries to be associated with the pet entry
	 */
	public void setAnimalTagEntries(
		long pk,
		java.util.List<com.dogoo.sample.pet.service.model.AnimalTagEntry>
			animalTagEntries);

}