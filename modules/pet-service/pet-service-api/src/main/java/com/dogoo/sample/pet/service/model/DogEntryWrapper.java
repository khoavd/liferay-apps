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

package com.dogoo.sample.pet.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DogEntry}.
 * </p>
 *
 * @author khoavu
 * @see DogEntry
 * @generated
 */
public class DogEntryWrapper
	extends BaseModelWrapper<DogEntry>
	implements DogEntry, ModelWrapper<DogEntry> {

	public DogEntryWrapper(DogEntry dogEntry) {
		super(dogEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("dogId", getDogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("weight", getWeight());
		attributes.put("color", getColor());
		attributes.put("status", getStatus());
		attributes.put("statusDate", getStatusDate());
		attributes.put("animalGroupId", getAnimalGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long dogId = (Long)attributes.get("dogId");

		if (dogId != null) {
			setDogId(dogId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long animalGroupId = (Long)attributes.get("animalGroupId");

		if (animalGroupId != null) {
			setAnimalGroupId(animalGroupId);
		}
	}

	@Override
	public DogEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the animal group ID of this dog entry.
	 *
	 * @return the animal group ID of this dog entry
	 */
	@Override
	public long getAnimalGroupId() {
		return model.getAnimalGroupId();
	}

	/**
	 * Returns the color of this dog entry.
	 *
	 * @return the color of this dog entry
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * Returns the company ID of this dog entry.
	 *
	 * @return the company ID of this dog entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dog entry.
	 *
	 * @return the create date of this dog entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this dog entry.
	 *
	 * @return the creator ID of this dog entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this dog entry.
	 *
	 * @return the customer ID of this dog entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the dog ID of this dog entry.
	 *
	 * @return the dog ID of this dog entry
	 */
	@Override
	public long getDogId() {
		return model.getDogId();
	}

	/**
	 * Returns the external reference code of this dog entry.
	 *
	 * @return the external reference code of this dog entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this dog entry.
	 *
	 * @return the group ID of this dog entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this dog entry.
	 *
	 * @return the modified date of this dog entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this dog entry.
	 *
	 * @return the name of this dog entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dog entry.
	 *
	 * @return the primary key of this dog entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dog entry.
	 *
	 * @return the status of this dog entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status date of this dog entry.
	 *
	 * @return the status date of this dog entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this dog entry.
	 *
	 * @return the title of this dog entry
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this dog entry.
	 *
	 * @return the user ID of this dog entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dog entry.
	 *
	 * @return the user name of this dog entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dog entry.
	 *
	 * @return the user uuid of this dog entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dog entry.
	 *
	 * @return the uuid of this dog entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the weight of this dog entry.
	 *
	 * @return the weight of this dog entry
	 */
	@Override
	public double getWeight() {
		return model.getWeight();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the animal group ID of this dog entry.
	 *
	 * @param animalGroupId the animal group ID of this dog entry
	 */
	@Override
	public void setAnimalGroupId(long animalGroupId) {
		model.setAnimalGroupId(animalGroupId);
	}

	/**
	 * Sets the color of this dog entry.
	 *
	 * @param color the color of this dog entry
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the company ID of this dog entry.
	 *
	 * @param companyId the company ID of this dog entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dog entry.
	 *
	 * @param createDate the create date of this dog entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this dog entry.
	 *
	 * @param creatorId the creator ID of this dog entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this dog entry.
	 *
	 * @param customerId the customer ID of this dog entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the dog ID of this dog entry.
	 *
	 * @param dogId the dog ID of this dog entry
	 */
	@Override
	public void setDogId(long dogId) {
		model.setDogId(dogId);
	}

	/**
	 * Sets the external reference code of this dog entry.
	 *
	 * @param externalReferenceCode the external reference code of this dog entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this dog entry.
	 *
	 * @param groupId the group ID of this dog entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this dog entry.
	 *
	 * @param modifiedDate the modified date of this dog entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this dog entry.
	 *
	 * @param name the name of this dog entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dog entry.
	 *
	 * @param primaryKey the primary key of this dog entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dog entry.
	 *
	 * @param status the status of this dog entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status date of this dog entry.
	 *
	 * @param statusDate the status date of this dog entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this dog entry.
	 *
	 * @param title the title of this dog entry
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this dog entry.
	 *
	 * @param userId the user ID of this dog entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dog entry.
	 *
	 * @param userName the user name of this dog entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dog entry.
	 *
	 * @param userUuid the user uuid of this dog entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dog entry.
	 *
	 * @param uuid the uuid of this dog entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the weight of this dog entry.
	 *
	 * @param weight the weight of this dog entry
	 */
	@Override
	public void setWeight(double weight) {
		model.setWeight(weight);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DogEntryWrapper wrap(DogEntry dogEntry) {
		return new DogEntryWrapper(dogEntry);
	}

}