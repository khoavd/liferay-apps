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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DG_UGS_CAT&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CatEntry
 * @generated
 */
public class CatEntryTable extends BaseTable<CatEntryTable> {

	public static final CatEntryTable INSTANCE = new CatEntryTable();

	public final Column<CatEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CatEntryTable, Long> catId = createColumn(
		"ID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CatEntryTable, String> name = createColumn(
		"NAME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CatEntryTable, Boolean> gender = createColumn(
		"GENDER", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CatEntryTable, Date> dob = createColumn(
		"DOB", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CatEntryTable, Long> category = createColumn(
		"cate", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CatEntryTable() {
		super("DG_UGS_CAT", CatEntryTable::new);
	}

}