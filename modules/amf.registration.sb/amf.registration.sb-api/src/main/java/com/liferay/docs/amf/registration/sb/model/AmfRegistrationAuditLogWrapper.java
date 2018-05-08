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

package com.liferay.docs.amf.registration.sb.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AmfRegistrationAuditLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLog
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogWrapper implements AmfRegistrationAuditLog,
	ModelWrapper<AmfRegistrationAuditLog> {
	public AmfRegistrationAuditLogWrapper(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		_amfRegistrationAuditLog = amfRegistrationAuditLog;
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
	public AmfRegistrationAuditLog toEscapedModel() {
		return new AmfRegistrationAuditLogWrapper(_amfRegistrationAuditLog.toEscapedModel());
	}

	@Override
	public AmfRegistrationAuditLog toUnescapedModel() {
		return new AmfRegistrationAuditLogWrapper(_amfRegistrationAuditLog.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _amfRegistrationAuditLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _amfRegistrationAuditLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _amfRegistrationAuditLog.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _amfRegistrationAuditLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AmfRegistrationAuditLog> toCacheModel() {
		return _amfRegistrationAuditLog.toCacheModel();
	}

	@Override
	public int compareTo(AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return _amfRegistrationAuditLog.compareTo(amfRegistrationAuditLog);
	}

	@Override
	public int hashCode() {
		return _amfRegistrationAuditLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfRegistrationAuditLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AmfRegistrationAuditLogWrapper((AmfRegistrationAuditLog)_amfRegistrationAuditLog.clone());
	}

	/**
	* Returns the event_type of this amf registration audit log.
	*
	* @return the event_type of this amf registration audit log
	*/
	@Override
	public java.lang.String getEvent_type() {
		return _amfRegistrationAuditLog.getEvent_type();
	}

	/**
	* Returns the ip_address of this amf registration audit log.
	*
	* @return the ip_address of this amf registration audit log
	*/
	@Override
	public java.lang.String getIp_address() {
		return _amfRegistrationAuditLog.getIp_address();
	}

	/**
	* Returns the screen_name of this amf registration audit log.
	*
	* @return the screen_name of this amf registration audit log
	*/
	@Override
	public java.lang.String getScreen_name() {
		return _amfRegistrationAuditLog.getScreen_name();
	}

	@Override
	public java.lang.String toString() {
		return _amfRegistrationAuditLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _amfRegistrationAuditLog.toXmlString();
	}

	/**
	* Returns the action_time of this amf registration audit log.
	*
	* @return the action_time of this amf registration audit log
	*/
	@Override
	public Date getAction_time() {
		return _amfRegistrationAuditLog.getAction_time();
	}

	/**
	* Returns the ID of this amf registration audit log.
	*
	* @return the ID of this amf registration audit log
	*/
	@Override
	public long getId() {
		return _amfRegistrationAuditLog.getId();
	}

	/**
	* Returns the primary key of this amf registration audit log.
	*
	* @return the primary key of this amf registration audit log
	*/
	@Override
	public long getPrimaryKey() {
		return _amfRegistrationAuditLog.getPrimaryKey();
	}

	/**
	* Returns the user_id of this amf registration audit log.
	*
	* @return the user_id of this amf registration audit log
	*/
	@Override
	public long getUser_id() {
		return _amfRegistrationAuditLog.getUser_id();
	}

	@Override
	public void persist() {
		_amfRegistrationAuditLog.persist();
	}

	/**
	* Sets the action_time of this amf registration audit log.
	*
	* @param action_time the action_time of this amf registration audit log
	*/
	@Override
	public void setAction_time(Date action_time) {
		_amfRegistrationAuditLog.setAction_time(action_time);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_amfRegistrationAuditLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the event_type of this amf registration audit log.
	*
	* @param event_type the event_type of this amf registration audit log
	*/
	@Override
	public void setEvent_type(java.lang.String event_type) {
		_amfRegistrationAuditLog.setEvent_type(event_type);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_amfRegistrationAuditLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_amfRegistrationAuditLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_amfRegistrationAuditLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this amf registration audit log.
	*
	* @param id the ID of this amf registration audit log
	*/
	@Override
	public void setId(long id) {
		_amfRegistrationAuditLog.setId(id);
	}

	/**
	* Sets the ip_address of this amf registration audit log.
	*
	* @param ip_address the ip_address of this amf registration audit log
	*/
	@Override
	public void setIp_address(java.lang.String ip_address) {
		_amfRegistrationAuditLog.setIp_address(ip_address);
	}

	@Override
	public void setNew(boolean n) {
		_amfRegistrationAuditLog.setNew(n);
	}

	/**
	* Sets the primary key of this amf registration audit log.
	*
	* @param primaryKey the primary key of this amf registration audit log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_amfRegistrationAuditLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_amfRegistrationAuditLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the screen_name of this amf registration audit log.
	*
	* @param screen_name the screen_name of this amf registration audit log
	*/
	@Override
	public void setScreen_name(java.lang.String screen_name) {
		_amfRegistrationAuditLog.setScreen_name(screen_name);
	}

	/**
	* Sets the user_id of this amf registration audit log.
	*
	* @param user_id the user_id of this amf registration audit log
	*/
	@Override
	public void setUser_id(long user_id) {
		_amfRegistrationAuditLog.setUser_id(user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmfRegistrationAuditLogWrapper)) {
			return false;
		}

		AmfRegistrationAuditLogWrapper amfRegistrationAuditLogWrapper = (AmfRegistrationAuditLogWrapper)obj;

		if (Objects.equals(_amfRegistrationAuditLog,
					amfRegistrationAuditLogWrapper._amfRegistrationAuditLog)) {
			return true;
		}

		return false;
	}

	@Override
	public AmfRegistrationAuditLog getWrappedModel() {
		return _amfRegistrationAuditLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _amfRegistrationAuditLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _amfRegistrationAuditLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_amfRegistrationAuditLog.resetOriginalValues();
	}

	private final AmfRegistrationAuditLog _amfRegistrationAuditLog;
}