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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AmfRegistrationAuditLog. This utility wraps
 * {@link com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogService
 * @see com.liferay.docs.amf.registration.sb.service.base.AmfRegistrationAuditLogServiceBaseImpl
 * @see com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogServiceImpl
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hasPermissionVIEW_ALL_USER_EVENTS(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().hasPermissionVIEW_ALL_USER_EVENTS(serviceContext);
	}

	public static int countByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().countByLoginLogout(serviceContext);
	}

	public static int countByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().countByRegistration(serviceContext);
	}

	public static int countUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().countUsers(serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().findByLoginLogout(serviceContext, start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().findByRegistration(serviceContext, start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().findUsers(serviceContext, start, end);
	}

	public static AmfRegistrationAuditLogService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfRegistrationAuditLogService, AmfRegistrationAuditLogService> _serviceTracker =
		ServiceTrackerFactory.open(AmfRegistrationAuditLogService.class);
}