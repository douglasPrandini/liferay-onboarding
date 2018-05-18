<%@ include file="/init.jsp" %>
<%
    Integer count = (Integer)request.getAttribute("count");
    Integer zipCode = (Integer)request.getAttribute("zipCode");

    String sZipCode = "";
    if(zipCode > 0) {
        sZipCode = zipCode.toString();
    }
%>

<h1>
    Search Results for <b><%= sZipCode %></b>
</h1>

<liferay-ui:search-container delta="5" emptyResultsMessage="no.results" total="${count}">

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