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

import com.dogoo.poc.upgradeservice.cat.service.model.CatUsaEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CatUsaEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CatUsaEntryCacheModel
	implements CacheModel<CatUsaEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatUsaEntryCacheModel)) {
			return false;
		}

		CatUsaEntryCacheModel catUsaEntryCacheModel =
			(CatUsaEntryCacheModel)object;

		if (catId == catUsaEntryCacheModel.catId) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", catId=");
		sb.append(catId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatUsaEntry toEntityModel() {
		CatUsaEntryImpl catUsaEntryImpl = new CatUsaEntryImpl();

		if (uuid == null) {
			catUsaEntryImpl.setUuid("");
		}
		else {
			catUsaEntryImpl.setUuid(uuid);
		}

		catUsaEntryImpl.setCatId(catId);

		if (name == null) {
			catUsaEntryImpl.setName("");
		}
		else {
			catUsaEntryImpl.setName(name);
		}

		catUsaEntryImpl.setGender(gender);
		catUsaEntryImpl.setType(type);

		catUsaEntryImpl.resetOriginalValues();

		return catUsaEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		catId = objectInput.readLong();
		name = objectInput.readUTF();

		gender = objectInput.readBoolean();

		type = objectInput.readInt();
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

		objectOutput.writeInt(type);
	}

	public String uuid;
	public long catId;
	public String name;
	public boolean gender;
	public int type;

}