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
 * Provides a wrapper for {@link AmfRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationLocalService
 * @generated
 */
@ProviderType
public class AmfRegistrationLocalServiceWrapper
	implements AmfRegistrationLocalService,
		ServiceWrapper<AmfRegistrationLocalService> {
	public AmfRegistrationLocalServiceWrapper(
		AmfRegistrationLocalService amfRegistrationLocalService) {
		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	/**
	* Adds the amf registration to the database. Also notifies the appropriate model listeners.
	*
	* @param amfRegistration the amf registration
	* @return the amf registration that was added
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration addAmfRegistration(
		com.liferay.docs.amf.registration.sb.model.AmfRegistration amfRegistration) {
		return _amfRegistrationLocalService.addAmfRegistration(amfRegistration);
	}

	/**
	* Creates a new amf registration with the primary key. Does not add the amf registration to the database.
	*
	* @param dummy the primary key for the new amf registration
	* @return the new amf registration
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration createAmfRegistration(
		long dummy) {
		return _amfRegistrationLocalService.createAmfRegistration(dummy);
	}

	/**
	* Deletes the amf registration from the database. Also notifies the appropriate model listeners.
	*
	* @param amfRegistration the amf registration
	* @return the amf registration that was removed
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration deleteAmfRegistration(
		com.liferay.docs.amf.registration.sb.model.AmfRegistration amfRegistration) {
		return _amfRegistrationLocalService.deleteAmfRegistration(amfRegistration);
	}

	/**
	* Deletes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummy the primary key of the amf registration
	* @return the amf registration that was removed
	* @throws PortalException if a amf registration with the primary key could not be found
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration deleteAmfRegistration(
		long dummy) throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationLocalService.deleteAmfRegistration(dummy);
	}

	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration fetchAmfRegistration(
		long dummy) {
		return _amfRegistrationLocalService.fetchAmfRegistration(dummy);
	}

	/**
	* Returns the amf registration with the primary key.
	*
	* @param dummy the primary key of the amf registration
	* @return the amf registration
	* @throws PortalException if a amf registration with the primary key could not be found
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration getAmfRegistration(
		long dummy) throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationLocalService.getAmfRegistration(dummy);
	}

	/**
	* Updates the amf registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfRegistration the amf registration
	* @return the amf registration that was updated
	*/
	@Override
	public com.liferay.docs.amf.registration.sb.model.AmfRegistration updateAmfRegistration(
		com.liferay.docs.amf.registration.sb.model.AmfRegistration amfRegistration) {
		return _amfRegistrationLocalService.updateAmfRegistration(amfRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _amfRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfRegistrationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _amfRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.service.ServiceContext getServiceContext() {
		return _amfRegistrationLocalService.getServiceContext();
	}

	@Override
	public int countByUsersByZip(int zipCode) {
		return _amfRegistrationLocalService.countByUsersByZip(zipCode);
	}

	/**
	* Returns the number of amf registrations.
	*
	* @return the number of amf registrations
	*/
	@Override
	public int getAmfRegistrationsCount() {
		return _amfRegistrationLocalService.getAmfRegistrationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfRegistrationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _amfRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _amfRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _amfRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.dto.UserDTO> findByUsersByZip(
		int zipCode, int start, int end) {
		return _amfRegistrationLocalService.findByUsersByZip(zipCode, start, end);
	}

	/**
	* Returns a range of all the amf registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf registrations
	* @param end the upper bound of the range of amf registrations (not inclusive)
	* @return the range of amf registrations
	*/
	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.model.AmfRegistration> getAmfRegistrations(
		int start, int end) {
		return _amfRegistrationLocalService.getAmfRegistrations(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _amfRegistrationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _amfRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public void addNewAccount(
		com.liferay.docs.amf.registration.sb.dto.RegistrationDto registrationDto)
		throws com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException {
		_amfRegistrationLocalService.addNewAccount(registrationDto);
	}

	@Override
	public void setServiceContext(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		_amfRegistrationLocalService.setServiceContext(serviceContext);
	}

	@Override
	public AmfRegistrationLocalService getWrappedService() {
		return _amfRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		AmfRegistrationLocalService amfRegistrationLocalService) {
		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	private AmfRegistrationLocalService _amfRegistrationLocalService;
}