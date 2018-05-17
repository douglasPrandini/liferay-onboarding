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

	@Override
	public com.liferay.portal.kernel.service.ServiceContext getServiceContext() {
		return _amfRegistrationLocalService.getServiceContext();
	}

	@Override
	public int countByUsersByZip(int zipCode) {
		return _amfRegistrationLocalService.countByUsersByZip(zipCode);
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

	@Override
	public java.util.List<com.liferay.docs.amf.registration.sb.dto.UserDTO> findByUsersByZip(
		int zipCode, int start, int end) {
		return _amfRegistrationLocalService.findByUsersByZip(zipCode, start, end);
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