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

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.service.builder.test.model.CacheFieldEntry;
import com.liferay.portal.tools.service.builder.test.model.CacheFieldEntryModel;

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
 * The base model implementation for the CacheFieldEntry service. Represents a row in the &quot;CacheFieldEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CacheFieldEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheFieldEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CacheFieldEntryImpl
 * @generated
 */
public class CacheFieldEntryModelImpl
	extends BaseModelImpl<CacheFieldEntry> implements CacheFieldEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache field entry model instance should use the <code>CacheFieldEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CacheFieldEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"cacheFieldEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cacheFieldEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CacheFieldEntry (cacheFieldEntryId LONG not null primary key,groupId LONG,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table CacheFieldEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cacheFieldEntry.cacheFieldEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CacheFieldEntry.cacheFieldEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CACHEFIELDENTRYID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.CacheFieldEntry"));

	public CacheFieldEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cacheFieldEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCacheFieldEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cacheFieldEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CacheFieldEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CacheFieldEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CacheFieldEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CacheFieldEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheFieldEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CacheFieldEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CacheFieldEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CacheFieldEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CacheFieldEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CacheFieldEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CacheFieldEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CacheFieldEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CacheFieldEntry.class.getClassLoader(), CacheFieldEntry.class,
			ModelWrapper.class);

		try {
			Constructor<CacheFieldEntry> constructor =
				(Constructor<CacheFieldEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CacheFieldEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CacheFieldEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CacheFieldEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CacheFieldEntry, Object>>();
		Map<String, BiConsumer<CacheFieldEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CacheFieldEntry, ?>>();

		attributeGetterFunctions.put(
			"cacheFieldEntryId", CacheFieldEntry::getCacheFieldEntryId);
		attributeSetterBiConsumers.put(
			"cacheFieldEntryId",
			(BiConsumer<CacheFieldEntry, Long>)
				CacheFieldEntry::setCacheFieldEntryId);
		attributeGetterFunctions.put("groupId", CacheFieldEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CacheFieldEntry, Long>)CacheFieldEntry::setGroupId);
		attributeGetterFunctions.put("name", CacheFieldEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CacheFieldEntry, String>)CacheFieldEntry::setName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCacheFieldEntryId() {
		return _cacheFieldEntryId;
	}

	@Override
	public void setCacheFieldEntryId(long cacheFieldEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cacheFieldEntryId = cacheFieldEntryId;
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

	public String getNickname() {
		return null;
	}

	public void setNickname(String nickname) {
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
			0, CacheFieldEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CacheFieldEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CacheFieldEntry>
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
		CacheFieldEntryImpl cacheFieldEntryImpl = new CacheFieldEntryImpl();

		cacheFieldEntryImpl.setCacheFieldEntryId(getCacheFieldEntryId());
		cacheFieldEntryImpl.setGroupId(getGroupId());
		cacheFieldEntryImpl.setName(getName());

		cacheFieldEntryImpl.resetOriginalValues();

		return cacheFieldEntryImpl;
	}

	@Override
	public CacheFieldEntry cloneWithOriginalValues() {
		CacheFieldEntryImpl cacheFieldEntryImpl = new CacheFieldEntryImpl();

		cacheFieldEntryImpl.setCacheFieldEntryId(
			this.<Long>getColumnOriginalValue("cacheFieldEntryId"));
		cacheFieldEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		cacheFieldEntryImpl.setName(
			this.<String>getColumnOriginalValue("name"));

		return cacheFieldEntryImpl;
	}

	@Override
	public int compareTo(CacheFieldEntry cacheFieldEntry) {
		long primaryKey = cacheFieldEntry.getPrimaryKey();

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

		if (!(object instanceof CacheFieldEntry)) {
			return false;
		}

		CacheFieldEntry cacheFieldEntry = (CacheFieldEntry)object;

		long primaryKey = cacheFieldEntry.getPrimaryKey();

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
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		setNickname(null);

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CacheFieldEntry> toCacheModel() {
		CacheFieldEntryCacheModel cacheFieldEntryCacheModel =
			new CacheFieldEntryCacheModel();

		cacheFieldEntryCacheModel.cacheFieldEntryId = getCacheFieldEntryId();

		cacheFieldEntryCacheModel.groupId = getGroupId();

		cacheFieldEntryCacheModel.name = getName();

		String name = cacheFieldEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cacheFieldEntryCacheModel.name = null;
		}

		cacheFieldEntryCacheModel._nickname = getNickname();

		return cacheFieldEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CacheFieldEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CacheFieldEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheFieldEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CacheFieldEntry)this);

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
		Map<String, Function<CacheFieldEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CacheFieldEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheFieldEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CacheFieldEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CacheFieldEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _cacheFieldEntryId;
	private long _groupId;
	private String _name;

	public <T> T getColumnValue(String columnName) {
		Function<CacheFieldEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CacheFieldEntry)this);
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

		_columnOriginalValues.put("cacheFieldEntryId", _cacheFieldEntryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("name", _name);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("cacheFieldEntryId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("name", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CacheFieldEntry _escapedModel;

}