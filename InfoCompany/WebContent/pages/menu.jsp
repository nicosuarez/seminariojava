<%@ taglib prefix="s" uri="/struts-tags" %>

 <div id="menu">
    <ul>
        <li class="current_page_item">
            <a href="welcome.jsp">home</a>
        </li>
        <li>
	       	 <s:url id="companyList" action="SearchCompanyAction"></s:url> 
	        <s:a href="%{companyList}" cssClass="permalink">Compañias</s:a>
        </li>
        <li>
            <a href="login.jsp">Log-in</a>
        </li>
        <li>
            <a href="userEditForm.jsp">Mi cuenta</a>
        </li>
        <li>
            <a href="reports.jsp#">Estadisticas</a>
        </li>
    </ul>
</div>