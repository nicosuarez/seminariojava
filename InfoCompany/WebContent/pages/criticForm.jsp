<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title"><s:property value="company.name"/> &nbsp; (<s:property value="company.industry.name"/>)</h2><br/>
                    <h2 class="title"><s:property value="critic.getJob().getName()"/> &nbsp; (<s:property value="critic.getIndustry().getName()"/>)&nbsp;| Salario: $<s:property value="critic.salary"/></h2><br/>
                    <div class="entry"> 
	                    <table>
						    <tr>
						        <th></th>
						        <th></th>
						    </tr>
						    <s:iterator value="critic.items">
						        <tr>
						        	<td ><s:property value="tag"/>:&nbsp;</td>
						            <td ><s:property value="score"/></td>
						        </tr>	
							</s:iterator>				
					    </table>
                    </div>
                    <h2 class="title">Comentar
                        <br/>
                    </h2>
                    <div class="entry">
                    	<s:form action="CommentAction" namespace="/pages/secure">
                        	<s:textarea rows="5" cols="60" name="textComment"/>
							    <s:hidden name="criticId" value="%{criticId}">
							    </s:hidden> 
    	                        <s:hidden name="companyId" value="%{companyId}"/>                       	                       	
                        	<s:submit key="label.publish"/>
                        </s:form>            
                    </div>
                   
               		 <s:iterator value="critic.getReplies()" status="itStatus">
	                    <div class="entry">
	                    	<table>
	                    		<tr>
		                    		<td>
				                        <p>
				                        	<s:property value="text"/> 
				                        </p>
			                        </td>
		                        </tr>
	                        </table>
	                        <p class="meta">
	                            <span class="posted">Posted on <s:property value="date"/> by 
	                            <s:property value="author.userName"/>&nbsp;(<s:property value="author.reputation"/>)</span>
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