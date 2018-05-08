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

package com.liferay.docs.amf.registration.sb.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the amf registration audit log service. This utility wraps {@link com.liferay.docs.amf.registration.sb.service.persistence.impl.AmfRegistrationAuditLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogPersistence
 * @see com.liferay.docs.amf.registration.sb.service.persistence.impl.AmfRegistrationAuditLogPersistenceImpl
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		getPersistence().clearCache(amfRegistrationAuditLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AmfRegistrationAuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmfRegistrationAuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmfRegistrationAuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmfRegistrationAuditLog update(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return getPersistence().update(amfRegistrationAuditLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmfRegistrationAuditLog update(
		AmfRegistrationAuditLog amfRegistrationAuditLog,
		ServiceContext serviceContext) {
		return getPersistence().update(amfRegistrationAuditLog, serviceContext);
	}

	/**
	* Returns all the amf registration audit logs where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByuser_id(long user_id) {
		return getPersistence().findByuser_id(user_id);
	}

	/**
	* Returns a range of all the amf registration audit logs where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end) {
		return getPersistence().findByuser_id(user_id, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByuser_id(user_id, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByuser_id(user_id, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByuser_id_First(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence().findByuser_id_First(user_id, orderByComparator);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByuser_id_First(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence().fetchByuser_id_First(user_id, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByuser_id_Last(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence().findByuser_id_Last(user_id, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByuser_id_Last(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence().fetchByuser_id_Last(user_id, orderByComparator);
	}

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog[] findByuser_id_PrevAndNext(long id,
		long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByuser_id_PrevAndNext(id, user_id, orderByComparator);
	}

	/**
	* Removes all the amf registration audit logs where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	*/
	public static void removeByuser_id(long user_id) {
		getPersistence().removeByuser_id(user_id);
	}

	/**
	* Returns the number of amf registration audit logs where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public static int countByuser_id(long user_id) {
		return getPersistence().countByuser_id(user_id);
	}

	/**
	* Returns all the amf registration audit logs where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name) {
		return getPersistence().findByscreen_name(screen_name);
	}

	/**
	* Returns a range of all the amf registration audit logs where screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end) {
		return getPersistence().findByscreen_name(screen_name, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByscreen_name(screen_name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByscreen_name(screen_name, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByscreen_name_First(
		java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByscreen_name_First(screen_name, orderByComparator);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByscreen_name_First(
		java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByscreen_name_First(screen_name, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByscreen_name_Last(
		java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByscreen_name_Last(screen_name, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByscreen_name_Last(
		java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByscreen_name_Last(screen_name, orderByComparator);
	}

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog[] findByscreen_name_PrevAndNext(
		long id, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByscreen_name_PrevAndNext(id, screen_name,
			orderByComparator);
	}

	/**
	* Removes all the amf registration audit logs where screen_name = &#63; from the database.
	*
	* @param screen_name the screen_name
	*/
	public static void removeByscreen_name(java.lang.String screen_name) {
		getPersistence().removeByscreen_name(screen_name);
	}

	/**
	* Returns the number of amf registration audit logs where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @return the number of matching amf registration audit logs
	*/
	public static int countByscreen_name(java.lang.String screen_name) {
		return getPersistence().countByscreen_name(screen_name);
	}

	/**
	* Returns all the amf registration audit logs where event_type = &#63;.
	*
	* @param event_type the event_type
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type) {
		return getPersistence().findByevent_type(event_type);
	}

	/**
	* Returns a range of all the amf registration audit logs where event_type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end) {
		return getPersistence().findByevent_type(event_type, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByevent_type(event_type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByevent_type(event_type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByevent_type_First(
		java.lang.String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByevent_type_First(event_type, orderByComparator);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByevent_type_First(
		java.lang.String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByevent_type_First(event_type, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByevent_type_Last(
		java.lang.String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByevent_type_Last(event_type, orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByevent_type_Last(
		java.lang.String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByevent_type_Last(event_type, orderByComparator);
	}

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog[] findByevent_type_PrevAndNext(
		long id, java.lang.String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByevent_type_PrevAndNext(id, event_type,
			orderByComparator);
	}

	/**
	* Returns all the amf registration audit logs where event_type = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types) {
		return getPersistence().findByevent_type(event_types);
	}

	/**
	* Returns a range of all the amf registration audit logs where event_type = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end) {
		return getPersistence().findByevent_type(event_types, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByevent_type(event_types, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByevent_type(event_types, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amf registration audit logs where event_type = &#63; from the database.
	*
	* @param event_type the event_type
	*/
	public static void removeByevent_type(java.lang.String event_type) {
		getPersistence().removeByevent_type(event_type);
	}

	/**
	* Returns the number of amf registration audit logs where event_type = &#63;.
	*
	* @param event_type the event_type
	* @return the number of matching amf registration audit logs
	*/
	public static int countByevent_type(java.lang.String event_type) {
		return getPersistence().countByevent_type(event_type);
	}

	/**
	* Returns the number of amf registration audit logs where event_type = any &#63;.
	*
	* @param event_types the event_types
	* @return the number of matching amf registration audit logs
	*/
	public static int countByevent_type(java.lang.String[] event_types) {
		return getPersistence().countByevent_type(event_types);
	}

	/**
	* Returns all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name) {
		return getPersistence()
				   .findByEventTypeAndUserName(event_type, screen_name);
	}

	/**
	* Returns a range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end) {
		return getPersistence()
				   .findByEventTypeAndUserName(event_type, screen_name, start,
			end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end, OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByEventTypeAndUserName(event_type, screen_name, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end, OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventTypeAndUserName(event_type, screen_name, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByEventTypeAndUserName_First(
		java.lang.String event_type, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserName_First(event_type, screen_name,
			orderByComparator);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByEventTypeAndUserName_First(
		java.lang.String event_type, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByEventTypeAndUserName_First(event_type, screen_name,
			orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByEventTypeAndUserName_Last(
		java.lang.String event_type, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserName_Last(event_type, screen_name,
			orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByEventTypeAndUserName_Last(
		java.lang.String event_type, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByEventTypeAndUserName_Last(event_type, screen_name,
			orderByComparator);
	}

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog[] findByEventTypeAndUserName_PrevAndNext(
		long id, java.lang.String event_type, java.lang.String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserName_PrevAndNext(id, event_type,
			screen_name, orderByComparator);
	}

	/**
	* Removes all the amf registration audit logs where event_type = &#63; and screen_name = &#63; from the database.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	*/
	public static void removeByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name) {
		getPersistence().removeByEventTypeAndUserName(event_type, screen_name);
	}

	/**
	* Returns the number of amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @return the number of matching amf registration audit logs
	*/
	public static int countByEventTypeAndUserName(java.lang.String event_type,
		java.lang.String screen_name) {
		return getPersistence()
				   .countByEventTypeAndUserName(event_type, screen_name);
	}

	/**
	* Returns all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id) {
		return getPersistence().findByEventTypeAndUserId(event_type, user_id);
	}

	/**
	* Returns a range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_type, user_id, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_type, user_id, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_type, user_id, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByEventTypeAndUserId_First(
		java.lang.String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserId_First(event_type, user_id,
			orderByComparator);
	}

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByEventTypeAndUserId_First(
		java.lang.String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByEventTypeAndUserId_First(event_type, user_id,
			orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog findByEventTypeAndUserId_Last(
		java.lang.String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserId_Last(event_type, user_id,
			orderByComparator);
	}

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public static AmfRegistrationAuditLog fetchByEventTypeAndUserId_Last(
		java.lang.String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .fetchByEventTypeAndUserId_Last(event_type, user_id,
			orderByComparator);
	}

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog[] findByEventTypeAndUserId_PrevAndNext(
		long id, java.lang.String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence()
				   .findByEventTypeAndUserId_PrevAndNext(id, event_type,
			user_id, orderByComparator);
	}

	/**
	* Returns all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @param user_id the user_id
	* @return the matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id) {
		return getPersistence().findByEventTypeAndUserId(event_types, user_id);
	}

	/**
	* Returns a range of all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_types, user_id, start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_types the event_types
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_types, user_id, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventTypeAndUserId(event_types, user_id, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amf registration audit logs where event_type = &#63; and user_id = &#63; from the database.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	*/
	public static void removeByEventTypeAndUserId(java.lang.String event_type,
		long user_id) {
		getPersistence().removeByEventTypeAndUserId(event_type, user_id);
	}

	/**
	* Returns the number of amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public static int countByEventTypeAndUserId(java.lang.String event_type,
		long user_id) {
		return getPersistence().countByEventTypeAndUserId(event_type, user_id);
	}

	/**
	* Returns the number of amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	*
	* @param event_types the event_types
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public static int countByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id) {
		return getPersistence().countByEventTypeAndUserId(event_types, user_id);
	}

	/**
	* Caches the amf registration audit log in the entity cache if it is enabled.
	*
	* @param amfRegistrationAuditLog the amf registration audit log
	*/
	public static void cacheResult(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		getPersistence().cacheResult(amfRegistrationAuditLog);
	}

	/**
	* Caches the amf registration audit logs in the entity cache if it is enabled.
	*
	* @param amfRegistrationAuditLogs the amf registration audit logs
	*/
	public static void cacheResult(
		List<AmfRegistrationAuditLog> amfRegistrationAuditLogs) {
		getPersistence().cacheResult(amfRegistrationAuditLogs);
	}

	/**
	* Creates a new amf registration audit log with the primary key. Does not add the amf registration audit log to the database.
	*
	* @param id the primary key for the new amf registration audit log
	* @return the new amf registration audit log
	*/
	public static AmfRegistrationAuditLog create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log that was removed
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog remove(long id)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence().remove(id);
	}

	public static AmfRegistrationAuditLog updateImpl(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return getPersistence().updateImpl(amfRegistrationAuditLog);
	}

	/**
	* Returns the amf registration audit log with the primary key or throws a {@link NoSuchAmfRegistrationAuditLogException} if it could not be found.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog findByPrimaryKey(long id)
		throws com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the amf registration audit log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log, or <code>null</code> if a amf registration audit log with the primary key could not be found
	*/
	public static AmfRegistrationAuditLog fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, AmfRegistrationAuditLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the amf registration audit logs.
	*
	* @return the amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the amf registration audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @return the range of amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findAll(int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf registration audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registration audit logs
	* @param end the upper bound of the range of amf registration audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amf registration audit logs
	*/
	public static List<AmfRegistrationAuditLog> findAll(int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amf registration audit logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of amf registration audit logs.
	*
	* @return the number of amf registration audit logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmfRegistrationAuditLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfRegistrationAuditLogPersistence, AmfRegistrationAuditLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AmfRegistrationAuditLogPersistence.class);
}