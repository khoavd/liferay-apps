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

package com.dogoo.poc.upgradeservice.cat.service.model.impl;

import com.dogoo.poc.upgradeservice.cat.service.model.CatEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CatEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CatEntryCacheModel
	implements CacheModel<CatEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatEntryCacheModel)) {
			return false;
		}

		CatEntryCacheModel catEntryCacheModel = (CatEntryCacheModel)object;

		if (catId == catEntryCacheModel.catId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, catId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", catId=");
		sb.append(catId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", category=");
		sb.append(category);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatEntry toEntityModel() {
		CatEntryImpl catEntryImpl = new CatEntryImpl();

		if (uuid == null) {
			catEntryImpl.setUuid("");
		}
		else {
			catEntryImpl.setUuid(uuid);
		}

		catEntryImpl.setCatId(catId);

		if (name == null) {
			catEntryImpl.setName("");
		}
		else {
			catEntryImpl.setName(name);
		}

		catEntryImpl.setGender(gender);

		if (dob == Long.MIN_VALUE) {
			catEntryImpl.setDob(null);
		}
		else {
			catEntryImpl.setDob(new Date(dob));
		}

		catEntryImpl.setCategory(category);

		catEntryImpl.resetOriginalValues();

		return catEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		catId = objectInput.readLong();
		name = objectInput.readUTF();

		gender = objectInput.readBoolean();
		dob = objectInput.readLong();

		category = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(catId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(gender);
		objectOutput.writeLong(dob);

		objectOutput.writeLong(category);
	}

	public String uuid;
	public long catId;
	public String name;
	public boolean gender;
	public long dob;
	public long category;

}