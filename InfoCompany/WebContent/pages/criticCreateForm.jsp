<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                	<s:if test="company != null || company.id != 0">
                		<h2 class="title"><s:property value="company.name"/> &nbsp; (<s:property value="company.industry.name"/>)</h2> 
                	</s:if>
  
                    <div class="entry">
                    	<s:form action="CreateCriticAction" status="itStatus" namespace="/pages/secure" >
                    		<s:if test="company == null || company.id == 0">
		                		<s:textfield key="label.company" name="companyName"/>
		                		<s:select key="label.industry" list="industries" name="industryCompanyName" listKey="name" listValue="name" />
		                	</s:if>
               			    <s:iterator value="items">
					        	<s:select key="name" name="itemsScore" list="{'1','2','3','4','5','6','7','8','9',10}" />
							</s:iterator>
						 	<s:doubleselect key="label.location" name="country" list="countries" listKey="name" listValue="name" 
						 	doubleName="state" doubleList="states" doubleListKey="name" doubleListValue="name"/>
						 	<s:doubleselect key="label.job"  name="industryName" list="industries" listKey="name" listValue="name" 
						 	doubleName="jobName" doubleList="jobs" doubleListKey="name" doubleListValue="name"/>
		                    <s:textfield key="label.salary" name="salary"></s:textfield>	
							<s:textarea key="label.comment" name="comment" rows="5" cols="40"></s:textarea>
							<s:hidden name="companyId" value="%{companyId}" />
                   	    	<s:submit key="label.publish"></s:submit>
					    </s:form>
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