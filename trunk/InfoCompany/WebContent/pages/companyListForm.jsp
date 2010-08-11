<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title">Resultado de Companias </h2>
                    <div class="entry">
                    <s:property value="companyName"/>
                        <table border="1">
						    <tr>
						        <th><s:text name="label.name"/></th>
						        <th><s:text name="label.field"/></th>
						        <th><s:text name="label.options"/></th>
						    </tr>
						    <s:iterator value="companies">
						        <tr>
						            <td><s:property value="name"/></td>
						            <td><s:property value="industry.name"/></td>
						            <td>
						            	<s:url id="viewCompany" action="ViewCompanyAction">
											<s:param name="companyId" value="id" />
										</s:url> 
										<s:a href="%{viewCompany}">Ver</s:a>
									</td>
						        </tr>	
							</s:iterator>
					    </table>
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