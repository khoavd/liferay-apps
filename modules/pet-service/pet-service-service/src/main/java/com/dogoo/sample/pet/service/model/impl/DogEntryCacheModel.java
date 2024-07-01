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

import com.dogoo.sample.pet.service.model.DogEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DogEntry in entity cache.
 *
 * @author khoavu
 * @generated
 */
public class DogEntryCacheModel
	implements CacheModel<DogEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DogEntryCacheModel)) {
			return false;
		}

		DogEntryCacheModel dogEntryCacheModel = (DogEntryCacheModel)object;

		if (dogId == dogEntryCacheModel.dogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", dogId=");
		sb.append(dogId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", color=");
		sb.append(color);
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
	public DogEntry toEntityModel() {
		DogEntryImpl dogEntryImpl = new DogEntryImpl();

		if (uuid == null) {
			dogEntryImpl.setUuid("");
		}
		else {
			dogEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			dogEntryImpl.setExternalReferenceCode("");
		}
		else {
			dogEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		dogEntryImpl.setDogId(dogId);
		dogEntryImpl.setGroupId(groupId);
		dogEntryImpl.setCompanyId(companyId);
		dogEntryImpl.setUserId(userId);

		if (userName == null) {
			dogEntryImpl.setUserName("");
		}
		else {
			dogEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dogEntryImpl.setCreateDate(null);
		}
		else {
			dogEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dogEntryImpl.setModifiedDate(null);
		}
		else {
			dogEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dogEntryImpl.setCreatorId(creatorId);
		dogEntryImpl.setCustomerId(customerId);

		if (name == null) {
			dogEntryImpl.setName("");
		}
		else {
			dogEntryImpl.setName(name);
		}

		if (title == null) {
			dogEntryImpl.setTitle("");
		}
		else {
			dogEntryImpl.setTitle(title);
		}

		dogEntryImpl.setWeight(weight);

		if (color == null) {
			dogEntryImpl.setColor("");
		}
		else {
			dogEntryImpl.setColor(color);
		}

		if (status == null) {
			dogEntryImpl.setStatus("");
		}
		else {
			dogEntryImpl.setStatus(status);
		}

		if (statusDate == Long.MIN_VALUE) {
			dogEntryImpl.setStatusDate(null);
		}
		else {
			dogEntryImpl.setStatusDate(new Date(statusDate));
		}

		dogEntryImpl.setAnimalGroupId(animalGroupId);

		dogEntryImpl.resetOriginalValues();

		return dogEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		dogId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();

		weight = objectInput.readDouble();
		color = objectInput.readUTF();
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

		objectOutput.writeLong(dogId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeDouble(weight);

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

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
	public long dogId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long customerId;
	public String name;
	public String title;
	public double weight;
	public String color;
	public String status;
	public long statusDate;
	public long animalGroupId;

}