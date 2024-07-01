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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CatUsaEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatUsaEntry
 * @generated
 */
public class CatUsaEntryWrapper
	extends BaseModelWrapper<CatUsaEntry>
	implements CatUsaEntry, ModelWrapper<CatUsaEntry> {

	public CatUsaEntryWrapper(CatUsaEntry catUsaEntry) {
		super(catUsaEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("catId", getCatId());
		attributes.put("name", getName());
		attributes.put("gender", isGender());
		attributes.put("type", getType());

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

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public CatUsaEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cat ID of this cat usa entry.
	 *
	 * @return the cat ID of this cat usa entry
	 */
	@Override
	public long getCatId() {
		return model.getCatId();
	}

	/**
	 * Returns the gender of this cat usa entry.
	 *
	 * @return the gender of this cat usa entry
	 */
	@Override
	public boolean getGender() {
		return model.getGender();
	}

	/**
	 * Returns the name of this cat usa entry.
	 *
	 * @return the name of this cat usa entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cat usa entry.
	 *
	 * @return the primary key of this cat usa entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this cat usa entry.
	 *
	 * @return the type of this cat usa entry
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this cat usa entry.
	 *
	 * @return the uuid of this cat usa entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this cat usa entry is gender.
	 *
	 * @return <code>true</code> if this cat usa entry is gender; <code>false</code> otherwise
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
	 * Sets the cat ID of this cat usa entry.
	 *
	 * @param catId the cat ID of this cat usa entry
	 */
	@Override
	public void setCatId(long catId) {
		model.setCatId(catId);
	}

	/**
	 * Sets whether this cat usa entry is gender.
	 *
	 * @param gender the gender of this cat usa entry
	 */
	@Override
	public void setGender(boolean gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the name of this cat usa entry.
	 *
	 * @param name the name of this cat usa entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cat usa entry.
	 *
	 * @param primaryKey the primary key of this cat usa entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this cat usa entry.
	 *
	 * @param type the type of this cat usa entry
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this cat usa entry.
	 *
	 * @param uuid the uuid of this cat usa entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CatUsaEntryWrapper wrap(CatUsaEntry catUsaEntry) {
		return new CatUsaEntryWrapper(catUsaEntry);
	}

}