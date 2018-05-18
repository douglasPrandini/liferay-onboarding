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

package com.liferay.docs.amf.registration.sb.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AmfRegistrationAuditLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogService
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogServiceWrapper
	implements AmfRegistrationAuditLogService,
		ServiceWrapper<AmfRegistrationAuditLogService> {
	public AmfRegistrationAuditLogServiceWrapper(
		AmfRegistrationAuditLogService amfRegistrationAuditLogService) {
		_amfRegistrationAuditLogService = amfRegistrationAuditLogService;
	}

	@Override
	public boolean hasPermissionVIEW_ALL_USER_EVENTS(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {
		return _amfRegistrationAuditLogService.hasPermissionVIEW_ALL_USER_EVENTS(serviceContext);
	}

	@Override
	public int countByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.countByLoginLogout(serviceContext);
	}

	@Override
	public int countByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.countByRegistration(serviceContext);
	}

	@Override
	public int countUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.countUsers(serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfRegistrationAuditLogService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.findByLoginLogout(serviceContext,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.findByRegistration(serviceContext,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationAuditLogService.findUsers(serviceContext, start,
			end);
	}

	@Override
	public AmfRegistrationAuditLogService getWrappedService() {
		return _amfRegistrationAuditLogService;
	}

	@Override
	public void setWrappedService(
		AmfRegistrationAuditLogService amfRegistrationAuditLogService) {
		_amfRegistrationAuditLogService = amfRegistrationAuditLogService;
	}

	private AmfRegistrationAuditLogService _amfRegistrationAuditLogService;
}