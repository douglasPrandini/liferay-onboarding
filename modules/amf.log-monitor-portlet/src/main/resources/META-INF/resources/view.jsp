<%@ include file="/init.jsp" %>

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(AmfRegistrationAuditLog.class.getName(), request);
%>

<liferay-ui:tabs names="All,Registration,Login" refresh="false" tabsValues="All,Registration,Login">
    <liferay-ui:section>

        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= AmfRegistrationAuditLogLocalServiceUtil.countUsers(serviceContext) %>">
            <liferay-ui:search-container-results
                results="<%= AmfRegistrationAuditLogLocalServiceUtil.findUsers(serviceContext, searchContainer.getStart(), searchContainer.getEnd()) %>"
            />

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
        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= AmfRegistrationAuditLogLocalServiceUtil.countByRegistration(serviceContext) %>">

            <liferay-ui:search-container-results
                results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByRegistration(serviceContext, searchContainer.getStart(), searchContainer.getEnd()) %>"
            />

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
        <liferay-ui:search-container delta="20" emptyResultsMessage="No results" total="<%= AmfRegistrationAuditLogLocalServiceUtil.countByLoginLogout(serviceContext) %>">

            <liferay-ui:search-container-results
                results="<%= AmfRegistrationAuditLogLocalServiceUtil.findByLoginLogout(serviceContext, searchContainer.getStart(), searchContainer.getEnd()) %>"
            />

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