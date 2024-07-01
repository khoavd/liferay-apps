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

package com.dogoo.sample.pet.service.service;

import com.dogoo.sample.pet.service.mapper.model.DogMapperModel;
import com.dogoo.sample.pet.service.model.DogEntry;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DogEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoavu
 * @see DogEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DogEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.dogoo.sample.pet.service.service.impl.DogEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dog entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DogEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries);

	public void addAnimalTagEntryDogEntries(long animalTagId, long[] dogIds);

	public void addAnimalTagEntryDogEntry(long animalTagId, DogEntry dogEntry);

	public void addAnimalTagEntryDogEntry(long animalTagId, long dogId);

	/**
	 * Adds the dog entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DogEntry addDogEntry(DogEntry dogEntry);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DogEntry addDogEntry(
		long customerId, long creatorId, DogMapperModel dogMapperModel,
		ServiceContext context);

	@Indexable(type = IndexableType.REINDEX)
	public DogEntry approvalDogEntry(
			long creatorId, long entryId, String status, ServiceContext context)
		throws PortalException;

	public void clearAnimalTagEntryDogEntries(long animalTagId);

	public int countByName(long customerId, String name);

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	@Transactional(enabled = false)
	public DogEntry createDogEntry(long dogId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries);

	public void deleteAnimalTagEntryDogEntries(long animalTagId, long[] dogIds);

	public void deleteAnimalTagEntryDogEntry(
		long animalTagId, DogEntry dogEntry);

	public void deleteAnimalTagEntryDogEntry(long animalTagId, long dogId);

	/**
	 * Deletes the dog entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DogEntry deleteDogEntry(DogEntry dogEntry);

	/**
	 * Deletes the dog entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry that was removed
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DogEntry deleteDogEntry(long dogId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry fetchDogEntry(long dogId);

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry fetchDogEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDogEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry fetchDogEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry fetchDogEntryByUuidAndGroupId(String uuid, long groupId);

	public List<DogEntry> findByName(long customerId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getAnimalTagEntryDogEntries(long animalTagId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnimalTagEntryDogEntriesCount(long animalTagId);

	/**
	 * Returns the animalTagIds of the animal tag entries associated with the dog entry.
	 *
	 * @param dogId the dogId of the dog entry
	 * @return long[] the animalTagIds of animal tag entries associated with the dog entry
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAnimalTagEntryPrimaryKeys(long dogId);

	/**
	 * Returns a range of all the dog entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.DogEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @return the range of dog entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getDogEntries(int start, int end);

	/**
	 * Returns all the dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @return the matching dog entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dog entries
	 * @param end the upper bound of the range of dog entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dog entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator);

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDogEntriesCount();

	/**
	 * Returns the dog entry with the primary key.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry getDogEntry(long dogId) throws PortalException;

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry getDogEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DogEntry getDogEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAnimalTagEntryDogEntries(long animalTagId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAnimalTagEntryDogEntry(long animalTagId, long dogId);

	public void setAnimalTagEntryDogEntries(long animalTagId, long[] dogIds);

	/**
	 * Updates the dog entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DogEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dogEntry the dog entry
	 * @return the dog entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DogEntry updateDogEntry(DogEntry dogEntry);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public DogEntry updateDogEntry(
			long customerId, long entryId, long creatorId,
			DogMapperModel dogMapperModel, ServiceContext context)
		throws PortalException;

}