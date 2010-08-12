<%@ taglib prefix="s" uri="/struts-tags" %>

 <div id="menu">
    <ul>
        <li class="current_page_item">
            <s:a href="welcome.jsp">home</s:a>
        </li>
        <li>
	       	 <s:url id="companyList" action="SearchCompanyAction"></s:url> 
	        <s:a href="%{companyList}" cssClass="permalink">Compañias</s:a>
        </li>
        <li>
            <a href="login.jsp">Log-in</a>
        </li>
        <li>
        	<s:url action="PrepareEditUserAction" id="editUser" namespace="/pages" />
            <s:a href="%{editUser}">Mi cuenta</s:a>
        </li>
        <li>
            <s:a href="reports.jsp#">Estadisticas</s:a>
        </li>
    </ul>
</div>