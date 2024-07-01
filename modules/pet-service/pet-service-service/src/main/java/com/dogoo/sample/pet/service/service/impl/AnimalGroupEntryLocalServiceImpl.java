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

import com.dogoo.sample.pet.service.mapper.model.AnimalGroupMapperModel;
import com.dogoo.sample.pet.service.model.AnimalGroupEntry;
import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.service.base.AnimalGroupEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author khoavu
 */
@Component(
	property = "model.class.name=com.dogoo.sample.pet.service.model.AnimalGroupEntry",
	service = AopService.class
)
public class AnimalGroupEntryLocalServiceImpl
	extends AnimalGroupEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public AnimalGroupEntry addAnimalGroup(long customerId,
										   long creatorId,
										   AnimalGroupMapperModel animalGroupMapperModel,
										   ServiceContext serviceContext) {

		AnimalGroupEntry groupEntry =
				createAnimalGroupEntry(counterLocalService.increment(AnimalGroupEntry.class.getName()));

		Date currentDate = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				groupEntry,
				currentDate,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		updateAnimalGroupData(groupEntry, animalGroupMapperModel);

		groupEntry.setExternalReferenceCode(UUID.randomUUID().toString());

		return addAnimalGroupEntry(groupEntry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public AnimalGroupEntry updateAnimalGroup(long creatorId,
											  long animalGroupId,
											  AnimalGroupMapperModel animalGroupMapperModel,
											  ServiceContext serviceContext) throws PortalException {

		AnimalGroupEntry groupEntry =
				getAnimalGroupEntry(animalGroupId);

		Date currentDate = new Date();

		updateModifierAudit(
				creatorId,
				groupEntry,
				currentDate,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		updateAnimalGroupData(groupEntry, animalGroupMapperModel);

		return updateAnimalGroupEntry(groupEntry);
	}

	public int countAnimalGroupByName(long customerId,
									  String name) {

		return animalGroupEntryPersistence.countByC_N(customerId, name);
	}

	public List<AnimalGroupEntry> findAnimalGroupByName(long customerId,
														 String name) {

		return animalGroupEntryPersistence.findByC_N(customerId, name);
	}

	private void updateAnimalGroupData(AnimalGroupEntry animalGroupEntry,
									   AnimalGroupMapperModel animalGroupMapperModel){

		animalGroupEntry.setName(animalGroupMapperModel.getName());
		animalGroupEntry.setDescription(animalGroupMapperModel.getDescription());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 AnimalGroupEntry entry,
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
									 AnimalGroupEntry entry,
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