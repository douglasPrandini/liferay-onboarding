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

package com.liferay.docs.amf.registration.sb.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.docs.amf.registration.sb.service.http.AmfRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.amf.registration.sb.service.http.AmfRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class AmfRegistrationSoap implements Serializable {
	public static AmfRegistrationSoap toSoapModel(AmfRegistration model) {
		AmfRegistrationSoap soapModel = new AmfRegistrationSoap();

		soapModel.setDummy(model.getDummy());

		return soapModel;
	}

	public static AmfRegistrationSoap[] toSoapModels(AmfRegistration[] models) {
		AmfRegistrationSoap[] soapModels = new AmfRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmfRegistrationSoap[][] toSoapModels(
		AmfRegistration[][] models) {
		AmfRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmfRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmfRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmfRegistrationSoap[] toSoapModels(
		List<AmfRegistration> models) {
		List<AmfRegistrationSoap> soapModels = new ArrayList<AmfRegistrationSoap>(models.size());

		for (AmfRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmfRegistrationSoap[soapModels.size()]);
	}

	public AmfRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _dummy;
	}

	public void setPrimaryKey(long pk) {
		setDummy(pk);
	}

	public long getDummy() {
		return _dummy;
	}

	public void setDummy(long dummy) {
		_dummy = dummy;
	}

	private long _dummy;
}