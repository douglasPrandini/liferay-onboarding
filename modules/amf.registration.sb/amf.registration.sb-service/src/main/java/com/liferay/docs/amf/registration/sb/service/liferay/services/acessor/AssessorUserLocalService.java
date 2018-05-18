package com.liferay.docs.amf.registration.sb.service.liferay.services.acessor;

import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.docs.amf.registration.sb.service.liferay.services.acessor.interfaces.AssessorUserLocalServiceInterface;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.Calendar;

/*
* This assessor class just was created to be easy read and write tests; because of the number of parameters of Liferay services methods
* The interface just exist to be mocked
* */
public class AssessorUserLocalService implements AssessorUserLocalServiceInterface {

    private UserLocalService userLocalService;
    private ServiceContext serviceContext;

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public User addUser(RegistrationDto registrationDto) throws PortalException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(registrationDto.getBirthdayDate());
        int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
        int birthdayMonth = cal.get(Calendar.MONTH);
        int birthdayYear = cal.get(Calendar.YEAR);
        boolean male = registrationDto.getGender() == 1;

        return userLocalService.addUser(0,
                registrationDto.getCompanyId(),
                false,
                registrationDto.getPassword(),
                registrationDto.getPassword2(),
                false,
                registrationDto.getUsername(),
                registrationDto.getEmailAddress(),
                0,
                null,
                registrationDto.getLocale(),
                registrationDto.getFirstName(),
                null,
                registrationDto.getLastName(),
                0,
                0,
                male,
                birthdayMonth, birthdayDay, birthdayYear,
                null, null, null,
                null, null, false, getServiceContext());
    }

    public ServiceContext getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }
}
