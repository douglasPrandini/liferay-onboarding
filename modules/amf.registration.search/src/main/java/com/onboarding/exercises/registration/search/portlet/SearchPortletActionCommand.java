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

@SuppressWarnings("unchecked")
@Component(immediate = true, property = {
            "javax.portlet.name=" + RegistrationSearchPortletKeys.RegistrationSearch,
            "mvc.command.name=/RegistrationSearch/searchForm",
            "javax.portlet.supported-publishing-event=queryZipCode;http://liferay.onboarding.com"
        },
        service = MVCActionCommand.class)
public class SearchPortletActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String zipCode = ParamUtil.getString(actionRequest, "zip");
        QName qName = new QName("http://liferay.onboarding.com", "queryZipCode");
        actionResponse.setEvent(qName, zipCode);

        actionRequest.setAttribute("zipCode", zipCode);

        String no_default_error_message = PortalUtil.getPortletId(actionRequest) +
                SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE;
        SessionMessages.add(actionRequest, no_default_error_message);
    }

}