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
                    	<s:form action="CreateCriticAction" status="itStatus">
               			    <s:iterator value="items">
					        	<s:select key="name" name="critic.getItems()[#itStatus.Count].score" list="{'1','2','3','4','5','6','7','8','9',10}" />
							</s:iterator>
						 	<s:doubleselect key="label.location" name="critic.countryName" list="countries" listKey="id" listValue="name" 
						 	doubleName="critic.stateName" doubleList="states" doubleListKey="id" doubleListValue="name"/>
						 	<s:doubleselect key="label.job" name="critic.industryName" list="industries" listKey="id" listValue="name" 
						 	doubleName="critic.jobName" doubleList="jobs" doubleListKey="id" doubleListValue="name"/>
		                    <s:textfield key="label.salary" name="critic.salary"></s:textfield>	
							<s:textarea key="label.comment" name="critic.comment" rows="5" cols="40"></s:textarea>
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