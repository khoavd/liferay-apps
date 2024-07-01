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

package com.dogoo.sample.animal.service.service.persistence;

import com.dogoo.sample.animal.service.exception.NoSuchAnimalCategoryEntryException;
import com.dogoo.sample.animal.service.model.AnimalCategoryEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the animal category entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnimalCategoryEntryUtil
 * @generated
 */
@ProviderType
public interface AnimalCategoryEntryPersistence
	extends BasePersistence<AnimalCategoryEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnimalCategoryEntryUtil} to access the animal category entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the animal category entry in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntry the animal category entry
	 */
	public void cacheResult(AnimalCategoryEntry animalCategoryEntry);

	/**
	 * Caches the animal category entries in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntries the animal category entries
	 */
	public void cacheResult(
		java.util.List<AnimalCategoryEntry> animalCategoryEntries);

	/**
	 * Creates a new animal category entry with the primary key. Does not add the animal category entry to the database.
	 *
	 * @param animalId the primary key for the new animal category entry
	 * @return the new animal category entry
	 */
	public AnimalCategoryEntry create(long animalId);

	/**
	 * Removes the animal category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry that was removed
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	public AnimalCategoryEntry remove(long animalId)
		throws NoSuchAnimalCategoryEntryException;

	public AnimalCategoryEntry updateImpl(
		AnimalCategoryEntry animalCategoryEntry);

	/**
	 * Returns the animal category entry with the primary key or throws a <code>NoSuchAnimalCategoryEntryException</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	public AnimalCategoryEntry findByPrimaryKey(long animalId)
		throws NoSuchAnimalCategoryEntryException;

	/**
	 * Returns the animal category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry, or <code>null</code> if a animal category entry with the primary key could not be found
	 */
	public AnimalCategoryEntry fetchByPrimaryKey(long animalId);

	/**
	 * Returns all the animal category entries.
	 *
	 * @return the animal category entries
	 */
	public java.util.List<AnimalCategoryEntry> findAll();

	/**
	 * Returns a range of all the animal category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalCategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal category entries
	 * @param end the upper bound of the range of animal category entries (not inclusive)
	 * @return the range of animal category entries
	 */
	public java.util.List<AnimalCategoryEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the animal category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalCategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal category entries
	 * @param end the upper bound of the range of animal category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal category entries
	 */
	public java.util.List<AnimalCategoryEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalCategoryEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the animal category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalCategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal category entries
	 * @param end the upper bound of the range of animal category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animal category entries
	 */
	public java.util.List<AnimalCategoryEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimalCategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the animal category entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of animal category entries.
	 *
	 * @return the number of animal category entries
	 */
	public int countAll();

}