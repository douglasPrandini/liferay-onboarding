package com.onboarding.exercises.registration.search.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.onboarding.exercises.registration.search.constants.RegistrationSearchPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author douglas
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.info.title=",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=amf-search",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegistrationSearchPortletKeys.RegistrationSearch,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)

public class RegistrationSearchPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.render(renderRequest, renderResponse);
	}
}