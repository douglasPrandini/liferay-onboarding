package com.onboarding.exercises.registration.portlet;

import com.liferay.docs.amf.registration.sb.custom.exceptions.RegistrationPortalException;
import com.liferay.docs.amf.registration.sb.dto.RegistrationDto;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.onboarding.exercises.registration.constants.RegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * @author douglas
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/html/css/view.css",
		"com.liferay.portlet.footer-portlet-javascript=/html/js/view.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + RegistrationPortletKeys.PortletDisplayName,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegistrationPortletKeys.Registration,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)

public class RegistrationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			request.setAttribute("signin", true);
		}

		Country country = null;
		try {
			country = CountryServiceUtil.getCountryByA2("US");

		} catch(PortalException ex) {
			SessionErrors.add(request, "error");
		}
		List<Region> regions =  RegionServiceUtil.getRegions(country.getCountryId());
		request.setAttribute("regions", regions);

		super.render(request, response);
	}

}

