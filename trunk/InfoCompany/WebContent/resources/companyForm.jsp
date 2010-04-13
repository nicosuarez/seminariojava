<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<link href="resources/style.css" rel="stylesheet" type="text/css"/>
  		<title>InfoCompany v1.0 | 2010 project...</title>
	</head>
	<body>
		<div id="wrapper"></div>
		<div id="header"></div>

		<div id="nav">
		 <%@ include file="/resources/menu.jsp" %>
		</div>

		<div id="content"></div>
    	<div id="right"></div>
    
		<table>
			<tr>
				<td class="tdValidate"> 
		            <s:fielderror/>
	                <s:actionerror/>
	                <s:actionmessage/>
	            </td>
	        </tr>
	     </table>		 	
		
		<center>
	    	<s:form validate="true">
				<b><s:if test="company==null || company.CompanyId == null">
						<s:text name="label.company.add" /></s:if>
					<s:else>
						<s:text name="label.company.edit" /></s:else> 
				</b>
				
			     <s:textfield key="label.name" name="company.Name"/>
		   		 <s:select key="label.field" name="company.FieldId"
						    headerKey="1"
						    headerValue="-- Seleccionar --"
						    list="#{'1':'Rubro de prueba','2':'Otros'}"/>
				 <s:hidden name="company.CompanyId"></s:hidden>
			    <br>
			    <br>
			    <br>
			    <table>
					<tr>
						<td><s:submit action="insertOrUpdateCompany" key="button.label.submit"/></td>
						<td><s:reset key="button.label.cancel"/></td>
					</tr>
				</table> 		 
		    </s:form>
	    </center>
		<br class="clear" />
		<div id="footer">
			<center>
			<p>Project 2010 Seminario de ingenieria en informatica | Universidad de Buenos Aires 
			</p>
			</center>
		</div>
	</body>
</html>