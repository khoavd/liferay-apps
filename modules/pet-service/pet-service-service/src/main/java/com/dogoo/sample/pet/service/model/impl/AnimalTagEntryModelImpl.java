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

package com.dogoo.sample.pet.service.model.impl;

import com.dogoo.sample.pet.service.model.AnimalTagEntry;
import com.dogoo.sample.pet.service.model.AnimalTagEntryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
 * The base model implementation for the AnimalTagEntry service. Represents a row in the &quot;DG_ANIMALTAG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AnimalTagEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnimalTagEntryImpl}.
 * </p>
 *
 * @author khoavu
 * @see AnimalTagEntryImpl
 * @generated
 */
public class AnimalTagEntryModelImpl
	extends BaseModelImpl<AnimalTagEntry> implements AnimalTagEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a animal tag entry model instance should use the <code>AnimalTagEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_ANIMALTAG";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"animalTagId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"creatorId", Types.BIGINT},
		{"customerId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"status", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("animalTagId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_ANIMALTAG (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,animalTagId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creatorId LONG,customerId LONG,name VARCHAR(75) null,description VARCHAR(75) null,status VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table DG_ANIMALTAG";

	public static final String ORDER_BY_JPQL =
		" ORDER BY animalTagEntry.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY DG_ANIMALTAG.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CUSTOMERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

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

	public static final String MAPPING_TABLE_DG_PETS_ANIMALTAGS_NAME =
		"DG_Pets_AnimalTags";

	public static final Object[][] MAPPING_TABLE_DG_PETS_ANIMALTAGS_COLUMNS = {
		{"companyId", Types.BIGINT}, {"animalTagId", Types.BIGINT},
		{"petId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_DG_PETS_ANIMALTAGS_SQL_CREATE =
		"create table DG_Pets_AnimalTags (companyId LONG not null,animalTagId LONG not null,petId LONG not null,primary key (animalTagId, petId))";

	public static final String MAPPING_TABLE_DG_DOGS_ANIMALTAGS_NAME =
		"DG_Dogs_AnimalTags";

	public static final Object[][] MAPPING_TABLE_DG_DOGS_ANIMALTAGS_COLUMNS = {
		{"companyId", Types.BIGINT}, {"animalTagId", Types.BIGINT},
		{"dogId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_DG_DOGS_ANIMALTAGS_SQL_CREATE =
		"create table DG_Dogs_AnimalTags (companyId LONG not null,animalTagId LONG not null,dogId LONG not null,primary key (animalTagId, dogId))";

	public AnimalTagEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _animalTagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnimalTagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _animalTagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AnimalTagEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AnimalTagEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AnimalTagEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AnimalTagEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AnimalTagEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AnimalTagEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AnimalTagEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AnimalTagEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AnimalTagEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AnimalTagEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AnimalTagEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AnimalTagEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AnimalTagEntry.class.getClassLoader(), AnimalTagEntry.class,
			ModelWrapper.class);

		try {
			Constructor<AnimalTagEntry> constructor =
				(Constructor<AnimalTagEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AnimalTagEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AnimalTagEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AnimalTagEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AnimalTagEntry, Object>>();
		Map<String, BiConsumer<AnimalTagEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AnimalTagEntry, ?>>();

		attributeGetterFunctions.put("uuid", AnimalTagEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<AnimalTagEntry, String>)AnimalTagEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", AnimalTagEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<AnimalTagEntry, String>)
				AnimalTagEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"animalTagId", AnimalTagEntry::getAnimalTagId);
		attributeSetterBiConsumers.put(
			"animalTagId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setAnimalTagId);
		attributeGetterFunctions.put("groupId", AnimalTagEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setGroupId);
		attributeGetterFunctions.put("companyId", AnimalTagEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setCompanyId);
		attributeGetterFunctions.put("userId", AnimalTagEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setUserId);
		attributeGetterFunctions.put("userName", AnimalTagEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AnimalTagEntry, String>)AnimalTagEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", AnimalTagEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AnimalTagEntry, Date>)AnimalTagEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AnimalTagEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AnimalTagEntry, Date>)AnimalTagEntry::setModifiedDate);
		attributeGetterFunctions.put("creatorId", AnimalTagEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setCreatorId);
		attributeGetterFunctions.put(
			"customerId", AnimalTagEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<AnimalTagEntry, Long>)AnimalTagEntry::setCustomerId);
		attributeGetterFunctions.put("name", AnimalTagEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<AnimalTagEntry, String>)AnimalTagEntry::setName);
		attributeGetterFunctions.put(
			"description", AnimalTagEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<AnimalTagEntry, String>)AnimalTagEntry::setDescription);
		attributeGetterFunctions.put("status", AnimalTagEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<AnimalTagEntry, String>)AnimalTagEntry::setStatus);
		attributeGetterFunctions.put(
			"statusDate", AnimalTagEntry::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<AnimalTagEntry, Date>)AnimalTagEntry::setStatusDate);

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
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_externalReferenceCode = externalReferenceCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalExternalReferenceCode() {
		return getColumnOriginalValue("externalReferenceCode");
	}

	@Override
	public long getAnimalTagId() {
		return _animalTagId;
	}

	@Override
	public void setAnimalTagId(long animalTagId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_animalTagId = animalTagId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_creatorId = creatorId;
	}

	@Override
	public long getCustomerId() {
		return _customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_customerId = customerId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCustomerId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("customerId"));
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AnimalTagEntry.class.getName()));
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
			getCompanyId(), AnimalTagEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AnimalTagEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AnimalTagEntry>
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
		AnimalTagEntryImpl animalTagEntryImpl = new AnimalTagEntryImpl();

		animalTagEntryImpl.setUuid(getUuid());
		animalTagEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		animalTagEntryImpl.setAnimalTagId(getAnimalTagId());
		animalTagEntryImpl.setGroupId(getGroupId());
		animalTagEntryImpl.setCompanyId(getCompanyId());
		animalTagEntryImpl.setUserId(getUserId());
		animalTagEntryImpl.setUserName(getUserName());
		animalTagEntryImpl.setCreateDate(getCreateDate());
		animalTagEntryImpl.setModifiedDate(getModifiedDate());
		animalTagEntryImpl.setCreatorId(getCreatorId());
		animalTagEntryImpl.setCustomerId(getCustomerId());
		animalTagEntryImpl.setName(getName());
		animalTagEntryImpl.setDescription(getDescription());
		animalTagEntryImpl.setStatus(getStatus());
		animalTagEntryImpl.setStatusDate(getStatusDate());

		animalTagEntryImpl.resetOriginalValues();

		return animalTagEntryImpl;
	}

	@Override
	public AnimalTagEntry cloneWithOriginalValues() {
		AnimalTagEntryImpl animalTagEntryImpl = new AnimalTagEntryImpl();

		animalTagEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		animalTagEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		animalTagEntryImpl.setAnimalTagId(
			this.<Long>getColumnOriginalValue("animalTagId"));
		animalTagEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		animalTagEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		animalTagEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		animalTagEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		animalTagEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		animalTagEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		animalTagEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		animalTagEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		animalTagEntryImpl.setName(this.<String>getColumnOriginalValue("name"));
		animalTagEntryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		animalTagEntryImpl.setStatus(
			this.<String>getColumnOriginalValue("status"));
		animalTagEntryImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));

		return animalTagEntryImpl;
	}

	@Override
	public int compareTo(AnimalTagEntry animalTagEntry) {
		int value = 0;

		value = getName().compareTo(animalTagEntry.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnimalTagEntry)) {
			return false;
		}

		AnimalTagEntry animalTagEntry = (AnimalTagEntry)object;

		long primaryKey = animalTagEntry.getPrimaryKey();

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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<AnimalTagEntry> toCacheModel() {
		AnimalTagEntryCacheModel animalTagEntryCacheModel =
			new AnimalTagEntryCacheModel();

		animalTagEntryCacheModel.uuid = getUuid();

		String uuid = animalTagEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			animalTagEntryCacheModel.uuid = null;
		}

		animalTagEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			animalTagEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			animalTagEntryCacheModel.externalReferenceCode = null;
		}

		animalTagEntryCacheModel.animalTagId = getAnimalTagId();

		animalTagEntryCacheModel.groupId = getGroupId();

		animalTagEntryCacheModel.companyId = getCompanyId();

		animalTagEntryCacheModel.userId = getUserId();

		animalTagEntryCacheModel.userName = getUserName();

		String userName = animalTagEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			animalTagEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			animalTagEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			animalTagEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			animalTagEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			animalTagEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		animalTagEntryCacheModel.creatorId = getCreatorId();

		animalTagEntryCacheModel.customerId = getCustomerId();

		animalTagEntryCacheModel.name = getName();

		String name = animalTagEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			animalTagEntryCacheModel.name = null;
		}

		animalTagEntryCacheModel.description = getDescription();

		String description = animalTagEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			animalTagEntryCacheModel.description = null;
		}

		animalTagEntryCacheModel.status = getStatus();

		String status = animalTagEntryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			animalTagEntryCacheModel.status = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			animalTagEntryCacheModel.statusDate = statusDate.getTime();
		}
		else {
			animalTagEntryCacheModel.statusDate = Long.MIN_VALUE;
		}

		return animalTagEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AnimalTagEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AnimalTagEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AnimalTagEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((AnimalTagEntry)this);

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
		Map<String, Function<AnimalTagEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AnimalTagEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AnimalTagEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AnimalTagEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AnimalTagEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _animalTagId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _name;
	private String _description;
	private String _status;
	private Date _statusDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AnimalTagEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AnimalTagEntry)this);
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
		_columnOriginalValues.put(
			"externalReferenceCode", _externalReferenceCode);
		_columnOriginalValues.put("animalTagId", _animalTagId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusDate", _statusDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("externalReferenceCode", 2L);

		columnBitmasks.put("animalTagId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("creatorId", 512L);

		columnBitmasks.put("customerId", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("description", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("statusDate", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AnimalTagEntry _escapedModel;

}