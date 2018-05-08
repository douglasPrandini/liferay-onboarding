package com.liferay.docs.amf.registration.sb.model.listeners;

import com.liferay.docs.amf.registration.sb.dto.AmfRegistrationAuditLogDTO;
import com.liferay.docs.amf.registration.sb.enums.ActionType;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.ModelListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class UserListener extends BaseModelListener<User> {

    private AmfRegistrationAuditLogLocalService _amfRegistrationAuditLogLocalService;

    @Reference(unbind = "-")
    protected void setDLAppLocalService(AmfRegistrationAuditLogLocalService amfRegistrationAuditLogLocalService) {
        _amfRegistrationAuditLogLocalService = amfRegistrationAuditLogLocalService;
    }

    public void onAfterCreate(User user) throws ModelListenerException {

        insertNewLog(user, ActionType.REGISTRATION);
        super.onAfterCreate(user);
    }

    @Override
    public void onAfterUpdate(User user) throws ModelListenerException {

        ActionType action = ActionType.UPDATED;

        insertNewLog(user, action);
        super.onAfterUpdate(user);
    }

    private void insertNewLog(User user, ActionType action) {
        AmfRegistrationAuditLogDTO amfRegistrationAuditLogDTO = new AmfRegistrationAuditLogDTO();
        amfRegistrationAuditLogDTO.setEvent_type(action.toString());
        amfRegistrationAuditLogDTO.setIp_address("0.0.0.0");
        amfRegistrationAuditLogDTO.setScreen_name(user.getScreenName());
        amfRegistrationAuditLogDTO.setUser_id(user.getUserId());

        _amfRegistrationAuditLogLocalService.addNewRegister(amfRegistrationAuditLogDTO);
    }
}
