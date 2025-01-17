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

import com.dogoo.poc.upgradeservice.cat.service.exception.NoSuchCatEntryException;
import com.dogoo.poc.upgradeservice.cat.service.model.CatEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cat entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatEntryUtil
 * @generated
 */
@ProviderType
public interface CatEntryPersistence extends BasePersistence<CatEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatEntryUtil} to access the cat entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cat entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cat entries
	 */
	public java.util.List<CatEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of matching cat entries
	 */
	public java.util.List<CatEntry> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cat entries
	 */
	public java.util.List<CatEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cat entries
	 */
	public java.util.List<CatEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public CatEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
				orderByComparator)
		throws NoSuchCatEntryException;

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public CatEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator);

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public CatEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
				orderByComparator)
		throws NoSuchCatEntryException;

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public CatEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator);

	/**
	 * Returns the cat entries before and after the current cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param catId the primary key of the current cat entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public CatEntry[] findByUuid_PrevAndNext(
			long catId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
				orderByComparator)
		throws NoSuchCatEntryException;

	/**
	 * Removes all the cat entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cat entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cat entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the cat entry in the entity cache if it is enabled.
	 *
	 * @param catEntry the cat entry
	 */
	public void cacheResult(CatEntry catEntry);

	/**
	 * Caches the cat entries in the entity cache if it is enabled.
	 *
	 * @param catEntries the cat entries
	 */
	public void cacheResult(java.util.List<CatEntry> catEntries);

	/**
	 * Creates a new cat entry with the primary key. Does not add the cat entry to the database.
	 *
	 * @param catId the primary key for the new cat entry
	 * @return the new cat entry
	 */
	public CatEntry create(long catId);

	/**
	 * Removes the cat entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catId the primary key of the cat entry
	 * @return the cat entry that was removed
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public CatEntry remove(long catId) throws NoSuchCatEntryException;

	public CatEntry updateImpl(CatEntry catEntry);

	/**
	 * Returns the cat entry with the primary key or throws a <code>NoSuchCatEntryException</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat entry
	 * @return the cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public CatEntry findByPrimaryKey(long catId) throws NoSuchCatEntryException;

	/**
	 * Returns the cat entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat entry
	 * @return the cat entry, or <code>null</code> if a cat entry with the primary key could not be found
	 */
	public CatEntry fetchByPrimaryKey(long catId);

	/**
	 * Returns all the cat entries.
	 *
	 * @return the cat entries
	 */
	public java.util.List<CatEntry> findAll();

	/**
	 * Returns a range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of cat entries
	 */
	public java.util.List<CatEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cat entries
	 */
	public java.util.List<CatEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cat entries
	 */
	public java.util.List<CatEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CatEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cat entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cat entries.
	 *
	 * @return the number of cat entries
	 */
	public int countAll();

}