<%@ include file="/init.jsp" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>

<%@ page import="com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil" %>

<%
    boolean hasPermission = (boolean)request.getAttribute("hasAllUserViewEventsPermissions");
    User userU = themeDisplay.getUser();
    int count = 0; int countRegistration = 0; int countLoginLogout = 0;
    if(hasPermission) {
        count = AmfRegistrationAuditLogLocalServiceUtil.getAmfRegistrationAuditLogsCount();
        countRegistration = AmfRegistrationAuditLogLocalServiceUtil.countByRegistration();
        countLoginLogout = AmfRegistrationAuditLogLocalServiceUtil.countByLoginLogout();
    } else {
        count = AmfRegistrationAuditLogLocalServiceUtil.countByUserId(userU.getUserId());
        countRegistration = AmfRegistrationAuditLogLocalServiceUtil.countByRegistration(userU.getUserId());
        countLoginLogout = AmfRegistrationAuditLogLocalServiceUtil.countByLoginLogout(userU.getUserId());
    }
%>

<liferay-ui:tabs names="All,Registration,Login" refresh="false" tabsValues="All,Registration,Login">
    <liferay-ui:section>
        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= count %>">

            <c:choose>
                <c:when test="${hasAllUserViewEventsPermissions}">
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.getAmfRegistrationAuditLogs(searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:when>
                <c:otherwise>
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByUserId(userU.getUserId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:otherwise>
            </c:choose>

            <liferay-ui:search-container-row className="AmfRegistrationAuditLog" keyProperty="id" modelVar="log">
                <%
                    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
                %>
                <liferay-ui:search-container-column-text name="Time" value="<%= dateFormat.format(log.getAction_time()) %>" />
                <liferay-ui:search-container-column-text name="Username" value="<%= String.format("%s (%d)", log.getScreen_name(), log.getUser_id()) %>" />
                <liferay-ui:search-container-column-text name="IP Address" property="ip_address" />
                <liferay-ui:search-container-column-text name="Event type" property="event_type" />

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator />
        </liferay-ui:search-container>

    </liferay-ui:section>
    <liferay-ui:section>

        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= countRegistration %>">
            <c:choose>
                <c:when test="${hasAllUserViewEventsPermissions}">
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByRegistration(searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:when>
                <c:otherwise>
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByRegistration(userU.getUserId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:otherwise>
            </c:choose>

            <liferay-ui:search-container-row className="AmfRegistrationAuditLog" keyProperty="id" modelVar="log">
                <%
                    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
                %>
                <liferay-ui:search-container-column-text name="Time" value="<%= dateFormat.format(log.getAction_time()) %>" />
                <liferay-ui:search-container-column-text name="Username" value="<%= String.format("%s (%d)", log.getScreen_name(), log.getUser_id()) %>" />
                <liferay-ui:search-container-column-text name="IP Address" property="ip_address" />
                <liferay-ui:search-container-column-text name="Event type" property="event_type" />

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator />
        </liferay-ui:search-container>

    </liferay-ui:section>
    <liferay-ui:section>
        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= countLoginLogout %>">
            <c:choose>
                <c:when test="${hasAllUserViewEventsPermissions}">
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByLoginLogout(searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:when>
                <c:otherwise>
                    <liferay-ui:search-container-results
                        results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByLoginLogout(userU.getUserId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
                    />
                </c:otherwise>
            </c:choose>

            <liferay-ui:search-container-row className="AmfRegistrationAuditLog" keyProperty="id" modelVar="log">
                <%
                    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
                %>
                <liferay-ui:search-container-column-text name="Time" value="<%= dateFormat.format(log.getAction_time()) %>" />
                <liferay-ui:search-container-column-text name="Username" value="<%= String.format("%s (%d)", log.getScreen_name(), log.getUser_id()) %>" />
                <liferay-ui:search-container-column-text name="IP Address" property="ip_address" />
                <liferay-ui:search-container-column-text name="Event type" property="event_type" />

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator />
        </liferay-ui:search-container>
    </liferay-ui:section>
</liferay-ui:tabs>