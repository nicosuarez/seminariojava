<%@ taglib prefix="s" uri="/struts-tags" %>

 <div id="menu">
    <ul>
        <li class="current_page_item">
        	 <s:url id="welcome" action="WelcomeAction" namespace="/pages"></s:url> 
            <s:a href="%{welcome}">home</s:a>
        </li>
        <li>
	       	 <s:url id="companyList" action="SearchCompanyAction" namespace="/pages" ></s:url> 
	        <s:a href="%{companyList}" cssClass="permalink">Compañias</s:a>
        </li>
        <li>
        	<s:url id="loginForm" action="LoginForm" namespace="/pages"></s:url> 
	        <s:a href="%{loginForm}" cssClass="permalink">Log-in</s:a>
        </li>
        <li>
        	<s:url action="PrepareEditUserAction" id="editUser" namespace="/pages/secure" />
            <s:a href="%{editUser}">Mi cuenta</s:a>
        </li>
        <li>
        	<!--<s:url action="PrepareEditUserAction" id="editUser" namespace="/pages/secure" />
            <s:a href="%{editUser}">Mi cuenta</s:a>
            --><s:a href="reports.jsp">Estadisticas</s:a>
        </li>
    </ul>
</div>