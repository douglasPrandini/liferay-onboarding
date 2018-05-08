package com.onboarding.exercises.registration.portlet;

import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.onboarding.exercises.registration.constants.RegistrationPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;

@Component(immediate = true, property = {
            "javax.portlet.name=" + RegistrationPortletKeys.Registration,
            "mvc.command.name=/Registration/AddUser"
        },
        service = MVCActionCommand.class)
public class RegistrationAddUserActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        SessionErrors.clear(actionRequest);

        String no_default_error_message = PortalUtil.getPortletId(actionRequest) +
                SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE;
        SessionMessages.add(actionRequest, no_default_error_message);


        RegistrationDto registrationDto = getRegistrationDto(actionRequest);
        try {
            AmfRegistrationLocalServiceUtil.addNewAccount(registrationDto);
            SessionMessages.add(actionRequest, "account-created");

        } catch (RegistrationPortalException rpe) {
            List<String> errors = rpe.getErrorMessages();
            for (String error : errors) {
                SessionErrors.add(actionRequest, error);
            }
        }
    }

    private RegistrationDto getRegistrationDto(ActionRequest request) {
        RegistrationDto registrationDto = new RegistrationDto();

        registrationDto.setFirstName(ParamUtil.getString(request, "first_name"));
        registrationDto.setLastName(ParamUtil.getString(request, "last_name"));
        registrationDto.setEmailAddress(ParamUtil.getString(request, "email_address"));
        registrationDto.setUsername(ParamUtil.getString(request, "username"));
        registrationDto.setGender(ParamUtil.getInteger(request, "gender"));

        registrationDto.setBirthday(ParamUtil.getString(request, "birthday"));
        registrationDto.setB_day(ParamUtil.getString(request, "b_day"));
        registrationDto.setB_month(ParamUtil.getString(request, "b_month"));
        registrationDto.setB_year(ParamUtil.getString(request, "b_year"));

        registrationDto.setPassword1(ParamUtil.getString(request, "password1"));
        registrationDto.setPassword2(ParamUtil.getString(request, "password2"));
        registrationDto.setHomePhone(ParamUtil.getString(request, "home_phone"));
        registrationDto.setMobilePhone(ParamUtil.getString(request, "mobile_phone"));
        registrationDto.setAddress(ParamUtil.getString(request, "address"));
        registrationDto.setAddress2(ParamUtil.getString(request, "address2"));
        registrationDto.setCity(ParamUtil.getString(request, "city"));
        registrationDto.setState(ParamUtil.getInteger(request, "state"));
        registrationDto.setZip(ParamUtil.getString(request, "zip"));
        registrationDto.setSecurityQuestion(ParamUtil.getString(request, "security_question"));
        registrationDto.setSecurityAnswer(ParamUtil.getString(request, "security_answer"));
        registrationDto.setAcceptedTou(ParamUtil.getBoolean(request, "accepted_tou"));

        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
        registrationDto.setCompanyId(themeDisplay.getCompanyId());
        registrationDto.setLocale(themeDisplay.getLocale());

        return registrationDto;
    }
}