<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <s:include value="/pages/head.jsp"></s:include>
    <body>
    	<s:include value="/pages/header.jsp"></s:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                    <h2 class="title">Bienvenidos a infocompany</h2>
                    <div class="entry">
                        <p>
                            Infocompany sirve como guia a aquellas personas que inician una
                            busqueda laboral o necesitan informacion del mercado, en base a la 
                            experiencia y opinion de la comunidad. 
                            <br/>
                            El objetivo es que podamos tener una herramienta mas al momento de
                            decidir en que empresa queremos trabajar, que opiniones tienen los
                            demas de la empresa en que trabajo, saber si me estan pagando lo que se
                            esta pagando en el mercado, cual ofrece mejores beneficios, crecimiento 
                            profesional, ambiente laboral ... y mas. 
                            <br/>
                            Por eso te invitamos a que nos cuentes tu experiencia calificando la 
                            empresa, es facil, rapido y anonimo. 
                            <br/>
                            Desde ya gracias por sumar tu experiencia, nos sirve a todos! 
                            <br/>
                        </p>
                        
                    </div>

                    <br/>
                    <div style="margin: auto; width: 80%;">
	                     <s:iterator value="companyCloud.tags()" status="status" >
				       		 <a href="<s:property value="link"/>" style="font-size: <s:property value="weight"/>px;"><s:property value="name" /></a>
				   		 </s:iterator>
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