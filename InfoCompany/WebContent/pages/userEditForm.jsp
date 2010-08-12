<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<link href=".../resources/style2.css" rel="stylesheet" type="text/css" media="screen" />
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <link href="./../resources/style2.css" rel="stylesheet" type="text/css" media="screen" />
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                	<h2 class="title"><s:text name="label.userMyAccountForm.greeting"/></h2><br/>
                  		<s:form action="EditUserAction" namespace="/pages">
							<s:textfield key="label.username" name="user.userName" readonly="true" />
							<s:textfield  key="label.email" name="user.email"/>
							<s:textfield key="label.birthdayYear" name="user.birthdayYear"/>
							
							<s:doubleselect key="label.location" name="user.country" list="countries" listKey="name" listValue="name" 
							doubleName="user.state" doubleList="states" doubleListKey="name" doubleListValue="name"/>
								
							<s:doubleselect key="label.job"  name="industryName" list="industries" listKey="name" listValue="name" 
							doubleName="jobName" doubleList="jobs" doubleListKey="name" doubleListValue="name"/>
							<s:submit/>
						</s:form>	
						<s:actionerror />
						<s:actionmessage />					
                </div>
                <jsp:include page="/pages/sidebar.jsp"></jsp:include>
                <jsp:include page="/pages/divFooter.jsp"></jsp:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>