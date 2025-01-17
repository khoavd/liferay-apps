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

/**
 * The table class for the &quot;DG_UGS_CATUSA&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CatUsaEntry
 * @generated
 */
public class CatUsaEntryTable extends BaseTable<CatUsaEntryTable> {

	public static final CatUsaEntryTable INSTANCE = new CatUsaEntryTable();

	public final Column<CatUsaEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CatUsaEntryTable, Long> catId = createColumn(
		"ID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CatUsaEntryTable, String> name = createColumn(
		"NAME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CatUsaEntryTable, Boolean> gender = createColumn(
		"GENDER", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CatUsaEntryTable, Integer> type = createColumn(
		"TYPE", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private CatUsaEntryTable() {
		super("DG_UGS_CATUSA", CatUsaEntryTable::new);
	}

}