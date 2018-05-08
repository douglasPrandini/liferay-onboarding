<%@ include file="/init.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.docs.amf.registration.sb.dto.UserDTO" %>
<%@ page import="com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalServiceUtil" %>

<h1>
    Search Results for <b>${zipCode}</b>
</h1>

<%
    int zipCode = 0;
    if ( request.getAttribute("zipCode") != null && !((String)request.getAttribute("zipCode")).isEmpty() ) {
        zipCode =  Integer.parseInt((String)request.getAttribute("zipCode"));
    }
    int count = 0;
    if(zipCode > 0) {
        count = AmfRegistrationLocalServiceUtil.countByUsersByZip(zipCode);
    }
%>

<liferay-ui:search-container delta="5" emptyResultsMessage="no.results" total="<%= count %>">

    <liferay-ui:search-container-results
        results="<%= AmfRegistrationLocalServiceUtil.findByUsersByZip(zipCode, searchContainer.getStart(), searchContainer.getEnd()) %>"
    />

    <liferay-ui:search-container-row className="UserDTO" modelVar="userDTO">
        <liferay-ui:search-container-column-text name="First Name" value="<%= userDTO.getFirstName() %>" />
        <liferay-ui:search-container-column-text name="User Name" value="<%= userDTO.getScreenName() %>" />
        <liferay-ui:search-container-column-text name="Email Address" value="<%= userDTO.getEmailAddress() %>" />

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>