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

package com.dogoo.poc.upgradeservice.cat.service.model;

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
public class CatUsaEntrySoap implements Serializable {

	public static CatUsaEntrySoap toSoapModel(CatUsaEntry model) {
		CatUsaEntrySoap soapModel = new CatUsaEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCatId(model.getCatId());
		soapModel.setName(model.getName());
		soapModel.setGender(model.isGender());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static CatUsaEntrySoap[] toSoapModels(CatUsaEntry[] models) {
		CatUsaEntrySoap[] soapModels = new CatUsaEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatUsaEntrySoap[][] toSoapModels(CatUsaEntry[][] models) {
		CatUsaEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatUsaEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatUsaEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatUsaEntrySoap[] toSoapModels(List<CatUsaEntry> models) {
		List<CatUsaEntrySoap> soapModels = new ArrayList<CatUsaEntrySoap>(
			models.size());

		for (CatUsaEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatUsaEntrySoap[soapModels.size()]);
	}

	public CatUsaEntrySoap() {
	}

	public long getPrimaryKey() {
		return _catId;
	}

	public void setPrimaryKey(long pk) {
		setCatId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCatId() {
		return _catId;
	}

	public void setCatId(long catId) {
		_catId = catId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getGender() {
		return _gender;
	}

	public boolean isGender() {
		return _gender;
	}

	public void setGender(boolean gender) {
		_gender = gender;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private String _uuid;
	private long _catId;
	private String _name;
	private boolean _gender;
	private int _type;

}