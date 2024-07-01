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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DG_ANIMAL_CATE&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AnimalCategoryEntry
 * @generated
 */
public class AnimalCategoryEntryTable
	extends BaseTable<AnimalCategoryEntryTable> {

	public static final AnimalCategoryEntryTable INSTANCE =
		new AnimalCategoryEntryTable();

	public final Column<AnimalCategoryEntryTable, Long> animalId = createColumn(
		"ID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AnimalCategoryEntryTable, String> name = createColumn(
		"NAME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AnimalCategoryEntryTable() {
		super("DG_ANIMAL_CATE", AnimalCategoryEntryTable::new);
	}

}