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

import com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationException;
import com.liferay.docs.amf.registration.sb.model.AmfRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the amf registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.amf.registration.sb.service.persistence.impl.AmfRegistrationPersistenceImpl
 * @see AmfRegistrationUtil
 * @generated
 */
@ProviderType
public interface AmfRegistrationPersistence extends BasePersistence<AmfRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmfRegistrationUtil} to access the amf registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the amf registration in the entity cache if it is enabled.
	*
	* @param amfRegistration the amf registration
	*/
	public void cacheResult(AmfRegistration amfRegistration);

	/**
	* Caches the amf registrations in the entity cache if it is enabled.
	*
	* @param amfRegistrations the amf registrations
	*/
	public void cacheResult(java.util.List<AmfRegistration> amfRegistrations);

	/**
	* Creates a new amf registration with the primary key. Does not add the amf registration to the database.
	*
	* @param dummy the primary key for the new amf registration
	* @return the new amf registration
	*/
	public AmfRegistration create(long dummy);

	/**
	* Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummy the primary key of the amf registration
	* @return the amf registration that was removed
	* @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	*/
	public AmfRegistration remove(long dummy)
		throws NoSuchAmfRegistrationException;

	public AmfRegistration updateImpl(AmfRegistration amfRegistration);

	/**
	* Returns the amf registration with the primary key or throws a {@link NoSuchAmfRegistrationException} if it could not be found.
	*
	* @param dummy the primary key of the amf registration
	* @return the amf registration
	* @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	*/
	public AmfRegistration findByPrimaryKey(long dummy)
		throws NoSuchAmfRegistrationException;

	/**
	* Returns the amf registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummy the primary key of the amf registration
	* @return the amf registration, or <code>null</code> if a amf registration with the primary key could not be found
	*/
	public AmfRegistration fetchByPrimaryKey(long dummy);

	@Override
	public java.util.Map<java.io.Serializable, AmfRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the amf registrations.
	*
	* @return the amf registrations
	*/
	public java.util.List<AmfRegistration> findAll();

	/**
	* Returns a range of all the amf registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registrations
	* @param end the upper bound of the range of amf registrations (not inclusive)
	* @return the range of amf registrations
	*/
	public java.util.List<AmfRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the amf registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registrations
	* @param end the upper bound of the range of amf registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amf registrations
	*/
	public java.util.List<AmfRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the amf registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registrations
	* @param end the upper bound of the range of amf registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amf registrations
	*/
	public java.util.List<AmfRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of amf registrations.
	*
	* @return the number of amf registrations
	*/
	public int countAll();
}