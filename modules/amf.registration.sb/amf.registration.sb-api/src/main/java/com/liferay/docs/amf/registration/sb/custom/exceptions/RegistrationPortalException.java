package com.liferay.docs.amf.registration.sb.custom.exceptions;

import com.liferay.portal.kernel.exception.PortalException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPortalException extends PortalException {

    private List<String> errors;

    public RegistrationPortalException(List<String> errors) {
        this.errors = errors == null ? new ArrayList<String>() : errors;
    }

    public List<String> getErrorMessages(){
        return errors;
    }

}