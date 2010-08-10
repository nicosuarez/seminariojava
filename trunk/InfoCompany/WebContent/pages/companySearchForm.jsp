<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Buscar Compania</h2>
<ul>
    <li>
    	<s:form action="SearchCompanyAction">
    	  <s:textfield name="companyName"/>
      	  <s:submit key="label.go"></s:submit>
		</s:form>	
    </li>
</ul>