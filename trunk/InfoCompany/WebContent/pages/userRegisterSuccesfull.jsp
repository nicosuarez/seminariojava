<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <s:include value="/pages/head.jsp"></s:include>
    <body>
    	<s:include value="/pages/header.jsp"></s:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title">Bienvenido <s:property value="userName" />!!<br\>
                    ya estas registrado en InfoCompany</h2>
                    <div class="entry">
                        <p>
                       		<a href="login.jsp" >Logueate</a> y empeza a compartir experiencias con el resto de la comunidad.
                       	</p>
                    </div>
                    <h2 class="title"> 
                        <br/>
                    </h2>
                    
                </div>
                <s:include value="/pages/sidebar.jsp"></s:include>
                <s:include value="/pages/divFooter.jsp"></s:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>
