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

package com.liferay.docs.amf.registration.sb.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link AmfRegistrationAuditLogServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog}, that is translated to a
 * {@link com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogServiceHttp
 * @see com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap
 * @see AmfRegistrationAuditLogServiceUtil
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogServiceSoap {
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap[] findUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> returnValue =
				AmfRegistrationAuditLogServiceUtil.findUsers(serviceContext,
					start, end);

			return com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap[] findByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> returnValue =
				AmfRegistrationAuditLogServiceUtil.findByRegistration(serviceContext,
					start, end);

			return com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap[] findByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> returnValue =
				AmfRegistrationAuditLogServiceUtil.findByLoginLogout(serviceContext,
					start, end);

			return com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countUsers(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AmfRegistrationAuditLogServiceUtil.countUsers(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByRegistration(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AmfRegistrationAuditLogServiceUtil.countByRegistration(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByLoginLogout(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = AmfRegistrationAuditLogServiceUtil.countByLoginLogout(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasPermissionVIEW_ALL_USER_EVENTS(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = AmfRegistrationAuditLogServiceUtil.hasPermissionVIEW_ALL_USER_EVENTS(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AmfRegistrationAuditLogServiceSoap.class);
}