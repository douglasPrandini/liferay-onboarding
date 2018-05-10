package com.liferay.docs.amf.registration.sb.service.impl;


import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.portal.kernel.service.UserLocalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AmfRegistrationLocalServiceImplTest {

    @InjectMocks
    private AmfRegistrationLocalServiceImpl _amfRegistrationLocalServiceImpl;

    @Mock
    private UserLocalService _userLocalService;

    @Test(expected = RegistrationPortalException.class)
    public void firstTest() throws RegistrationPortalException {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("");

        _amfRegistrationLocalServiceImpl.addNewAccount(registrationDto);
    }
}
