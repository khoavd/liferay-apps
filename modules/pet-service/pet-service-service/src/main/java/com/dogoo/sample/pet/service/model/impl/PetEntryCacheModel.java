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

package com.dogoo.sample.pet.service.model.impl;

import com.dogoo.sample.pet.service.model.PetEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetEntry in entity cache.
 *
 * @author khoavu
 * @generated
 */
public class PetEntryCacheModel
	implements CacheModel<PetEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetEntryCacheModel)) {
			return false;
		}

		PetEntryCacheModel petEntryCacheModel = (PetEntryCacheModel)object;

		if (petId == petEntryCacheModel.petId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", petId=");
		sb.append(petId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", brief=");
		sb.append(brief);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", vaccine=");
		sb.append(vaccine);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", birthOfDate=");
		sb.append(birthOfDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", animalGroupId=");
		sb.append(animalGroupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PetEntry toEntityModel() {
		PetEntryImpl petEntryImpl = new PetEntryImpl();

		if (uuid == null) {
			petEntryImpl.setUuid("");
		}
		else {
			petEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			petEntryImpl.setExternalReferenceCode("");
		}
		else {
			petEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		petEntryImpl.setPetId(petId);
		petEntryImpl.setGroupId(groupId);
		petEntryImpl.setCompanyId(companyId);
		petEntryImpl.setUserId(userId);

		if (userName == null) {
			petEntryImpl.setUserName("");
		}
		else {
			petEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petEntryImpl.setCreateDate(null);
		}
		else {
			petEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petEntryImpl.setModifiedDate(null);
		}
		else {
			petEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		petEntryImpl.setCreatorId(creatorId);
		petEntryImpl.setCustomerId(customerId);

		if (name == null) {
			petEntryImpl.setName("");
		}
		else {
			petEntryImpl.setName(name);
		}

		if (description == null) {
			petEntryImpl.setDescription("");
		}
		else {
			petEntryImpl.setDescription(description);
		}

		if (brief == null) {
			petEntryImpl.setBrief("");
		}
		else {
			petEntryImpl.setBrief(brief);
		}

		petEntryImpl.setGender(gender);
		petEntryImpl.setVaccine(vaccine);
		petEntryImpl.setWeight(weight);

		if (birthOfDate == Long.MIN_VALUE) {
			petEntryImpl.setBirthOfDate(null);
		}
		else {
			petEntryImpl.setBirthOfDate(new Date(birthOfDate));
		}

		if (status == null) {
			petEntryImpl.setStatus("");
		}
		else {
			petEntryImpl.setStatus(status);
		}

		if (statusDate == Long.MIN_VALUE) {
			petEntryImpl.setStatusDate(null);
		}
		else {
			petEntryImpl.setStatusDate(new Date(statusDate));
		}

		petEntryImpl.setAnimalGroupId(animalGroupId);

		petEntryImpl.resetOriginalValues();

		return petEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		petId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		brief = objectInput.readUTF();

		gender = objectInput.readInt();

		vaccine = objectInput.readBoolean();

		weight = objectInput.readDouble();
		birthOfDate = objectInput.readLong();
		status = objectInput.readUTF();
		statusDate = objectInput.readLong();

		animalGroupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(petId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(customerId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (brief == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brief);
		}

		objectOutput.writeInt(gender);

		objectOutput.writeBoolean(vaccine);

		objectOutput.writeDouble(weight);
		objectOutput.writeLong(birthOfDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(animalGroupId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long petId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String name;
	public String description;
	public String brief;
	public int gender;
	public boolean vaccine;
	public double weight;
	public long birthOfDate;
	public String status;
	public long statusDate;
	public long animalGroupId;

}