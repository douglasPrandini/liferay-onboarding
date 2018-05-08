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

import com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException;
import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the amf registration audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.amf.registration.sb.service.persistence.impl.AmfRegistrationAuditLogPersistenceImpl
 * @see AmfRegistrationAuditLogUtil
 * @generated
 */
@ProviderType
public interface AmfRegistrationAuditLogPersistence extends BasePersistence<AmfRegistrationAuditLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmfRegistrationAuditLogUtil} to access the amf registration audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the amf registration audit logs where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findByuser_id(long user_id);

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
	public java.util.List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByuser_id(long user_id,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByuser_id_First(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByuser_id_First(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByuser_id_Last(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByuser_id_Last(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where user_id = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog[] findByuser_id_PrevAndNext(long id,
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Removes all the amf registration audit logs where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	*/
	public void removeByuser_id(long user_id);

	/**
	* Returns the number of amf registration audit logs where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public int countByuser_id(long user_id);

	/**
	* Returns all the amf registration audit logs where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @return the matching amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name);

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
	public java.util.List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByscreen_name(
		java.lang.String screen_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByscreen_name_First(
		java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByscreen_name_First(
		java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByscreen_name_Last(
		java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByscreen_name_Last(
		java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where screen_name = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog[] findByscreen_name_PrevAndNext(long id,
		java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Removes all the amf registration audit logs where screen_name = &#63; from the database.
	*
	* @param screen_name the screen_name
	*/
	public void removeByscreen_name(java.lang.String screen_name);

	/**
	* Returns the number of amf registration audit logs where screen_name = &#63;.
	*
	* @param screen_name the screen_name
	* @return the number of matching amf registration audit logs
	*/
	public int countByscreen_name(java.lang.String screen_name);

	/**
	* Returns all the amf registration audit logs where event_type = &#63;.
	*
	* @param event_type the event_type
	* @return the matching amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String event_type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByevent_type_First(
		java.lang.String event_type,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByevent_type_First(
		java.lang.String event_type,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByevent_type_Last(
		java.lang.String event_type,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByevent_type_Last(
		java.lang.String event_type,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63;.
	*
	* @param id the primary key of the current amf registration audit log
	* @param event_type the event_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog[] findByevent_type_PrevAndNext(long id,
		java.lang.String event_type,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByevent_type(
		java.lang.String[] event_types, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf registration audit logs where event_type = &#63; from the database.
	*
	* @param event_type the event_type
	*/
	public void removeByevent_type(java.lang.String event_type);

	/**
	* Returns the number of amf registration audit logs where event_type = &#63;.
	*
	* @param event_type the event_type
	* @return the number of matching amf registration audit logs
	*/
	public int countByevent_type(java.lang.String event_type);

	/**
	* Returns the number of amf registration audit logs where event_type = any &#63;.
	*
	* @param event_types the event_types
	* @return the number of matching amf registration audit logs
	*/
	public int countByevent_type(java.lang.String[] event_types);

	/**
	* Returns all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @return the matching amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		java.lang.String event_type, java.lang.String screen_name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByEventTypeAndUserName_First(
		java.lang.String event_type, java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByEventTypeAndUserName_First(
		java.lang.String event_type, java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByEventTypeAndUserName_Last(
		java.lang.String event_type, java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByEventTypeAndUserName_Last(
		java.lang.String event_type, java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public AmfRegistrationAuditLog[] findByEventTypeAndUserName_PrevAndNext(
		long id, java.lang.String event_type, java.lang.String screen_name,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Removes all the amf registration audit logs where event_type = &#63; and screen_name = &#63; from the database.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	*/
	public void removeByEventTypeAndUserName(java.lang.String event_type,
		java.lang.String screen_name);

	/**
	* Returns the number of amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	*
	* @param event_type the event_type
	* @param screen_name the screen_name
	* @return the number of matching amf registration audit logs
	*/
	public int countByEventTypeAndUserName(java.lang.String event_type,
		java.lang.String screen_name);

	/**
	* Returns all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @return the matching amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String event_type, long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByEventTypeAndUserId_First(
		java.lang.String event_type, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByEventTypeAndUserId_First(
		java.lang.String event_type, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog findByEventTypeAndUserId_Last(
		java.lang.String event_type, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	*/
	public AmfRegistrationAuditLog fetchByEventTypeAndUserId_Last(
		java.lang.String event_type, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public AmfRegistrationAuditLog[] findByEventTypeAndUserId_PrevAndNext(
		long id, java.lang.String event_type, long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException;

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		java.lang.String[] event_types, long user_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf registration audit logs where event_type = &#63; and user_id = &#63; from the database.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	*/
	public void removeByEventTypeAndUserId(java.lang.String event_type,
		long user_id);

	/**
	* Returns the number of amf registration audit logs where event_type = &#63; and user_id = &#63;.
	*
	* @param event_type the event_type
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public int countByEventTypeAndUserId(java.lang.String event_type,
		long user_id);

	/**
	* Returns the number of amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	*
	* @param event_types the event_types
	* @param user_id the user_id
	* @return the number of matching amf registration audit logs
	*/
	public int countByEventTypeAndUserId(java.lang.String[] event_types,
		long user_id);

	/**
	* Caches the amf registration audit log in the entity cache if it is enabled.
	*
	* @param amfRegistrationAuditLog the amf registration audit log
	*/
	public void cacheResult(AmfRegistrationAuditLog amfRegistrationAuditLog);

	/**
	* Caches the amf registration audit logs in the entity cache if it is enabled.
	*
	* @param amfRegistrationAuditLogs the amf registration audit logs
	*/
	public void cacheResult(
		java.util.List<AmfRegistrationAuditLog> amfRegistrationAuditLogs);

	/**
	* Creates a new amf registration audit log with the primary key. Does not add the amf registration audit log to the database.
	*
	* @param id the primary key for the new amf registration audit log
	* @return the new amf registration audit log
	*/
	public AmfRegistrationAuditLog create(long id);

	/**
	* Removes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log that was removed
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog remove(long id)
		throws NoSuchAmfRegistrationAuditLogException;

	public AmfRegistrationAuditLog updateImpl(
		AmfRegistrationAuditLog amfRegistrationAuditLog);

	/**
	* Returns the amf registration audit log with the primary key or throws a {@link NoSuchAmfRegistrationAuditLogException} if it could not be found.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log
	* @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog findByPrimaryKey(long id)
		throws NoSuchAmfRegistrationAuditLogException;

	/**
	* Returns the amf registration audit log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the amf registration audit log
	* @return the amf registration audit log, or <code>null</code> if a amf registration audit log with the primary key could not be found
	*/
	public AmfRegistrationAuditLog fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, AmfRegistrationAuditLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the amf registration audit logs.
	*
	* @return the amf registration audit logs
	*/
	public java.util.List<AmfRegistrationAuditLog> findAll();

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
	public java.util.List<AmfRegistrationAuditLog> findAll(int start, int end);

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
	public java.util.List<AmfRegistrationAuditLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator);

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
	public java.util.List<AmfRegistrationAuditLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf registration audit logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of amf registration audit logs.
	*
	* @return the number of amf registration audit logs
	*/
	public int countAll();
}