<%@ taglib prefix="s" uri="/struts-tags" %>

<h2><s:text name="title.searchMenu"/></h2>
<ul>
    <li>
    	<s:form action="SearchCompanyAction">
    	  <s:textfield name="companyName"/>
      	  <s:submit key="label.search"></s:submit>
		</s:form>	
    </li>
</ul>