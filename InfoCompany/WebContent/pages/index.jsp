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
                        	<div id="error">
	                        	<s:property value="name" />
	                        	<s:fielderror title="label.name" key="label.name" label="label.name" name="label.name" value="name" fieldName="name"  ></s:fielderror>
	                        	<s:actionerror label="Se ha producido los siguientes errores:"/>
                        	</div>
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
                    <h2 class="title">Empresas de moda/populares 
                        <br/>
                    </h2>
                    <div class="entry">
                        <p>
                            Free css. Cras at nibh. Aliquam fermentum. Nunc aliquet tempus dui.
                            Duis ultrices aliquet elit. Vestibulum id metus vel mi semper laoreet.
                            Nullam adipiscing consectetuer nisl. Lorem ipsum dolorede. Proin et
                            libero sed enim vehicula ornare. Etiam nec lacus. Proin id elit. Duis 
                            at massa. Suspendisse in dui eu magna viverra condimentum. 
                        </p>
                        <p class="meta">
                            <span class="posted">Posted on March 4, 2008 by <a href="#">Someone</a></span>
                            <a href="#" class="permalink">More</a>
                            <a href="#" class="comments">64</a>
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