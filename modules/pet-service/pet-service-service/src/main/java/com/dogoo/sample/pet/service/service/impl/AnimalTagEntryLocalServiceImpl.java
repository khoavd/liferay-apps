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

import com.dogoo.sample.pet.service.mapper.model.AnimalTagMapperModel;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.base.AnimalTagEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.*;

/**
 * @author khoavu
 */
@Component(
	property = "model.class.name=com.dogoo.sample.pet.service.model.AnimalTagEntry",
	service = AopService.class
)
public class AnimalTagEntryLocalServiceImpl
	extends AnimalTagEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry addAnimalTag(long customerId,
									   long creatorId,
									   AnimalTagMapperModel animalTagMapperModel,
									   ServiceContext context) {

		AnimalTagEntry entry =
				createAnimalTagEntry(counterLocalService.increment(AnimalTagEntry.class.getName()));

		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		updateAnimalTagData(entry, animalTagMapperModel);

		entry.setExternalReferenceCode(UUID.randomUUID().toString());
		entry.setStatus(animalTagMapperModel.getStatus());
		entry.setStatusDate(currentDate);

		return addAnimalTagEntry(entry);
	}

	public List<AnimalTagEntry> addAnimalTags(long customerId,
											  long creatorId,
											  String[] names,
											  ServiceContext context){

		List<AnimalTagEntry> animalTagEntries = new ArrayList<>();

		Arrays.stream(names).forEach(name -> {
			AnimalTagMapperModel animalTagMapperModel = new AnimalTagMapperModel();
			animalTagMapperModel.setName(name);
			animalTagMapperModel.setDesc("");
			animalTagMapperModel.setStatus("pending");

			animalTagEntries.add(addAnimalTag(
					customerId,
					creatorId,
					animalTagMapperModel,
					context));
		});

		return animalTagEntries;
	}

	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry updateAnimalTag(long creatorId,
										  long tagId,
										  AnimalTagMapperModel animalTagMapperModel,
										  ServiceContext context) throws PortalException {

		AnimalTagEntry entry = getAnimalTagEntry(tagId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		updateAnimalTagData(entry, animalTagMapperModel);

		return updateAnimalTagEntry(entry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public AnimalTagEntry approvalAnimalTag(long creatorId,
											long tagId,
											String status,
											ServiceContext context) throws PortalException {

		AnimalTagEntry entry = getAnimalTagEntry(tagId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				entry,
				currentDate,
				userLocalService.fetchUser(context.getUserId()),
				context);

		entry.setStatus(status);
		entry.setStatusDate(currentDate);

		return updateAnimalTagEntry(entry);
	}

	public int countAnimalTagByName(long customerId,
									String name) {

		return animalTagEntryPersistence.countByC_N(customerId, name);
	}

	public List<AnimalTagEntry> findAnimalTagByName(long customerId,
													String name) {

		return animalTagEntryPersistence.findByC_N(customerId, name);
	}

	private void updateAnimalTagData(AnimalTagEntry animalTagEntry,
								AnimalTagMapperModel animalTagMapperModel){

		animalTagEntry.setName(animalTagMapperModel.getName());
		animalTagEntry.setDescription(animalTagMapperModel.getDesc());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 AnimalTagEntry entry,
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
									 AnimalTagEntry entry,
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

}