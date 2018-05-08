<%@ include file="/init.jsp" %>

<portlet:actionURL var="searchForm" name="/RegistrationSearch/searchForm"></portlet:actionURL>

<aui:form method="post" action="${searchForm}" >
    <aui:input label="Enter US Zip" name="zip" type="text" placeholder="zip code" maxlength="5">
        <aui:validator  name="required "  errorMessage="zip.required"></aui:validator>
        <aui:validator  name="number" errorMessage="zip.code.must.be.numbers"></aui:validator>
        <aui:validator name="rangeLength" errorMessage="zip.code.must.be.5.digits">[5,5]</aui:validator>
    </aui:input>

    <button class="aui-button" type="submit">
        <span class="aui-icon aui-icon-small aui-iconfont-search"></span>
        Search
    </button>
</aui:form>