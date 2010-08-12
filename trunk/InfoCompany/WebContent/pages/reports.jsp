<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title"><s:text name="%{criteria}" /></h2><br/>
                    <div class="entry">
                   	   <table border="1" style="border-spacing:7;width:100%;"  />
						    <tr>
						    	<th></th>
						        <th><s:text name="label.name"/></th>
						        <th><s:text name="label.industry"/></th>
						        <th><s:text name="label.score"/></th>
						        <th></th>
						    </tr>
						    <s:iterator value="companies" status="it">
						        <tr>
						        	<td><s:property value="#it.count"/></td>
						            <td><s:property value="name"/></td>
						            <td><s:property value="industry.name"/></td>
						            <td> <s:property value="getRating()"/></td>
						            <td>
						            	<s:url id="viewCompany" action="ViewCompanyAction" namespace="/pages">
											<s:param name="companyId" value="id" />
										</s:url> 
										<s:a href="%{viewCompany}">Ver</s:a>
									</td>
						        </tr>	
							</s:iterator>
						</table>
                    </div>
                    <div class="entry"></div>
                  
                </div>
                <jsp:include page="/pages/sidebar.jsp"></jsp:include>
                <jsp:include page="/pages/divFooter.jsp"></jsp:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>