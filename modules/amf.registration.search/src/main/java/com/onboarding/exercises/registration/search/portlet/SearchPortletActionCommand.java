package com.onboarding.exercises.registration.search.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.onboarding.exercises.registration.search.constants.RegistrationSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {
            "javax.portlet.name=" + RegistrationSearchPortletKeys.RegistrationSearch,
            "mvc.command.name=/RegistrationSearch/searchForm",
            "javax.portlet.supported-publishing-event=queryZipCode;http://liferay.onboarding.com"
        },
        service = MVCActionCommand.class)
public class SearchPortletActionCommand extends BaseMVCActionCommand {

    public static final String ZIP_CODE_LIST = "ZIP_CODE_LIST";

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String zipCode = ParamUtil.getString(actionRequest, "zip");
        QName qName = new QName("http://liferay.onboarding.com", "queryZipCode");
        actionResponse.setEvent(qName, zipCode);

        setSessionZipCode(actionRequest, zipCode);

        String no_default_error_message = PortalUtil.getPortletId(actionRequest) +
                SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE;
        SessionMessages.add(actionRequest, no_default_error_message);
    }

    private void setSessionZipCode(ActionRequest actionRequest, String zipCode) {
        List<String> zipCodes = new ArrayList<>();

        PortletSession session = actionRequest.getPortletSession();
        if(session.getAttribute(ZIP_CODE_LIST, PortletSession.APPLICATION_SCOPE) != null) {
            zipCodes = (List<String>) session.getAttribute(ZIP_CODE_LIST, PortletSession.APPLICATION_SCOPE);
        }

        zipCodes.add(zipCode);
        session.setAttribute(ZIP_CODE_LIST, zipCodes, PortletSession.APPLICATION_SCOPE);
    }
}