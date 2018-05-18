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

package com.liferay.docs.amf.registration.sb.service.persistence.impl;

import com.liferay.docs.amf.registration.sb.model.AmfRegistration;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmfRegistrationFinderBaseImpl extends BasePersistenceImpl<AmfRegistration> {
	public AmfRegistrationFinderBaseImpl() {
		setModelClass(AmfRegistration.class);
	}

	/**
	 * Returns the amf registration persistence.
	 *
	 * @return the amf registration persistence
	 */
	public AmfRegistrationPersistence getAmfRegistrationPersistence() {
		return amfRegistrationPersistence;
	}

	/**
	 * Sets the amf registration persistence.
	 *
	 * @param amfRegistrationPersistence the amf registration persistence
	 */
	public void setAmfRegistrationPersistence(
		AmfRegistrationPersistence amfRegistrationPersistence) {
		this.amfRegistrationPersistence = amfRegistrationPersistence;
	}

	@BeanReference(type = AmfRegistrationPersistence.class)
	protected AmfRegistrationPersistence amfRegistrationPersistence;
}