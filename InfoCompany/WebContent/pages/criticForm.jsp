<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title"><s:property value="company.name"/> &nbsp; (<s:property value="company.industry.name"/>)</h2>
                    <div class="entry"> 
	                    <table>
						    <tr>
						        <th><s:text name="label.name"/></th>
						        <th><s:text name="label.field"/></th>
						        <th><s:text name="label.options"/></th>
						    </tr>
						    <s:iterator value="critic.items">
						        <tr>
						        	<td ><s:property value="value"/></td>
						            <td ><s:property value="score"/></td>
						            <td></td>
						        </tr>	
							</s:iterator>
							
							<!-- 
							<s:url id="updateCompany" action="setUpForInsertOrUpdateCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url> <s:a href="%{updateCompany}">Edit</s:a>
								
							 <s:url id="deleteCompany" action="deleteCompany">
								<s:param name="company.CompanyId" value="CompanyId" />
							</s:url>
						    <s:a href="%{deleteCompany}">Delete</s:a>-->
					    </table>
                    </div>
                    <h2 class="title">Comentar
                        <br/>
                    </h2>
                    <div class="entry">
                    	<s:form action="CommentCompanyAction">
                        	<s:textarea rows="5" cols="60"></s:textarea>
                        	<s:submit key="label.publish"></s:submit>
                        </s:form>
                    </div>
                   
               		 <s:iterator value="critic.comments" status="itStatus">
               		 	<h1 class="title">
               		 		<s:property value="jobName" />(<s:property value="industryName" />) &nbsp; &nbsp; $<s:property value="salary" />  
                        	<br/>
                    	</h1>
	                    <div class="entry">
	                    	<table>
	                    		<tr>
		                    		<td>
				                        <p>
				                            Free css. Cras at nibh. Aliquam fermentum. Nunc aliquet tempus dui.
				                            Duis ultrices aliquet elit. Vestibulum id metus vel mi semper laoreet.
				                            Nullam adipiscing consectetuer nisl. Lorem ipsum dolorede. Proin et
				                            libero sed enim vehicula ornare. Etiam nec lacus. Proin id elit. Duis 
				                            at massa. Suspendisse in dui eu magna viverra condimentum. 
				                        </p>
			                        </td>
			                        <td>
				                        <s:property value="author.reputation" />
			                        </td>
		                        </tr>
	                        </table>
	                        <p class="meta">
	                            <span class="posted">Posted on <s:property value="postedDate"/> by 
	                            <s:property value="author.userName"/>(<s:property value="author.reputation"/>)</span>
	                            <a href="#" class="permalink">More</a>
	                            <a href="#" class="comments">(<s:property value="repliesSize"/>)</a>
	                        </p>
	                    </div>
                    </s:iterator>
                </div>
                <jsp:include page="/pages/sidebar.jsp"></jsp:include>
                <jsp:include page="/pages/divFooter.jsp"></jsp:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>