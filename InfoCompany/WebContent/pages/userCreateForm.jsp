<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                	<h2 class="title"><s:text name="label.userCreateForm.greeting"/></h2>
                  		<s:form action="CreateUserAction">
							<s:textfield key="label.username" name="userName" required="true"/>
							<s:password  key="label.password" name="password"/>
							<s:textfield  key="label.email" name="email"/>
							<s:textfield key="label.birthdayYear" name="birthdayYear"/>
							
							<s:doubleselect key="label.location" name="country" list="countries" listKey="name" listValue="name" 
							doubleName="state" doubleList="states" doubleListKey="name" doubleListValue="name"/>
								
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