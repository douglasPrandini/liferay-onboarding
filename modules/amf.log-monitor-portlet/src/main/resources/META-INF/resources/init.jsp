<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextFactory" %>