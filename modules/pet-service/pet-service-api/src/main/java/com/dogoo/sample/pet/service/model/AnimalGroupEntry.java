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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AnimalGroupEntry service. Represents a row in the &quot;DG_ANIMALGROUP&quot; database table, with each column mapped to a property of this class.
 *
 * @author khoavu
 * @see AnimalGroupEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryImpl"
)
@ProviderType
public interface AnimalGroupEntry
	extends AnimalGroupEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.dogoo.sample.pet.service.model.impl.AnimalGroupEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnimalGroupEntry, Long>
		ANIMAL_GROUP_ID_ACCESSOR = new Accessor<AnimalGroupEntry, Long>() {

			@Override
			public Long get(AnimalGroupEntry animalGroupEntry) {
				return animalGroupEntry.getAnimalGroupId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnimalGroupEntry> getTypeClass() {
				return AnimalGroupEntry.class;
			}

		};

}