<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Login</title>
	</head>

	<body>
		<center>
			<h4>Ingrese nombre de usuario y contrasena para loguearse a InfoCompany.</h4> 
			<s:form action="LoginAction">
	    	  	<s:textfield name="username" label="Username"/>
	    	  	<s:password name="password" label="Password"/>
	    		<s:submit/>
			</s:form>
		</center>	
		<div id="footer">
			<center>
			<p>Project 2010 Seminario de ingenieria en informatica | Universidad de Buenos Aires 
			</p>
			</center>
		</div>
	</body>
</html>
