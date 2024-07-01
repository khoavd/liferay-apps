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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author khoavu
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetEntrySoap implements Serializable {

	public static PetEntrySoap toSoapModel(PetEntry model) {
		PetEntrySoap soapModel = new PetEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setPetId(model.getPetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setBrief(model.getBrief());
		soapModel.setGender(model.getGender());
		soapModel.setVaccine(model.isVaccine());
		soapModel.setWeight(model.getWeight());
		soapModel.setBirthOfDate(model.getBirthOfDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setAnimalGroupId(model.getAnimalGroupId());

		return soapModel;
	}

	public static PetEntrySoap[] toSoapModels(PetEntry[] models) {
		PetEntrySoap[] soapModels = new PetEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetEntrySoap[][] toSoapModels(PetEntry[][] models) {
		PetEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetEntrySoap[] toSoapModels(List<PetEntry> models) {
		List<PetEntrySoap> soapModels = new ArrayList<PetEntrySoap>(
			models.size());

		for (PetEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetEntrySoap[soapModels.size()]);
	}

	public PetEntrySoap() {
	}

	public long getPrimaryKey() {
		return _petId;
	}

	public void setPrimaryKey(long pk) {
		setPetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getPetId() {
		return _petId;
	}

	public void setPetId(long petId) {
		_petId = petId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getBrief() {
		return _brief;
	}

	public void setBrief(String brief) {
		_brief = brief;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public boolean getVaccine() {
		return _vaccine;
	}

	public boolean isVaccine() {
		return _vaccine;
	}

	public void setVaccine(boolean vaccine) {
		_vaccine = vaccine;
	}

	public double getWeight() {
		return _weight;
	}

	public void setWeight(double weight) {
		_weight = weight;
	}

	public Date getBirthOfDate() {
		return _birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		_birthOfDate = birthOfDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getAnimalGroupId() {
		return _animalGroupId;
	}

	public void setAnimalGroupId(long animalGroupId) {
		_animalGroupId = animalGroupId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _petId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _name;
	private String _description;
	private String _brief;
	private int _gender;
	private boolean _vaccine;
	private double _weight;
	private Date _birthOfDate;
	private String _status;
	private Date _statusDate;
	private long _animalGroupId;

}