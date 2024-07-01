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

import com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;

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

import java.util.*;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AnimalTagEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoavu
 * @see AnimalTagEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AnimalTagEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.dogoo.sample.pet.service.service.impl.AnimalTagEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the animal tag entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AnimalTagEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry addAnimalTag(
		long customerId, long creatorId,
		AnimalTagMapperModel animalTagMapperModel, ServiceContext context);

	/**
	 * Adds the animal tag entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry addAnimalTagEntry(AnimalTagEntry animalTagEntry);

	public List<AnimalTagEntry> addAnimalTags(
		long customerId, long creatorId, String[] names,
		ServiceContext context);

	public void addDogEntryAnimalTagEntries(
		long dogId, List<AnimalTagEntry> animalTagEntries);

	public void addDogEntryAnimalTagEntries(long dogId, long[] animalTagIds);

	public void addDogEntryAnimalTagEntry(
		long dogId, AnimalTagEntry animalTagEntry);

	public void addDogEntryAnimalTagEntry(long dogId, long animalTagId);

	public void addPetEntryAnimalTagEntries(
		long petId, List<AnimalTagEntry> animalTagEntries);

	public void addPetEntryAnimalTagEntries(long petId, long[] animalTagIds);

	public void addPetEntryAnimalTagEntry(
		long petId, AnimalTagEntry animalTagEntry);

	public void addPetEntryAnimalTagEntry(long petId, long animalTagId);

	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry approvalAnimalTag(
			long creatorId, long tagId, String status, ServiceContext context)
		throws PortalException;

	public void clearDogEntryAnimalTagEntries(long dogId);

	public void clearPetEntryAnimalTagEntries(long petId);

	public int countAnimalTagByName(long customerId, String name);

	/**
	 * Creates a new animal tag entry with the primary key. Does not add the animal tag entry to the database.
	 *
	 * @param animalTagId the primary key for the new animal tag entry
	 * @return the new animal tag entry
	 */
	@Transactional(enabled = false)
	public AnimalTagEntry createAnimalTagEntry(long animalTagId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the animal tag entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AnimalTagEntry deleteAnimalTagEntry(AnimalTagEntry animalTagEntry);

	/**
	 * Deletes the animal tag entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry that was removed
	 * @throws PortalException if a animal tag entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AnimalTagEntry deleteAnimalTagEntry(long animalTagId)
		throws PortalException;

	public void deleteDogEntryAnimalTagEntries(
		long dogId, List<AnimalTagEntry> animalTagEntries);

	public void deleteDogEntryAnimalTagEntries(long dogId, long[] animalTagIds);

	public void deleteDogEntryAnimalTagEntry(
		long dogId, AnimalTagEntry animalTagEntry);

	public void deleteDogEntryAnimalTagEntry(long dogId, long animalTagId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deletePetEntryAnimalTagEntries(
		long petId, List<AnimalTagEntry> animalTagEntries);

	public void deletePetEntryAnimalTagEntries(long petId, long[] animalTagIds);

	public void deletePetEntryAnimalTagEntry(
		long petId, AnimalTagEntry animalTagEntry);

	public void deletePetEntryAnimalTagEntry(long petId, long animalTagId);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
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
	public AnimalTagEntry fetchAnimalTagEntry(long animalTagId);

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry fetchAnimalTagEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAnimalTagEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry fetchAnimalTagEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the animal tag entry matching the UUID and group.
	 *
	 * @param uuid the animal tag entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal tag entry, or <code>null</code> if a matching animal tag entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry fetchAnimalTagEntryByUuidAndGroupId(
		String uuid, long groupId);

	public List<AnimalTagEntry> findAnimalTagByName(
		long customerId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns a range of all the animal tag entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.sample.pet.service.model.impl.AnimalTagEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @return the range of animal tag entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getAnimalTagEntries(int start, int end);

	/**
	 * Returns all the animal tag entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal tag entries
	 * @param companyId the primary key of the company
	 * @return the matching animal tag entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getAnimalTagEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of animal tag entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the animal tag entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of animal tag entries
	 * @param end the upper bound of the range of animal tag entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching animal tag entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getAnimalTagEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator);

	/**
	 * Returns the number of animal tag entries.
	 *
	 * @return the number of animal tag entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnimalTagEntriesCount();

	/**
	 * Returns the animal tag entry with the primary key.
	 *
	 * @param animalTagId the primary key of the animal tag entry
	 * @return the animal tag entry
	 * @throws PortalException if a animal tag entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry getAnimalTagEntry(long animalTagId)
		throws PortalException;

	/**
	 * Returns the animal tag entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the animal tag entry's external reference code
	 * @return the matching animal tag entry
	 * @throws PortalException if a matching animal tag entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry getAnimalTagEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the animal tag entry matching the UUID and group.
	 *
	 * @param uuid the animal tag entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching animal tag entry
	 * @throws PortalException if a matching animal tag entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnimalTagEntry getAnimalTagEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(long dogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long dogId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getDogEntryAnimalTagEntries(
		long dogId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDogEntryAnimalTagEntriesCount(long dogId);

	/**
	 * Returns the dogIds of the dog entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the dogIds of dog entries associated with the animal tag entry
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDogEntryPrimaryKeys(long animalTagId);

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
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(long petId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long petId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnimalTagEntry> getPetEntryAnimalTagEntries(
		long petId, int start, int end,
		OrderByComparator<AnimalTagEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPetEntryAnimalTagEntriesCount(long petId);

	/**
	 * Returns the petIds of the pet entries associated with the animal tag entry.
	 *
	 * @param animalTagId the animalTagId of the animal tag entry
	 * @return long[] the petIds of pet entries associated with the animal tag entry
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPetEntryPrimaryKeys(long animalTagId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDogEntryAnimalTagEntries(long dogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDogEntryAnimalTagEntry(long dogId, long animalTagId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPetEntryAnimalTagEntries(long petId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPetEntryAnimalTagEntry(long petId, long animalTagId);

	public void setDogEntryAnimalTagEntries(long dogId, long[] animalTagIds);

	public void setPetEntryAnimalTagEntries(long petId, long[] animalTagIds);

	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry updateAnimalTag(
			long creatorId, long tagId,
			AnimalTagMapperModel animalTagMapperModel, ServiceContext context)
		throws PortalException;

	/**
	 * Updates the animal tag entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnimalTagEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param animalTagEntry the animal tag entry
	 * @return the animal tag entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry updateAnimalTagEntry(AnimalTagEntry animalTagEntry);

}