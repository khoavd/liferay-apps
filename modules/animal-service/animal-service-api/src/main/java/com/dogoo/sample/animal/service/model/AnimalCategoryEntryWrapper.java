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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnimalCategoryEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnimalCategoryEntry
 * @generated
 */
public class AnimalCategoryEntryWrapper
	extends BaseModelWrapper<AnimalCategoryEntry>
	implements AnimalCategoryEntry, ModelWrapper<AnimalCategoryEntry> {

	public AnimalCategoryEntryWrapper(AnimalCategoryEntry animalCategoryEntry) {
		super(animalCategoryEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("animalId", getAnimalId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long animalId = (Long)attributes.get("animalId");

		if (animalId != null) {
			setAnimalId(animalId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public AnimalCategoryEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the animal ID of this animal category entry.
	 *
	 * @return the animal ID of this animal category entry
	 */
	@Override
	public long getAnimalId() {
		return model.getAnimalId();
	}

	/**
	 * Returns the name of this animal category entry.
	 *
	 * @return the name of this animal category entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this animal category entry.
	 *
	 * @return the primary key of this animal category entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the animal ID of this animal category entry.
	 *
	 * @param animalId the animal ID of this animal category entry
	 */
	@Override
	public void setAnimalId(long animalId) {
		model.setAnimalId(animalId);
	}

	/**
	 * Sets the name of this animal category entry.
	 *
	 * @param name the name of this animal category entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this animal category entry.
	 *
	 * @param primaryKey the primary key of this animal category entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AnimalCategoryEntryWrapper wrap(
		AnimalCategoryEntry animalCategoryEntry) {

		return new AnimalCategoryEntryWrapper(animalCategoryEntry);
	}

}