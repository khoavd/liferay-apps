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

package com.dogoo.sample.animal.service.model.impl;

import com.dogoo.sample.animal.service.model.AnimalCategoryEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AnimalCategoryEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnimalCategoryEntryCacheModel
	implements CacheModel<AnimalCategoryEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnimalCategoryEntryCacheModel)) {
			return false;
		}

		AnimalCategoryEntryCacheModel animalCategoryEntryCacheModel =
			(AnimalCategoryEntryCacheModel)object;

		if (animalId == animalCategoryEntryCacheModel.animalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, animalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{animalId=");
		sb.append(animalId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnimalCategoryEntry toEntityModel() {
		AnimalCategoryEntryImpl animalCategoryEntryImpl =
			new AnimalCategoryEntryImpl();

		animalCategoryEntryImpl.setAnimalId(animalId);

		if (name == null) {
			animalCategoryEntryImpl.setName("");
		}
		else {
			animalCategoryEntryImpl.setName(name);
		}

		animalCategoryEntryImpl.resetOriginalValues();

		return animalCategoryEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		animalId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(animalId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long animalId;
	public String name;

}