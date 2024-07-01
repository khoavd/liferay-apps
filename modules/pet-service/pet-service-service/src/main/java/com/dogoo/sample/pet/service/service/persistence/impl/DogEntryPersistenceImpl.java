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

package com.dogoo.sample.pet.service.service.persistence.impl;

import com.dogoo.sample.pet.service.exception.NoSuchDogEntryException;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.model.DogEntryTable;
import com.dogoo.sample.pet.service.model.impl.DogEntryImpl;
import com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl;
import com.dogoo.sample.pet.service.service.persistence.DogEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.DogEntryUtil;
import com.dogoo.sample.pet.service.service.persistence.impl.constants.DG_PETPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
 * The persistence implementation for the dog entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @generated
 */
@Component(service = {DogEntryPersistence.class, BasePersistence.class})
public class DogEntryPersistenceImpl
	extends BasePersistenceImpl<DogEntry> implements DogEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DogEntryUtil</code> to access the dog entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DogEntryImpl.class.getName();

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
	 * Returns all the dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dog entries
	 */
	@Override
	public List<DogEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DogEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<DogEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DogEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

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

		List<DogEntry> list = null;

		if (useFinderCache) {
			list = (List<DogEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DogEntry dogEntry : list) {
					if (!uuid.equals(dogEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

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
				sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DogEntry>)QueryUtil.list(
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
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByUuid_First(
			String uuid, OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByUuid_First(uuid, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUuid_First(
		String uuid, OrderByComparator<DogEntry> orderByComparator) {

		List<DogEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByUuid_Last(
			String uuid, OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DogEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DogEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where uuid = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry[] findByUuid_PrevAndNext(
			long dogId, String uuid,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		uuid = Objects.toString(uuid, "");

		DogEntry dogEntry = findByPrimaryKey(dogId);

		Session session = null;

		try {
			session = openSession();

			DogEntry[] array = new DogEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dogEntry, uuid, orderByComparator, true);

			array[1] = dogEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dogEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DogEntry getByUuid_PrevAndNext(
		Session session, DogEntry dogEntry, String uuid,
		OrderByComparator<DogEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOGENTRY_WHERE);

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
			sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dogEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DogEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dog entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DogEntry dogEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dogEntry);
		}
	}

	/**
	 * Returns the number of dog entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

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
		"dogEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dogEntry.uuid IS NULL OR dogEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByUUID_G(uuid, groupId);

		if (dogEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDogEntryException(sb.toString());
		}

		return dogEntry;
	}

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dog entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof DogEntry) {
			DogEntry dogEntry = (DogEntry)result;

			if (!Objects.equals(uuid, dogEntry.getUuid()) ||
				(groupId != dogEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DogEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DogEntry dogEntry = list.get(0);

					result = dogEntry;

					cacheResult(dogEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DogEntry)result;
		}
	}

	/**
	 * Removes the dog entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dog entry that was removed
	 */
	@Override
	public DogEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = findByUUID_G(uuid, groupId);

		return remove(dogEntry);
	}

	/**
	 * Returns the number of dog entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"dogEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dogEntry.uuid IS NULL OR dogEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dogEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dog entries
	 */
	@Override
	public List<DogEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DogEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DogEntry> list = null;

		if (useFinderCache) {
			list = (List<DogEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DogEntry dogEntry : list) {
					if (!uuid.equals(dogEntry.getUuid()) ||
						(companyId != dogEntry.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<DogEntry>)QueryUtil.list(
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
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the first dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DogEntry> orderByComparator) {

		List<DogEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the last dog entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DogEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DogEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public DogEntry[] findByUuid_C_PrevAndNext(
			long dogId, String uuid, long companyId,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		uuid = Objects.toString(uuid, "");

		DogEntry dogEntry = findByPrimaryKey(dogId);

		Session session = null;

		try {
			session = openSession();

			DogEntry[] array = new DogEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dogEntry, uuid, companyId, orderByComparator, true);

			array[1] = dogEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dogEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DogEntry getByUuid_C_PrevAndNext(
		Session session, DogEntry dogEntry, String uuid, long companyId,
		OrderByComparator<DogEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOGENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dogEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DogEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dog entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DogEntry dogEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dogEntry);
		}
	}

	/**
	 * Returns the number of dog entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"dogEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dogEntry.uuid IS NULL OR dogEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dogEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_;
	private FinderPath _finderPathWithoutPaginationFindByG_;
	private FinderPath _finderPathCountByG_;

	/**
	 * Returns all the dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dog entries
	 */
	@Override
	public List<DogEntry> findByG_(long groupId) {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DogEntry> findByG_(long groupId, int start, int end) {
		return findByG_(groupId, start, end, null);
	}

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
	@Override
	public List<DogEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return findByG_(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DogEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DogEntry> list = null;

		if (useFinderCache) {
			list = (List<DogEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DogEntry dogEntry : list) {
					if (groupId != dogEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DogEntry>)QueryUtil.list(
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
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByG__First(
			long groupId, OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByG__First(groupId, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the first dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByG__First(
		long groupId, OrderByComparator<DogEntry> orderByComparator) {

		List<DogEntry> list = findByG_(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByG__Last(
			long groupId, OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByG__Last(groupId, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the last dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByG__Last(
		long groupId, OrderByComparator<DogEntry> orderByComparator) {

		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<DogEntry> list = findByG_(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dog entries before and after the current dog entry in the ordered set where groupId = &#63;.
	 *
	 * @param dogId the primary key of the current dog entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry[] findByG__PrevAndNext(
			long dogId, long groupId,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = findByPrimaryKey(dogId);

		Session session = null;

		try {
			session = openSession();

			DogEntry[] array = new DogEntryImpl[3];

			array[0] = getByG__PrevAndNext(
				session, dogEntry, groupId, orderByComparator, true);

			array[1] = dogEntry;

			array[2] = getByG__PrevAndNext(
				session, dogEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DogEntry getByG__PrevAndNext(
		Session session, DogEntry dogEntry, long groupId,
		OrderByComparator<DogEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOGENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G__GROUPID_2);

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
			sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dogEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DogEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dog entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG_(long groupId) {
		for (DogEntry dogEntry :
				findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dogEntry);
		}
	}

	/**
	 * Returns the number of dog entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByG_(long groupId) {
		FinderPath finderPath = _finderPathCountByG_;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G__GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G__GROUPID_2 =
		"dogEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByC_N;
	private FinderPath _finderPathWithoutPaginationFindByC_N;
	private FinderPath _finderPathCountByC_N;

	/**
	 * Returns all the dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching dog entries
	 */
	@Override
	public List<DogEntry> findByC_N(long customerId, String name) {
		return findByC_N(
			customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DogEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return findByC_N(customerId, name, start, end, null);
	}

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
	@Override
	public List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return findByC_N(customerId, name, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DogEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<DogEntry> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_N;
				finderArgs = new Object[] {customerId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_N;
			finderArgs = new Object[] {
				customerId, name, start, end, orderByComparator
			};
		}

		List<DogEntry> list = null;

		if (useFinderCache) {
			list = (List<DogEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DogEntry dogEntry : list) {
					if ((customerId != dogEntry.getCustomerId()) ||
						!name.equals(dogEntry.getName())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_N_CUSTOMERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<DogEntry>)QueryUtil.list(
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
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByC_N_First(
			customerId, name, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the first dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<DogEntry> orderByComparator) {

		List<DogEntry> list = findByC_N(
			customerId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByC_N_Last(
			customerId, name, orderByComparator);

		if (dogEntry != null) {
			return dogEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDogEntryException(sb.toString());
	}

	/**
	 * Returns the last dog entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<DogEntry> orderByComparator) {

		int count = countByC_N(customerId, name);

		if (count == 0) {
			return null;
		}

		List<DogEntry> list = findByC_N(
			customerId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public DogEntry[] findByC_N_PrevAndNext(
			long dogId, long customerId, String name,
			OrderByComparator<DogEntry> orderByComparator)
		throws NoSuchDogEntryException {

		name = Objects.toString(name, "");

		DogEntry dogEntry = findByPrimaryKey(dogId);

		Session session = null;

		try {
			session = openSession();

			DogEntry[] array = new DogEntryImpl[3];

			array[0] = getByC_N_PrevAndNext(
				session, dogEntry, customerId, name, orderByComparator, true);

			array[1] = dogEntry;

			array[2] = getByC_N_PrevAndNext(
				session, dogEntry, customerId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DogEntry getByC_N_PrevAndNext(
		Session session, DogEntry dogEntry, long customerId, String name,
		OrderByComparator<DogEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOGENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_N_CUSTOMERID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_N_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_C_N_NAME_2);
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
			sb.append(DogEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dogEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DogEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dog entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	@Override
	public void removeByC_N(long customerId, String name) {
		for (DogEntry dogEntry :
				findByC_N(
					customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dogEntry);
		}
	}

	/**
	 * Returns the number of dog entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByC_N(long customerId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByC_N;

		Object[] finderArgs = new Object[] {customerId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_N_CUSTOMERID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_C_N_CUSTOMERID_2 =
		"dogEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_N_NAME_2 = "dogEntry.name = ?";

	private static final String _FINDER_COLUMN_C_N_NAME_3 =
		"(dogEntry.name IS NULL OR dogEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry
	 * @throws NoSuchDogEntryException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (dogEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDogEntryException(sb.toString());
		}

		return dogEntry;
	}

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByC_ERC(long companyId, String externalReferenceCode) {
		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the dog entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_ERC, finderArgs);
		}

		if (result instanceof DogEntry) {
			DogEntry dogEntry = (DogEntry)result;

			if ((companyId != dogEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					dogEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<DogEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"DogEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DogEntry dogEntry = list.get(0);

					result = dogEntry;

					cacheResult(dogEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DogEntry)result;
		}
	}

	/**
	 * Removes the dog entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the dog entry that was removed
	 */
	@Override
	public DogEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(dogEntry);
	}

	/**
	 * Returns the number of dog entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching dog entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
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

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"dogEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"dogEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(dogEntry.externalReferenceCode IS NULL OR dogEntry.externalReferenceCode = '')";

	public DogEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DogEntry.class);

		setModelImplClass(DogEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DogEntryTable.INSTANCE);
	}

	/**
	 * Caches the dog entry in the entity cache if it is enabled.
	 *
	 * @param dogEntry the dog entry
	 */
	@Override
	public void cacheResult(DogEntry dogEntry) {
		entityCache.putResult(
			DogEntryImpl.class, dogEntry.getPrimaryKey(), dogEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dogEntry.getUuid(), dogEntry.getGroupId()}, dogEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				dogEntry.getCompanyId(), dogEntry.getExternalReferenceCode()
			},
			dogEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dog entries in the entity cache if it is enabled.
	 *
	 * @param dogEntries the dog entries
	 */
	@Override
	public void cacheResult(List<DogEntry> dogEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dogEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DogEntry dogEntry : dogEntries) {
			if (entityCache.getResult(
					DogEntryImpl.class, dogEntry.getPrimaryKey()) == null) {

				cacheResult(dogEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dog entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DogEntryImpl.class);

		finderCache.clearCache(DogEntryImpl.class);
	}

	/**
	 * Clears the cache for the dog entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DogEntry dogEntry) {
		entityCache.removeResult(DogEntryImpl.class, dogEntry);
	}

	@Override
	public void clearCache(List<DogEntry> dogEntries) {
		for (DogEntry dogEntry : dogEntries) {
			entityCache.removeResult(DogEntryImpl.class, dogEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DogEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DogEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DogEntryModelImpl dogEntryModelImpl) {

		Object[] args = new Object[] {
			dogEntryModelImpl.getUuid(), dogEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dogEntryModelImpl);

		args = new Object[] {
			dogEntryModelImpl.getCompanyId(),
			dogEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_ERC, args, dogEntryModelImpl);
	}

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	@Override
	public DogEntry create(long dogId) {
		DogEntry dogEntry = new DogEntryImpl();

		dogEntry.setNew(true);
		dogEntry.setPrimaryKey(dogId);

		String uuid = PortalUUIDUtil.generate();

		dogEntry.setUuid(uuid);

		dogEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dogEntry;
	}

	/**
	 * Removes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry remove(long dogId) throws NoSuchDogEntryException {
		return remove((Serializable)dogId);
	}

	/**
	 * Removes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry remove(Serializable primaryKey)
		throws NoSuchDogEntryException {

		Session session = null;

		try {
			session = openSession();

			DogEntry dogEntry = (DogEntry)session.get(
				DogEntryImpl.class, primaryKey);

			if (dogEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDogEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dogEntry);
		}
		catch (NoSuchDogEntryException noSuchEntityException) {
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
	protected DogEntry removeImpl(DogEntry dogEntry) {
		dogEntryToAnimalTagEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			dogEntry.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dogEntry)) {
				dogEntry = (DogEntry)session.get(
					DogEntryImpl.class, dogEntry.getPrimaryKeyObj());
			}

			if (dogEntry != null) {
				session.delete(dogEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dogEntry != null) {
			clearCache(dogEntry);
		}

		return dogEntry;
	}

	@Override
	public DogEntry updateImpl(DogEntry dogEntry) {
		boolean isNew = dogEntry.isNew();

		if (!(dogEntry instanceof DogEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dogEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dogEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dogEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DogEntry implementation " +
					dogEntry.getClass());
		}

		DogEntryModelImpl dogEntryModelImpl = (DogEntryModelImpl)dogEntry;

		if (Validator.isNull(dogEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dogEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dogEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dogEntry.setCreateDate(date);
			}
			else {
				dogEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dogEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dogEntry.setModifiedDate(date);
			}
			else {
				dogEntry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dogEntry);
			}
			else {
				dogEntry = (DogEntry)session.merge(dogEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DogEntryImpl.class, dogEntryModelImpl, false, true);

		cacheUniqueFindersCache(dogEntryModelImpl);

		if (isNew) {
			dogEntry.setNew(false);
		}

		dogEntry.resetOriginalValues();

		return dogEntry;
	}

	/**
	 * Returns the dog entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dog entry
	 * @return the dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDogEntryException {

		DogEntry dogEntry = fetchByPrimaryKey(primaryKey);

		if (dogEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDogEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dogEntry;
	}

	/**
	 * Returns the dog entry with the primary key or throws a <code>NoSuchDogEntryException</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws NoSuchDogEntryException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry findByPrimaryKey(long dogId)
		throws NoSuchDogEntryException {

		return findByPrimaryKey((Serializable)dogId);
	}

	/**
	 * Returns the dog entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry, or <code>null</code> if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry fetchByPrimaryKey(long dogId) {
		return fetchByPrimaryKey((Serializable)dogId);
	}

	/**
	 * Returns all the dog entries.
	 *
	 * @return the dog entries
	 */
	@Override
	public List<DogEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DogEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<DogEntry> findAll(
		int start, int end, OrderByComparator<DogEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<DogEntry> findAll(
		int start, int end, OrderByComparator<DogEntry> orderByComparator,
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

		List<DogEntry> list = null;

		if (useFinderCache) {
			list = (List<DogEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOGENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOGENTRY;

				sql = sql.concat(DogEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DogEntry>)QueryUtil.list(
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
	 * Removes all the dog entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DogEntry dogEntry : findAll()) {
			remove(dogEntry);
		}
	}

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOGENTRY);

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

	/**
	 * Returns the primaryKeys of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the dog entry
	 */
	@Override
	public long[] getAnimalTagEntryPrimaryKeys(long pk) {
		long[] pks = dogEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.clone();
	}

	/**
	 * Returns all the dog entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the dog entries associated with the animal tag entry
	 */
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(long pk) {
		return getAnimalTagEntryDogEntries(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end) {

		return getAnimalTagEntryDogEntries(pk, start, end, null);
	}

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
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long pk, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return dogEntryToAnimalTagEntryTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the number of animal tag entries associated with the dog entry
	 */
	@Override
	public int getAnimalTagEntriesSize(long pk) {
		long[] pks = dogEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the dog entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAnimalTagEntry(long pk, long animalTagEntryPK) {
		return dogEntryToAnimalTagEntryTableMapper.containsTableMapping(
			pk, animalTagEntryPK);
	}

	/**
	 * Returns <code>true</code> if the dog entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the dog entry to check for associations with animal tag entries
	 * @return <code>true</code> if the dog entry has any animal tag entries associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAnimalTagEntries(long pk) {
		if (getAnimalTagEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	@Override
	public void addAnimalTagEntry(long pk, long animalTagEntryPK) {
		DogEntry dogEntry = fetchByPrimaryKey(pk);

		if (dogEntry == null) {
			dogEntryToAnimalTagEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, animalTagEntryPK);
		}
		else {
			dogEntryToAnimalTagEntryTableMapper.addTableMapping(
				dogEntry.getCompanyId(), pk, animalTagEntryPK);
		}
	}

	/**
	 * Adds an association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	@Override
	public void addAnimalTagEntry(long pk, AnimalTagEntry animalTagEntry) {
		DogEntry dogEntry = fetchByPrimaryKey(pk);

		if (dogEntry == null) {
			dogEntryToAnimalTagEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				animalTagEntry.getPrimaryKey());
		}
		else {
			dogEntryToAnimalTagEntryTableMapper.addTableMapping(
				dogEntry.getCompanyId(), pk, animalTagEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	@Override
	public void addAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		long companyId = 0;

		DogEntry dogEntry = fetchByPrimaryKey(pk);

		if (dogEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = dogEntry.getCompanyId();
		}

		dogEntryToAnimalTagEntryTableMapper.addTableMappings(
			companyId, pk, animalTagEntryPKs);
	}

	/**
	 * Adds an association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	@Override
	public void addAnimalTagEntries(
		long pk, List<AnimalTagEntry> animalTagEntries) {

		addAnimalTagEntries(
			pk,
			ListUtil.toLongArray(
				animalTagEntries, AnimalTagEntry.ANIMAL_TAG_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the dog entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry to clear the associated animal tag entries from
	 */
	@Override
	public void clearAnimalTagEntries(long pk) {
		dogEntryToAnimalTagEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	@Override
	public void removeAnimalTagEntry(long pk, long animalTagEntryPK) {
		dogEntryToAnimalTagEntryTableMapper.deleteTableMapping(
			pk, animalTagEntryPK);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntry the animal tag entry
	 */
	@Override
	public void removeAnimalTagEntry(long pk, AnimalTagEntry animalTagEntry) {
		dogEntryToAnimalTagEntryTableMapper.deleteTableMapping(
			pk, animalTagEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	@Override
	public void removeAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		dogEntryToAnimalTagEntryTableMapper.deleteTableMappings(
			pk, animalTagEntryPKs);
	}

	/**
	 * Removes the association between the dog entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries
	 */
	@Override
	public void removeAnimalTagEntries(
		long pk, List<AnimalTagEntry> animalTagEntries) {

		removeAnimalTagEntries(
			pk,
			ListUtil.toLongArray(
				animalTagEntries, AnimalTagEntry.ANIMAL_TAG_ID_ACCESSOR));
	}

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the dog entry
	 */
	@Override
	public void setAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		Set<Long> newAnimalTagEntryPKsSet = SetUtil.fromArray(
			animalTagEntryPKs);
		Set<Long> oldAnimalTagEntryPKsSet = SetUtil.fromArray(
			dogEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeAnimalTagEntryPKsSet = new HashSet<Long>(
			oldAnimalTagEntryPKsSet);

		removeAnimalTagEntryPKsSet.removeAll(newAnimalTagEntryPKsSet);

		dogEntryToAnimalTagEntryTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeAnimalTagEntryPKsSet));

		newAnimalTagEntryPKsSet.removeAll(oldAnimalTagEntryPKsSet);

		long companyId = 0;

		DogEntry dogEntry = fetchByPrimaryKey(pk);

		if (dogEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = dogEntry.getCompanyId();
		}

		dogEntryToAnimalTagEntryTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newAnimalTagEntryPKsSet));
	}

	/**
	 * Sets the animal tag entries associated with the dog entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the dog entry
	 * @param animalTagEntries the animal tag entries to be associated with the dog entry
	 */
	@Override
	public void setAnimalTagEntries(
		long pk, List<AnimalTagEntry> animalTagEntries) {

		try {
			long[] animalTagEntryPKs = new long[animalTagEntries.size()];

			for (int i = 0; i < animalTagEntries.size(); i++) {
				AnimalTagEntry animalTagEntry = animalTagEntries.get(i);

				animalTagEntryPKs[i] = animalTagEntry.getPrimaryKey();
			}

			setAnimalTagEntries(pk, animalTagEntryPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
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
		return "dogId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOGENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DogEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dog entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		dogEntryToAnimalTagEntryTableMapper = TableMapperFactory.getTableMapper(
			"DG_Dogs_AnimalTags#dogId", "DG_Dogs_AnimalTags", "companyId",
			"dogId", "animalTagId", this, AnimalTagEntry.class);

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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByG_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByG_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByG_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByC_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "name"}, true);

		_finderPathWithoutPaginationFindByC_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "name"}, true);

		_finderPathCountByC_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"customerId", "name"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDogEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDogEntryUtilPersistence(null);

		entityCache.removeCache(DogEntryImpl.class.getName());

		TableMapperFactory.removeTableMapper("DG_Dogs_AnimalTags#dogId");
	}

	private void _setDogEntryUtilPersistence(
		DogEntryPersistence dogEntryPersistence) {

		try {
			Field field = DogEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dogEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DG_PETPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DG_PETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DG_PETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<DogEntry, AnimalTagEntry>
		dogEntryToAnimalTagEntryTableMapper;

	private static final String _SQL_SELECT_DOGENTRY =
		"SELECT dogEntry FROM DogEntry dogEntry";

	private static final String _SQL_SELECT_DOGENTRY_WHERE =
		"SELECT dogEntry FROM DogEntry dogEntry WHERE ";

	private static final String _SQL_COUNT_DOGENTRY =
		"SELECT COUNT(dogEntry) FROM DogEntry dogEntry";

	private static final String _SQL_COUNT_DOGENTRY_WHERE =
		"SELECT COUNT(dogEntry) FROM DogEntry dogEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dogEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DogEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DogEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DogEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DogEntryModelArgumentsResolver _dogEntryModelArgumentsResolver;

}