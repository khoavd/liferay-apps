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

import com.dogoo.sample.pet.service.mapper.model.PetMapperModel;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.PetEntry;
import com.dogoo.sample.pet.service.service.AnimalTagEntryLocalService;
import com.dogoo.sample.pet.service.service.base.PetEntryLocalServiceBaseImpl;

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

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author khoavu
 */
@Component(
	property = "model.class.name=com.dogoo.sample.pet.service.model.PetEntry",
	service = AopService.class
)
public class PetEntryLocalServiceImpl extends PetEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public PetEntry addPetEntry(long customerId,
								long creatorId,
								PetMapperModel petMapperModel,
								ServiceContext context) {

		PetEntry entry =
				createPetEntry(counterLocalService.increment(PetEntry.class.getName()));

		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);
		
		updatePetData(entry, petMapperModel);
		entry.setStatus(petMapperModel.getStatus());
		entry.setStatusDate(currentDate);

		_animalTagEntryLocalService.addPetEntryAnimalTagEntries(entry.getPetId(), petMapperModel.getAnimalTags());

		return addPetEntry(entry);
	}

	public List<PetEntry> getByVaccine(long customerId,
									   boolean vaccine) {
		return petEntryPersistence.findByC_V(customerId, vaccine);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public PetEntry updatePetEntry(long creatorId,
								   long entryId,
								   PetMapperModel petMapperModel,
								   ServiceContext context) throws PortalException {

		PetEntry entry = getPetEntry(entryId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		updatePetData(entry, petMapperModel);

		List<AnimalTagEntry> animalTagEntries =
				_animalTagEntryLocalService.getPetEntryAnimalTagEntries(entryId);

		_animalTagEntryLocalService.deletePetEntryAnimalTagEntries(entryId, animalTagEntries);

		_animalTagEntryLocalService.addPetEntryAnimalTagEntries(entry.getPetId(), petMapperModel.getAnimalTags());

		return updatePetEntry(entry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public PetEntry approvalPetEntry(long creatorId,
								     long entryId,
								     String status,
								     ServiceContext context)
			throws PortalException {

		PetEntry entry = getPetEntry(entryId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		entry.setStatus(status);
		entry.setStatusDate(currentDate);

		return updatePetEntry(entry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public PetEntry changeAnimalGroup(long creatorId,
									  long entryId,
									  long animalGroupId,
									  ServiceContext context)
			throws PortalException {

		PetEntry entry = getPetEntry(entryId);

		Date currentDate = new Date();

		entry.setGroupId(animalGroupId);

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		return updatePetEntry(entry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public void changeAnimalGroupBatch(long creatorId,
									   long [] petIds,
									   long animalGroupId,
									   ServiceContext context)
			throws PortalException {

		for (long petId : petIds) {
			changeAnimalGroup(creatorId, petId, animalGroupId, context);
		}
	}

	@Indexable(type = IndexableType.REINDEX)
	public PetEntry removeAnimalGroup(long creatorId,
									  long entryId,
									  ServiceContext context)
			throws PortalException {

		PetEntry entry = getPetEntry(entryId);

		Date currentDate = new Date();

		entry.setGroupId(0l);

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		return updatePetEntry(entry);
	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public void removeAnimalGroupBatch(long creatorId,
									   long[] entryIds,
									   ServiceContext context)
			throws PortalException {

		for (long entryId : entryIds) {
			removeAnimalGroup(creatorId, entryId, context);
		}
	}

	public int countByName(long customerId,
							  String name) {

		return petEntryPersistence.countByC_N(customerId, name);
	}

	public List<PetEntry> findByName(long customerId,
									 String name) {

		return petEntryPersistence.findByC_N(customerId, name);
	}

	private void updatePetData(PetEntry petEntry,
							   PetMapperModel petMapperModel){

		petEntry.setName(petMapperModel.getName());
		petEntry.setDescription(petMapperModel.getDescription());
		petEntry.setBrief(petMapperModel.getBrief());
		petEntry.setWeight(petMapperModel.getWeight());
		petEntry.setGender(petMapperModel.getGender());
		petEntry.setVaccine(petMapperModel.isVaccine());
		petEntry.setBirthOfDate(petMapperModel.getBirthOfDate());
		petEntry.setAnimalGroupId(petMapperModel.getAnimalGroupId());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 PetEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		entry.setCustomerId(customerId);
		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));
		entry.setExternalReferenceCode(UUID.randomUUID().toString());

		updateModifierAudit(creatorId, entry, current, user, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 PetEntry entry,
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