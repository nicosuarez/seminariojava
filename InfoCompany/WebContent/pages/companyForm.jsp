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
						        <th></th>
						        <th></th>
						    </tr>
						    <s:iterator value="criticItems">
						        <tr>
						        	<td ><s:property value="tag"/></td>
						            <td ><s:property value="score"/></td>
						        </tr>	
							</s:iterator>
							
							<tr>
							    <td colspan="1">
							    	<!--<s:set var="Company" value="company" scope="session"/>-->
									<s:url id="criticCompany" action="CriticCompany">
										<s:param name="companyId" value="id" />
									</s:url> 
									<s:a href="%{criticCompany}">Criticar</s:a>
								</td>
							</tr>
							
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
                   
               		 <s:iterator value="company.critics" status="itStatus">
               		 	<h1 class="title">
               		 		<s:property value="getJob().getName()" />&nbsp;(<s:property value="getIndustry().getName()" />) &nbsp; &nbsp; <s:property value="getScore()" />  
                        	<br/>
                    	</h1>
	                    <div class="entry">
	                    	<table>
	                    		<tr>
		                    		<td>
				                        <p>
				                           <s:property value="getAuthorComment().getText()"/>
				                        </p>
			                        </td>
		                        </tr>
	                        </table>
	                        <p class="meta">
	                            <span class="posted">Posted on <s:property value="getAuthorComment().date"/> by 
	                            <s:property value="author.userName"/> (<s:property value="author.reputation"/>)</span>
	                            

	                            <s:url id="positiveCritic" action="CriticLikeAction">
									<s:param name="criticId" value="id" />
									<s:param name="companyId" value="companyId" />
									<s:param name="value" value="1" />
								</s:url>							                         
	                            <s:a href="%{positiveCritic}" cssClass="handUp">(<s:property value="positiveCriticScore"/>)</s:a>
	                            
	                            <s:url id="negativeCritic" action="CriticLikeAction">
									<s:param name="criticId" value="id" />
									<s:param name="companyId" value="companyId" />
									<s:param name="value" value="-1" />
								</s:url>
	                            <s:a href="%{negativeCritic}" cssClass="handDown">(<s:property value="negativeCriticScore"/>)</s:a>
	                            
	                            <s:url id="abuseCritic" action="CriticAbuseAction">
									<s:param name="criticId" value="id" />
									<s:param name="companyId" value="companyId" />
								</s:url>
	                            <s:a href="%{abuseCritic}" cssClass="abuse"></s:a>
	                            
	                            <s:url id="viewCritic" action="ViewCriticAction">
									<s:param name="criticId" value="id" />
									<s:param name="companyId" value="companyId" />
								</s:url> 
	                            <s:a href="%{viewCritic}" cssClass="permalink">More</s:a>
	                            <s:a href="%{viewCritic}" cssClass="comments">(<s:property value="repliesSize"/>)</s:a>
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


