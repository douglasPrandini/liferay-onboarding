package com.onboarding.exercises.registration.search.results.portlet;

import com.liferay.docs.amf.registration.sb.dto.UserDTO;

import com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalServiceUtil;

import com.onboarding.exercises.registration.search.results.constants.RegistrationSearchResultsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;


import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author douglas
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=amf-search-results",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegistrationSearchResultsPortletKeys.RegistrationSearchResults,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=queryZipCode;http://liferay.onboarding.com"
	},
	service = Portlet.class
)
public class RegistrationSearchResultsPortlet extends MVCPortlet {

	private int _zipCode = 0;

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		int count = 0;
		if(_zipCode > 0) {
			count = AmfRegistrationLocalServiceUtil.countByUsersByZip(_zipCode);
		}
		request.setAttribute("count", count);
		request.setAttribute("zipCode", _zipCode);

		super.render(request, response);
	}

	@ProcessEvent(qname="{http://liferay.onboarding.com}queryZipCode")
	public void search(EventRequest eventRequest, EventResponse eventResponse){
		Event event = eventRequest.getEvent();
		String zipCode = (String)event.getValue();

		_zipCode = Integer.parseInt(zipCode);
		eventRequest.setAttribute("zipCode", zipCode);
	}
}