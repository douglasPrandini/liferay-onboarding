package com.liferay.docs.amf.registration.sb.service.impl.test;


import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.portal.kernel.service.UserLocalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AmfRegistrationLocalServiceImplTest {

    @InjectMocks
    private AmfRegistrationLocalServiceImpl _amfRegistrationLocalServiceImpl;

    @Mock
    private UserLocalService _userLocalService;

    @Test
    public void firstNameRequired() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("");

        String firstNameKeyMessageError = "first-name.required";
        checkErrorServiceAddNewAccount(registrationDto, firstNameKeyMessageError);
    }

    @Test
    public void firstNameMustBeAlphanumeric() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("First 1 Name !");

        String firstNameKeyMessageError = "first-name.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, firstNameKeyMessageError);
    }

    @Test
    public void firstNameMaxLength50Chars() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        String firstNameKeyMessageError = "first-name.length-max";
        checkErrorServiceAddNewAccount(registrationDto, firstNameKeyMessageError);
    }

    private void checkErrorServiceAddNewAccount(RegistrationDto registrationDto, String firstNameKeyMessageError) {
        try {
            _amfRegistrationLocalServiceImpl.addNewAccount(registrationDto);
        } catch (RegistrationPortalException e) {
            List<String> errors =  e.getErrorMessages();
            Assert.assertTrue(errors.contains(firstNameKeyMessageError));
        }
    }
}
