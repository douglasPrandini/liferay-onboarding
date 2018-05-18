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

package com.liferay.docs.amf.registration.sb.service.impl;

import com.liferay.docs.amf.registration.sb.enums.ActionType;
import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;
import com.liferay.docs.amf.registration.sb.service.base.AmfRegistrationAuditLogServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the amf registration audit log remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogServiceBaseImpl
 * @see com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogServiceUtil
 */
public class AmfRegistrationAuditLogServiceImpl
	extends AmfRegistrationAuditLogServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogServiceUtil} to access the amf registration audit log remote service.
	 */

	private static final String VIEW_ALL_USER_EVENTS = "VIEW_ALL_USER_EVENTS";
	private static final long CLASS_PK = 0;

	public List<AmfRegistrationAuditLog> findUsers(ServiceContext serviceContext, int start, int end) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			return amfRegistrationAuditLogLocalService.getAmfRegistrationAuditLogs(start, end);
		} else {
			return amfRegistrationAuditLogPersistence.findByuser_id(serviceContext.getGuestOrUserId(), start, end);
		}
	}

	public List<AmfRegistrationAuditLog> findByRegistration(ServiceContext serviceContext, int start, int end) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			return amfRegistrationAuditLogPersistence.findByevent_type(ActionType.REGISTRATION.toString(), start, end);
		} else {
			return amfRegistrationAuditLogPersistence.findByEventTypeAndUserId(ActionType.REGISTRATION.toString(), serviceContext.getGuestOrUserId(), start, end);
		}
	}

	public List<AmfRegistrationAuditLog> findByLoginLogout(ServiceContext serviceContext, int start, int end) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
			return amfRegistrationAuditLogPersistence.findByevent_type(loginLogout , start, end);
		} else {
			String[] loginLogout = {ActionType.LOGIN.toString(), ActionType.LOGOUT.toString()};
			return amfRegistrationAuditLogPersistence.findByEventTypeAndUserId(loginLogout, serviceContext.getGuestOrUserId(), start, end);
		}
	}

	public int countUsers(ServiceContext serviceContext) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			return amfRegistrationAuditLogLocalService.getAmfRegistrationAuditLogsCount();
		} else {
			return amfRegistrationAuditLogPersistence.countByuser_id(serviceContext.getGuestOrUserId());
		}
	}

	public int countByRegistration(ServiceContext serviceContext) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			return amfRegistrationAuditLogPersistence.countByevent_type(ActionType.REGISTRATION.toString());
		} else {
			return amfRegistrationAuditLogPersistence.countByEventTypeAndUserId(ActionType.REGISTRATION.toString(), serviceContext.getGuestOrUserId());
		}
	}

	public int countByLoginLogout(ServiceContext serviceContext) throws PortalException {
		if(hasPermissionVIEW_ALL_USER_EVENTS(serviceContext)) {
			String[] loginLogout = { ActionType.LOGIN.toString(), ActionType.LOGOUT.toString() };
			return amfRegistrationAuditLogPersistence.countByevent_type(loginLogout);
		} else {
			String[] loginLogout = {ActionType.LOGIN.toString(), ActionType.LOGOUT.toString()};
			return amfRegistrationAuditLogPersistence.countByEventTypeAndUserId(loginLogout, serviceContext.getGuestOrUserId());
		}
	}

	public boolean hasPermissionVIEW_ALL_USER_EVENTS(ServiceContext serviceContext) throws PrincipalException {
		return getPermissionChecker().hasPermission(
				serviceContext.getScopeGroupId(),
				serviceContext.getRootPortletId(),
				CLASS_PK, VIEW_ALL_USER_EVENTS);
	}
}