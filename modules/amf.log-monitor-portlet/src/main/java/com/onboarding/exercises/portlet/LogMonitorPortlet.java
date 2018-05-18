package com.onboarding.exercises.portlet;

import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalServiceUtil;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationAuditLogUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.onboarding.exercises.constants.LogMonitorPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author douglas
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=amf-event-monitor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LogMonitorPortletKeys.LogMonitor,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class LogMonitorPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		boolean hasAllUserViewEventsPermissions =
				permissionChecker.hasPermission(
						themeDisplay.getScopeGroupId(),
						portletDisplay.getRootPortletId(),
						portletDisplay.getResourcePK(),
						"VIEW_ALL_USER_EVENTS");


		/*if(hasAllUserViewEventsPermissions) {
			AmfRegistrationAuditLogLocalServiceUtil.getAmfRegistrationAuditLogsCount();
		} else {
			count = AmfRegistrationAuditLogLocalServiceUtil.countByUserId(userU.getUserId());
			countRegistration = AmfRegistrationAuditLogLocalServiceUtil.countByRegistration(userU.getUserId());
			countLoginLogout = AmfRegistrationAuditLogLocalServiceUtil.countByLoginLogout(userU.getUserId());
		}*/

		request.setAttribute("hasAllUserViewEventsPermissions", hasAllUserViewEventsPermissions);

		super.render(request, response);
	}
}