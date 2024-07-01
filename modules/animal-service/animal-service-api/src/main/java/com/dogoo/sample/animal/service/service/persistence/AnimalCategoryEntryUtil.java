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

import com.dogoo.sample.animal.service.model.AnimalCategoryEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the animal category entry service. This utility wraps <code>com.dogoo.sample.animal.service.service.persistence.impl.AnimalCategoryEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnimalCategoryEntryPersistence
 * @generated
 */
public class AnimalCategoryEntryUtil {

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
	public static void clearCache(AnimalCategoryEntry animalCategoryEntry) {
		getPersistence().clearCache(animalCategoryEntry);
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
	public static Map<Serializable, AnimalCategoryEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnimalCategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnimalCategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnimalCategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnimalCategoryEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnimalCategoryEntry update(
		AnimalCategoryEntry animalCategoryEntry) {

		return getPersistence().update(animalCategoryEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnimalCategoryEntry update(
		AnimalCategoryEntry animalCategoryEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(animalCategoryEntry, serviceContext);
	}

	/**
	 * Caches the animal category entry in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntry the animal category entry
	 */
	public static void cacheResult(AnimalCategoryEntry animalCategoryEntry) {
		getPersistence().cacheResult(animalCategoryEntry);
	}

	/**
	 * Caches the animal category entries in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntries the animal category entries
	 */
	public static void cacheResult(
		List<AnimalCategoryEntry> animalCategoryEntries) {

		getPersistence().cacheResult(animalCategoryEntries);
	}

	/**
	 * Creates a new animal category entry with the primary key. Does not add the animal category entry to the database.
	 *
	 * @param animalId the primary key for the new animal category entry
	 * @return the new animal category entry
	 */
	public static AnimalCategoryEntry create(long animalId) {
		return getPersistence().create(animalId);
	}

	/**
	 * Removes the animal category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry that was removed
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	public static AnimalCategoryEntry remove(long animalId)
		throws com.dogoo.sample.animal.service.exception.
			NoSuchAnimalCategoryEntryException {

		return getPersistence().remove(animalId);
	}

	public static AnimalCategoryEntry updateImpl(
		AnimalCategoryEntry animalCategoryEntry) {

		return getPersistence().updateImpl(animalCategoryEntry);
	}

	/**
	 * Returns the animal category entry with the primary key or throws a <code>NoSuchAnimalCategoryEntryException</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	public static AnimalCategoryEntry findByPrimaryKey(long animalId)
		throws com.dogoo.sample.animal.service.exception.
			NoSuchAnimalCategoryEntryException {

		return getPersistence().findByPrimaryKey(animalId);
	}

	/**
	 * Returns the animal category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry, or <code>null</code> if a animal category entry with the primary key could not be found
	 */
	public static AnimalCategoryEntry fetchByPrimaryKey(long animalId) {
		return getPersistence().fetchByPrimaryKey(animalId);
	}

	/**
	 * Returns all the animal category entries.
	 *
	 * @return the animal category entries
	 */
	public static List<AnimalCategoryEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AnimalCategoryEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AnimalCategoryEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalCategoryEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AnimalCategoryEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalCategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the animal category entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of animal category entries.
	 *
	 * @return the number of animal category entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnimalCategoryEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AnimalCategoryEntryPersistence _persistence;

}