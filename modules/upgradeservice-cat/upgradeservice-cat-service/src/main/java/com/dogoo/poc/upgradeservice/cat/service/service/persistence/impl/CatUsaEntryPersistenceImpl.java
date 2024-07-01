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

package com.dogoo.poc.upgradeservice.cat.service.service.persistence.impl;

import com.dogoo.poc.upgradeservice.cat.service.exception.NoSuchCatUsaEntryException;
import com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry;
import com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntryTable;
import com.dogoo.poc.upgradeservice.cat.service.model.impl.CatUsaEntryImpl;
import com.dogoo.poc.upgradeservice.cat.service.model.impl.CatUsaEntryModelImpl;
import com.dogoo.poc.upgradeservice.cat.service.service.persistence.CatUsaEntryPersistence;
import com.dogoo.poc.upgradeservice.cat.service.service.persistence.CatUsaEntryUtil;
import com.dogoo.poc.upgradeservice.cat.service.service.persistence.impl.constants.SAMP_CATPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cat usa entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CatUsaEntryPersistence.class, BasePersistence.class})
public class CatUsaEntryPersistenceImpl
	extends BasePersistenceImpl<CatUsaEntry> implements CatUsaEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CatUsaEntryUtil</code> to access the cat usa entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CatUsaEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cat usa entries
	 */
	@Override
	public List<CatUsaEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CatUsaEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatUsaEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CatUsaEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatUsaEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CatUsaEntry> list = null;

		if (useFinderCache) {
			list = (List<CatUsaEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CatUsaEntry catUsaEntry : list) {
					if (!uuid.equals(catUsaEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATUSAENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CatUsaEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CatUsaEntry>)QueryUtil.list(
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
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	@Override
	public CatUsaEntry findByUuid_First(
			String uuid, OrderByComparator<CatUsaEntry> orderByComparator)
		throws NoSuchCatUsaEntryException {

		CatUsaEntry catUsaEntry = fetchByUuid_First(uuid, orderByComparator);

		if (catUsaEntry != null) {
			return catUsaEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCatUsaEntryException(sb.toString());
	}

	/**
	 * Returns the first cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	@Override
	public CatUsaEntry fetchByUuid_First(
		String uuid, OrderByComparator<CatUsaEntry> orderByComparator) {

		List<CatUsaEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry
	 * @throws NoSuchCatUsaEntryException if a matching cat usa entry could not be found
	 */
	@Override
	public CatUsaEntry findByUuid_Last(
			String uuid, OrderByComparator<CatUsaEntry> orderByComparator)
		throws NoSuchCatUsaEntryException {

		CatUsaEntry catUsaEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (catUsaEntry != null) {
			return catUsaEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCatUsaEntryException(sb.toString());
	}

	/**
	 * Returns the last cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat usa entry, or <code>null</code> if a matching cat usa entry could not be found
	 */
	@Override
	public CatUsaEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CatUsaEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CatUsaEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cat usa entries before and after the current cat usa entry in the ordered set where uuid = &#63;.
	 *
	 * @param catId the primary key of the current cat usa entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry[] findByUuid_PrevAndNext(
			long catId, String uuid,
			OrderByComparator<CatUsaEntry> orderByComparator)
		throws NoSuchCatUsaEntryException {

		uuid = Objects.toString(uuid, "");

		CatUsaEntry catUsaEntry = findByPrimaryKey(catId);

		Session session = null;

		try {
			session = openSession();

			CatUsaEntry[] array = new CatUsaEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, catUsaEntry, uuid, orderByComparator, true);

			array[1] = catUsaEntry;

			array[2] = getByUuid_PrevAndNext(
				session, catUsaEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatUsaEntry getByUuid_PrevAndNext(
		Session session, CatUsaEntry catUsaEntry, String uuid,
		OrderByComparator<CatUsaEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATUSAENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CatUsaEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(catUsaEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CatUsaEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cat usa entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CatUsaEntry catUsaEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(catUsaEntry);
		}
	}

	/**
	 * Returns the number of cat usa entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cat usa entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATUSAENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"catUsaEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(catUsaEntry.uuid IS NULL OR catUsaEntry.uuid = '')";

	public CatUsaEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("catId", "ID");
		dbColumnNames.put("name", "NAME");
		dbColumnNames.put("gender", "GENDER");
		dbColumnNames.put("type", "TYPE");

		setDBColumnNames(dbColumnNames);

		setModelClass(CatUsaEntry.class);

		setModelImplClass(CatUsaEntryImpl.class);
		setModelPKClass(long.class);

		setTable(CatUsaEntryTable.INSTANCE);
	}

	/**
	 * Caches the cat usa entry in the entity cache if it is enabled.
	 *
	 * @param catUsaEntry the cat usa entry
	 */
	@Override
	public void cacheResult(CatUsaEntry catUsaEntry) {
		entityCache.putResult(
			CatUsaEntryImpl.class, catUsaEntry.getPrimaryKey(), catUsaEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cat usa entries in the entity cache if it is enabled.
	 *
	 * @param catUsaEntries the cat usa entries
	 */
	@Override
	public void cacheResult(List<CatUsaEntry> catUsaEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (catUsaEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CatUsaEntry catUsaEntry : catUsaEntries) {
			if (entityCache.getResult(
					CatUsaEntryImpl.class, catUsaEntry.getPrimaryKey()) ==
						null) {

				cacheResult(catUsaEntry);
			}
		}
	}

	/**
	 * Clears the cache for all cat usa entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CatUsaEntryImpl.class);

		finderCache.clearCache(CatUsaEntryImpl.class);
	}

	/**
	 * Clears the cache for the cat usa entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatUsaEntry catUsaEntry) {
		entityCache.removeResult(CatUsaEntryImpl.class, catUsaEntry);
	}

	@Override
	public void clearCache(List<CatUsaEntry> catUsaEntries) {
		for (CatUsaEntry catUsaEntry : catUsaEntries) {
			entityCache.removeResult(CatUsaEntryImpl.class, catUsaEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CatUsaEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CatUsaEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cat usa entry with the primary key. Does not add the cat usa entry to the database.
	 *
	 * @param catId the primary key for the new cat usa entry
	 * @return the new cat usa entry
	 */
	@Override
	public CatUsaEntry create(long catId) {
		CatUsaEntry catUsaEntry = new CatUsaEntryImpl();

		catUsaEntry.setNew(true);
		catUsaEntry.setPrimaryKey(catId);

		String uuid = PortalUUIDUtil.generate();

		catUsaEntry.setUuid(uuid);

		return catUsaEntry;
	}

	/**
	 * Removes the cat usa entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry that was removed
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry remove(long catId) throws NoSuchCatUsaEntryException {
		return remove((Serializable)catId);
	}

	/**
	 * Removes the cat usa entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cat usa entry
	 * @return the cat usa entry that was removed
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry remove(Serializable primaryKey)
		throws NoSuchCatUsaEntryException {

		Session session = null;

		try {
			session = openSession();

			CatUsaEntry catUsaEntry = (CatUsaEntry)session.get(
				CatUsaEntryImpl.class, primaryKey);

			if (catUsaEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatUsaEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(catUsaEntry);
		}
		catch (NoSuchCatUsaEntryException noSuchEntityException) {
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
	protected CatUsaEntry removeImpl(CatUsaEntry catUsaEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catUsaEntry)) {
				catUsaEntry = (CatUsaEntry)session.get(
					CatUsaEntryImpl.class, catUsaEntry.getPrimaryKeyObj());
			}

			if (catUsaEntry != null) {
				session.delete(catUsaEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (catUsaEntry != null) {
			clearCache(catUsaEntry);
		}

		return catUsaEntry;
	}

	@Override
	public CatUsaEntry updateImpl(CatUsaEntry catUsaEntry) {
		boolean isNew = catUsaEntry.isNew();

		if (!(catUsaEntry instanceof CatUsaEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(catUsaEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(catUsaEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in catUsaEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CatUsaEntry implementation " +
					catUsaEntry.getClass());
		}

		CatUsaEntryModelImpl catUsaEntryModelImpl =
			(CatUsaEntryModelImpl)catUsaEntry;

		if (Validator.isNull(catUsaEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			catUsaEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(catUsaEntry);
			}
			else {
				catUsaEntry = (CatUsaEntry)session.merge(catUsaEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CatUsaEntryImpl.class, catUsaEntryModelImpl, false, true);

		if (isNew) {
			catUsaEntry.setNew(false);
		}

		catUsaEntry.resetOriginalValues();

		return catUsaEntry;
	}

	/**
	 * Returns the cat usa entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cat usa entry
	 * @return the cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatUsaEntryException {

		CatUsaEntry catUsaEntry = fetchByPrimaryKey(primaryKey);

		if (catUsaEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatUsaEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return catUsaEntry;
	}

	/**
	 * Returns the cat usa entry with the primary key or throws a <code>NoSuchCatUsaEntryException</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry
	 * @throws NoSuchCatUsaEntryException if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry findByPrimaryKey(long catId)
		throws NoSuchCatUsaEntryException {

		return findByPrimaryKey((Serializable)catId);
	}

	/**
	 * Returns the cat usa entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catId the primary key of the cat usa entry
	 * @return the cat usa entry, or <code>null</code> if a cat usa entry with the primary key could not be found
	 */
	@Override
	public CatUsaEntry fetchByPrimaryKey(long catId) {
		return fetchByPrimaryKey((Serializable)catId);
	}

	/**
	 * Returns all the cat usa entries.
	 *
	 * @return the cat usa entries
	 */
	@Override
	public List<CatUsaEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CatUsaEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CatUsaEntry> findAll(
		int start, int end, OrderByComparator<CatUsaEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CatUsaEntry> findAll(
		int start, int end, OrderByComparator<CatUsaEntry> orderByComparator,
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

		List<CatUsaEntry> list = null;

		if (useFinderCache) {
			list = (List<CatUsaEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATUSAENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATUSAENTRY;

				sql = sql.concat(CatUsaEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CatUsaEntry>)QueryUtil.list(
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
	 * Removes all the cat usa entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CatUsaEntry catUsaEntry : findAll()) {
			remove(catUsaEntry);
		}
	}

	/**
	 * Returns the number of cat usa entries.
	 *
	 * @return the number of cat usa entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATUSAENTRY);

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
		return _SQL_SELECT_CATUSAENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CatUsaEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cat usa entry persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setCatUsaEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCatUsaEntryUtilPersistence(null);

		entityCache.removeCache(CatUsaEntryImpl.class.getName());
	}

	private void _setCatUsaEntryUtilPersistence(
		CatUsaEntryPersistence catUsaEntryPersistence) {

		try {
			Field field = CatUsaEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, catUsaEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SAMP_CATPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SAMP_CATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SAMP_CATPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CATUSAENTRY =
		"SELECT catUsaEntry FROM CatUsaEntry catUsaEntry";

	private static final String _SQL_SELECT_CATUSAENTRY_WHERE =
		"SELECT catUsaEntry FROM CatUsaEntry catUsaEntry WHERE ";

	private static final String _SQL_COUNT_CATUSAENTRY =
		"SELECT COUNT(catUsaEntry) FROM CatUsaEntry catUsaEntry";

	private static final String _SQL_COUNT_CATUSAENTRY_WHERE =
		"SELECT COUNT(catUsaEntry) FROM CatUsaEntry catUsaEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "catUsaEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CatUsaEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CatUsaEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CatUsaEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "catId", "name", "gender", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CatUsaEntryModelArgumentsResolver
		_catUsaEntryModelArgumentsResolver;

}