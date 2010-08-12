<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title">Resultado de Compañias </h2><br/>
                    <div class="entry">
                    
                    <s:if test="companies.size() == 0">
                   		<h3>No se ha encontrado ningun resultado para "<b><s:property value="companyName"/></b>",
                   		<s:url id="criticCompany" action="PrepareCreateCriticAction" namespace="/pages" >
							<s:param name="companyId" value="0" />
						</s:url> 
						<s:a href="%{criticCompany}"> desea agregar la compañia</s:a> </h3><br/>
                   	</s:if>
                   	<s:else>
                   		<h3>Se encontraron <s:property value="companies.size()"/> resultados: <b><s:property value="companyName"/></b></h3><br/>
                     	   <table border="1" style="border-spacing:7;width:100%;"  />
					    <tr>
					        <th><s:text name="label.name"/></th>
					        <th><s:text name="label.industry"/></th>
					        <th><s:text name="label.score"/></th>
					        <th></th>
					    </tr>
					    <s:iterator value="companies">
					        <tr>
					            <td><s:property value="name"/></td>
					            <td><s:property value="industry.name"/></td>
					            <td> <s:property value="getRating()"/></td>
					            <td>
					            	<s:url id="viewCompany" action="ViewCompanyAction">
										<s:param name="companyId" value="id" />
									</s:url> 
									<s:a href="%{viewCompany}">Ver</s:a>
								</td>
					        </tr>	
						</s:iterator>
						</table>
					</s:else>
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