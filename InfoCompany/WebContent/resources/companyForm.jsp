<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	
	<head>
		<link href="resources/style.css" rel="stylesheet" type="text/css"/>
  		<title>InfoCompany v1.0 | 2010 project...</title>
	</head>
	<body>
	
	<div id="wrapper">
	
	<div id="header">
	</div>

  <div id="nav">
	  <%@ include file="/resources/menu.jsp" %>
  </div>

	<div id="content">
	

    
    <div id="right">
	
	
    
	 <table>
		<tr><td class="tdValidate"> 
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
	<table border="1">
	
         <tr>
         	<td class="tdLabel"><s:text name="label.Name"/></td>
        </tr>
        <tr>
        	<td class="tdField"><s:textfield name="company.Name"/></td>
        	
        </tr>
        

        <s:hidden name="company.CompanyId"></s:hidden>

    </table>
    
    <br>
    <br>
    <br>
    
     	
    <table>
		<tr>
			<td><s:submit action="insertOrUpdateEst" key="button.label.submit"/></td>
			<td><s:reset key="button.label.cancel"/></td>
		</tr>
	</table> 		 
    
    </s:form>
    
    </center>
    
	</div>
	</div>

	<br class="clear" />
	
	
	<div id="footer">
		<center>
		<p>Project 2010 Seminario de ingenieria en informatica | Universidad de Buenos Aires 
		</p>
		</center>
	</div>

	</div>

	</body>
</html>