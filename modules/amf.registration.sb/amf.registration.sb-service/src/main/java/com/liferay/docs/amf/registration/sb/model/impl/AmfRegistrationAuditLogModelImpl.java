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

package com.liferay.docs.amf.registration.sb.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;
import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AmfRegistrationAuditLog service. Represents a row in the &quot;amf_registration_audit_log&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AmfRegistrationAuditLogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AmfRegistrationAuditLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogImpl
 * @see AmfRegistrationAuditLog
 * @see AmfRegistrationAuditLogModel
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogModelImpl extends BaseModelImpl<AmfRegistrationAuditLog>
	implements AmfRegistrationAuditLogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a amf registration audit log model instance should use the {@link AmfRegistrationAuditLog} interface instead.
	 */
	public static final String TABLE_NAME = "amf_registration_audit_log";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "action_time", Types.TIMESTAMP },
			{ "screen_name", Types.VARCHAR },
			{ "user_id", Types.BIGINT },
			{ "ip_address", Types.VARCHAR },
			{ "event_type", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("action_time", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("screen_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("user_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ip_address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("event_type", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table amf_registration_audit_log (id LONG not null primary key,action_time DATE null,screen_name VARCHAR(75) null,user_id LONG,ip_address VARCHAR(75) null,event_type VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table amf_registration_audit_log";
	public static final String ORDER_BY_JPQL = " ORDER BY amfRegistrationAuditLog.action_time DESC";
	public static final String ORDER_BY_SQL = " ORDER BY amf_registration_audit_log.action_time DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.docs.amf.registration.sb.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.docs.amf.registration.sb.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.docs.amf.registration.sb.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog"),
			true);
	public static final long EVENT_TYPE_COLUMN_BITMASK = 1L;
	public static final long SCREEN_NAME_COLUMN_BITMASK = 2L;
	public static final long USER_ID_COLUMN_BITMASK = 4L;
	public static final long ACTION_TIME_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.docs.amf.registration.sb.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog"));

	public AmfRegistrationAuditLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AmfRegistrationAuditLog.class;
	}

	@Override
	public String getModelClassName() {
		return AmfRegistrationAuditLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("action_time", getAction_time());
		attributes.put("screen_name", getScreen_name());
		attributes.put("user_id", getUser_id());
		attributes.put("ip_address", getIp_address());
		attributes.put("event_type", getEvent_type());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date action_time = (Date)attributes.get("action_time");

		if (action_time != null) {
			setAction_time(action_time);
		}

		String screen_name = (String)attributes.get("screen_name");

		if (screen_name != null) {
			setScreen_name(screen_name);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String ip_address = (String)attributes.get("ip_address");

		if (ip_address != null) {
			setIp_address(ip_address);
		}

		String event_type = (String)attributes.get("event_type");

		if (event_type != null) {
			setEvent_type(event_type);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public Date getAction_time() {
		return _action_time;
	}

	@Override
	public void setAction_time(Date action_time) {
		_columnBitmask = -1L;

		_action_time = action_time;
	}

	@Override
	public String getScreen_name() {
		if (_screen_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _screen_name;
		}
	}

	@Override
	public void setScreen_name(String screen_name) {
		_columnBitmask |= SCREEN_NAME_COLUMN_BITMASK;

		if (_originalScreen_name == null) {
			_originalScreen_name = _screen_name;
		}

		_screen_name = screen_name;
	}

	public String getOriginalScreen_name() {
		return GetterUtil.getString(_originalScreen_name);
	}

	@Override
	public long getUser_id() {
		return _user_id;
	}

	@Override
	public void setUser_id(long user_id) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUser_id) {
			_setOriginalUser_id = true;

			_originalUser_id = _user_id;
		}

		_user_id = user_id;
	}

	public long getOriginalUser_id() {
		return _originalUser_id;
	}

	@Override
	public String getIp_address() {
		if (_ip_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _ip_address;
		}
	}

	@Override
	public void setIp_address(String ip_address) {
		_ip_address = ip_address;
	}

	@Override
	public String getEvent_type() {
		if (_event_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _event_type;
		}
	}

	@Override
	public void setEvent_type(String event_type) {
		_columnBitmask |= EVENT_TYPE_COLUMN_BITMASK;

		if (_originalEvent_type == null) {
			_originalEvent_type = _event_type;
		}

		_event_type = event_type;
	}

	public String getOriginalEvent_type() {
		return GetterUtil.getString(_originalEvent_type);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AmfRegistrationAuditLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AmfRegistrationAuditLog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AmfRegistrationAuditLog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AmfRegistrationAuditLogImpl amfRegistrationAuditLogImpl = new AmfRegistrationAuditLogImpl();

		amfRegistrationAuditLogImpl.setId(getId());
		amfRegistrationAuditLogImpl.setAction_time(getAction_time());
		amfRegistrationAuditLogImpl.setScreen_name(getScreen_name());
		amfRegistrationAuditLogImpl.setUser_id(getUser_id());
		amfRegistrationAuditLogImpl.setIp_address(getIp_address());
		amfRegistrationAuditLogImpl.setEvent_type(getEvent_type());

		amfRegistrationAuditLogImpl.resetOriginalValues();

		return amfRegistrationAuditLogImpl;
	}

	@Override
	public int compareTo(AmfRegistrationAuditLog amfRegistrationAuditLog) {
		int value = 0;

		value = DateUtil.compareTo(getAction_time(),
				amfRegistrationAuditLog.getAction_time());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmfRegistrationAuditLog)) {
			return false;
		}

		AmfRegistrationAuditLog amfRegistrationAuditLog = (AmfRegistrationAuditLog)obj;

		long primaryKey = amfRegistrationAuditLog.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		AmfRegistrationAuditLogModelImpl amfRegistrationAuditLogModelImpl = this;

		amfRegistrationAuditLogModelImpl._originalScreen_name = amfRegistrationAuditLogModelImpl._screen_name;

		amfRegistrationAuditLogModelImpl._originalUser_id = amfRegistrationAuditLogModelImpl._user_id;

		amfRegistrationAuditLogModelImpl._setOriginalUser_id = false;

		amfRegistrationAuditLogModelImpl._originalEvent_type = amfRegistrationAuditLogModelImpl._event_type;

		amfRegistrationAuditLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AmfRegistrationAuditLog> toCacheModel() {
		AmfRegistrationAuditLogCacheModel amfRegistrationAuditLogCacheModel = new AmfRegistrationAuditLogCacheModel();

		amfRegistrationAuditLogCacheModel.id = getId();

		Date action_time = getAction_time();

		if (action_time != null) {
			amfRegistrationAuditLogCacheModel.action_time = action_time.getTime();
		}
		else {
			amfRegistrationAuditLogCacheModel.action_time = Long.MIN_VALUE;
		}

		amfRegistrationAuditLogCacheModel.screen_name = getScreen_name();

		String screen_name = amfRegistrationAuditLogCacheModel.screen_name;

		if ((screen_name != null) && (screen_name.length() == 0)) {
			amfRegistrationAuditLogCacheModel.screen_name = null;
		}

		amfRegistrationAuditLogCacheModel.user_id = getUser_id();

		amfRegistrationAuditLogCacheModel.ip_address = getIp_address();

		String ip_address = amfRegistrationAuditLogCacheModel.ip_address;

		if ((ip_address != null) && (ip_address.length() == 0)) {
			amfRegistrationAuditLogCacheModel.ip_address = null;
		}

		amfRegistrationAuditLogCacheModel.event_type = getEvent_type();

		String event_type = amfRegistrationAuditLogCacheModel.event_type;

		if ((event_type != null) && (event_type.length() == 0)) {
			amfRegistrationAuditLogCacheModel.event_type = null;
		}

		return amfRegistrationAuditLogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", action_time=");
		sb.append(getAction_time());
		sb.append(", screen_name=");
		sb.append(getScreen_name());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append(", ip_address=");
		sb.append(getIp_address());
		sb.append(", event_type=");
		sb.append(getEvent_type());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action_time</column-name><column-value><![CDATA[");
		sb.append(getAction_time());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screen_name</column-name><column-value><![CDATA[");
		sb.append(getScreen_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip_address</column-name><column-value><![CDATA[");
		sb.append(getIp_address());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>event_type</column-name><column-value><![CDATA[");
		sb.append(getEvent_type());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AmfRegistrationAuditLog.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AmfRegistrationAuditLog.class
		};
	private long _id;
	private Date _action_time;
	private String _screen_name;
	private String _originalScreen_name;
	private long _user_id;
	private long _originalUser_id;
	private boolean _setOriginalUser_id;
	private String _ip_address;
	private String _event_type;
	private String _originalEvent_type;
	private long _columnBitmask;
	private AmfRegistrationAuditLog _escapedModel;
}