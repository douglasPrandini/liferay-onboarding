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

package com.liferay.docs.amf.registration.sb.service.impl.test;

import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.docs.amf.registration.sb.dto.UserDTO;
import com.liferay.docs.amf.registration.sb.service.base.AmfRegistrationLocalServiceBaseImpl;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AmfRegistrationLocalServiceImpl extends AmfRegistrationLocalServiceBaseImpl {

	private List<String> errors = null;
	public static final long MOBILE_PHONE = 11008;
	public static final long HOME_PHONE = 11011;

	public static final String FIND_USERS_BY_ZIP_CODE = "findUsersByZipCode";
	public static final String COUNT_USERS_BY_ZIP_CODE = "countUsersByZipCode";

	public AmfRegistrationLocalServiceImpl(){
		errors = new ArrayList<String>();
	}

	@Override
	public void addNewAccount(RegistrationDto registrationDto)
			throws RegistrationPortalException {
		errors.clear();

		validate(registrationDto);
		if(!errors.isEmpty()){
			throw new RegistrationPortalException(errors);
		}

		try {
			createNewAccount(registrationDto);
		} catch (PortalException e) {
			throw new RegistrationPortalException(errors);
		}
		return;
	}

	private void createNewAccount(RegistrationDto registrationDto) throws PortalException {

		Calendar cal = Calendar.getInstance();
		cal.setTime(registrationDto.getBirthdayDate());
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);

		User user = userLocalService.addUser(
				0, registrationDto.getCompanyId(), false,
				registrationDto.getPassword(), registrationDto.getPassword2(),
				false, registrationDto.getUsername(),
				registrationDto.getEmailAddress(),0,
				null, registrationDto.getLocale(), registrationDto.getFirstName(), null,registrationDto.getLastName(),
				0, 0, "Male".equals(registrationDto.getGender()),
				birthdayMonth, birthdayDay, birthdayYear,
				null, null, null,
				null, null, false, new ServiceContext());

		userLocalService.updateReminderQuery(user.getUserId(), registrationDto.getSecurityQuestion(), registrationDto.getSecurityAnswer());
		userLocalService.updateAgreedToTermsOfUse(user.getUserId(), registrationDto.getAcceptedTou());


		long countryId = 19;
		long typeId = 11002;
		boolean mailing = true;
		addressLocalService.addAddress(user.getUserId(), Contact.class.getName(),
				user.getContactId(), registrationDto.getAddress(), registrationDto.getAddress2(),
				null, registrationDto.getCity(), registrationDto.getZip(),
				registrationDto.getState(), countryId, typeId, mailing,
				true, new ServiceContext());

		//List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(Contact.class.getName() + ListTypeConstants.PHONE);
		if(Validator.isNotNull(registrationDto.getHomePhone())) {
			phoneLocalService.addPhone(user.getUserId(), Contact.class.getName(),
					user.getContactId(), registrationDto.getHomePhone(), null,
					HOME_PHONE, true, new ServiceContext());
		}
		if(Validator.isNotNull(registrationDto.getMobilePhone())) {
			phoneLocalService.addPhone(user.getUserId(), Contact.class.getName(),
					user.getContactId(), registrationDto.getMobilePhone(), null,
					MOBILE_PHONE, false, new ServiceContext());
		}
	}

	private void validate(RegistrationDto registrationDto) {

		validateFirstName(registrationDto.getFirstName());
		validateLasttName(registrationDto.getLastName());
		validateEmailAddress(registrationDto.getEmailAddress());
		validateUsername(registrationDto);
		validateBirthdate(registrationDto.getBirthdayDate());
		validatePassword(registrationDto.getPassword(), registrationDto.getPassword2());

		validateHomePhone(registrationDto.getHomePhone());
		validateMobile(registrationDto.getMobilePhone());

		validateAddress(registrationDto.getAddress());
		validateAddress2(registrationDto.getAddress2());
		validateCity(registrationDto.getCity());
		validateZipCode(registrationDto.getZip());

		validateSecurityQuestion(registrationDto.getSecurityQuestion());
		validateSecurityAnswer(registrationDto.getSecurityAnswer());
		validateToU(registrationDto.getAcceptedTou());
	}

	private void validateSecurityQuestion(String securityQuestion) {
		if(empty(securityQuestion)){
			errors.add("security.question.required");
		}
	}

	private void validateToU(Boolean acceptedTou) {
		if(!acceptedTou){
			errors.add("must.accepted-tou");
		}
	}

	private void validateSecurityAnswer(String securityAnswer) {
		if(empty(securityAnswer)){
			errors.add("security.answer.required");
		}
		if(!isAlphanumeric(securityAnswer)) {
			errors.add("security.answer.alphanumeric");
		}
		if(isLengthExceeded(securityAnswer, 255)) {
			errors.add("security.answer.length-max");
		}
	}

	private void validateZipCode(String zip) {
		if(isLengthReached(zip, 5)){
			errors.add("zip-length-min");
		}
	}

	private void validateCity(String city) {
		if(empty(city)){
			errors.add("city.required");
		}
		if(!isAlphanumeric(city)) {
			errors.add("city.alphanumeric");
		}
		if(isLengthExceeded(city, 255)) {
			errors.add("city.length-max");
		}
	}

	private void validateAddress2(String address2) {
		if(!empty(address2)) {
			if (!isAlphanumeric(address2)) {
				errors.add("address2.alphanumeric");
			}
			if (isLengthExceeded(address2, 255)) {
				errors.add("address2.length-max");
			}
		}
	}

	private void validateAddress(String address) {
		if(empty(address)){
			errors.add("address.required");
		}
		if(!isAlphanumeric(address)) {
			errors.add("address.alphanumeric");
		}
		if(isLengthExceeded(address, 255)) {
			errors.add("address.length-max");
		}
	}

	private void validateMobile(String mobilePhone) {
		if(!empty(mobilePhone) && mobilePhone.length() != 10){
			errors.add("mobile-phone-invalid");
		}
	}

	private void validateHomePhone(String homePhone) {
		if(!empty(homePhone) && homePhone.length() != 10){
			errors.add("home-phone-invalid");
		}
	}

	private void validatePassword(String password, String password2) {
		Boolean teste = password.matches("^((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{6,99})$");

		if (empty(password)) {
			errors.add("password.required");
		} else {
			Pattern pattern = Pattern.compile("^((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{6,99})$");
			Matcher matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errors.add("password.not.valid");
			} else {
				if (!password.equals(password2)) {
					errors.add("password.must.match");
				}
			}
		}
	}

	private void validateFirstName(String firstName) {

		if(empty(firstName)){
			errors.add("first-name.required");
		}
		if(!isAlphanumeric(firstName)) {
			errors.add("first-name.alphanumeric");
		}
		if(isLengthExceeded(firstName, 50)) {
			errors.add("first-name.length-max");
		}
	}

	private void validateLasttName(String lastName) {
		if(empty(lastName)){
			errors.add("last-name.required");
		}
		if(!isAlphanumeric(lastName)) {
			errors.add("last-name.alphanumeric");
		}
		if(isLengthExceeded(lastName, 50)) {
			errors.add("last-name.length-max");
		}
	}

	private void validateEmailAddress(String emailAddress) {
		if(empty(emailAddress)){
			errors.add("email-address.required");
		}
		if(isLengthExceeded(emailAddress, 255)) {
			errors.add("email-address.length-max");
		}
		if(!Validator.isEmailAddress(emailAddress)){
			errors.add("email-address.invalid");
		}
	}

	private void validateUsername(RegistrationDto dto) {
		if(empty(dto.getUsername())){
			errors.add("username.required");
		}
		else {
			if (!isAlphanumeric(dto.getUsername())) {
				errors.add("username.alphanumeric");
			}
			if (isLengthExceeded(dto.getUsername(), 16)) {
				errors.add("username.length-max");
			}
			if (isLengthReached(dto.getUsername(), 4)) {
				errors.add("username.length-min");
			}
			if (!isUnique(dto)) {
				errors.add("username.unique");
			}
		}
	}

	private boolean isUnique(RegistrationDto dto) {
		try {
			userLocalService.getUserByScreenName(dto.getCompanyId(), dto.getUsername());
			return false;
		} catch (PortalException e) {
			//User not exists
			return true;
		}
	}

	private void validateBirthdate(Date birthdayDate) {
		if(getAge(birthdayDate) < 13){
			errors.add("birthday.age.min");
		}

	}

	private static int getAge(Date birthday) {
		LocalDate birthdayLD = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(birthdayLD, LocalDate.now()).getYears();
	}

	private boolean isLengthExceeded(String data, int max) {
		return data.length() > max;
	}

	private boolean isLengthReached(String data, int min) {
		return data.length() < min;
	}

	private Boolean isAlphanumeric(String data) {
		return Validator.isAlphanumericName(data);
	}

	private boolean empty(String s ) {
		return Validator.isBlank(s);
	}

	public List<UserDTO> findByUsersByZip(int zipCode, int start, int end) {
		if(!validateZip(String.valueOf(zipCode))){
			return new ArrayList<>();
		}

		Session session = null;
		try {
			session = amfRegistrationAuditLogPersistence.openSession();
			String sql = CustomSQLUtil.get(getClass(),FIND_USERS_BY_ZIP_CODE);

			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			//queryObject.addEntity("User_", User.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(zipCode);

			//Pagination
			qPos.add(start);
			qPos.add(end);

			List<Object[]> returnedList = (List<Object[]>)queryObject.list();

			return transformDTO(returnedList);
		} catch (Exception e) {
			throw e;
		} finally {
			amfRegistrationAuditLogPersistence.closeSession(session);
		}
	}

	private boolean validateZip(String s) {
		return s.length() == 5;
	}

	public int countByUsersByZip(int zipCode) {
		Session session = null;
		try {
			session = amfRegistrationAuditLogPersistence.openSession();
			String sql = CustomSQLUtil.get(getClass(), COUNT_USERS_BY_ZIP_CODE);

			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(zipCode);

			BigInteger total = (BigInteger)queryObject.uniqueResult();
			return total.intValue();

		} catch (Exception e) {
			throw e;
		} finally {
			amfRegistrationAuditLogPersistence.closeSession(session);
		}
	}

	private List<UserDTO> transformDTO(List<Object[]> returnedList) {
		List<UserDTO> usersDTO = new ArrayList<>();

		if(returnedList != null) {

			for(Object[] object : returnedList){
				UserDTO userDTO = new UserDTO();

				BigInteger useridBI = (BigInteger)object[0];
				userDTO.setUserId(useridBI.longValue());

				userDTO.setFirstName((String)object[1]);
				userDTO.setScreenName((String)object[2]);
				userDTO.setEmailAddress((String)object[3]);
				usersDTO.add(userDTO);
			}
		}

		return usersDTO;
	}
}