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

import com.dogoo.poc.upgradeservice.cat.service.exception.NoSuchCatUsaEntryException;
import com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cat usa entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatUsaEntryUtil
 * @generated
 */
@ProviderType
public interface CatUsaEntryPersistence extends BasePersistence<CatUsaEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatUsaEntryUtil} to access the cat usa entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cat usa entries
	 */
	public java.util.List<CatUsaEntry> findByUuid(String uuid);

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
	public java.util.List<CatUsaEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator);

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
	public java.util.List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	public CatUsaEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
				orderByComparator)
		throws NoSuchCatUsaEntryException;

	/**
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	public CatUsaEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator);

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	public CatUsaEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
				orderByComparator)
		throws NoSuchCatUsaEntryException;

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	public CatUsaEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator);

	/**
	 * Returns the cat usa entries before and after the current cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param catId the primary key of the current cat usa entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public CatUsaEntry[] findByUuid_PrevAndNext(
			long catId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
				orderByComparator)
		throws NoSuchCatUsaEntryException;

	/**
	 * Removes all the cat usa entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cat usa entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the cat usa entry in the entity cache if it is enabled.
	 *
	 * @param catUsaEntry the cat usa entry
	 */
	public void cacheResult(CatUsaEntry catUsaEntry);

	/**
	 * Caches the cat usa entries in the entity cache if it is enabled.
	 *
	 * @param catUsaEntries the cat usa entries
	 */
	public void cacheResult(java.util.List<CatUsaEntry> catUsaEntries);

	/**
	 * Creates a new cat usa entry with the primary key. Does not add the cat usa entry to the database.
	 *
	 * @param catId the primary key for the new cat usa entry
	 * @return the new cat usa entry
	 */
	public CatUsaEntry create(long catId);

	/**
	 * Removes the cat usa entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry that was removed
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public CatUsaEntry remove(long catId) throws NoSuchCatUsaEntryException;

	public CatUsaEntry updateImpl(CatUsaEntry catUsaEntry);

	/**
	 * Returns the cat usa entry with the primary key or throws a <code>NoSuchCatUsaEntryException</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	public CatUsaEntry findByPrimaryKey(long catId)
		throws NoSuchCatUsaEntryException;

	/**
	 * Returns the cat usa entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry, or <code>null</code> if a cat usa entry with the primary key could not be found
	 */
	public CatUsaEntry fetchByPrimaryKey(long catId);

	/**
	 * Returns all the cat usa entries.
	 *
	 * @return the cat usa entries
	 */
	public java.util.List<CatUsaEntry> findAll();

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
	public java.util.List<CatUsaEntry> findAll(int start, int end);

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
	public java.util.List<CatUsaEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator);

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
	public java.util.List<CatUsaEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatUsaEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cat usa entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cat usa entries.
	 *
	 * @return the number of cat usa entries
	 */
	public int countAll();

}