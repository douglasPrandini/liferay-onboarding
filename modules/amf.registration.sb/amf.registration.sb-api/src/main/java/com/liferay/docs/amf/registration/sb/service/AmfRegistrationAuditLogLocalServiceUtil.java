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
 * Provides the local service utility for AmfRegistrationAuditLog. This utility wraps
 * {@link com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogLocalService
 * @see com.liferay.docs.amf.registration.sb.service.base.AmfRegistrationAuditLogLocalServiceBaseImpl
 * @see com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogLocalServiceImpl
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the amf registration audit log to the database. Also notifies the appropriate model listeners.
	*
	* @param amfRegistrationAuditLog the amf registration audit log
	* @return the amf registration audit log that was added
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog addAmfRegistrationAuditLog(
		com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return getService().addAmfRegistrationAuditLog(amfRegistrationAuditLog);
	}

	/**
	* Creates a new amf registration audit log with the primary key. Does not add the amf registration audit log to the database.
	*
	* @param id the primary key for the new amf registration audit log
	* @return the new amf registration audit log
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog createAmfRegistrationAuditLog(
		long id) {
		return getService().createAmfRegistrationAuditLog(id);
	}

	/**
	* Deletes the amf registration audit log from the database. Also notifies the appropriate model listeners.
	*
	* @param amfRegistrationAuditLog the amf registration audit log
	* @return the amf registration audit log that was removed
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog deleteAmfRegistrationAuditLog(
		com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return getService()
				   .deleteAmfRegistrationAuditLog(amfRegistrationAuditLog);
	}

	/**
	* Deletes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log that was removed
	* @throws PortalException if a amf registration audit log with the primary key could not be found
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog deleteAmfRegistrationAuditLog(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAmfRegistrationAuditLog(id);
	}

	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog fetchAmfRegistrationAuditLog(
		long id) {
		return getService().fetchAmfRegistrationAuditLog(id);
	}

	/**
	* Returns the amf registration audit log with the primary key.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log
	* @throws PortalException if a amf registration audit log with the primary key could not be found
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog getAmfRegistrationAuditLog(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAmfRegistrationAuditLog(id);
	}

	/**
	* Updates the amf registration audit log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfRegistrationAuditLog the amf registration audit log
	* @return the amf registration audit log that was updated
	*/
	public static com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog updateAmfRegistrationAuditLog(
		com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return getService()
				   .updateAmfRegistrationAuditLog(amfRegistrationAuditLog);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int countByLoginLogout() {
		return getService().countByLoginLogout();
	}

	public static int countByLoginLogout(long userId) {
		return getService().countByLoginLogout(userId);
	}

	public static int countByRegistration() {
		return getService().countByRegistration();
	}

	public static int countByRegistration(long userId) {
		return getService().countByRegistration(userId);
	}

	public static int countByUserId(long userId) {
		return getService().countByUserId(userId);
	}

	/**
	* Returns the number of amf registration audit logs.
	*
	* @return the number of amf registration audit logs
	*/
	public static int getAmfRegistrationAuditLogsCount() {
		return getService().getAmfRegistrationAuditLogsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByLoginLogout(
		int start, int end) {
		return getService().findByLoginLogout(start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByLoginLogout(
		long userId, int start, int end) {
		return getService().findByLoginLogout(userId, start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByRegistration(
		int start, int end) {
		return getService().findByRegistration(start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByRegistration(
		long userId, int start, int end) {
		return getService().findByRegistration(userId, start, end);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByUserId(
		long userId) {
		return getService().findByUserId(userId);
	}

	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> findByUserId(
		long userId, int start, int end) {
		return getService().findByUserId(userId, start, end);
	}

	/**
	* Returns a range of all the amf registration audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of amf registration audit logs
	*/
	public static java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog> getAmfRegistrationAuditLogs(
		int start, int end) {
		return getService().getAmfRegistrationAuditLogs(start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.model.User> getUsers(
		int zipCode, int start, int end) {
		return getService().getUsers(zipCode, start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void addNewRegister(
		com.liferay.docs.amf.registration.sb.dto.AmfRegistrationAuditLogDTO amfRegistrationAuditLogDTO) {
		getService().addNewRegister(amfRegistrationAuditLogDTO);
	}

	public static AmfRegistrationAuditLogLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfRegistrationAuditLogLocalService, AmfRegistrationAuditLogLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AmfRegistrationAuditLogLocalService.class);
}