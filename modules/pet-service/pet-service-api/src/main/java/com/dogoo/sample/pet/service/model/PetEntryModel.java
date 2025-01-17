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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PetEntry service. Represents a row in the &quot;DG_PETENTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.sample.pet.service.model.impl.PetEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.sample.pet.service.model.impl.PetEntryImpl</code>.
 * </p>
 *
 * @author khoavu
 * @see PetEntry
 * @generated
 */
@ProviderType
public interface PetEntryModel
	extends BaseModel<PetEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pet entry model instance should use the {@link PetEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this pet entry.
	 *
	 * @return the primary key of this pet entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pet entry.
	 *
	 * @param primaryKey the primary key of this pet entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this pet entry.
	 *
	 * @return the uuid of this pet entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this pet entry.
	 *
	 * @param uuid the uuid of this pet entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this pet entry.
	 *
	 * @return the external reference code of this pet entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this pet entry.
	 *
	 * @param externalReferenceCode the external reference code of this pet entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the pet ID of this pet entry.
	 *
	 * @return the pet ID of this pet entry
	 */
	public long getPetId();

	/**
	 * Sets the pet ID of this pet entry.
	 *
	 * @param petId the pet ID of this pet entry
	 */
	public void setPetId(long petId);

	/**
	 * Returns the group ID of this pet entry.
	 *
	 * @return the group ID of this pet entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this pet entry.
	 *
	 * @param groupId the group ID of this pet entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this pet entry.
	 *
	 * @return the company ID of this pet entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pet entry.
	 *
	 * @param companyId the company ID of this pet entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this pet entry.
	 *
	 * @return the user ID of this pet entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this pet entry.
	 *
	 * @param userId the user ID of this pet entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this pet entry.
	 *
	 * @return the user uuid of this pet entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this pet entry.
	 *
	 * @param userUuid the user uuid of this pet entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this pet entry.
	 *
	 * @return the user name of this pet entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this pet entry.
	 *
	 * @param userName the user name of this pet entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this pet entry.
	 *
	 * @return the create date of this pet entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this pet entry.
	 *
	 * @param createDate the create date of this pet entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this pet entry.
	 *
	 * @return the modified date of this pet entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pet entry.
	 *
	 * @param modifiedDate the modified date of this pet entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the creator ID of this pet entry.
	 *
	 * @return the creator ID of this pet entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this pet entry.
	 *
	 * @param creatorId the creator ID of this pet entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the customer ID of this pet entry.
	 *
	 * @return the customer ID of this pet entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this pet entry.
	 *
	 * @param customerId the customer ID of this pet entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the name of this pet entry.
	 *
	 * @return the name of this pet entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this pet entry.
	 *
	 * @param name the name of this pet entry
	 */
	public void setName(String name);

	/**
	 * Returns the description of this pet entry.
	 *
	 * @return the description of this pet entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this pet entry.
	 *
	 * @param description the description of this pet entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the brief of this pet entry.
	 *
	 * @return the brief of this pet entry
	 */
	@AutoEscape
	public String getBrief();

	/**
	 * Sets the brief of this pet entry.
	 *
	 * @param brief the brief of this pet entry
	 */
	public void setBrief(String brief);

	/**
	 * Returns the gender of this pet entry.
	 *
	 * @return the gender of this pet entry
	 */
	public int getGender();

	/**
	 * Sets the gender of this pet entry.
	 *
	 * @param gender the gender of this pet entry
	 */
	public void setGender(int gender);

	/**
	 * Returns the vaccine of this pet entry.
	 *
	 * @return the vaccine of this pet entry
	 */
	public boolean getVaccine();

	/**
	 * Returns <code>true</code> if this pet entry is vaccine.
	 *
	 * @return <code>true</code> if this pet entry is vaccine; <code>false</code> otherwise
	 */
	public boolean isVaccine();

	/**
	 * Sets whether this pet entry is vaccine.
	 *
	 * @param vaccine the vaccine of this pet entry
	 */
	public void setVaccine(boolean vaccine);

	/**
	 * Returns the weight of this pet entry.
	 *
	 * @return the weight of this pet entry
	 */
	public double getWeight();

	/**
	 * Sets the weight of this pet entry.
	 *
	 * @param weight the weight of this pet entry
	 */
	public void setWeight(double weight);

	/**
	 * Returns the birth of date of this pet entry.
	 *
	 * @return the birth of date of this pet entry
	 */
	public Date getBirthOfDate();

	/**
	 * Sets the birth of date of this pet entry.
	 *
	 * @param birthOfDate the birth of date of this pet entry
	 */
	public void setBirthOfDate(Date birthOfDate);

	/**
	 * Returns the status of this pet entry.
	 *
	 * @return the status of this pet entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this pet entry.
	 *
	 * @param status the status of this pet entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the status date of this pet entry.
	 *
	 * @return the status date of this pet entry
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this pet entry.
	 *
	 * @param statusDate the status date of this pet entry
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the animal group ID of this pet entry.
	 *
	 * @return the animal group ID of this pet entry
	 */
	public long getAnimalGroupId();

	/**
	 * Sets the animal group ID of this pet entry.
	 *
	 * @param animalGroupId the animal group ID of this pet entry
	 */
	public void setAnimalGroupId(long animalGroupId);

	@Override
	public PetEntry cloneWithOriginalValues();

}