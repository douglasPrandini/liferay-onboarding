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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogSoap implements Serializable {
	public static AmfRegistrationAuditLogSoap toSoapModel(
		AmfRegistrationAuditLog model) {
		AmfRegistrationAuditLogSoap soapModel = new AmfRegistrationAuditLogSoap();

		soapModel.setId(model.getId());
		soapModel.setAction_time(model.getAction_time());
		soapModel.setScreen_name(model.getScreen_name());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setIp_address(model.getIp_address());
		soapModel.setEvent_type(model.getEvent_type());

		return soapModel;
	}

	public static AmfRegistrationAuditLogSoap[] toSoapModels(
		AmfRegistrationAuditLog[] models) {
		AmfRegistrationAuditLogSoap[] soapModels = new AmfRegistrationAuditLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmfRegistrationAuditLogSoap[][] toSoapModels(
		AmfRegistrationAuditLog[][] models) {
		AmfRegistrationAuditLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmfRegistrationAuditLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmfRegistrationAuditLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmfRegistrationAuditLogSoap[] toSoapModels(
		List<AmfRegistrationAuditLog> models) {
		List<AmfRegistrationAuditLogSoap> soapModels = new ArrayList<AmfRegistrationAuditLogSoap>(models.size());

		for (AmfRegistrationAuditLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmfRegistrationAuditLogSoap[soapModels.size()]);
	}

	public AmfRegistrationAuditLogSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Date getAction_time() {
		return _action_time;
	}

	public void setAction_time(Date action_time) {
		_action_time = action_time;
	}

	public String getScreen_name() {
		return _screen_name;
	}

	public void setScreen_name(String screen_name) {
		_screen_name = screen_name;
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;
	}

	public String getIp_address() {
		return _ip_address;
	}

	public void setIp_address(String ip_address) {
		_ip_address = ip_address;
	}

	public String getEvent_type() {
		return _event_type;
	}

	public void setEvent_type(String event_type) {
		_event_type = event_type;
	}

	private long _id;
	private Date _action_time;
	private String _screen_name;
	private long _user_id;
	private String _ip_address;
	private String _event_type;
}