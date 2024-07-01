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
 * The extended model interface for the DogEntry service. Represents a row in the &quot;DG_DOG&quot; database table, with each column mapped to a property of this class.
 *
 * @author khoavu
 * @see DogEntryModel
 * @generated
 */
@ImplementationClassName("com.dogoo.sample.pet.service.model.impl.DogEntryImpl")
@ProviderType
public interface DogEntry extends DogEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.dogoo.sample.pet.service.model.impl.DogEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DogEntry, Long> DOG_ID_ACCESSOR =
		new Accessor<DogEntry, Long>() {

			@Override
			public Long get(DogEntry dogEntry) {
				return dogEntry.getDogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DogEntry> getTypeClass() {
				return DogEntry.class;
			}

		};

}