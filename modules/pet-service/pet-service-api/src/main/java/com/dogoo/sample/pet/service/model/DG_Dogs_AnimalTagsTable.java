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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DG_Dogs_AnimalTags&quot; database table.
 *
 * @author khoavu
 * @see AnimalTagEntry
 * @see DogEntry
 * @generated
 */
public class DG_Dogs_AnimalTagsTable
	extends BaseTable<DG_Dogs_AnimalTagsTable> {

	public static final DG_Dogs_AnimalTagsTable INSTANCE =
		new DG_Dogs_AnimalTagsTable();

	public final Column<DG_Dogs_AnimalTagsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DG_Dogs_AnimalTagsTable, Long> animalTagId =
		createColumn(
			"animalTagId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DG_Dogs_AnimalTagsTable, Long> dogId = createColumn(
		"dogId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private DG_Dogs_AnimalTagsTable() {
		super("DG_Dogs_AnimalTags", DG_Dogs_AnimalTagsTable::new);
	}

}