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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AmfRegistrationAuditLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLog
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogCacheModel implements CacheModel<AmfRegistrationAuditLog>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmfRegistrationAuditLogCacheModel)) {
			return false;
		}

		AmfRegistrationAuditLogCacheModel amfRegistrationAuditLogCacheModel = (AmfRegistrationAuditLogCacheModel)obj;

		if (id == amfRegistrationAuditLogCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", action_time=");
		sb.append(action_time);
		sb.append(", screen_name=");
		sb.append(screen_name);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", ip_address=");
		sb.append(ip_address);
		sb.append(", event_type=");
		sb.append(event_type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AmfRegistrationAuditLog toEntityModel() {
		AmfRegistrationAuditLogImpl amfRegistrationAuditLogImpl = new AmfRegistrationAuditLogImpl();

		amfRegistrationAuditLogImpl.setId(id);

		if (action_time == Long.MIN_VALUE) {
			amfRegistrationAuditLogImpl.setAction_time(null);
		}
		else {
			amfRegistrationAuditLogImpl.setAction_time(new Date(action_time));
		}

		if (screen_name == null) {
			amfRegistrationAuditLogImpl.setScreen_name(StringPool.BLANK);
		}
		else {
			amfRegistrationAuditLogImpl.setScreen_name(screen_name);
		}

		amfRegistrationAuditLogImpl.setUser_id(user_id);

		if (ip_address == null) {
			amfRegistrationAuditLogImpl.setIp_address(StringPool.BLANK);
		}
		else {
			amfRegistrationAuditLogImpl.setIp_address(ip_address);
		}

		if (event_type == null) {
			amfRegistrationAuditLogImpl.setEvent_type(StringPool.BLANK);
		}
		else {
			amfRegistrationAuditLogImpl.setEvent_type(event_type);
		}

		amfRegistrationAuditLogImpl.resetOriginalValues();

		return amfRegistrationAuditLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		action_time = objectInput.readLong();
		screen_name = objectInput.readUTF();

		user_id = objectInput.readLong();
		ip_address = objectInput.readUTF();
		event_type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(action_time);

		if (screen_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screen_name);
		}

		objectOutput.writeLong(user_id);

		if (ip_address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip_address);
		}

		if (event_type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(event_type);
		}
	}

	public long id;
	public long action_time;
	public String screen_name;
	public long user_id;
	public String ip_address;
	public String event_type;
}