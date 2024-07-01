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

package com.dogoo.sample.pet.service.service.base;

import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.DogEntryLocalService;
import com.dogoo.sample.pet.service.service.DogEntryLocalServiceUtil;
import com.dogoo.sample.pet.service.service.persistence.AnimalGroupEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.AnimalTagEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.DogEntryPersistence;
import com.dogoo.sample.pet.service.service.persistence.PetEntryPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the dog entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.sample.pet.service.service.impl.DogEntryLocalServiceImpl}.
 * </p>
 *
 * @author khoavu
 * @see com.dogoo.sample.pet.service.service.impl.DogEntryLocalServiceImpl
 * @generated
 */
public abstract class DogEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DogEntryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DogEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DogEntryLocalServiceUtil</code>.
	 */

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
	@Override
	public DogEntry addDogEntry(DogEntry dogEntry) {
		dogEntry.setNew(true);

		return dogEntryPersistence.update(dogEntry);
	}

	/**
	 * Creates a new dog entry with the primary key. Does not add the dog entry to the database.
	 *
	 * @param dogId the primary key for the new dog entry
	 * @return the new dog entry
	 */
	@Override
	@Transactional(enabled = false)
	public DogEntry createDogEntry(long dogId) {
		return dogEntryPersistence.create(dogId);
	}

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
	@Override
	public DogEntry deleteDogEntry(long dogId) throws PortalException {
		return dogEntryPersistence.remove(dogId);
	}

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
	@Override
	public DogEntry deleteDogEntry(DogEntry dogEntry) {
		return dogEntryPersistence.remove(dogEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dogEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DogEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dogEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dogEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dogEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dogEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return dogEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DogEntry fetchDogEntry(long dogId) {
		return dogEntryPersistence.fetchByPrimaryKey(dogId);
	}

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchDogEntryByUuidAndGroupId(String uuid, long groupId) {
		return dogEntryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry, or <code>null</code> if a matching dog entry could not be found
	 */
	@Override
	public DogEntry fetchDogEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return dogEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDogEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public DogEntry fetchDogEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchDogEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the dog entry's external reference code
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry getDogEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return dogEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the dog entry with the primary key.
	 *
	 * @param dogId the primary key of the dog entry
	 * @return the dog entry
	 * @throws PortalException if a dog entry with the primary key could not be found
	 */
	@Override
	public DogEntry getDogEntry(long dogId) throws PortalException {
		return dogEntryPersistence.findByPrimaryKey(dogId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dogEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DogEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dogId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dogEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DogEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("dogId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dogEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DogEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dogId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DogEntry>() {

				@Override
				public void performAction(DogEntry dogEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dogEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(DogEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dogEntryPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dogEntryLocalService.deleteDogEntry((DogEntry)persistedModel);
	}

	@Override
	public BasePersistence<DogEntry> getBasePersistence() {
		return dogEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dogEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the dog entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dog entries
	 * @param companyId the primary key of the company
	 * @return the matching dog entries, or an empty list if no matches were found
	 */
	@Override
	public List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return dogEntryPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<DogEntry> getDogEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return dogEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the dog entry matching the UUID and group.
	 *
	 * @param uuid the dog entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dog entry
	 * @throws PortalException if a matching dog entry could not be found
	 */
	@Override
	public DogEntry getDogEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return dogEntryPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<DogEntry> getDogEntries(int start, int end) {
		return dogEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dog entries.
	 *
	 * @return the number of dog entries
	 */
	@Override
	public int getDogEntriesCount() {
		return dogEntryPersistence.countAll();
	}

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
	@Override
	public DogEntry updateDogEntry(DogEntry dogEntry) {
		return dogEntryPersistence.update(dogEntry);
	}

	/**
	 */
	@Override
	public void addAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		animalTagEntryPersistence.addDogEntry(animalTagId, dogId);
	}

	/**
	 */
	@Override
	public void addAnimalTagEntryDogEntry(long animalTagId, DogEntry dogEntry) {
		animalTagEntryPersistence.addDogEntry(animalTagId, dogEntry);
	}

	/**
	 */
	@Override
	public void addAnimalTagEntryDogEntries(long animalTagId, long[] dogIds) {
		animalTagEntryPersistence.addDogEntries(animalTagId, dogIds);
	}

	/**
	 */
	@Override
	public void addAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries) {

		animalTagEntryPersistence.addDogEntries(animalTagId, dogEntries);
	}

	/**
	 */
	@Override
	public void clearAnimalTagEntryDogEntries(long animalTagId) {
		animalTagEntryPersistence.clearDogEntries(animalTagId);
	}

	/**
	 */
	@Override
	public void deleteAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		animalTagEntryPersistence.removeDogEntry(animalTagId, dogId);
	}

	/**
	 */
	@Override
	public void deleteAnimalTagEntryDogEntry(
		long animalTagId, DogEntry dogEntry) {

		animalTagEntryPersistence.removeDogEntry(animalTagId, dogEntry);
	}

	/**
	 */
	@Override
	public void deleteAnimalTagEntryDogEntries(
		long animalTagId, long[] dogIds) {

		animalTagEntryPersistence.removeDogEntries(animalTagId, dogIds);
	}

	/**
	 */
	@Override
	public void deleteAnimalTagEntryDogEntries(
		long animalTagId, List<DogEntry> dogEntries) {

		animalTagEntryPersistence.removeDogEntries(animalTagId, dogEntries);
	}

	/**
	 * Returns the animalTagIds of the animal tag entries associated with the dog entry.
	 *
	 * @param dogId the dogId of the dog entry
	 * @return long[] the animalTagIds of animal tag entries associated with the dog entry
	 */
	@Override
	public long[] getAnimalTagEntryPrimaryKeys(long dogId) {
		return dogEntryPersistence.getAnimalTagEntryPrimaryKeys(dogId);
	}

	/**
	 */
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(long animalTagId) {
		return dogEntryPersistence.getAnimalTagEntryDogEntries(animalTagId);
	}

	/**
	 */
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end) {

		return dogEntryPersistence.getAnimalTagEntryDogEntries(
			animalTagId, start, end);
	}

	/**
	 */
	@Override
	public List<DogEntry> getAnimalTagEntryDogEntries(
		long animalTagId, int start, int end,
		OrderByComparator<DogEntry> orderByComparator) {

		return dogEntryPersistence.getAnimalTagEntryDogEntries(
			animalTagId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getAnimalTagEntryDogEntriesCount(long animalTagId) {
		return animalTagEntryPersistence.getDogEntriesSize(animalTagId);
	}

	/**
	 */
	@Override
	public boolean hasAnimalTagEntryDogEntry(long animalTagId, long dogId) {
		return animalTagEntryPersistence.containsDogEntry(animalTagId, dogId);
	}

	/**
	 */
	@Override
	public boolean hasAnimalTagEntryDogEntries(long animalTagId) {
		return animalTagEntryPersistence.containsDogEntries(animalTagId);
	}

	/**
	 */
	@Override
	public void setAnimalTagEntryDogEntries(long animalTagId, long[] dogIds) {
		animalTagEntryPersistence.setDogEntries(animalTagId, dogIds);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DogEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dogEntryLocalService = (DogEntryLocalService)aopProxy;

		_setLocalServiceUtilService(dogEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DogEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DogEntry.class;
	}

	protected String getModelClassName() {
		return DogEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dogEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DogEntryLocalService dogEntryLocalService) {

		try {
			Field field = DogEntryLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, dogEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AnimalGroupEntryPersistence animalGroupEntryPersistence;

	@Reference
	protected AnimalTagEntryPersistence animalTagEntryPersistence;

	protected DogEntryLocalService dogEntryLocalService;

	@Reference
	protected DogEntryPersistence dogEntryPersistence;

	@Reference
	protected PetEntryPersistence petEntryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}