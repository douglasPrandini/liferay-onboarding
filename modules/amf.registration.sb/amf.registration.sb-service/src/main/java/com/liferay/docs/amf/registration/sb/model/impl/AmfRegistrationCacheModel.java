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

package com.liferay.docs.amf.registration.sb.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.model.AmfRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AmfRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistration
 * @generated
 */
@ProviderType
public class AmfRegistrationCacheModel implements CacheModel<AmfRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmfRegistrationCacheModel)) {
			return false;
		}

		AmfRegistrationCacheModel amfRegistrationCacheModel = (AmfRegistrationCacheModel)obj;

		if (dummy == amfRegistrationCacheModel.dummy) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dummy);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{dummy=");
		sb.append(dummy);

		return sb.toString();
	}

	@Override
	public AmfRegistration toEntityModel() {
		AmfRegistrationImpl amfRegistrationImpl = new AmfRegistrationImpl();

		amfRegistrationImpl.setDummy(dummy);

		amfRegistrationImpl.resetOriginalValues();

		return amfRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dummy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dummy);
	}

	public long dummy;
}