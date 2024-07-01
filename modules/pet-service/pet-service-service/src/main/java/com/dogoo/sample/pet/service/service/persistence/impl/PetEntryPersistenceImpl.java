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

import com.dogoo.sample.pet.service.exception.NoSuchPetEntryException;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.model.PetEntryTable;
import com.dogoo.sample.pet.service.model.impl.PetEntryImpl;
import com.dogoo.sample.pet.service.model.impl.PetEntryModelImpl;
import com.dogoo.sample.pet.service.service.persistence.PetEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.PetEntryUtil;
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
 * The persistence implementation for the pet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavu
 * @generated
 */
@Component(service = {PetEntryPersistence.class, BasePersistence.class})
public class PetEntryPersistenceImpl
	extends BasePersistenceImpl<PetEntry> implements PetEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetEntryUtil</code> to access the pet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetEntryImpl.class.getName();

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
	 * Returns all the pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet entries
	 */
	@Override
	public List<PetEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<PetEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

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

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PetEntry petEntry : list) {
					if (!uuid.equals(petEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
				sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByUuid_First(
			String uuid, OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByUuid_First(uuid, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUuid_First(
		String uuid, OrderByComparator<PetEntry> orderByComparator) {

		List<PetEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByUuid_Last(
			String uuid, OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PetEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PetEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry[] findByUuid_PrevAndNext(
			long petId, String uuid,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		uuid = Objects.toString(uuid, "");

		PetEntry petEntry = findByPrimaryKey(petId);

		Session session = null;

		try {
			session = openSession();

			PetEntry[] array = new PetEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, petEntry, uuid, orderByComparator, true);

			array[1] = petEntry;

			array[2] = getByUuid_PrevAndNext(
				session, petEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetEntry getByUuid_PrevAndNext(
		Session session, PetEntry petEntry, String uuid,
		OrderByComparator<PetEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
			sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(petEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PetEntry petEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

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
		"petEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(petEntry.uuid IS NULL OR petEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByUUID_G(uuid, groupId);

		if (petEntry == null) {
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

			throw new NoSuchPetEntryException(sb.toString());
		}

		return petEntry;
	}

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUUID_G(
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

		if (result instanceof PetEntry) {
			PetEntry petEntry = (PetEntry)result;

			if (!Objects.equals(uuid, petEntry.getUuid()) ||
				(groupId != petEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

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

				List<PetEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PetEntry petEntry = list.get(0);

					result = petEntry;

					cacheResult(petEntry);
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
			return (PetEntry)result;
		}
	}

	/**
	 * Removes the pet entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet entry that was removed
	 */
	@Override
	public PetEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException {

		PetEntry petEntry = findByUUID_G(uuid, groupId);

		return remove(petEntry);
	}

	/**
	 * Returns the number of pet entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

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
		"petEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(petEntry.uuid IS NULL OR petEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"petEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet entries
	 */
	@Override
	public List<PetEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

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

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PetEntry petEntry : list) {
					if (!uuid.equals(petEntry.getUuid()) ||
						(companyId != petEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
				sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PetEntry> orderByComparator) {

		List<PetEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PetEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PetEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PetEntry[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		uuid = Objects.toString(uuid, "");

		PetEntry petEntry = findByPrimaryKey(petId);

		Session session = null;

		try {
			session = openSession();

			PetEntry[] array = new PetEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, petEntry, uuid, companyId, orderByComparator, true);

			array[1] = petEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, petEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetEntry getByUuid_C_PrevAndNext(
		Session session, PetEntry petEntry, String uuid, long companyId,
		OrderByComparator<PetEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
			sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(petEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PetEntry petEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

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
		"petEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(petEntry.uuid IS NULL OR petEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"petEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_V;
	private FinderPath _finderPathWithoutPaginationFindByC_V;
	private FinderPath _finderPathCountByC_V;

	/**
	 * Returns all the pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the matching pet entries
	 */
	@Override
	public List<PetEntry> findByC_V(long customerId, boolean vaccine) {
		return findByC_V(
			customerId, vaccine, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end) {

		return findByC_V(customerId, vaccine, start, end, null);
	}

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
	@Override
	public List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return findByC_V(
			customerId, vaccine, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findByC_V(
		long customerId, boolean vaccine, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_V;
				finderArgs = new Object[] {customerId, vaccine};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_V;
			finderArgs = new Object[] {
				customerId, vaccine, start, end, orderByComparator
			};
		}

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PetEntry petEntry : list) {
					if ((customerId != petEntry.getCustomerId()) ||
						(vaccine != petEntry.isVaccine())) {

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

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_V_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_V_VACCINE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(vaccine);

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByC_V_First(
			long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByC_V_First(
			customerId, vaccine, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", vaccine=");
		sb.append(vaccine);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_V_First(
		long customerId, boolean vaccine,
		OrderByComparator<PetEntry> orderByComparator) {

		List<PetEntry> list = findByC_V(
			customerId, vaccine, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByC_V_Last(
			long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByC_V_Last(
			customerId, vaccine, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", vaccine=");
		sb.append(vaccine);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_V_Last(
		long customerId, boolean vaccine,
		OrderByComparator<PetEntry> orderByComparator) {

		int count = countByC_V(customerId, vaccine);

		if (count == 0) {
			return null;
		}

		List<PetEntry> list = findByC_V(
			customerId, vaccine, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PetEntry[] findByC_V_PrevAndNext(
			long petId, long customerId, boolean vaccine,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = findByPrimaryKey(petId);

		Session session = null;

		try {
			session = openSession();

			PetEntry[] array = new PetEntryImpl[3];

			array[0] = getByC_V_PrevAndNext(
				session, petEntry, customerId, vaccine, orderByComparator,
				true);

			array[1] = petEntry;

			array[2] = getByC_V_PrevAndNext(
				session, petEntry, customerId, vaccine, orderByComparator,
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

	protected PetEntry getByC_V_PrevAndNext(
		Session session, PetEntry petEntry, long customerId, boolean vaccine,
		OrderByComparator<PetEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PETENTRY_WHERE);

		sb.append(_FINDER_COLUMN_C_V_CUSTOMERID_2);

		sb.append(_FINDER_COLUMN_C_V_VACCINE_2);

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
			sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		queryPos.add(vaccine);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(petEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet entries where customerId = &#63; and vaccine = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 */
	@Override
	public void removeByC_V(long customerId, boolean vaccine) {
		for (PetEntry petEntry :
				findByC_V(
					customerId, vaccine, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries where customerId = &#63; and vaccine = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param vaccine the vaccine
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByC_V(long customerId, boolean vaccine) {
		FinderPath finderPath = _finderPathCountByC_V;

		Object[] finderArgs = new Object[] {customerId, vaccine};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_V_CUSTOMERID_2);

			sb.append(_FINDER_COLUMN_C_V_VACCINE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				queryPos.add(vaccine);

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

	private static final String _FINDER_COLUMN_C_V_CUSTOMERID_2 =
		"petEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_V_VACCINE_2 =
		"petEntry.vaccine = ?";

	private FinderPath _finderPathWithPaginationFindByA_G;
	private FinderPath _finderPathWithoutPaginationFindByA_G;
	private FinderPath _finderPathCountByA_G;

	/**
	 * Returns all the pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the matching pet entries
	 */
	@Override
	public List<PetEntry> findByA_G(long animalGroupId) {
		return findByA_G(
			animalGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findByA_G(long animalGroupId, int start, int end) {
		return findByA_G(animalGroupId, start, end, null);
	}

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
	@Override
	public List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return findByA_G(animalGroupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findByA_G(
		long animalGroupId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByA_G;
				finderArgs = new Object[] {animalGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByA_G;
			finderArgs = new Object[] {
				animalGroupId, start, end, orderByComparator
			};
		}

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PetEntry petEntry : list) {
					if (animalGroupId != petEntry.getAnimalGroupId()) {
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

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

			sb.append(_FINDER_COLUMN_A_G_ANIMALGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(animalGroupId);

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByA_G_First(
			long animalGroupId, OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByA_G_First(animalGroupId, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("animalGroupId=");
		sb.append(animalGroupId);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the first pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByA_G_First(
		long animalGroupId, OrderByComparator<PetEntry> orderByComparator) {

		List<PetEntry> list = findByA_G(animalGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByA_G_Last(
			long animalGroupId, OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByA_G_Last(animalGroupId, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("animalGroupId=");
		sb.append(animalGroupId);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the last pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByA_G_Last(
		long animalGroupId, OrderByComparator<PetEntry> orderByComparator) {

		int count = countByA_G(animalGroupId);

		if (count == 0) {
			return null;
		}

		List<PetEntry> list = findByA_G(
			animalGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where animalGroupId = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param animalGroupId the animal group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry[] findByA_G_PrevAndNext(
			long petId, long animalGroupId,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = findByPrimaryKey(petId);

		Session session = null;

		try {
			session = openSession();

			PetEntry[] array = new PetEntryImpl[3];

			array[0] = getByA_G_PrevAndNext(
				session, petEntry, animalGroupId, orderByComparator, true);

			array[1] = petEntry;

			array[2] = getByA_G_PrevAndNext(
				session, petEntry, animalGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetEntry getByA_G_PrevAndNext(
		Session session, PetEntry petEntry, long animalGroupId,
		OrderByComparator<PetEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PETENTRY_WHERE);

		sb.append(_FINDER_COLUMN_A_G_ANIMALGROUPID_2);

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
			sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(animalGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(petEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet entries where animalGroupId = &#63; from the database.
	 *
	 * @param animalGroupId the animal group ID
	 */
	@Override
	public void removeByA_G(long animalGroupId) {
		for (PetEntry petEntry :
				findByA_G(
					animalGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries where animalGroupId = &#63;.
	 *
	 * @param animalGroupId the animal group ID
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByA_G(long animalGroupId) {
		FinderPath finderPath = _finderPathCountByA_G;

		Object[] finderArgs = new Object[] {animalGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

			sb.append(_FINDER_COLUMN_A_G_ANIMALGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(animalGroupId);

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

	private static final String _FINDER_COLUMN_A_G_ANIMALGROUPID_2 =
		"petEntry.animalGroupId = ?";

	private FinderPath _finderPathWithPaginationFindByC_N;
	private FinderPath _finderPathWithoutPaginationFindByC_N;
	private FinderPath _finderPathCountByC_N;

	/**
	 * Returns all the pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the matching pet entries
	 */
	@Override
	public List<PetEntry> findByC_N(long customerId, String name) {
		return findByC_N(
			customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findByC_N(
		long customerId, String name, int start, int end) {

		return findByC_N(customerId, name, start, end, null);
	}

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
	@Override
	public List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return findByC_N(customerId, name, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findByC_N(
		long customerId, String name, int start, int end,
		OrderByComparator<PetEntry> orderByComparator, boolean useFinderCache) {

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

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PetEntry petEntry : list) {
					if ((customerId != petEntry.getCustomerId()) ||
						!name.equals(petEntry.getName())) {

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

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
				sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByC_N_First(
			long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByC_N_First(
			customerId, name, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the first pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_N_First(
		long customerId, String name,
		OrderByComparator<PetEntry> orderByComparator) {

		List<PetEntry> list = findByC_N(
			customerId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByC_N_Last(
			long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByC_N_Last(
			customerId, name, orderByComparator);

		if (petEntry != null) {
			return petEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPetEntryException(sb.toString());
	}

	/**
	 * Returns the last pet entry in the ordered set where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_N_Last(
		long customerId, String name,
		OrderByComparator<PetEntry> orderByComparator) {

		int count = countByC_N(customerId, name);

		if (count == 0) {
			return null;
		}

		List<PetEntry> list = findByC_N(
			customerId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PetEntry[] findByC_N_PrevAndNext(
			long petId, long customerId, String name,
			OrderByComparator<PetEntry> orderByComparator)
		throws NoSuchPetEntryException {

		name = Objects.toString(name, "");

		PetEntry petEntry = findByPrimaryKey(petId);

		Session session = null;

		try {
			session = openSession();

			PetEntry[] array = new PetEntryImpl[3];

			array[0] = getByC_N_PrevAndNext(
				session, petEntry, customerId, name, orderByComparator, true);

			array[1] = petEntry;

			array[2] = getByC_N_PrevAndNext(
				session, petEntry, customerId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PetEntry getByC_N_PrevAndNext(
		Session session, PetEntry petEntry, long customerId, String name,
		OrderByComparator<PetEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PETENTRY_WHERE);

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
			sb.append(PetEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(petEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PetEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pet entries where customerId = &#63; and name = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 */
	@Override
	public void removeByC_N(long customerId, String name) {
		for (PetEntry petEntry :
				findByC_N(
					customerId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries where customerId = &#63; and name = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param name the name
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByC_N(long customerId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByC_N;

		Object[] finderArgs = new Object[] {customerId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

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
		"petEntry.customerId = ? AND ";

	private static final String _FINDER_COLUMN_C_N_NAME_2 = "petEntry.name = ?";

	private static final String _FINDER_COLUMN_C_N_NAME_3 =
		"(petEntry.name IS NULL OR petEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	@Override
	public PetEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (petEntry == null) {
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

			throw new NoSuchPetEntryException(sb.toString());
		}

		return petEntry;
	}

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_ERC(long companyId, String externalReferenceCode) {
		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the pet entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public PetEntry fetchByC_ERC(
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

		if (result instanceof PetEntry) {
			PetEntry petEntry = (PetEntry)result;

			if ((companyId != petEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					petEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PETENTRY_WHERE);

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

				List<PetEntry> list = query.list();

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
								"PetEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PetEntry petEntry = list.get(0);

					result = petEntry;

					cacheResult(petEntry);
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
			return (PetEntry)result;
		}
	}

	/**
	 * Removes the pet entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the pet entry that was removed
	 */
	@Override
	public PetEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPetEntryException {

		PetEntry petEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(petEntry);
	}

	/**
	 * Returns the number of pet entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching pet entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PETENTRY_WHERE);

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
		"petEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"petEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(petEntry.externalReferenceCode IS NULL OR petEntry.externalReferenceCode = '')";

	public PetEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PetEntry.class);

		setModelImplClass(PetEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PetEntryTable.INSTANCE);
	}

	/**
	 * Caches the pet entry in the entity cache if it is enabled.
	 *
	 * @param petEntry the pet entry
	 */
	@Override
	public void cacheResult(PetEntry petEntry) {
		entityCache.putResult(
			PetEntryImpl.class, petEntry.getPrimaryKey(), petEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {petEntry.getUuid(), petEntry.getGroupId()}, petEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				petEntry.getCompanyId(), petEntry.getExternalReferenceCode()
			},
			petEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pet entries in the entity cache if it is enabled.
	 *
	 * @param petEntries the pet entries
	 */
	@Override
	public void cacheResult(List<PetEntry> petEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (petEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PetEntry petEntry : petEntries) {
			if (entityCache.getResult(
					PetEntryImpl.class, petEntry.getPrimaryKey()) == null) {

				cacheResult(petEntry);
			}
		}
	}

	/**
	 * Clears the cache for all pet entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetEntryImpl.class);

		finderCache.clearCache(PetEntryImpl.class);
	}

	/**
	 * Clears the cache for the pet entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PetEntry petEntry) {
		entityCache.removeResult(PetEntryImpl.class, petEntry);
	}

	@Override
	public void clearCache(List<PetEntry> petEntries) {
		for (PetEntry petEntry : petEntries) {
			entityCache.removeResult(PetEntryImpl.class, petEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PetEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PetEntryModelImpl petEntryModelImpl) {

		Object[] args = new Object[] {
			petEntryModelImpl.getUuid(), petEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, petEntryModelImpl);

		args = new Object[] {
			petEntryModelImpl.getCompanyId(),
			petEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByC_ERC, args, petEntryModelImpl);
	}

	/**
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	@Override
	public PetEntry create(long petId) {
		PetEntry petEntry = new PetEntryImpl();

		petEntry.setNew(true);
		petEntry.setPrimaryKey(petId);

		String uuid = PortalUUIDUtil.generate();

		petEntry.setUuid(uuid);

		petEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return petEntry;
	}

	/**
	 * Removes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry remove(long petId) throws NoSuchPetEntryException {
		return remove((Serializable)petId);
	}

	/**
	 * Removes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry remove(Serializable primaryKey)
		throws NoSuchPetEntryException {

		Session session = null;

		try {
			session = openSession();

			PetEntry petEntry = (PetEntry)session.get(
				PetEntryImpl.class, primaryKey);

			if (petEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(petEntry);
		}
		catch (NoSuchPetEntryException noSuchEntityException) {
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
	protected PetEntry removeImpl(PetEntry petEntry) {
		petEntryToAnimalTagEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			petEntry.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(petEntry)) {
				petEntry = (PetEntry)session.get(
					PetEntryImpl.class, petEntry.getPrimaryKeyObj());
			}

			if (petEntry != null) {
				session.delete(petEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (petEntry != null) {
			clearCache(petEntry);
		}

		return petEntry;
	}

	@Override
	public PetEntry updateImpl(PetEntry petEntry) {
		boolean isNew = petEntry.isNew();

		if (!(petEntry instanceof PetEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(petEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(petEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in petEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PetEntry implementation " +
					petEntry.getClass());
		}

		PetEntryModelImpl petEntryModelImpl = (PetEntryModelImpl)petEntry;

		if (Validator.isNull(petEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			petEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (petEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				petEntry.setCreateDate(date);
			}
			else {
				petEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!petEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				petEntry.setModifiedDate(date);
			}
			else {
				petEntry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(petEntry);
			}
			else {
				petEntry = (PetEntry)session.merge(petEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PetEntryImpl.class, petEntryModelImpl, false, true);

		cacheUniqueFindersCache(petEntryModelImpl);

		if (isNew) {
			petEntry.setNew(false);
		}

		petEntry.resetOriginalValues();

		return petEntry;
	}

	/**
	 * Returns the pet entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet entry
	 * @return the pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetEntryException {

		PetEntry petEntry = fetchByPrimaryKey(primaryKey);

		if (petEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return petEntry;
	}

	/**
	 * Returns the pet entry with the primary key or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry findByPrimaryKey(long petId)
		throws NoSuchPetEntryException {

		return findByPrimaryKey((Serializable)petId);
	}

	/**
	 * Returns the pet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry, or <code>null</code> if a pet entry with the primary key could not be found
	 */
	@Override
	public PetEntry fetchByPrimaryKey(long petId) {
		return fetchByPrimaryKey((Serializable)petId);
	}

	/**
	 * Returns all the pet entries.
	 *
	 * @return the pet entries
	 */
	@Override
	public List<PetEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PetEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PetEntry> findAll(
		int start, int end, OrderByComparator<PetEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<PetEntry> findAll(
		int start, int end, OrderByComparator<PetEntry> orderByComparator,
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

		List<PetEntry> list = null;

		if (useFinderCache) {
			list = (List<PetEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PETENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PETENTRY;

				sql = sql.concat(PetEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PetEntry>)QueryUtil.list(
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
	 * Removes all the pet entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PetEntry petEntry : findAll()) {
			remove(petEntry);
		}
	}

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PETENTRY);

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
	 * Returns the primaryKeys of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return long[] of the primaryKeys of animal tag entries associated with the pet entry
	 */
	@Override
	public long[] getAnimalTagEntryPrimaryKeys(long pk) {
		long[] pks = petEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.clone();
	}

	/**
	 * Returns all the pet entry associated with the animal tag entry.
	 *
	 * @param pk the primary key of the animal tag entry
	 * @return the pet entries associated with the animal tag entry
	 */
	@Override
	public List<PetEntry> getAnimalTagEntryPetEntries(long pk) {
		return getAnimalTagEntryPetEntries(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end) {

		return getAnimalTagEntryPetEntries(pk, start, end, null);
	}

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
	@Override
	public List<PetEntry> getAnimalTagEntryPetEntries(
		long pk, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return petEntryToAnimalTagEntryTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of animal tag entries associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @return the number of animal tag entries associated with the pet entry
	 */
	@Override
	public int getAnimalTagEntriesSize(long pk) {
		long[] pks = petEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the animal tag entry is associated with the pet entry.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 * @return <code>true</code> if the animal tag entry is associated with the pet entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAnimalTagEntry(long pk, long animalTagEntryPK) {
		return petEntryToAnimalTagEntryTableMapper.containsTableMapping(
			pk, animalTagEntryPK);
	}

	/**
	 * Returns <code>true</code> if the pet entry has any animal tag entries associated with it.
	 *
	 * @param pk the primary key of the pet entry to check for associations with animal tag entries
	 * @return <code>true</code> if the pet entry has any animal tag entries associated with it; <code>false</code> otherwise
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
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	@Override
	public void addAnimalTagEntry(long pk, long animalTagEntryPK) {
		PetEntry petEntry = fetchByPrimaryKey(pk);

		if (petEntry == null) {
			petEntryToAnimalTagEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, animalTagEntryPK);
		}
		else {
			petEntryToAnimalTagEntryTableMapper.addTableMapping(
				petEntry.getCompanyId(), pk, animalTagEntryPK);
		}
	}

	/**
	 * Adds an association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	@Override
	public void addAnimalTagEntry(long pk, AnimalTagEntry animalTagEntry) {
		PetEntry petEntry = fetchByPrimaryKey(pk);

		if (petEntry == null) {
			petEntryToAnimalTagEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				animalTagEntry.getPrimaryKey());
		}
		else {
			petEntryToAnimalTagEntryTableMapper.addTableMapping(
				petEntry.getCompanyId(), pk, animalTagEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	@Override
	public void addAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		long companyId = 0;

		PetEntry petEntry = fetchByPrimaryKey(pk);

		if (petEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = petEntry.getCompanyId();
		}

		petEntryToAnimalTagEntryTableMapper.addTableMappings(
			companyId, pk, animalTagEntryPKs);
	}

	/**
	 * Adds an association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
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
	 * Clears all associations between the pet entry and its animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry to clear the associated animal tag entries from
	 */
	@Override
	public void clearAnimalTagEntries(long pk) {
		petEntryToAnimalTagEntryTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPK the primary key of the animal tag entry
	 */
	@Override
	public void removeAnimalTagEntry(long pk, long animalTagEntryPK) {
		petEntryToAnimalTagEntryTableMapper.deleteTableMapping(
			pk, animalTagEntryPK);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntry the animal tag entry
	 */
	@Override
	public void removeAnimalTagEntry(long pk, AnimalTagEntry animalTagEntry) {
		petEntryToAnimalTagEntryTableMapper.deleteTableMapping(
			pk, animalTagEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries
	 */
	@Override
	public void removeAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		petEntryToAnimalTagEntryTableMapper.deleteTableMappings(
			pk, animalTagEntryPKs);
	}

	/**
	 * Removes the association between the pet entry and the animal tag entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
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
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntryPKs the primary keys of the animal tag entries to be associated with the pet entry
	 */
	@Override
	public void setAnimalTagEntries(long pk, long[] animalTagEntryPKs) {
		Set<Long> newAnimalTagEntryPKsSet = SetUtil.fromArray(
			animalTagEntryPKs);
		Set<Long> oldAnimalTagEntryPKsSet = SetUtil.fromArray(
			petEntryToAnimalTagEntryTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeAnimalTagEntryPKsSet = new HashSet<Long>(
			oldAnimalTagEntryPKsSet);

		removeAnimalTagEntryPKsSet.removeAll(newAnimalTagEntryPKsSet);

		petEntryToAnimalTagEntryTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeAnimalTagEntryPKsSet));

		newAnimalTagEntryPKsSet.removeAll(oldAnimalTagEntryPKsSet);

		long companyId = 0;

		PetEntry petEntry = fetchByPrimaryKey(pk);

		if (petEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = petEntry.getCompanyId();
		}

		petEntryToAnimalTagEntryTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newAnimalTagEntryPKsSet));
	}

	/**
	 * Sets the animal tag entries associated with the pet entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the pet entry
	 * @param animalTagEntries the animal tag entries to be associated with the pet entry
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
		return "petId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PETENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		petEntryToAnimalTagEntryTableMapper = TableMapperFactory.getTableMapper(
			"DG_Pets_AnimalTags#petId", "DG_Pets_AnimalTags", "companyId",
			"petId", "animalTagId", this, AnimalTagEntry.class);

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

		_finderPathWithPaginationFindByC_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_V",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"customerId", "vaccine"}, true);

		_finderPathWithoutPaginationFindByC_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_V",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "vaccine"}, true);

		_finderPathCountByC_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_V",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"customerId", "vaccine"}, false);

		_finderPathWithPaginationFindByA_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_G",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"animalGroupId"}, true);

		_finderPathWithoutPaginationFindByA_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_G",
			new String[] {Long.class.getName()}, new String[] {"animalGroupId"},
			true);

		_finderPathCountByA_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_G",
			new String[] {Long.class.getName()}, new String[] {"animalGroupId"},
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

		_setPetEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetEntryUtilPersistence(null);

		entityCache.removeCache(PetEntryImpl.class.getName());

		TableMapperFactory.removeTableMapper("DG_Pets_AnimalTags#petId");
	}

	private void _setPetEntryUtilPersistence(
		PetEntryPersistence petEntryPersistence) {

		try {
			Field field = PetEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, petEntryPersistence);
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

	protected TableMapper<PetEntry, AnimalTagEntry>
		petEntryToAnimalTagEntryTableMapper;

	private static final String _SQL_SELECT_PETENTRY =
		"SELECT petEntry FROM PetEntry petEntry";

	private static final String _SQL_SELECT_PETENTRY_WHERE =
		"SELECT petEntry FROM PetEntry petEntry WHERE ";

	private static final String _SQL_COUNT_PETENTRY =
		"SELECT COUNT(petEntry) FROM PetEntry petEntry";

	private static final String _SQL_COUNT_PETENTRY_WHERE =
		"SELECT COUNT(petEntry) FROM PetEntry petEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "petEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PetEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PetEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PetEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PetEntryModelArgumentsResolver _petEntryModelArgumentsResolver;

}