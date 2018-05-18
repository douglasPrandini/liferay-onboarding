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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AmfRegistrationAuditLogServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogServiceSoap
 * @see HttpPrincipal
 * @see AmfRegistrationAuditLogServiceUtil
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogServiceHttp {
	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findUsers(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"findUsers", _findUsersParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByRegistration(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"findByRegistration", _findByRegistrationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByLoginLogout(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"findByLoginLogout", _findByLoginLogoutParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countUsers(HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"countUsers", _countUsersParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countByRegistration(HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"countByRegistration", _countByRegistrationParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countByLoginLogout(HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"countByLoginLogout", _countByLoginLogoutParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean hasPermissionVIEW_ALL_USER_EVENTS(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(AmfRegistrationAuditLogServiceUtil.class,
					"hasPermissionVIEW_ALL_USER_EVENTS",
					_hasPermissionVIEW_ALL_USER_EVENTSParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AmfRegistrationAuditLogServiceHttp.class);
	private static final Class<?>[] _findUsersParameterTypes0 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class,
			int.class
		};
	private static final Class<?>[] _findByRegistrationParameterTypes1 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class,
			int.class
		};
	private static final Class<?>[] _findByLoginLogoutParameterTypes2 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class,
			int.class
		};
	private static final Class<?>[] _countUsersParameterTypes3 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _countByRegistrationParameterTypes4 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _countByLoginLogoutParameterTypes5 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _hasPermissionVIEW_ALL_USER_EVENTSParameterTypes6 =
		new Class[] { com.liferay.portal.kernel.service.ServiceContext.class };
}