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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CatEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatEntry
 * @generated
 */
public class CatEntryWrapper
	extends BaseModelWrapper<CatEntry>
	implements CatEntry, ModelWrapper<CatEntry> {

	public CatEntryWrapper(CatEntry catEntry) {
		super(catEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("catId", getCatId());
		attributes.put("name", getName());
		attributes.put("gender", isGender());
		attributes.put("dob", getDob());
		attributes.put("category", getCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long catId = (Long)attributes.get("catId");

		if (catId != null) {
			setCatId(catId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean gender = (Boolean)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		Long category = (Long)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}
	}

	@Override
	public CatEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category of this cat entry.
	 *
	 * @return the category of this cat entry
	 */
	@Override
	public long getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the cat ID of this cat entry.
	 *
	 * @return the cat ID of this cat entry
	 */
	@Override
	public long getCatId() {
		return model.getCatId();
	}

	/**
	 * Returns the dob of this cat entry.
	 *
	 * @return the dob of this cat entry
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the gender of this cat entry.
	 *
	 * @return the gender of this cat entry
	 */
	@Override
	public boolean getGender() {
		return model.getGender();
	}

	/**
	 * Returns the name of this cat entry.
	 *
	 * @return the name of this cat entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cat entry.
	 *
	 * @return the primary key of this cat entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this cat entry.
	 *
	 * @return the uuid of this cat entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this cat entry is gender.
	 *
	 * @return <code>true</code> if this cat entry is gender; <code>false</code> otherwise
	 */
	@Override
	public boolean isGender() {
		return model.isGender();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category of this cat entry.
	 *
	 * @param category the category of this cat entry
	 */
	@Override
	public void setCategory(long category) {
		model.setCategory(category);
	}

	/**
	 * Sets the cat ID of this cat entry.
	 *
	 * @param catId the cat ID of this cat entry
	 */
	@Override
	public void setCatId(long catId) {
		model.setCatId(catId);
	}

	/**
	 * Sets the dob of this cat entry.
	 *
	 * @param dob the dob of this cat entry
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets whether this cat entry is gender.
	 *
	 * @param gender the gender of this cat entry
	 */
	@Override
	public void setGender(boolean gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the name of this cat entry.
	 *
	 * @param name the name of this cat entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cat entry.
	 *
	 * @param primaryKey the primary key of this cat entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this cat entry.
	 *
	 * @param uuid the uuid of this cat entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CatEntryWrapper wrap(CatEntry catEntry) {
		return new CatEntryWrapper(catEntry);
	}

}