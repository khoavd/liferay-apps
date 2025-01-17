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

import com.dogoo.sample.pet.service.exception.NoSuchAnimalGroupEntryException;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.model.AnimalGroupEntryTable;
import com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryImpl;
import com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryModelImpl;
import com.dogoo.sample.pet.service.service.persistence.AnimalGroupEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.AnimalGroupEntryUtil;
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
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The persistence implementation for the animal group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @generated
 */
@Component(service = {AnimalGroupEntryPersistence.class, BasePersistence.class})
public class AnimalGroupEntryPersistenceImpl
	extends BasePersistenceImpl<AnimalGroupEntry>
	implements AnimalGroupEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnimalGroupEntryUtil</code> to access the animal group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnimalGroupEntryImpl.class.getName();

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
	 * Returns all the animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		List<AnimalGroupEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalGroupEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalGroupEntry animalGroupEntry : list) {
					if (!uuid.equals(animalGroupEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
				sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalGroupEntry>)QueryUtil.list(
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
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByUuid_First(
			String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUuid_First(
		String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		List<AnimalGroupEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByUuid_Last(
			String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AnimalGroupEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where uuid = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry[] findByUuid_PrevAndNext(
			long animalGroupId, String uuid,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		uuid = Objects.toString(uuid, "");

		AnimalGroupEntry animalGroupEntry = findByPrimaryKey(animalGroupId);

		Session session = null;

		try {
			session = openSession();

			AnimalGroupEntry[] array = new AnimalGroupEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, animalGroupEntry, uuid, orderByComparator, true);

			array[1] = animalGroupEntry;

			array[2] = getByUuid_PrevAndNext(
				session, animalGroupEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalGroupEntry getByUuid_PrevAndNext(
		Session session, AnimalGroupEntry animalGroupEntry, String uuid,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
			sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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
						animalGroupEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalGroupEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal group entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AnimalGroupEntry animalGroupEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animalGroupEntry);
		}
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(animalGroupEntry.uuid IS NULL OR animalGroupEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByUUID_G(uuid, groupId);

		if (animalGroupEntry == null) {
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

			throw new NoSuchAnimalGroupEntryException(sb.toString());
		}

		return animalGroupEntry;
	}

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the animal group entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUUID_G(
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

		if (result instanceof AnimalGroupEntry) {
			AnimalGroupEntry animalGroupEntry = (AnimalGroupEntry)result;

			if (!Objects.equals(uuid, animalGroupEntry.getUuid()) ||
				(groupId != animalGroupEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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

				List<AnimalGroupEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AnimalGroupEntry animalGroupEntry = list.get(0);

					result = animalGroupEntry;

					cacheResult(animalGroupEntry);
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
			return (AnimalGroupEntry)result;
		}
	}

	/**
	 * Removes the animal group entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the animal group entry that was removed
	 */
	@Override
	public AnimalGroupEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = findByUUID_G(uuid, groupId);

		return remove(animalGroupEntry);
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(animalGroupEntry.uuid IS NULL OR animalGroupEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"animalGroupEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		List<AnimalGroupEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalGroupEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalGroupEntry animalGroupEntry : list) {
					if (!uuid.equals(animalGroupEntry.getUuid()) ||
						(companyId != animalGroupEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
				sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalGroupEntry>)QueryUtil.list(
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
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the first animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		List<AnimalGroupEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the last animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AnimalGroupEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry[] findByUuid_C_PrevAndNext(
			long animalGroupId, String uuid, long companyId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		uuid = Objects.toString(uuid, "");

		AnimalGroupEntry animalGroupEntry = findByPrimaryKey(animalGroupId);

		Session session = null;

		try {
			session = openSession();

			AnimalGroupEntry[] array = new AnimalGroupEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, animalGroupEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = animalGroupEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, animalGroupEntry, uuid, companyId, orderByComparator,
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

	protected AnimalGroupEntry getByUuid_C_PrevAndNext(
		Session session, AnimalGroupEntry animalGroupEntry, String uuid,
		long companyId, OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
			sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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
						animalGroupEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalGroupEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal group entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AnimalGroupEntry animalGroupEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(animalGroupEntry);
		}
	}

	/**
	 * Returns the number of animal group entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(animalGroupEntry.uuid IS NULL OR animalGroupEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"animalGroupEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_;
	private FinderPath _finderPathWithoutPaginationFindByG_;
	private FinderPath _finderPathCountByG_;

	/**
	 * Returns all the animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByG_(long groupId) {
		return findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByG_(long groupId, int start, int end) {
		return findByG_(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return findByG_(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal group entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByG_(
		long groupId, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		List<AnimalGroupEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalGroupEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalGroupEntry animalGroupEntry : list) {
					if (groupId != animalGroupEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G__GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<AnimalGroupEntry>)QueryUtil.list(
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
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByG__First(
			long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByG__First(
			groupId, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the first animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByG__First(
		long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		List<AnimalGroupEntry> list = findByG_(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByG__Last(
			long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByG__Last(
			groupId, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the last animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByG__Last(
		long groupId, OrderByComparator<AnimalGroupEntry> orderByComparator) {

		int count = countByG_(groupId);

		if (count == 0) {
			return null;
		}

		List<AnimalGroupEntry> list = findByG_(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where groupId = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry[] findByG__PrevAndNext(
			long animalGroupId, long groupId,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = findByPrimaryKey(animalGroupId);

		Session session = null;

		try {
			session = openSession();

			AnimalGroupEntry[] array = new AnimalGroupEntryImpl[3];

			array[0] = getByG__PrevAndNext(
				session, animalGroupEntry, groupId, orderByComparator, true);

			array[1] = animalGroupEntry;

			array[2] = getByG__PrevAndNext(
				session, animalGroupEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnimalGroupEntry getByG__PrevAndNext(
		Session session, AnimalGroupEntry animalGroupEntry, long groupId,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
			sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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
						animalGroupEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalGroupEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal group entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG_(long groupId) {
		for (AnimalGroupEntry animalGroupEntry :
				findByG_(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(animalGroupEntry);
		}
	}

	/**
	 * Returns the number of animal group entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByG_(long groupId) {
		FinderPath finderPath = _finderPathCountByG_;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByC_N;
	private FinderPath _finderPathWithoutPaginationFindByC_N;
	private FinderPath _finderPathCountByC_N;

	/**
	 * Returns all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByC_N(long customerId, String name) {
		return findByC_N(
			customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return findByC_N(customerId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return findByC_N(customerId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		List<AnimalGroupEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalGroupEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnimalGroupEntry animalGroupEntry : list) {
					if ((customerId != animalGroupEntry.getCustomerId()) ||
						!name.equals(animalGroupEntry.getName())) {

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

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
				sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AnimalGroupEntry>)QueryUtil.list(
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
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByC_N_First(
			customerId, name, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the first animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		List<AnimalGroupEntry> list = findByC_N(
			customerId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByC_N_Last(
			customerId, name, orderByComparator);

		if (animalGroupEntry != null) {
			return animalGroupEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchAnimalGroupEntryException(sb.toString());
	}

	/**
	 * Returns the last animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		int count = countByC_N(customerId, name);

		if (count == 0) {
			return null;
		}

		List<AnimalGroupEntry> list = findByC_N(
			customerId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the animal group entries before and after the current animal group entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param animalGroupId the primary key of the current animal group entry
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry[] findByC_N_PrevAndNext(
			long animalGroupId, long customerId, String name,
			OrderByComparator<AnimalGroupEntry> orderByComparator)
		throws NoSuchAnimalGroupEntryException {

		name = Objects.toString(name, "");

		AnimalGroupEntry animalGroupEntry = findByPrimaryKey(animalGroupId);

		Session session = null;

		try {
			session = openSession();

			AnimalGroupEntry[] array = new AnimalGroupEntryImpl[3];

			array[0] = getByC_N_PrevAndNext(
				session, animalGroupEntry, customerId, name, orderByComparator,
				true);

			array[1] = animalGroupEntry;

			array[2] = getByC_N_PrevAndNext(
				session, animalGroupEntry, customerId, name, orderByComparator,
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

	protected AnimalGroupEntry getByC_N_PrevAndNext(
		Session session, AnimalGroupEntry animalGroupEntry, long customerId,
		String name, OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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
			sb.append(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
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
						animalGroupEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnimalGroupEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the animal group entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	@Override
	public void removeByC_N(long customerId, String name) {
		for (AnimalGroupEntry animalGroupEntry :
				findByC_N(
					customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(animalGroupEntry);
		}
	}

	/**
	 * Returns the number of animal group entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByC_N(long customerId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByC_N;

		Object[] finderArgs = new Object[] {customerId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_N_NAME_2 =
		"animalGroupEntry.name = ?";

	private static final String _FINDER_COLUMN_C_N_NAME_3 =
		"(animalGroupEntry.name IS NULL OR animalGroupEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (animalGroupEntry == null) {
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

			throw new NoSuchAnimalGroupEntryException(sb.toString());
		}

		return animalGroupEntry;
	}

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the animal group entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching animal group entry, or <code>null</code> if a matching animal group entry could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByC_ERC(
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

		if (result instanceof AnimalGroupEntry) {
			AnimalGroupEntry animalGroupEntry = (AnimalGroupEntry)result;

			if ((companyId != animalGroupEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					animalGroupEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ANIMALGROUPENTRY_WHERE);

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

				List<AnimalGroupEntry> list = query.list();

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
								"AnimalGroupEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AnimalGroupEntry animalGroupEntry = list.get(0);

					result = animalGroupEntry;

					cacheResult(animalGroupEntry);
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
			return (AnimalGroupEntry)result;
		}
	}

	/**
	 * Removes the animal group entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the animal group entry that was removed
	 */
	@Override
	public AnimalGroupEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(animalGroupEntry);
	}

	/**
	 * Returns the number of animal group entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching animal group entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANIMALGROUPENTRY_WHERE);

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
		"animalGroupEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"animalGroupEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(animalGroupEntry.externalReferenceCode IS NULL OR animalGroupEntry.externalReferenceCode = '')";

	public AnimalGroupEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnimalGroupEntry.class);

		setModelImplClass(AnimalGroupEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AnimalGroupEntryTable.INSTANCE);
	}

	/**
	 * Caches the animal group entry in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntry the animal group entry
	 */
	@Override
	public void cacheResult(AnimalGroupEntry animalGroupEntry) {
		entityCache.putResult(
			AnimalGroupEntryImpl.class, animalGroupEntry.getPrimaryKey(),
			animalGroupEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				animalGroupEntry.getUuid(), animalGroupEntry.getGroupId()
			},
			animalGroupEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				animalGroupEntry.getCompanyId(),
				animalGroupEntry.getExternalReferenceCode()
			},
			animalGroupEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the animal group entries in the entity cache if it is enabled.
	 *
	 * @param animalGroupEntries the animal group entries
	 */
	@Override
	public void cacheResult(List<AnimalGroupEntry> animalGroupEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (animalGroupEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnimalGroupEntry animalGroupEntry : animalGroupEntries) {
			if (entityCache.getResult(
					AnimalGroupEntryImpl.class,
					animalGroupEntry.getPrimaryKey()) == null) {

				cacheResult(animalGroupEntry);
			}
		}
	}

	/**
	 * Clears the cache for all animal group entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnimalGroupEntryImpl.class);

		finderCache.clearCache(AnimalGroupEntryImpl.class);
	}

	/**
	 * Clears the cache for the animal group entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnimalGroupEntry animalGroupEntry) {
		entityCache.removeResult(AnimalGroupEntryImpl.class, animalGroupEntry);
	}

	@Override
	public void clearCache(List<AnimalGroupEntry> animalGroupEntries) {
		for (AnimalGroupEntry animalGroupEntry : animalGroupEntries) {
			entityCache.removeResult(
				AnimalGroupEntryImpl.class, animalGroupEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnimalGroupEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnimalGroupEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AnimalGroupEntryModelImpl animalGroupEntryModelImpl) {

		Object[] args = new Object[] {
			animalGroupEntryModelImpl.getUuid(),
			animalGroupEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, animalGroupEntryModelImpl);

		args = new Object[] {
			animalGroupEntryModelImpl.getCompanyId(),
			animalGroupEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, animalGroupEntryModelImpl);
	}

	/**
	 * Creates a new animal group entry with the primary key. Does not add the animal group entry to the database.
	 *
	 * @param animalGroupId the primary key for the new animal group entry
	 * @return the new animal group entry
	 */
	@Override
	public AnimalGroupEntry create(long animalGroupId) {
		AnimalGroupEntry animalGroupEntry = new AnimalGroupEntryImpl();

		animalGroupEntry.setNew(true);
		animalGroupEntry.setPrimaryKey(animalGroupId);

		String uuid = PortalUUIDUtil.generate();

		animalGroupEntry.setUuid(uuid);

		animalGroupEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return animalGroupEntry;
	}

	/**
	 * Removes the animal group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry that was removed
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry remove(long animalGroupId)
		throws NoSuchAnimalGroupEntryException {

		return remove((Serializable)animalGroupId);
	}

	/**
	 * Removes the animal group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the animal group entry
	 * @return the animal group entry that was removed
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry remove(Serializable primaryKey)
		throws NoSuchAnimalGroupEntryException {

		Session session = null;

		try {
			session = openSession();

			AnimalGroupEntry animalGroupEntry = (AnimalGroupEntry)session.get(
				AnimalGroupEntryImpl.class, primaryKey);

			if (animalGroupEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnimalGroupEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(animalGroupEntry);
		}
		catch (NoSuchAnimalGroupEntryException noSuchEntityException) {
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
	protected AnimalGroupEntry removeImpl(AnimalGroupEntry animalGroupEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(animalGroupEntry)) {
				animalGroupEntry = (AnimalGroupEntry)session.get(
					AnimalGroupEntryImpl.class,
					animalGroupEntry.getPrimaryKeyObj());
			}

			if (animalGroupEntry != null) {
				session.delete(animalGroupEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (animalGroupEntry != null) {
			clearCache(animalGroupEntry);
		}

		return animalGroupEntry;
	}

	@Override
	public AnimalGroupEntry updateImpl(AnimalGroupEntry animalGroupEntry) {
		boolean isNew = animalGroupEntry.isNew();

		if (!(animalGroupEntry instanceof AnimalGroupEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(animalGroupEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					animalGroupEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in animalGroupEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnimalGroupEntry implementation " +
					animalGroupEntry.getClass());
		}

		AnimalGroupEntryModelImpl animalGroupEntryModelImpl =
			(AnimalGroupEntryModelImpl)animalGroupEntry;

		if (Validator.isNull(animalGroupEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			animalGroupEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (animalGroupEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				animalGroupEntry.setCreateDate(date);
			}
			else {
				animalGroupEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!animalGroupEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				animalGroupEntry.setModifiedDate(date);
			}
			else {
				animalGroupEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(animalGroupEntry);
			}
			else {
				animalGroupEntry = (AnimalGroupEntry)session.merge(
					animalGroupEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnimalGroupEntryImpl.class, animalGroupEntryModelImpl, false, true);

		cacheUniqueFindersCache(animalGroupEntryModelImpl);

		if (isNew) {
			animalGroupEntry.setNew(false);
		}

		animalGroupEntry.resetOriginalValues();

		return animalGroupEntry;
	}

	/**
	 * Returns the animal group entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnimalGroupEntryException {

		AnimalGroupEntry animalGroupEntry = fetchByPrimaryKey(primaryKey);

		if (animalGroupEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnimalGroupEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return animalGroupEntry;
	}

	/**
	 * Returns the animal group entry with the primary key or throws a <code>NoSuchAnimalGroupEntryException</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry
	 * @throws NoSuchAnimalGroupEntryException if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry findByPrimaryKey(long animalGroupId)
		throws NoSuchAnimalGroupEntryException {

		return findByPrimaryKey((Serializable)animalGroupId);
	}

	/**
	 * Returns the animal group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param animalGroupId the primary key of the animal group entry
	 * @return the animal group entry, or <code>null</code> if a animal group entry with the primary key could not be found
	 */
	@Override
	public AnimalGroupEntry fetchByPrimaryKey(long animalGroupId) {
		return fetchByPrimaryKey((Serializable)animalGroupId);
	}

	/**
	 * Returns all the animal group entries.
	 *
	 * @return the animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @return the range of animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the animal group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimalGroupEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal group entries
	 * @param end the upper bound of the range of animal group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animal group entries
	 */
	@Override
	public List<AnimalGroupEntry> findAll(
		int start, int end,
		OrderByComparator<AnimalGroupEntry> orderByComparator,
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

		List<AnimalGroupEntry> list = null;

		if (useFinderCache) {
			list = (List<AnimalGroupEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANIMALGROUPENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANIMALGROUPENTRY;

				sql = sql.concat(AnimalGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnimalGroupEntry>)QueryUtil.list(
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
	 * Removes all the animal group entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnimalGroupEntry animalGroupEntry : findAll()) {
			remove(animalGroupEntry);
		}
	}

	/**
	 * Returns the number of animal group entries.
	 *
	 * @return the number of animal group entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANIMALGROUPENTRY);

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
		return "animalGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANIMALGROUPENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnimalGroupEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the animal group entry persistence.
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

		_setAnimalGroupEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnimalGroupEntryUtilPersistence(null);

		entityCache.removeCache(AnimalGroupEntryImpl.class.getName());
	}

	private void _setAnimalGroupEntryUtilPersistence(
		AnimalGroupEntryPersistence animalGroupEntryPersistence) {

		try {
			Field field = AnimalGroupEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, animalGroupEntryPersistence);
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

	private static final String _SQL_SELECT_ANIMALGROUPENTRY =
		"SELECT animalGroupEntry FROM AnimalGroupEntry animalGroupEntry";

	private static final String _SQL_SELECT_ANIMALGROUPENTRY_WHERE =
		"SELECT animalGroupEntry FROM AnimalGroupEntry animalGroupEntry WHERE ";

	private static final String _SQL_COUNT_ANIMALGROUPENTRY =
		"SELECT COUNT(animalGroupEntry) FROM AnimalGroupEntry animalGroupEntry";

	private static final String _SQL_COUNT_ANIMALGROUPENTRY_WHERE =
		"SELECT COUNT(animalGroupEntry) FROM AnimalGroupEntry animalGroupEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "animalGroupEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnimalGroupEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnimalGroupEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnimalGroupEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AnimalGroupEntryModelArgumentsResolver
		_animalGroupEntryModelArgumentsResolver;

}