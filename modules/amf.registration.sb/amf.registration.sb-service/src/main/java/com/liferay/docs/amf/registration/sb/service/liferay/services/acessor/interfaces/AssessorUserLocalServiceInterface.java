package com.liferay.docs.amf.registration.sb.service.liferay.services.acessor.interfaces;

import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

public interface AssessorUserLocalServiceInterface {
    User addUser(RegistrationDto registrationDto) throws PortalException;
}
