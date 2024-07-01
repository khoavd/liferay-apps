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

import com.dogoo.sample.pet.service.exception.NoSuchAnimalTagEntryException;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.AnimalTagEntryTable;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.model.impl.AnimalTagEntryImpl;
import com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl;
import com.dogoo.sample.pet.service.service.persistence.AnimalTagEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.AnimalTagEntryUtil;
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
 * The persistence implementation for the animal tag entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @generated
 */
@Component(service = {AnimalTagEntryPersistence.class, BasePersistence.class})
public class AnimalTagEntryPersistenceImpl
	extends BasePersistenceImpl<AnimalTagEntry>
	implements AnimalTagEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimalTagEntryUtil</code> to access the animal tag entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimalTagEntryImpl.class.getName();

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
	 * Returns all the animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
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

		List<AnimalTagEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalTagEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalTagEntry animalTagEntry : list) {
					if (!uuid.equals(animalTagEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
				sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalTagEntry>)QueryUtil.list(
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
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByUuid_First(
			String uuid, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUuid_First(
		String uuid, OrderByComparator<AnimalTagEntry> orderByComparator) {

		List<AnimalTagEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByUuid_Last(
			String uuid, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AnimalTagEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AnimalTagEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry[] findByUuid_PrevAndNext(
			long animalTagId, String uuid,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		uuid = Objects.toString(uuid, "");

		AnimalTagEntry animalTagEntry = findByPrimaryKey(animalTagId);

		Session session = null;

		try {
			session = openSession();

			AnimalTagEntry[] array = new AnimalTagEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, animalTagEntry, uuid, orderByComparator, true);

			array[1] = animalTagEntry;

			array[2] = getByUuid_PrevAndNext(
				session, animalTagEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalTagEntry getByUuid_PrevAndNext(
		Session session, AnimalTagEntry animalTagEntry, String uuid,
		OrderByComparator<AnimalTagEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
			sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						animalTagEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalTagEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal tag entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AnimalTagEntry animalTagEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animalTagEntry);
		}
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(animalTagEntry.uuid IS NULL OR animalTagEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByUUID_G(uuid, groupId);

		if (animalTagEntry == null) {
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

			throw new NoSuchAnimalTagEntryException(sb.toString());
		}

		return animalTagEntry;
	}

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the animal tag entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUUID_G(
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

		if (result instanceof AnimalTagEntry) {
			AnimalTagEntry animalTagEntry = (AnimalTagEntry)result;

			if (!Objects.equals(uuid, animalTagEntry.getUuid()) ||
				(groupId != animalTagEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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

				List<AnimalTagEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AnimalTagEntry animalTagEntry = list.get(0);

					result = animalTagEntry;

					cacheResult(animalTagEntry);
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
			return (AnimalTagEntry)result;
		}
	}

	/**
	 * Removes the animal tag entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal tag entry that was removed
	 */
	@Override
	public AnimalTagEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = findByUUID_G(uuid, groupId);

		return remove(animalTagEntry);
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(animalTagEntry.uuid IS NULL OR animalTagEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"animalTagEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

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

		List<AnimalTagEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalTagEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalTagEntry animalTagEntry : list) {
					if (!uuid.equals(animalTagEntry.getUuid()) ||
						(companyId != animalTagEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
				sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalTagEntry>)QueryUtil.list(
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
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the first animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		List<AnimalTagEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the last animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AnimalTagEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry[] findByUuid_C_PrevAndNext(
			long animalTagId, String uuid, long companyId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		uuid = Objects.toString(uuid, "");

		AnimalTagEntry animalTagEntry = findByPrimaryKey(animalTagId);

		Session session = null;

		try {
			session = openSession();

			AnimalTagEntry[] array = new AnimalTagEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, animalTagEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = animalTagEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, animalTagEntry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalTagEntry getByUuid_C_PrevAndNext(
		Session session, AnimalTagEntry animalTagEntry, String uuid,
		long companyId, OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
			sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						animalTagEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalTagEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal tag entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AnimalTagEntry animalTagEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(animalTagEntry);
		}
	}

	/**
	 * Returns the number of animal tag entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(animalTagEntry.uuid IS NULL OR animalTagEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"animalTagEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_;
	private FinderPath _finderPathWithoutPaginationFindByG_;
	private FinderPath _finderPathCountByG_;

	/**
	 * Returns all the animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByG_(long groupId) {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByG_(long groupId, int start, int end) {
		return findByG_(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return findByG_(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

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

		List<AnimalTagEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalTagEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalTagEntry animalTagEntry : list) {
					if (groupId != animalTagEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<AnimalTagEntry>)QueryUtil.list(
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
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByG__First(
			long groupId, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByG__First(
			groupId, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the first animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByG__First(
		long groupId, OrderByComparator<AnimalTagEntry> orderByComparator) {

		List<AnimalTagEntry> list = findByG_(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByG__Last(
			long groupId, OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByG__Last(
			groupId, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the last animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByG__Last(
		long groupId, OrderByComparator<AnimalTagEntry> orderByComparator) {

		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<AnimalTagEntry> list = findByG_(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry[] findByG__PrevAndNext(
			long animalTagId, long groupId,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = findByPrimaryKey(animalTagId);

		Session session = null;

		try {
			session = openSession();

			AnimalTagEntry[] array = new AnimalTagEntryImpl[3];

			array[0] = getByG__PrevAndNext(
				session, animalTagEntry, groupId, orderByComparator, true);

			array[1] = animalTagEntry;

			array[2] = getByG__PrevAndNext(
				session, animalTagEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalTagEntry getByG__PrevAndNext(
		Session session, AnimalTagEntry animalTagEntry, long groupId,
		OrderByComparator<AnimalTagEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
			sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						animalTagEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalTagEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal tag entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG_(long groupId) {
		for (AnimalTagEntry animalTagEntry :
				findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animalTagEntry);
		}
	}

	/**
	 * Returns the number of animal tag entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByG_(long groupId) {
		FinderPath finderPath = _finderPathCountByG_;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByC_N;
	private FinderPath _finderPathWithoutPaginationFindByC_N;
	private FinderPath _finderPathCountByC_N;

	/**
	 * Returns all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByC_N(long customerId, String name) {
		return findByC_N(
			customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return findByC_N(customerId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return findByC_N(customerId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean useFinderCache) {

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

		List<AnimalTagEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalTagEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalTagEntry animalTagEntry : list) {
					if ((customerId != animalTagEntry.getCustomerId()) ||
						!name.equals(animalTagEntry.getName())) {

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

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
				sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalTagEntry>)QueryUtil.list(
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
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByC_N_First(
			customerId, name, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the first animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		List<AnimalTagEntry> list = findByC_N(
			customerId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByC_N_Last(
			customerId, name, orderByComparator);

		if (animalTagEntry != null) {
			return animalTagEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchAnimalTagEntryException(sb.toString());
	}

	/**
	 * Returns the last animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		int count = countByC_N(customerId, name);

		if (count == 0) {
			return null;
		}

		List<AnimalTagEntry> list = findByC_N(
			customerId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal tag entries before and after the current animal tag entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param animalTagId the primary key of the current animal tag entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry[] findByC_N_PrevAndNext(
			long animalTagId, long customerId, String name,
			OrderByComparator<AnimalTagEntry> orderByComparator)
		throws NoSuchAnimalTagEntryException {

		name = Objects.toString(name, "");

		AnimalTagEntry animalTagEntry = findByPrimaryKey(animalTagId);

		Session session = null;

		try {
			session = openSession();

			AnimalTagEntry[] array = new AnimalTagEntryImpl[3];

			array[0] = getByC_N_PrevAndNext(
				session, animalTagEntry, customerId, name, orderByComparator,
				true);

			array[1] = animalTagEntry;

			array[2] = getByC_N_PrevAndNext(
				session, animalTagEntry, customerId, name, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalTagEntry getByC_N_PrevAndNext(
		Session session, AnimalTagEntry animalTagEntry, long customerId,
		String name, OrderByComparator<AnimalTagEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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
			sb.append(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						animalTagEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalTagEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal tag entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	@Override
	public void removeByC_N(long customerId, String name) {
		for (AnimalTagEntry animalTagEntry :
				findByC_N(
					customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(animalTagEntry);
		}
	}

	/**
	 * Returns the number of animal tag entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByC_N(long customerId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByC_N;

		Object[] finderArgs = new Object[] {customerId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_N_NAME_2 =
		"animalTagEntry.name = ?";

	private static final String _FINDER_COLUMN_C_N_NAME_3 =
		"(animalTagEntry.name IS NULL OR animalTagEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (animalTagEntry == null) {
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

			throw new NoSuchAnimalTagEntryException(sb.toString());
		}

		return animalTagEntry;
	}

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Override
	public AnimalTagEntry fetchByC_ERC(
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

		if (result instanceof AnimalTagEntry) {
			AnimalTagEntry animalTagEntry = (AnimalTagEntry)result;

			if ((companyId != animalTagEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					animalTagEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ANIMALTAGENTRY_WHERE);

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

				List<AnimalTagEntry> list = query.list();

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
								"AnimalTagEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AnimalTagEntry animalTagEntry = list.get(0);

					result = animalTagEntry;

					cacheResult(animalTagEntry);
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
			return (AnimalTagEntry)result;
		}
	}

	/**
	 * Removes the animal tag entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal tag entry that was removed
	 */
	@Override
	public AnimalTagEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(animalTagEntry);
	}

	/**
	 * Returns the number of animal tag entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal tag entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALTAGENTRY_WHERE);

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
		"animalTagEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"animalTagEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(animalTagEntry.externalReferenceCode IS NULL OR animalTagEntry.externalReferenceCode = '')";

	public AnimalTagEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnimalTagEntry.class);

		setModelImplClass(AnimalTagEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AnimalTagEntryTable.INSTANCE);
	}

	/**
	 * Caches the animal tag entry in the entity cache if it is enabled.
	 *
	 * @param animalTagEntry the animal tag entry
	 */
	@Override
	public void cacheResult(AnimalTagEntry animalTagEntry) {
		entityCache.putResult(
			AnimalTagEntryImpl.class, animalTagEntry.getPrimaryKey(),
			animalTagEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				animalTagEntry.getUuid(), animalTagEntry.getGroupId()
			},
			animalTagEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				animalTagEntry.getCompanyId(),
				animalTagEntry.getExternalReferenceCode()
			},
			animalTagEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the animal tag entries in the entity cache if it is enabled.
	 *
	 * @param animalTagEntries the animal tag entries
	 */
	@Override
	public void cacheResult(List<AnimalTagEntry> animalTagEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (animalTagEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnimalTagEntry animalTagEntry : animalTagEntries) {
			if (entityCache.getResult(
					AnimalTagEntryImpl.class, animalTagEntry.getPrimaryKey()) ==
						null) {

				cacheResult(animalTagEntry);
			}
		}
	}

	/**
	 * Clears the cache for all animal tag entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimalTagEntryImpl.class);

		finderCache.clearCache(AnimalTagEntryImpl.class);
	}

	/**
	 * Clears the cache for the animal tag entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimalTagEntry animalTagEntry) {
		entityCache.removeResult(AnimalTagEntryImpl.class, animalTagEntry);
	}

	@Override
	public void clearCache(List<AnimalTagEntry> animalTagEntries) {
		for (AnimalTagEntry animalTagEntry : animalTagEntries) {
			entityCache.removeResult(AnimalTagEntryImpl.class, animalTagEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnimalTagEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnimalTagEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AnimalTagEntryModelImpl animalTagEntryModelImpl) {

		Object[] args = new Object[] {
			animalTagEntryModelImpl.getUuid(),
			animalTagEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, animalTagEntryModelImpl);

		args = new Object[] {
			animalTagEntryModelImpl.getCompanyId(),
			animalTagEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, animalTagEntryModelImpl);
	}

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	@Override
	public AnimalTagEntry create(long animalTagId) {
		AnimalTagEntry animalTagEntry = new AnimalTagEntryImpl();

		animalTagEntry.setNew(true);
		animalTagEntry.setPrimaryKey(animalTagId);

		String uuid = PortalUUIDUtil.generate();

		animalTagEntry.setUuid(uuid);

		animalTagEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return animalTagEntry;
	}

	/**
	 * Removes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry remove(long animalTagId)
		throws NoSuchAnimalTagEntryException {

		return remove((Serializable)animalTagId);
	}

	/**
	 * Removes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry remove(Serializable primaryKey)
		throws NoSuchAnimalTagEntryException {

		Session session = null;

		try {
			session = openSession();

			AnimalTagEntry animalTagEntry = (AnimalTagEntry)session.get(
				AnimalTagEntryImpl.class, primaryKey);

			if (animalTagEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimalTagEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animalTagEntry);
		}
		catch (NoSuchAnimalTagEntryException noSuchEntityException) {
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
	protected AnimalTagEntry removeImpl(AnimalTagEntry animalTagEntry) {
		animalTagEntryToPetEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			animalTagEntry.getPrimaryKey());

		animalTagEntryToDogEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			animalTagEntry.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animalTagEntry)) {
				animalTagEntry = (AnimalTagEntry)session.get(
					AnimalTagEntryImpl.class,
					animalTagEntry.getPrimaryKeyObj());
			}

			if (animalTagEntry != null) {
				session.delete(animalTagEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (animalTagEntry != null) {
			clearCache(animalTagEntry);
		}

		return animalTagEntry;
	}

	@Override
	public AnimalTagEntry updateImpl(AnimalTagEntry animalTagEntry) {
		boolean isNew = animalTagEntry.isNew();

		if (!(animalTagEntry instanceof AnimalTagEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animalTagEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					animalTagEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animalTagEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimalTagEntry implementation " +
					animalTagEntry.getClass());
		}

		AnimalTagEntryModelImpl animalTagEntryModelImpl =
			(AnimalTagEntryModelImpl)animalTagEntry;

		if (Validator.isNull(animalTagEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			animalTagEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (animalTagEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				animalTagEntry.setCreateDate(date);
			}
			else {
				animalTagEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!animalTagEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				animalTagEntry.setModifiedDate(date);
			}
			else {
				animalTagEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(animalTagEntry);
			}
			else {
				animalTagEntry = (AnimalTagEntry)session.merge(animalTagEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnimalTagEntryImpl.class, animalTagEntryModelImpl, false, true);

		cacheUniqueFindersCache(animalTagEntryModelImpl);

		if (isNew) {
			animalTagEntry.setNew(false);
		}

		animalTagEntry.resetOriginalValues();

		return animalTagEntry;
	}

	/**
	 * Returns the animal tag entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimalTagEntryException {

		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(primaryKey);

		if (animalTagEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimalTagEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animalTagEntry;
	}

	/**
	 * Returns the animal tag entry with the primary key or throws a <code>NoSuchAnimalTagEntryException</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws NoSuchAnimalTagEntryException if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry findByPrimaryKey(long animalTagId)
		throws NoSuchAnimalTagEntryException {

		return findByPrimaryKey((Serializable)animalTagId);
	}

	/**
	 * Returns the animal tag entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry, or <code>null</code> if a animal tag entry with the primary key could not be found
	 */
	@Override
	public AnimalTagEntry fetchByPrimaryKey(long animalTagId) {
		return fetchByPrimaryKey((Serializable)animalTagId);
	}

	/**
	 * Returns all the animal tag entries.
	 *
	 * @return the animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animal tag entries
	 */
	@Override
	public List<AnimalTagEntry> findAll(
		int start, int end, OrderByComparator<AnimalTagEntry> orderByComparator,
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

		List<AnimalTagEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalTagEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANIMALTAGENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMALTAGENTRY;

				sql = sql.concat(AnimalTagEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnimalTagEntry>)QueryUtil.list(
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
	 * Removes all the animal tag entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimalTagEntry animalTagEntry : findAll()) {
			remove(animalTagEntry);
		}
	}

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANIMALTAGENTRY);

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
	 * Returns the primaryKeys of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of pet entries associated with the animal tag entry
	 */
	@Override
	public long[] getPetEntryPrimaryKeys(long pk) {
		long[] pks = animalTagEntryToPetEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.clone();
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the animal tag entries associated with the pet entry
	 */
	@Override
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(long pk) {
		return getPetEntryAnimalTagEntries(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the pet entry
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of animal tag entries associated with the pet entry
	 */
	@Override
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end) {

		return getPetEntryAnimalTagEntries(pk, start, end, null);
	}

	/**
	 * Returns all the animal tag entry associated with the pet entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the pet entry
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries associated with the pet entry
	 */
	@Override
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long pk, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return animalTagEntryToPetEntryTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of pet entries associated with the animal tag entry
	 */
	@Override
	public int getPetEntriesSize(long pk) {
		long[] pks = animalTagEntryToPetEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the pet entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 * @return <code>true</code> if the pet entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPetEntry(long pk, long petEntryPK) {
		return animalTagEntryToPetEntryTableMapper.containsTableMapping(
			pk, petEntryPK);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry has any pet entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with pet entries
	 * @return <code>true</code> if the animal tag entry has any pet entries associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPetEntries(long pk) {
		if (getPetEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	@Override
	public void addPetEntry(long pk, long petEntryPK) {
		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			animalTagEntryToPetEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, petEntryPK);
		}
		else {
			animalTagEntryToPetEntryTableMapper.addTableMapping(
				animalTagEntry.getCompanyId(), pk, petEntryPK);
		}
	}

	/**
	 * Adds an association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	@Override
	public void addPetEntry(long pk, PetEntry petEntry) {
		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			animalTagEntryToPetEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				petEntry.getPrimaryKey());
		}
		else {
			animalTagEntryToPetEntryTableMapper.addTableMapping(
				animalTagEntry.getCompanyId(), pk, petEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	@Override
	public void addPetEntries(long pk, long[] petEntryPKs) {
		long companyId = 0;

		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = animalTagEntry.getCompanyId();
		}

		animalTagEntryToPetEntryTableMapper.addTableMappings(
			companyId, pk, petEntryPKs);
	}

	/**
	 * Adds an association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	@Override
	public void addPetEntries(long pk, List<PetEntry> petEntries) {
		addPetEntries(
			pk, ListUtil.toLongArray(petEntries, PetEntry.PET_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the animal tag entry and its pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated pet entries from
	 */
	@Override
	public void clearPetEntries(long pk) {
		animalTagEntryToPetEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPK the primary key of the pet entry
	 */
	@Override
	public void removePetEntry(long pk, long petEntryPK) {
		animalTagEntryToPetEntryTableMapper.deleteTableMapping(pk, petEntryPK);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntry the pet entry
	 */
	@Override
	public void removePetEntry(long pk, PetEntry petEntry) {
		animalTagEntryToPetEntryTableMapper.deleteTableMapping(
			pk, petEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries
	 */
	@Override
	public void removePetEntries(long pk, long[] petEntryPKs) {
		animalTagEntryToPetEntryTableMapper.deleteTableMappings(
			pk, petEntryPKs);
	}

	/**
	 * Removes the association between the animal tag entry and the pet entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries
	 */
	@Override
	public void removePetEntries(long pk, List<PetEntry> petEntries) {
		removePetEntries(
			pk, ListUtil.toLongArray(petEntries, PetEntry.PET_ID_ACCESSOR));
	}

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntryPKs the primary keys of the pet entries to be associated with the animal tag entry
	 */
	@Override
	public void setPetEntries(long pk, long[] petEntryPKs) {
		Set<Long> newPetEntryPKsSet = SetUtil.fromArray(petEntryPKs);
		Set<Long> oldPetEntryPKsSet = SetUtil.fromArray(
			animalTagEntryToPetEntryTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removePetEntryPKsSet = new HashSet<Long>(oldPetEntryPKsSet);

		removePetEntryPKsSet.removeAll(newPetEntryPKsSet);

		animalTagEntryToPetEntryTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePetEntryPKsSet));

		newPetEntryPKsSet.removeAll(oldPetEntryPKsSet);

		long companyId = 0;

		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = animalTagEntry.getCompanyId();
		}

		animalTagEntryToPetEntryTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPetEntryPKsSet));
	}

	/**
	 * Sets the pet entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param petEntries the pet entries to be associated with the animal tag entry
	 */
	@Override
	public void setPetEntries(long pk, List<PetEntry> petEntries) {
		try {
			long[] petEntryPKs = new long[petEntries.size()];

			for (int i = 0; i < petEntries.size(); i++) {
				PetEntry petEntry = petEntries.get(i);

				petEntryPKs[i] = petEntry.getPrimaryKey();
			}

			setPetEntries(pk, petEntryPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return long[] of the primaryKeys of dog entries associated with the animal tag entry
	 */
	@Override
	public long[] getDogEntryPrimaryKeys(long pk) {
		long[] pks = animalTagEntryToDogEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.clone();
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * @param pk the primary key of the dog entry
	 * @return the animal tag entries associated with the dog entry
	 */
	@Override
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(long pk) {
		return getDogEntryAnimalTagEntries(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the dog entry
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of animal tag entries associated with the dog entry
	 */
	@Override
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end) {

		return getDogEntryAnimalTagEntries(pk, start, end, null);
	}

	/**
	 * Returns all the animal tag entry associated with the dog entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the dog entry
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal tag entries associated with the dog entry
	 */
	@Override
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long pk, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator) {

		return animalTagEntryToDogEntryTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dog entries associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the number of dog entries associated with the animal tag entry
	 */
	@Override
	public int getDogEntriesSize(long pk) {
		long[] pks = animalTagEntryToDogEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the dog entry is associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 * @return <code>true</code> if the dog entry is associated with the animal tag entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDogEntry(long pk, long dogEntryPK) {
		return animalTagEntryToDogEntryTableMapper.containsTableMapping(
			pk, dogEntryPK);
	}

	/**
	 * Returns <code>true</code> if the animal tag entry has any dog entries associated with it.
	 *
	 * @param pk the primary key of the animal tag entry to check for associations with dog entries
	 * @return <code>true</code> if the animal tag entry has any dog entries associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDogEntries(long pk) {
		if (getDogEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	@Override
	public void addDogEntry(long pk, long dogEntryPK) {
		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			animalTagEntryToDogEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, dogEntryPK);
		}
		else {
			animalTagEntryToDogEntryTableMapper.addTableMapping(
				animalTagEntry.getCompanyId(), pk, dogEntryPK);
		}
	}

	/**
	 * Adds an association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	@Override
	public void addDogEntry(long pk, DogEntry dogEntry) {
		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			animalTagEntryToDogEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				dogEntry.getPrimaryKey());
		}
		else {
			animalTagEntryToDogEntryTableMapper.addTableMapping(
				animalTagEntry.getCompanyId(), pk, dogEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	@Override
	public void addDogEntries(long pk, long[] dogEntryPKs) {
		long companyId = 0;

		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = animalTagEntry.getCompanyId();
		}

		animalTagEntryToDogEntryTableMapper.addTableMappings(
			companyId, pk, dogEntryPKs);
	}

	/**
	 * Adds an association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	@Override
	public void addDogEntries(long pk, List<DogEntry> dogEntries) {
		addDogEntries(
			pk, ListUtil.toLongArray(dogEntries, DogEntry.DOG_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the animal tag entry and its dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry to clear the associated dog entries from
	 */
	@Override
	public void clearDogEntries(long pk) {
		animalTagEntryToDogEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPK the primary key of the dog entry
	 */
	@Override
	public void removeDogEntry(long pk, long dogEntryPK) {
		animalTagEntryToDogEntryTableMapper.deleteTableMapping(pk, dogEntryPK);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntry the dog entry
	 */
	@Override
	public void removeDogEntry(long pk, DogEntry dogEntry) {
		animalTagEntryToDogEntryTableMapper.deleteTableMapping(
			pk, dogEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries
	 */
	@Override
	public void removeDogEntries(long pk, long[] dogEntryPKs) {
		animalTagEntryToDogEntryTableMapper.deleteTableMappings(
			pk, dogEntryPKs);
	}

	/**
	 * Removes the association between the animal tag entry and the dog entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries
	 */
	@Override
	public void removeDogEntries(long pk, List<DogEntry> dogEntries) {
		removeDogEntries(
			pk, ListUtil.toLongArray(dogEntries, DogEntry.DOG_ID_ACCESSOR));
	}

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntryPKs the primary keys of the dog entries to be associated with the animal tag entry
	 */
	@Override
	public void setDogEntries(long pk, long[] dogEntryPKs) {
		Set<Long> newDogEntryPKsSet = SetUtil.fromArray(dogEntryPKs);
		Set<Long> oldDogEntryPKsSet = SetUtil.fromArray(
			animalTagEntryToDogEntryTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeDogEntryPKsSet = new HashSet<Long>(oldDogEntryPKsSet);

		removeDogEntryPKsSet.removeAll(newDogEntryPKsSet);

		animalTagEntryToDogEntryTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeDogEntryPKsSet));

		newDogEntryPKsSet.removeAll(oldDogEntryPKsSet);

		long companyId = 0;

		AnimalTagEntry animalTagEntry = fetchByPrimaryKey(pk);

		if (animalTagEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = animalTagEntry.getCompanyId();
		}

		animalTagEntryToDogEntryTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newDogEntryPKsSet));
	}

	/**
	 * Sets the dog entries associated with the animal tag entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @param dogEntries the dog entries to be associated with the animal tag entry
	 */
	@Override
	public void setDogEntries(long pk, List<DogEntry> dogEntries) {
		try {
			long[] dogEntryPKs = new long[dogEntries.size()];

			for (int i = 0; i < dogEntries.size(); i++) {
				DogEntry dogEntry = dogEntries.get(i);

				dogEntryPKs[i] = dogEntry.getPrimaryKey();
			}

			setDogEntries(pk, dogEntryPKs);
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
		return "animalTagId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANIMALTAGENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnimalTagEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animal tag entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		animalTagEntryToPetEntryTableMapper = TableMapperFactory.getTableMapper(
			"DG_Pets_AnimalTags#animalTagId", "DG_Pets_AnimalTags", "companyId",
			"animalTagId", "petId", this, PetEntry.class);

		animalTagEntryToDogEntryTableMapper = TableMapperFactory.getTableMapper(
			"DG_Dogs_AnimalTags#animalTagId", "DG_Dogs_AnimalTags", "companyId",
			"animalTagId", "dogId", this, DogEntry.class);

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

		_setAnimalTagEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnimalTagEntryUtilPersistence(null);

		entityCache.removeCache(AnimalTagEntryImpl.class.getName());

		TableMapperFactory.removeTableMapper("DG_Pets_AnimalTags#animalTagId");
		TableMapperFactory.removeTableMapper("DG_Dogs_AnimalTags#animalTagId");
	}

	private void _setAnimalTagEntryUtilPersistence(
		AnimalTagEntryPersistence animalTagEntryPersistence) {

		try {
			Field field = AnimalTagEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, animalTagEntryPersistence);
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

	protected TableMapper<AnimalTagEntry, PetEntry>
		animalTagEntryToPetEntryTableMapper;
	protected TableMapper<AnimalTagEntry, DogEntry>
		animalTagEntryToDogEntryTableMapper;

	private static final String _SQL_SELECT_ANIMALTAGENTRY =
		"SELECT animalTagEntry FROM AnimalTagEntry animalTagEntry";

	private static final String _SQL_SELECT_ANIMALTAGENTRY_WHERE =
		"SELECT animalTagEntry FROM AnimalTagEntry animalTagEntry WHERE ";

	private static final String _SQL_COUNT_ANIMALTAGENTRY =
		"SELECT COUNT(animalTagEntry) FROM AnimalTagEntry animalTagEntry";

	private static final String _SQL_COUNT_ANIMALTAGENTRY_WHERE =
		"SELECT COUNT(animalTagEntry) FROM AnimalTagEntry animalTagEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animalTagEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimalTagEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimalTagEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimalTagEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AnimalTagEntryModelArgumentsResolver
		_animalTagEntryModelArgumentsResolver;

}