<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <s:include value="/pages/head.jsp"></s:include>
    <body>
    	<s:include value="/pages/header.jsp"></s:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title">Login</h2>
                    <div class="entry">
                        <p>
                            Ingrese nombre de usuario y contrasena para loguearse a InfoCompany. 
							<s:form action="LoginAction">
					    	  	<s:textfield name="username" label="Username"/>
					    	  	<s:password name="password" label="Password"/>
					    		<s:submit key="label.access"/>
							</s:form>
						</p>
						<div id="error">
                        	<s:property value="name" />
                        	<s:fielderror title="label.name" key="label.name" label="label.name" name="label.name" value="name" fieldName="name"  ></s:fielderror>
                        	<s:actionerror label="Se ha producido los siguientes errores:"/>
                       	</div>
                       	
                       	<p>
                            Sos nuevo? Queres compartir tus experiencias y opinar?.
                            Registrate es facil, rapido y anonimo. 
							<s:form action="UserAction">
					    		<s:submit key="label.register"/>
							</s:form>
						</p>
                    </div>
                </div>
                <s:include value="/pages/sidebar.jsp"></s:include>
                <s:include value="/pages/divFooter.jsp"></s:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>
