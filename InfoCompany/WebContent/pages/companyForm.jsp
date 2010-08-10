<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


		<center>
	    	<s:form validate="true">
				<b><s:if test="company==null || company.CompanyId == null">
						<s:text name="label.company.add" /></s:if>
					<s:else>
						<s:text name="label.company.edit" /></s:else> 
				</b>
				
			     <s:textfield key="label.name" name="company.Name"/>
		   		 <s:select key="label.field" name="nameField"
						    list="fields"
						  	headerKey="1"
						    headerValue="-- Seleccionar --"
						    listKey = "fieldId"
						    listValue="description"/>
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

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <!-- <h2 class="title"><s:property value="company.name"/> &nbsp; (<s:property value="company.industry.name"/>)</h2>
                    <div class="entry"> 
	                    <table border="1">
						    <tr>
						        <th><s:text name="label.name"/></th>
						        <th><s:text name="label.field"/></th>
						        <th><s:text name="label.options"/></th>
						    </tr>
						    <s:iterator value="company.critics.items">
						        <tr>
						        	<td ><s:property value="value"/></td>
						            <td ><s:property value="score"/></td>
						            <td></td>
						        </tr>	
							</s:iterator>
							
							<s:url id="updateCompany" action="setUpForInsertOrUpdateCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url> <s:a href="%{updateCompany}">Edit</s:a>
								
							 <s:url id="deleteCompany" action="deleteCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url>
						    <s:a href="%{deleteCompany}">Delete</s:a>
					    </table>-->
                    </div>
                    <h2 class="title">Empresas de moda/populares 
                        <br/>
                    </h2>
                    <div class="entry">
                        <p>
                            Free css. Cras at nibh. Aliquam fermentum. Nunc aliquet tempus dui.
                            Duis ultrices aliquet elit. Vestibulum id metus vel mi semper laoreet.
                            Nullam adipiscing consectetuer nisl. Lorem ipsum dolorede. Proin et
                            libero sed enim vehicula ornare. Etiam nec lacus. Proin id elit. Duis 
                            at massa. Suspendisse in dui eu magna viverra condimentum. 
                        </p>
                        <p class="meta">
                            <span class="posted">Posted on March 4, 2008 by <a href="#">Someone</a></span>
                            <a href="#" class="permalink">More</a>
                            <a href="#" class="comments">64</a>
                        </p>
                    </div>
                </div>
                <jsp:include page="/pages/sidebar.jsp"></jsp:include>
                <jsp:include page="/pages/divFooter.jsp"></jsp:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>