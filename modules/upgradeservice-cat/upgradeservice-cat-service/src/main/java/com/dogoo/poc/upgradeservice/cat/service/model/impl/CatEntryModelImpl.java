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

package com.dogoo.poc.upgradeservice.cat.service.model.impl;

import com.dogoo.poc.upgradeservice.cat.service.model.CatEntry;
import com.dogoo.poc.upgradeservice.cat.service.model.CatEntryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CatEntry service. Represents a row in the &quot;DG_UGS_CAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CatEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CatEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatEntryImpl
 * @generated
 */
public class CatEntryModelImpl
	extends BaseModelImpl<CatEntry> implements CatEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cat entry model instance should use the <code>CatEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_UGS_CAT";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"ID", Types.BIGINT}, {"NAME", Types.VARCHAR},
		{"GENDER", Types.BOOLEAN}, {"DOB", Types.TIMESTAMP},
		{"cate", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GENDER", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("DOB", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("cate", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_UGS_CAT (uuid_ VARCHAR(75) null,ID LONG not null primary key,NAME VARCHAR(75) null,GENDER BOOLEAN,DOB DATE null,cate LONG)";

	public static final String TABLE_SQL_DROP = "drop table DG_UGS_CAT";

	public static final String ORDER_BY_JPQL = " ORDER BY catEntry.catId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY DG_UGS_CAT.ID ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CATID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CatEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _catId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _catId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CatEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CatEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CatEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CatEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CatEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CatEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CatEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CatEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CatEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CatEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CatEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CatEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CatEntry.class.getClassLoader(), CatEntry.class,
			ModelWrapper.class);

		try {
			Constructor<CatEntry> constructor =
				(Constructor<CatEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CatEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CatEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CatEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CatEntry, Object>>();
		Map<String, BiConsumer<CatEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CatEntry, ?>>();

		attributeGetterFunctions.put("uuid", CatEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CatEntry, String>)CatEntry::setUuid);
		attributeGetterFunctions.put("catId", CatEntry::getCatId);
		attributeSetterBiConsumers.put(
			"catId", (BiConsumer<CatEntry, Long>)CatEntry::setCatId);
		attributeGetterFunctions.put("name", CatEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<CatEntry, String>)CatEntry::setName);
		attributeGetterFunctions.put("gender", CatEntry::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<CatEntry, Boolean>)CatEntry::setGender);
		attributeGetterFunctions.put("dob", CatEntry::getDob);
		attributeSetterBiConsumers.put(
			"dob", (BiConsumer<CatEntry, Date>)CatEntry::setDob);
		attributeGetterFunctions.put("category", CatEntry::getCategory);
		attributeSetterBiConsumers.put(
			"category", (BiConsumer<CatEntry, Long>)CatEntry::setCategory);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getCatId() {
		return _catId;
	}

	@Override
	public void setCatId(long catId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_catId = catId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public boolean getGender() {
		return _gender;
	}

	@Override
	public boolean isGender() {
		return _gender;
	}

	@Override
	public void setGender(boolean gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	@Override
	public Date getDob() {
		return _dob;
	}

	@Override
	public void setDob(Date dob) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dob = dob;
	}

	@Override
	public long getCategory() {
		return _category;
	}

	@Override
	public void setCategory(long category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CatEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CatEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CatEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CatEntryImpl catEntryImpl = new CatEntryImpl();

		catEntryImpl.setUuid(getUuid());
		catEntryImpl.setCatId(getCatId());
		catEntryImpl.setName(getName());
		catEntryImpl.setGender(isGender());
		catEntryImpl.setDob(getDob());
		catEntryImpl.setCategory(getCategory());

		catEntryImpl.resetOriginalValues();

		return catEntryImpl;
	}

	@Override
	public CatEntry cloneWithOriginalValues() {
		CatEntryImpl catEntryImpl = new CatEntryImpl();

		catEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		catEntryImpl.setCatId(this.<Long>getColumnOriginalValue("ID"));
		catEntryImpl.setName(this.<String>getColumnOriginalValue("NAME"));
		catEntryImpl.setGender(this.<Boolean>getColumnOriginalValue("GENDER"));
		catEntryImpl.setDob(this.<Date>getColumnOriginalValue("DOB"));
		catEntryImpl.setCategory(this.<Long>getColumnOriginalValue("cate"));

		return catEntryImpl;
	}

	@Override
	public int compareTo(CatEntry catEntry) {
		long primaryKey = catEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatEntry)) {
			return false;
		}

		CatEntry catEntry = (CatEntry)object;

		long primaryKey = catEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CatEntry> toCacheModel() {
		CatEntryCacheModel catEntryCacheModel = new CatEntryCacheModel();

		catEntryCacheModel.uuid = getUuid();

		String uuid = catEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			catEntryCacheModel.uuid = null;
		}

		catEntryCacheModel.catId = getCatId();

		catEntryCacheModel.name = getName();

		String name = catEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			catEntryCacheModel.name = null;
		}

		catEntryCacheModel.gender = isGender();

		Date dob = getDob();

		if (dob != null) {
			catEntryCacheModel.dob = dob.getTime();
		}
		else {
			catEntryCacheModel.dob = Long.MIN_VALUE;
		}

		catEntryCacheModel.category = getCategory();

		return catEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CatEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CatEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CatEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CatEntry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CatEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CatEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CatEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CatEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CatEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _catId;
	private String _name;
	private boolean _gender;
	private Date _dob;
	private long _category;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CatEntry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CatEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("ID", _catId);
		_columnOriginalValues.put("NAME", _name);
		_columnOriginalValues.put("GENDER", _gender);
		_columnOriginalValues.put("DOB", _dob);
		_columnOriginalValues.put("cate", _category);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("ID", "catId");
		attributeNames.put("NAME", "name");
		attributeNames.put("GENDER", "gender");
		attributeNames.put("DOB", "dob");
		attributeNames.put("cate", "category");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("ID", 2L);

		columnBitmasks.put("NAME", 4L);

		columnBitmasks.put("GENDER", 8L);

		columnBitmasks.put("DOB", 16L);

		columnBitmasks.put("cate", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CatEntry _escapedModel;

}