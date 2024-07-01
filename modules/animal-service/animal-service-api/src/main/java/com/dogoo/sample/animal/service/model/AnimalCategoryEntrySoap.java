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

package com.dogoo.sample.animal.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AnimalCategoryEntrySoap implements Serializable {

	public static AnimalCategoryEntrySoap toSoapModel(
		AnimalCategoryEntry model) {

		AnimalCategoryEntrySoap soapModel = new AnimalCategoryEntrySoap();

		soapModel.setAnimalId(model.getAnimalId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static AnimalCategoryEntrySoap[] toSoapModels(
		AnimalCategoryEntry[] models) {

		AnimalCategoryEntrySoap[] soapModels =
			new AnimalCategoryEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnimalCategoryEntrySoap[][] toSoapModels(
		AnimalCategoryEntry[][] models) {

		AnimalCategoryEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AnimalCategoryEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnimalCategoryEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnimalCategoryEntrySoap[] toSoapModels(
		List<AnimalCategoryEntry> models) {

		List<AnimalCategoryEntrySoap> soapModels =
			new ArrayList<AnimalCategoryEntrySoap>(models.size());

		for (AnimalCategoryEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AnimalCategoryEntrySoap[soapModels.size()]);
	}

	public AnimalCategoryEntrySoap() {
	}

	public long getPrimaryKey() {
		return _animalId;
	}

	public void setPrimaryKey(long pk) {
		setAnimalId(pk);
	}

	public long getAnimalId() {
		return _animalId;
	}

	public void setAnimalId(long animalId) {
		_animalId = animalId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _animalId;
	private String _name;

}