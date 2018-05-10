package com.liferay.docs.amf.registration.sb.service.impl.test;


import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
    @Mock
    private UserLocalServiceUtil _userLocalServiceUtil;

    @Test
    public void firstnameRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setFirstName("");

        String keyMessageError = "first-name.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void firstnameMustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setFirstName("First-name!");

        String keyMessageError = "first-name.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void firstnameMaxLength50Chars() {
        RegistrationDto registrationDto = getRegistrationDto();
        String charLength_51 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        registrationDto.setFirstName(charLength_51);

        String keyMessageError = "first-name.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void lastnameRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setLastName("");

        String keyMessageError = "last-name.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void lastnameMustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setLastName("Last-name2!");

        String keyMessageError = "last-name.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void lastnameMaxLength50Chars() {
        RegistrationDto registrationDto = getRegistrationDto();

        String charLength_51 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        registrationDto.setLastName(charLength_51);

        String keyMessageError = "last-name.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    private void checkErrorServiceAddNewAccount(RegistrationDto registrationDto, String keyMessageError) {
        try {
            _amfRegistrationLocalServiceImpl.addNewAccount(registrationDto);
        } catch (RegistrationPortalException e) {
            List<String> errors =  e.getErrorMessages();
            Assert.assertTrue(errors.contains(keyMessageError));
        }
    }

    private RegistrationDto getRegistrationDto(){
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setFirstName("First-name");
        registrationDto.setLastName("Last-name");
        registrationDto.setEmailAddress("test-dev@liferay.com");
        registrationDto.setUsername("test");
        registrationDto.setGender(1);
        registrationDto.setBirthday("10/10/2000");
        registrationDto.setPassword1("mustB3valid!");
        registrationDto.setPassword2(registrationDto.getPassword());

        registrationDto.setHomePhone("1234567890");
        registrationDto.setMobilePhone("1234567890");

        registrationDto.setAddress("Address One");
        registrationDto.setAddress2("Address Two");
        registrationDto.setCity("lowel");
        registrationDto.setState(19022);
        registrationDto.setZip("01854");

        registrationDto.setSecurityQuestion("What is your mothers maiden name?");
        registrationDto.setSecurityAnswer("Maiden");
        registrationDto.setAcceptedTou(true);

        registrationDto.setCompanyId(1234l);

        return registrationDto;
    }
}
