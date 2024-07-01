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

import com.dogoo.sample.pet.service.model.AnimalTagEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnimalTagEntry in entity cache.
 *
 * @author khoavu
 * @generated
 */
public class AnimalTagEntryCacheModel
	implements CacheModel<AnimalTagEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnimalTagEntryCacheModel)) {
			return false;
		}

		AnimalTagEntryCacheModel animalTagEntryCacheModel =
			(AnimalTagEntryCacheModel)object;

		if (animalTagId == animalTagEntryCacheModel.animalTagId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, animalTagId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", animalTagId=");
		sb.append(animalTagId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnimalTagEntry toEntityModel() {
		AnimalTagEntryImpl animalTagEntryImpl = new AnimalTagEntryImpl();

		if (uuid == null) {
			animalTagEntryImpl.setUuid("");
		}
		else {
			animalTagEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			animalTagEntryImpl.setExternalReferenceCode("");
		}
		else {
			animalTagEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		animalTagEntryImpl.setAnimalTagId(animalTagId);
		animalTagEntryImpl.setGroupId(groupId);
		animalTagEntryImpl.setCompanyId(companyId);
		animalTagEntryImpl.setUserId(userId);

		if (userName == null) {
			animalTagEntryImpl.setUserName("");
		}
		else {
			animalTagEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			animalTagEntryImpl.setCreateDate(null);
		}
		else {
			animalTagEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			animalTagEntryImpl.setModifiedDate(null);
		}
		else {
			animalTagEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		animalTagEntryImpl.setCreatorId(creatorId);
		animalTagEntryImpl.setCustomerId(customerId);

		if (name == null) {
			animalTagEntryImpl.setName("");
		}
		else {
			animalTagEntryImpl.setName(name);
		}

		if (description == null) {
			animalTagEntryImpl.setDescription("");
		}
		else {
			animalTagEntryImpl.setDescription(description);
		}

		if (status == null) {
			animalTagEntryImpl.setStatus("");
		}
		else {
			animalTagEntryImpl.setStatus(status);
		}

		if (statusDate == Long.MIN_VALUE) {
			animalTagEntryImpl.setStatusDate(null);
		}
		else {
			animalTagEntryImpl.setStatusDate(new Date(statusDate));
		}

		animalTagEntryImpl.resetOriginalValues();

		return animalTagEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		animalTagId = objectInput.readLong();

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
		status = objectInput.readUTF();
		statusDate = objectInput.readLong();
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

		objectOutput.writeLong(animalTagId);

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

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public String externalReferenceCode;
	public long animalTagId;
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
	public String status;
	public long statusDate;

}