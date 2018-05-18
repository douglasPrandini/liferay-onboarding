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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AmfRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistration
 * @generated
 */
@ProviderType
public class AmfRegistrationWrapper implements AmfRegistration,
	ModelWrapper<AmfRegistration> {
	public AmfRegistrationWrapper(AmfRegistration amfRegistration) {
		_amfRegistration = amfRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return AmfRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return AmfRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dummy", getDummy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dummy = (Long)attributes.get("dummy");

		if (dummy != null) {
			setDummy(dummy);
		}
	}

	@Override
	public AmfRegistration toEscapedModel() {
		return new AmfRegistrationWrapper(_amfRegistration.toEscapedModel());
	}

	@Override
	public AmfRegistration toUnescapedModel() {
		return new AmfRegistrationWrapper(_amfRegistration.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _amfRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _amfRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _amfRegistration.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _amfRegistration.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AmfRegistration> toCacheModel() {
		return _amfRegistration.toCacheModel();
	}

	@Override
	public int compareTo(AmfRegistration amfRegistration) {
		return _amfRegistration.compareTo(amfRegistration);
	}

	@Override
	public int hashCode() {
		return _amfRegistration.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfRegistration.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AmfRegistrationWrapper((AmfRegistration)_amfRegistration.clone());
	}

	@Override
	public java.lang.String toString() {
		return _amfRegistration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _amfRegistration.toXmlString();
	}

	/**
	* Returns the dummy of this amf registration.
	*
	* @return the dummy of this amf registration
	*/
	@Override
	public long getDummy() {
		return _amfRegistration.getDummy();
	}

	/**
	* Returns the primary key of this amf registration.
	*
	* @return the primary key of this amf registration
	*/
	@Override
	public long getPrimaryKey() {
		return _amfRegistration.getPrimaryKey();
	}

	@Override
	public void persist() {
		_amfRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_amfRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the dummy of this amf registration.
	*
	* @param dummy the dummy of this amf registration
	*/
	@Override
	public void setDummy(long dummy) {
		_amfRegistration.setDummy(dummy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_amfRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_amfRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_amfRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_amfRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this amf registration.
	*
	* @param primaryKey the primary key of this amf registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_amfRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_amfRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmfRegistrationWrapper)) {
			return false;
		}

		AmfRegistrationWrapper amfRegistrationWrapper = (AmfRegistrationWrapper)obj;

		if (Objects.equals(_amfRegistration,
					amfRegistrationWrapper._amfRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public AmfRegistration getWrappedModel() {
		return _amfRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _amfRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _amfRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_amfRegistration.resetOriginalValues();
	}

	private final AmfRegistration _amfRegistration;
}