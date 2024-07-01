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

package com.dogoo.sample.animal.service.service.persistence.impl;

import com.dogoo.sample.animal.service.exception.NoSuchAnimalCategoryEntryException;
import com.dogoo.sample.animal.service.model.AnimalCategoryEntry;
import com.dogoo.sample.animal.service.model.AnimalCategoryEntryTable;
import com.dogoo.sample.animal.service.model.impl.AnimalCategoryEntryImpl;
import com.dogoo.sample.animal.service.model.impl.AnimalCategoryEntryModelImpl;
import com.dogoo.sample.animal.service.service.persistence.AnimalCategoryEntryPersistence;
import com.dogoo.sample.animal.service.service.persistence.AnimalCategoryEntryUtil;
import com.dogoo.sample.animal.service.service.persistence.impl.constants.DG_ANMPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the animal category entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AnimalCategoryEntryPersistence.class, BasePersistence.class}
)
public class AnimalCategoryEntryPersistenceImpl
	extends BasePersistenceImpl<AnimalCategoryEntry>
	implements AnimalCategoryEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimalCategoryEntryUtil</code> to access the animal category entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimalCategoryEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AnimalCategoryEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("animalId", "ID");
		dbColumnNames.put("name", "NAME");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnimalCategoryEntry.class);

		setModelImplClass(AnimalCategoryEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AnimalCategoryEntryTable.INSTANCE);
	}

	/**
	 * Caches the animal category entry in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntry the animal category entry
	 */
	@Override
	public void cacheResult(AnimalCategoryEntry animalCategoryEntry) {
		entityCache.putResult(
			AnimalCategoryEntryImpl.class, animalCategoryEntry.getPrimaryKey(),
			animalCategoryEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the animal category entries in the entity cache if it is enabled.
	 *
	 * @param animalCategoryEntries the animal category entries
	 */
	@Override
	public void cacheResult(List<AnimalCategoryEntry> animalCategoryEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (animalCategoryEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnimalCategoryEntry animalCategoryEntry : animalCategoryEntries) {
			if (entityCache.getResult(
					AnimalCategoryEntryImpl.class,
					animalCategoryEntry.getPrimaryKey()) == null) {

				cacheResult(animalCategoryEntry);
			}
		}
	}

	/**
	 * Clears the cache for all animal category entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimalCategoryEntryImpl.class);

		finderCache.clearCache(AnimalCategoryEntryImpl.class);
	}

	/**
	 * Clears the cache for the animal category entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimalCategoryEntry animalCategoryEntry) {
		entityCache.removeResult(
			AnimalCategoryEntryImpl.class, animalCategoryEntry);
	}

	@Override
	public void clearCache(List<AnimalCategoryEntry> animalCategoryEntries) {
		for (AnimalCategoryEntry animalCategoryEntry : animalCategoryEntries) {
			entityCache.removeResult(
				AnimalCategoryEntryImpl.class, animalCategoryEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnimalCategoryEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnimalCategoryEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new animal category entry with the primary key. Does not add the animal category entry to the database.
	 *
	 * @param animalId the primary key for the new animal category entry
	 * @return the new animal category entry
	 */
	@Override
	public AnimalCategoryEntry create(long animalId) {
		AnimalCategoryEntry animalCategoryEntry = new AnimalCategoryEntryImpl();

		animalCategoryEntry.setNew(true);
		animalCategoryEntry.setPrimaryKey(animalId);

		return animalCategoryEntry;
	}

	/**
	 * Removes the animal category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry that was removed
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	@Override
	public AnimalCategoryEntry remove(long animalId)
		throws NoSuchAnimalCategoryEntryException {

		return remove((Serializable)animalId);
	}

	/**
	 * Removes the animal category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animal category entry
	 * @return the animal category entry that was removed
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	@Override
	public AnimalCategoryEntry remove(Serializable primaryKey)
		throws NoSuchAnimalCategoryEntryException {

		Session session = null;

		try {
			session = openSession();

			AnimalCategoryEntry animalCategoryEntry =
				(AnimalCategoryEntry)session.get(
					AnimalCategoryEntryImpl.class, primaryKey);

			if (animalCategoryEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimalCategoryEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animalCategoryEntry);
		}
		catch (NoSuchAnimalCategoryEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AnimalCategoryEntry removeImpl(
		AnimalCategoryEntry animalCategoryEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animalCategoryEntry)) {
				animalCategoryEntry = (AnimalCategoryEntry)session.get(
					AnimalCategoryEntryImpl.class,
					animalCategoryEntry.getPrimaryKeyObj());
			}

			if (animalCategoryEntry != null) {
				session.delete(animalCategoryEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (animalCategoryEntry != null) {
			clearCache(animalCategoryEntry);
		}

		return animalCategoryEntry;
	}

	@Override
	public AnimalCategoryEntry updateImpl(
		AnimalCategoryEntry animalCategoryEntry) {

		boolean isNew = animalCategoryEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(animalCategoryEntry);
			}
			else {
				animalCategoryEntry = (AnimalCategoryEntry)session.merge(
					animalCategoryEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnimalCategoryEntryImpl.class, animalCategoryEntry, false, true);

		if (isNew) {
			animalCategoryEntry.setNew(false);
		}

		animalCategoryEntry.resetOriginalValues();

		return animalCategoryEntry;
	}

	/**
	 * Returns the animal category entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animal category entry
	 * @return the animal category entry
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	@Override
	public AnimalCategoryEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimalCategoryEntryException {

		AnimalCategoryEntry animalCategoryEntry = fetchByPrimaryKey(primaryKey);

		if (animalCategoryEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimalCategoryEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animalCategoryEntry;
	}

	/**
	 * Returns the animal category entry with the primary key or throws a <code>NoSuchAnimalCategoryEntryException</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry
	 * @throws NoSuchAnimalCategoryEntryException if a animal category entry with the primary key could not be found
	 */
	@Override
	public AnimalCategoryEntry findByPrimaryKey(long animalId)
		throws NoSuchAnimalCategoryEntryException {

		return findByPrimaryKey((Serializable)animalId);
	}

	/**
	 * Returns the animal category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalId the primary key of the animal category entry
	 * @return the animal category entry, or <code>null</code> if a animal category entry with the primary key could not be found
	 */
	@Override
	public AnimalCategoryEntry fetchByPrimaryKey(long animalId) {
		return fetchByPrimaryKey((Serializable)animalId);
	}

	/**
	 * Returns all the animal category entries.
	 *
	 * @return the animal category entries
	 */
	@Override
	public List<AnimalCategoryEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnimalCategoryEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AnimalCategoryEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalCategoryEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AnimalCategoryEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalCategoryEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AnimalCategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalCategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANIMALCATEGORYENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMALCATEGORYENTRY;

				sql = sql.concat(AnimalCategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnimalCategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the animal category entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimalCategoryEntry animalCategoryEntry : findAll()) {
			remove(animalCategoryEntry);
		}
	}

	/**
	 * Returns the number of animal category entries.
	 *
	 * @return the number of animal category entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ANIMALCATEGORYENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANIMALCATEGORYENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnimalCategoryEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animal category entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setAnimalCategoryEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnimalCategoryEntryUtilPersistence(null);

		entityCache.removeCache(AnimalCategoryEntryImpl.class.getName());
	}

	private void _setAnimalCategoryEntryUtilPersistence(
		AnimalCategoryEntryPersistence animalCategoryEntryPersistence) {

		try {
			Field field = AnimalCategoryEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, animalCategoryEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_ANMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_ANMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_ANMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ANIMALCATEGORYENTRY =
		"SELECT animalCategoryEntry FROM AnimalCategoryEntry animalCategoryEntry";

	private static final String _SQL_COUNT_ANIMALCATEGORYENTRY =
		"SELECT COUNT(animalCategoryEntry) FROM AnimalCategoryEntry animalCategoryEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animalCategoryEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimalCategoryEntry exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimalCategoryEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"animalId", "name"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AnimalCategoryEntryModelArgumentsResolver
		_animalCategoryEntryModelArgumentsResolver;

}