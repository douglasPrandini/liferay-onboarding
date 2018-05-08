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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AmfRegistrationAuditLog service. Represents a row in the &quot;amf_registration_audit_log&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogModel
 * @see com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogImpl
 * @see com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogImpl")
@ProviderType
public interface AmfRegistrationAuditLog extends AmfRegistrationAuditLogModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AmfRegistrationAuditLog, Long> ID_ACCESSOR = new Accessor<AmfRegistrationAuditLog, Long>() {
			@Override
			public Long get(AmfRegistrationAuditLog amfRegistrationAuditLog) {
				return amfRegistrationAuditLog.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AmfRegistrationAuditLog> getTypeClass() {
				return AmfRegistrationAuditLog.class;
			}
		};
}