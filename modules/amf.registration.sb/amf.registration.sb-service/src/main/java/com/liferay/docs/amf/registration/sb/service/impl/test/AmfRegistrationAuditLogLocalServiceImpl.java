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

package com.liferay.docs.amf.registration.sb.service.impl.test;

import com.liferay.docs.amf.registration.sb.dto.AmfRegistrationAuditLogDTO;
import com.liferay.docs.amf.registration.sb.enums.ActionType;
import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;
import com.liferay.docs.amf.registration.sb.service.base.AmfRegistrationAuditLogLocalServiceBaseImpl;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationAuditLogUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the amf registration audit log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogLocalServiceBaseImpl
 * @see com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil
 */
public class AmfRegistrationAuditLogLocalServiceImpl
	extends AmfRegistrationAuditLogLocalServiceBaseImpl {

	public void addNewRegister(AmfRegistrationAuditLogDTO amfRegistrationAuditLogDTO) {

		AmfRegistrationAuditLog amfRegistrationAuditLog = amfRegistrationAuditLogPersistence.create(0);

		amfRegistrationAuditLog.setAction_time(new Date());
		amfRegistrationAuditLog.setScreen_name(amfRegistrationAuditLogDTO.getScreen_name());
		amfRegistrationAuditLog.setUser_id(amfRegistrationAuditLogDTO.getUser_id());
		amfRegistrationAuditLog.setIp_address(amfRegistrationAuditLogDTO.getIp_address());
		amfRegistrationAuditLog.setEvent_type(amfRegistrationAuditLogDTO.getEvent_type());

		amfRegistrationAuditLogPersistence.update(amfRegistrationAuditLog);
	}



	public List<AmfRegistrationAuditLog> findByUserId(long userId) {
		return AmfRegistrationAuditLogUtil.findByuser_id(userId);
	}

	public List<AmfRegistrationAuditLog> findByUserId(long userId, int start, int end) {
		return AmfRegistrationAuditLogUtil.findByuser_id(userId, start, end);
	}

	public List<AmfRegistrationAuditLog> findByRegistration(int start, int end) {
		return AmfRegistrationAuditLogUtil.findByevent_type(ActionType.REGISTRATION.toString(), start, end);
	}

	public List<AmfRegistrationAuditLog> findByRegistration(long userId, int start, int end) {
		return AmfRegistrationAuditLogUtil.findByEventTypeAndUserId(ActionType.REGISTRATION.toString(), userId, start, end);
	}

	public List<AmfRegistrationAuditLog> findByLoginLogout(int start, int end) {
		String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
		return AmfRegistrationAuditLogUtil.findByevent_type(loginLogout , start, end);
	}

	public List<AmfRegistrationAuditLog> findByLoginLogout(long userId, int start, int end) {
		String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
		return AmfRegistrationAuditLogUtil.findByEventTypeAndUserId(loginLogout, userId, start, end);
	}

	public int countByUserId(long userId) {
		return AmfRegistrationAuditLogUtil.countByuser_id(userId);
	}

	public int countByRegistration() {
		return AmfRegistrationAuditLogUtil.countByevent_type(ActionType.REGISTRATION.toString());
	}

	public int countByRegistration(long userId) {
		return AmfRegistrationAuditLogUtil.countByEventTypeAndUserId(ActionType.REGISTRATION.toString(), userId);
	}

	public int countByLoginLogout() {
		String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
		return AmfRegistrationAuditLogUtil.countByevent_type(loginLogout);
	}

	public int countByLoginLogout(long userId) {
		String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
		return AmfRegistrationAuditLogUtil.countByEventTypeAndUserId(loginLogout, userId);
	}


}