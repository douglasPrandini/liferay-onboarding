<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.service.RegionServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Region" %>
<%@ page import="java.util.Date" %>


<liferay-ui:error key="first-name.required" message="first-name.required" />
<liferay-ui:error key="first-name.alphanumeric" message="first-name.alphanumeric" />
<liferay-ui:error key="first-name.length-max" message="first-name.length-max" />

<liferay-ui:error key="last-name.required" message="last-name.required" />
<liferay-ui:error key="last-name.alphanumeric" message="last-name.alphanumeric" />
<liferay-ui:error key="last-name.length-max" message="last-name.length-max" />

<liferay-ui:error key="email-address.required" message="email-address.required" />
<liferay-ui:error key="email-address.alphanumeric" message="email-address.alphanumeric" />
<liferay-ui:error key="email-address.length-max" message="email-address.length-max" />
<liferay-ui:error key="email-address.invalid" message="email-address.invalid" />

<liferay-ui:error key="birthday.age.min" message="birthday.age.min" />

<liferay-ui:error key="password.required" message="password.required" />
<liferay-ui:error key="password.not.valid" message="password.not.valid" />
<liferay-ui:error key="password.must.match" message="password.must.match" />

<liferay-ui:error key="mobile-phone-invalid" message="mobile-phone-invalid" />
<liferay-ui:error key="home-phone-invalid" message="home-phone-invalid" />

<liferay-ui:error key="username.required" message="username.required" />
<liferay-ui:error key="username.alphanumeric" message="username.alphanumeric" />
<liferay-ui:error key="username.length-max" message="username.length-max" />
<liferay-ui:error key="username.length-min" message="username.length-min" />
<liferay-ui:error key="username.unique" message="username.unique" />

<liferay-ui:error key="address.required" message="address.required" />
<liferay-ui:error key="address.alphanumeric" message="address.alphanumeric" />
<liferay-ui:error key="address.length-max" message="address.length-max" />

<liferay-ui:error key="address2.alphanumeric" message="address2.alphanumeric" />
<liferay-ui:error key="address2.length-max" message="address2.length-max" />

<liferay-ui:error key="city.required" message="city.required" />
<liferay-ui:error key="city.alphanumeric" message="city.alphanumeric" />
<liferay-ui:error key="city.length-max" message="city.length-max" />

<liferay-ui:error key="zip-length-min" message="zip-length-min" />

<liferay-ui:error key="security.answer.required" message="security.answer.required" />
<liferay-ui:error key="security.answer.alphanumeric" message="security.answer.alphanumeric" />
<liferay-ui:error key="security.answer.length-max" message="security.answer.length-max" />

<liferay-ui:error key="security.question.required" message="security.question.required" />
<liferay-ui:error key="must.accepted-tou" message="must.accepted-tou" />

<liferay-ui:success key="account-created" message="account-created" />

<%
    Date defaultDate = new Date();
    int startDay, startMonth, startYear;

    startDay = defaultDate.getDate();
    startYear = defaultDate.getYear()+1900;
    startMonth = defaultDate.getMonth();

    List<Region> regions =  RegionServiceUtil.getRegions(19l);
%>

<portlet:actionURL name="/Registration/AddUser" var="addUserURL" />

<aui:form method="post" action="${addUserURL}" name="myForm">
<c:choose>
    <c:when test = "${signin != null}">
        <liferay-ui:message key="user.logged" />
    </c:when>
    <c:otherwise>
        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" label="Basic Info">

                <aui:input label="First Name" name="first_name" type="text" placeholder="First Name" >
                </aui:input>

                <aui:input label="Last Name" name="last_name" type="text" placeholder="Last Name" >
                </aui:input>

                <aui:input label="Email Address" name="email_address" type="text" placeholder="email_address" >
                </aui:input>

                <aui:input label="Username" name="username" type="text" placeholder="username" >
                </aui:input>

                <aui:select label="Gender" name="gender" >
                    <aui:option value="1">Male</aui:option>
                    <aui:option value="0">Female</aui:option>
                </aui:select>

                <label>Birthday</label>
                <liferay-ui:input-date name="birthday" cssClass="custom-test"
                            dayValue="<%=startDay%>" dayParam="b_day"
                            monthValue="<%=startMonth%>" monthParam="b_month"
                            yearValue="<%=startYear%>" yearParam="b_year"/>


                <aui:input label="Password" name="password1"  type="password" placeholder="password" >

                </aui:input>

                <aui:input label="Repeat Password" name="password2" type="password" placeholder="repeat password" >

                </aui:input>

            </aui:fieldset>
        </aui:fieldset-group>

        <hr>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="Phone">

                <aui:input label="Home Phone" name="home_phone" maxlength="10" type="text" placeholder="Home Phone" >

                </aui:input>

                <aui:input label="Mobile Phone" name="mobile_phone" maxlength="10" type="text" placeholder="Mobile Phone" >

                </aui:input>

            </aui:fieldset>
        </aui:fieldset-group>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="Billing Address (US-Only)">

                <aui:input label="Address 1" name="address" type="text" placeholder="Address 1" >

                </aui:input>

                <aui:input label="Address 2" name="address2" type="text" placeholder="Address 2" >

                </aui:input>

                <aui:input label="City" name="city" type="text" placeholder="City" >

                </aui:input>

                <aui:select label="State" name="state" >
                    <% for (Region region : regions ) {
                            String label = region.getRegionCode() + " - " + region.getName();
                    %>
                        <aui:option value="<%=region.getRegionId()%>" label="<%=label%>"></aui:option>
                    <% } %>
                </aui:select>

                <aui:input label="Zip Code" name="zip" maxLength="5" type="text" placeholder="Zip Code" >

                </aui:input>

            </aui:fieldset>
        </aui:fieldset-group>


        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" label="Security">

                <aui:select id="security_question"
                            name="security_question"
                            placeholder="Must choose one of the Following"
                            label="Security Question">
                    <aui:option label="What is your mothers maiden name?"></aui:option>
                    <aui:option label="What is the make of your first car?"></aui:option>
                    <aui:option label="What is your high school mascot?"></aui:option>
                    <aui:option label="Who is your favorite actor?"></aui:option>
                </aui:select>

                <aui:input label="Answer" name="security_answer" type="text" placeholder="Security Answer" >

                </aui:input>

                <aui:input  type="checkbox" name="accepted_tou"
                            label="I have read, understand, and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics web site." >
                            Terms of Use
                </aui:input>

            </aui:fieldset>
        </aui:fieldset-group>

        <aui:button type="submit" />

    </c:otherwise>
</c:choose>
</aui:form>
