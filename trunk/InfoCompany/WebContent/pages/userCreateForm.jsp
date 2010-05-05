<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>InfoCompany v1.0 | 2010 project...</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <s:head/>
	</head>

	<body>
		<center>
			<h4><s:text name="label.userCreateForm.greeting"/></h4> 
			
			<s:actionerror />
			<s:form action="userRegisterAction">
	    	  <s:textfield key="label.username" name="user.userName"/>
	    	  <s:password  key="label.password" name="user.password"/>
	    	  <s:textfield key="label.firstName" name="user.firstName"/>
	    	  <s:textfield key="label.lastName" name="user.lastName" />
	     	  <s:textfield key="label.email" name="user.email"/>  	
	    	  <s:submit/>
			</s:form>
		</center>	
	</body>
	
</html>
