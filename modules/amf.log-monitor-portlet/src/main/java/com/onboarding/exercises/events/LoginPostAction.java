package com.onboarding.exercises.events;


import com.liferay.docs.amf.registration.sb.dto.AmfRegistrationAuditLogDTO;
import com.liferay.docs.amf.registration.sb.enums.ActionType;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalService;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;


@Component(
        immediate = true,
        property = {
                "key=login.events.post"
        },
        service = LifecycleAction.class
)

public class LoginPostAction implements LifecycleAction {

    @Reference
    AmfRegistrationAuditLogLocalService _amfRegistrationAuditLogLocalService;

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

        HttpServletRequest request = lifecycleEvent.getRequest();
        try {
            User user = PortalUtil.getUser(request);

            AmfRegistrationAuditLogDTO amfRegistrationAuditLogDTO = new AmfRegistrationAuditLogDTO();
            amfRegistrationAuditLogDTO.setEvent_type(ActionType.LOGIN.toString());
            amfRegistrationAuditLogDTO.setIp_address(request.getRemoteAddr());
            amfRegistrationAuditLogDTO.setScreen_name(user.getScreenName());
            amfRegistrationAuditLogDTO.setUser_id(user.getUserId());

            _amfRegistrationAuditLogLocalService.addNewRegister(amfRegistrationAuditLogDTO);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }
}
