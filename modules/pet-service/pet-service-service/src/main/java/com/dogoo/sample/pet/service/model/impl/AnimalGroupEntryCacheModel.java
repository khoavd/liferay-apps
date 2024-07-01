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

import com.dogoo.sample.pet.service.model.AnimalGroupEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnimalGroupEntry in entity cache.
 *
 * @author khoavu
 * @generated
 */
public class AnimalGroupEntryCacheModel
	implements CacheModel<AnimalGroupEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnimalGroupEntryCacheModel)) {
			return false;
		}

		AnimalGroupEntryCacheModel animalGroupEntryCacheModel =
			(AnimalGroupEntryCacheModel)object;

		if (animalGroupId == animalGroupEntryCacheModel.animalGroupId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, animalGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", animalGroupId=");
		sb.append(animalGroupId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnimalGroupEntry toEntityModel() {
		AnimalGroupEntryImpl animalGroupEntryImpl = new AnimalGroupEntryImpl();

		if (uuid == null) {
			animalGroupEntryImpl.setUuid("");
		}
		else {
			animalGroupEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			animalGroupEntryImpl.setExternalReferenceCode("");
		}
		else {
			animalGroupEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		animalGroupEntryImpl.setAnimalGroupId(animalGroupId);
		animalGroupEntryImpl.setGroupId(groupId);
		animalGroupEntryImpl.setCompanyId(companyId);
		animalGroupEntryImpl.setUserId(userId);

		if (userName == null) {
			animalGroupEntryImpl.setUserName("");
		}
		else {
			animalGroupEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			animalGroupEntryImpl.setCreateDate(null);
		}
		else {
			animalGroupEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			animalGroupEntryImpl.setModifiedDate(null);
		}
		else {
			animalGroupEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		animalGroupEntryImpl.setCreatorId(creatorId);
		animalGroupEntryImpl.setCustomerId(customerId);

		if (name == null) {
			animalGroupEntryImpl.setName("");
		}
		else {
			animalGroupEntryImpl.setName(name);
		}

		if (description == null) {
			animalGroupEntryImpl.setDescription("");
		}
		else {
			animalGroupEntryImpl.setDescription(description);
		}

		animalGroupEntryImpl.resetOriginalValues();

		return animalGroupEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		animalGroupId = objectInput.readLong();

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

		objectOutput.writeLong(animalGroupId);

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
	}

	public String uuid;
	public String externalReferenceCode;
	public long animalGroupId;
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

}