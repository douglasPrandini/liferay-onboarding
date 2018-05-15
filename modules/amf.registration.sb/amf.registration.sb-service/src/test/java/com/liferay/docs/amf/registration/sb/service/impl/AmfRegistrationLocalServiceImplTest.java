package com.liferay.docs.amf.registration.sb.service.impl;


import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.docs.amf.registration.sb.service.liferay.services.acessor.AssessorUserLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.PhoneLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RunWith(MockitoJUnitRunner.class)
public class AmfRegistrationLocalServiceImplTest {

    @InjectMocks
    private AmfRegistrationLocalServiceImpl _amfRegistrationLocalServiceImpl;

    @Mock
    private AssessorUserLocalService assessorUserLocalService;

    @Mock
    private UserLocalService userLocalService;

    @Mock
    private AddressLocalService addressLocalService;

    @Mock
    private PhoneLocalService phoneLocalService;

    @Mock
    private User _user;

    @Before
    public void setup() {
    }
    @After
    public void clean() {
    }

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
        String lastnameLength_51 = new String(new char[51]).replace('\0', 'A');
        registrationDto.setFirstName(lastnameLength_51);

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

        String lastnameLength_51 = new String(new char[51]).replace('\0', 'A');
        registrationDto.setLastName(lastnameLength_51);

        String keyMessageError = "last-name.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void emailAddressRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setEmailAddress("");

        String keyMessageError = "email-address.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void emailAddressLangthMax() {
        RegistrationDto registrationDto = getRegistrationDto();

        String longEmail = new String(new char[260]).replace('\0', 'e');
        registrationDto.setEmailAddress(longEmail);

        String keyMessageError = "email-address.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void emailAddressValid() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setEmailAddress("email!email.com");

        String keyMessageError = "email-address.invalid";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void usernameRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setUsername("");

        String keyMessageError = "username.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void usernameMustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setUsername("test@");

        String keyMessageError = "username.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void usernameMustHaveMinimum4() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setUsername("tes");

        String keyMessageError = "username.length-min";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void usernameMustHaveMAximum16() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setUsername("myusernameisverylong");

        String keyMessageError = "username.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void usernameMustBeUnique() throws PortalException {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setUsername("test");

        long companyId = registrationDto.getCompanyId();
        String username = registrationDto.getUsername();
        Mockito.when(userLocalService.getUserByScreenName(companyId, username)).thenReturn(_user);

        String keyMessageError = "username.unique";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void birthdayMustBeGreaterThan13YearOld () {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setBirthday("10/10/2010");

        String keyMessageError = "birthday.age.min";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void password1Required() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setPassword1("");

        String keyMessageError = "password.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void password1Invalid() {
        RegistrationDto registrationDto = getRegistrationDto();

        List<String> invalidPasswords = new ArrayList<>();

        invalidPasswords.add("must6");
        invalidPasswords.add("mustB3valid");
        invalidPasswords.add("mustBevalid!");
        invalidPasswords.add("mustb3valid!");

        for (String password: invalidPasswords) {
            registrationDto.setPassword1(password);
            String keyMessageError = "password.not.valid";
            checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
        }

    }

    @Test
    public void password2MusbBeEquals() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setPassword2("notEqual");

        String keyMessageError = "password.must.match";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenLessThan10NumberMobilephoneErrorShouldThrow () {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setMobilePhone("123456789");

        String keyMessageError = "mobile-phone-invalid";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenMoreThan10NumberMobilephoneErrorShouldThrow () {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setMobilePhone("12345678901");

        String keyMessageError = "mobile-phone-invalid";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenLessThan10NumberHomephoneErrorShouldThrow () {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setHomePhone("123456789");

        String keyMessageError = "home-phone-invalid";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenMoreThan10NumberHomephoneErrorShouldThrow() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setHomePhone("12345678901");

        String keyMessageError = "home-phone-invalid";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void Address1MustBeRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setAddress("");

        String keyMessageError = "address.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void Address1MustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setAddress("Address !@#$%");

        String keyMessageError = "address.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void Address1MustBeLessThan255Chars() {
        RegistrationDto registrationDto = getRegistrationDto();
        String addressMoreThan255Chars = new String(new char[256]).replace('\0', 'A');
        registrationDto.setAddress(addressMoreThan255Chars);

        String keyMessageError = "address.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void Address2MustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setAddress2("Address 2 !@#$%");

        String keyMessageError = "address2.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void Address2MustBeLessThan255Chars() {
        RegistrationDto registrationDto = getRegistrationDto();
        String addressMoreThan255Chars = new String(new char[256]).replace('\0', 'A');
        registrationDto.setAddress2(addressMoreThan255Chars);

        String keyMessageError = "address2.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void cityMustBeRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setCity("");

        String keyMessageError = "city.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void cityMustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setCity("Maringá");

        String keyMessageError = "city.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void cityMustBeLessThan255Chars() {
        RegistrationDto registrationDto = getRegistrationDto();
        String addressMoreThan255Chars = new String(new char[256]).replace('\0', 'A');
        registrationDto.setCity(addressMoreThan255Chars);

        String keyMessageError = "city.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenLessThan5numberZipCodeErrorShouldThrow () {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setZip("1234");

        String keyMessageError = "zip-length-min";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void givenMoreThan5NumberZipCodeErrorShouldThrow() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setZip("123456");

        String keyMessageError = "zip-length-min";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void securityQuestionMustBeRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setSecurityQuestion("");

        String keyMessageError = "security.question.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void securityAnswerMustBeRequired() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setSecurityAnswer("");

        String keyMessageError = "security.answer.required";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void securityAnswerMustBeAlphanumeric() {
        RegistrationDto registrationDto = getRegistrationDto();
        registrationDto.setSecurityAnswer("");

        String keyMessageError = "security.answer.alphanumeric";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void securityAnswerMustaveLessThan255Chars() {
        RegistrationDto registrationDto = getRegistrationDto();
        String addressMoreThan255Chars = new String(new char[256]).replace('\0', 'A');
        registrationDto.setSecurityAnswer(addressMoreThan255Chars);

        String keyMessageError = "security.answer.length-max";
        checkErrorServiceAddNewAccount(registrationDto, keyMessageError);
    }

    @Test
    public void createNewAccount() throws PortalException {
        RegistrationDto registrationDto = getRegistrationDto();

        //Unique user name
        long companyId = registrationDto.getCompanyId();
        String username = registrationDto.getUsername();
        Mockito.when(userLocalService.getUserByScreenName(companyId, username)).thenThrow(PortalException.class);

        Mockito.when(assessorUserLocalService.addUser(registrationDto)).thenReturn(_user);

        _amfRegistrationLocalServiceImpl.addNewAccount(registrationDto);

        Mockito.verify(assessorUserLocalService, VerificationModeFactory.times(1))
                .addUser(registrationDto);

        Mockito.verify(userLocalService, VerificationModeFactory.times(1))
                .updateReminderQuery(_user.getUserId(), registrationDto.getSecurityQuestion(), registrationDto.getSecurityAnswer());

        Mockito.verify(userLocalService, VerificationModeFactory.times(1))
                .updateAgreedToTermsOfUse(_user.getUserId(), registrationDto.getAcceptedTou());
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
        registrationDto.setFirstName("FirstName");
        registrationDto.setLastName("LastName");
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
        registrationDto.setLocale(Locale.US);

        return registrationDto;
    }
}
