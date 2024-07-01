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

package com.dogoo.sample.pet.service.service.impl;

import com.dogoo.sample.pet.service.mapper.model.DogMapperModel;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.DogEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.dogoo.sample.pet.service.service.base.DogEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author khoavu
 */
@Component(
	property = "model.class.name=com.dogoo.sample.pet.service.model.DogEntry",
	service = AopService.class
)
public class DogEntryLocalServiceImpl extends DogEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public DogEntry addDogEntry(long customerId,
								long creatorId,
								DogMapperModel dogMapperModel,
								ServiceContext context){
		DogEntry entry =
				createDogEntry(counterLocalService.increment(DogEntry.class.getName()));

		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		entry.setExternalReferenceCode(UUID.randomUUID().toString());
		entry.setStatus(dogMapperModel.getStatus());
		entry.setStatusDate(currentDate);

		updateDogData(entry, dogMapperModel);

		List<AnimalTagEntry> animalTagEntries =
				_animalTagEntryLocalService
						.addAnimalTags(
								customerId,
								creatorId,
								dogMapperModel.getAnimalTags(),
								context);

		_animalTagEntryLocalService.addDogEntryAnimalTagEntries(entry.getDogId(), animalTagEntries);

		return addDogEntry(entry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public DogEntry updateDogEntry(long customerId,
								   long entryId,
								   long creatorId,
								   DogMapperModel dogMapperModel,
								   ServiceContext context) throws PortalException {

		DogEntry entry = getDogEntry(entryId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		updateDogData(entry, dogMapperModel);

		List<AnimalTagEntry> animalTagEntries =
				_animalTagEntryLocalService.getDogEntryAnimalTagEntries(entryId);

		_animalTagEntryLocalService.deleteDogEntryAnimalTagEntries(entryId, animalTagEntries);

		List<AnimalTagEntry> newAnimalTagEntries =
				_animalTagEntryLocalService
						.addAnimalTags(
								customerId,
								creatorId,
								dogMapperModel.getAnimalTags(),
								context);

		_animalTagEntryLocalService.addDogEntryAnimalTagEntries(entry.getDogId(), newAnimalTagEntries);

		return updateDogEntry(entry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public DogEntry approvalDogEntry(long creatorId,
									 long entryId,
									 String status,
									 ServiceContext context) throws PortalException {

		DogEntry entry = getDogEntry(entryId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		entry.setStatus(status);
		entry.setStatusDate(currentDate);

		return updateDogEntry(entry);
	}

	public int countByName(long customerId,
						   String name){

		return dogEntryPersistence.countByC_N(customerId, name);
	}

	public List<DogEntry> findByName(long customerId,
									 String name){

		return dogEntryPersistence.findByC_N(customerId, name);
	}

	private void updateDogData(DogEntry dogEntry, DogMapperModel dogMapperModel){

		dogEntry.setName(dogMapperModel.getName());
		dogEntry.setTitle(dogMapperModel.getTitle());
		dogEntry.setWeight(dogMapperModel.getWeight());
		dogEntry.setColor(dogMapperModel.getColor());
		dogEntry.setAnimalGroupId(dogMapperModel.getAnimalGroupId());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 DogEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		entry.setCustomerId(customerId);
		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));

		updateModifierAudit(creatorId, entry, current, user, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 DogEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		if (user != null) {
			entry.setUserName(user.getFullName());
			entry.setUserUuid(user.getUserUuid());
		}

		entry.setModifiedDate(serviceContext.getModifiedDate(current));
		entry.setUserId(serviceContext.getUserId());
		entry.setCreatorId(creatorId);
	}

	@Reference
	private AnimalTagEntryLocalService _animalTagEntryLocalService;
}