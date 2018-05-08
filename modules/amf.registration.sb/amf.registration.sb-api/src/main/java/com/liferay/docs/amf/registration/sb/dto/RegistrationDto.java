package com.liferay.docs.amf.registration.sb.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private Integer gender;
    private String birthday;

    private String b_day;
    private String b_month;
    private String b_year;

    private String password1;
    private String password2;
    private String homePhone;
    private String mobilePhone;
    private String address;
    private String address2;
    private String city;
    private Integer state;
    private String zip;
    private String securityQuestion;
    private String securityAnswer;
    private Boolean acceptedTou;

    private Long companyId;
    private Locale locale;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        if(getBirthday() != null && !getBirthday().isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            try {
                return formatter.parse(getBirthday());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return new Date();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }


    public String getB_day() {
        return b_day;
    }

    public void setB_day(String b_day) {
        this.b_day = b_day;
    }

    public String getB_month() {
        return b_month;
    }

    public void setB_month(String b_month) {
        this.b_month = b_month;
    }

    public String getB_year() {
        return b_year;
    }

    public void setB_year(String b_year) {
        this.b_year = b_year;
    }

    public Boolean getAcceptedTou() {
        return acceptedTou;
    }

    public void setAcceptedTou(Boolean acceptedTou) {
        this.acceptedTou = acceptedTou;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
