package com.liferay.docs.amf.registration.sb.model.listeners;

import com.liferay.docs.amf.registration.sb.dto.AmfRegistrationAuditLogDTO;
import com.liferay.docs.amf.registration.sb.enums.ActionType;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.ModelListener;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class UserListener extends BaseModelListener<User> {

    public void onAfterCreate(User user) throws ModelListenerException {

        AmfRegistrationAuditLogDTO amfRegistrationAuditLogDTO = new AmfRegistrationAuditLogDTO();
        amfRegistrationAuditLogDTO.setEvent_type(ActionType.REGISTRATION.toString());
        amfRegistrationAuditLogDTO.setIp_address("0.0.0.0");
        amfRegistrationAuditLogDTO.setScreen_name(user.getScreenName());
        amfRegistrationAuditLogDTO.setUser_id(user.getUserId());

        AmfRegistrationAuditLogLocalServiceUtil.addNewRegister(amfRegistrationAuditLogDTO);
    }

}
