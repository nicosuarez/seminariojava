<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<link href="resources/style.css" rel="stylesheet" type="text/css" />
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
	    
	    <center>
			<table>
				<tr>
					<s:url id="insertCompany" action="setUpForInsertOrUpdateCompany" />
					<td><s:a href="%{insertCompany}">Agregar Compañia</s:a></td>
				</tr>
			</table>
			<br>
			<br>
			<br>
			<table border="1">
			    <tr>
			        <th><s:text name="label.name"/></th>
			        <th><s:text name="label.field"/></th>
			        <th><s:text name="label.options"/></th>
			    </tr>
			    <s:iterator value="companies">
			        <tr>
			            <td class="nowrap"><s:property value="Name"/></td>
			            <td class="nowrap"><s:property value="FielfId"/></td>
			            <td class="nowrap"><s:url id="updateCompany" action="setUpForInsertOrUpdateCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url> <s:a href="%{updateCompany}">Edit</s:a>
							 &nbsp;&nbsp;&nbsp;
							 <s:url id="deleteCompany" action="deleteCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url>
						    <s:a href="%{deleteCompany}">Delete</s:a>
						</td>
			        </tr>	
				</s:iterator>
		    </table>
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
