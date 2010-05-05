<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Error</title>
	</head>

	<body>
		<h4>Ha ocurrido un error en el sistema InfoCompany.</h4>
		<p> Por favor, lea el siguiente detalle de los
			problemas encontrados durante el procesamiento de su solicitud. Después de determinar qué errores se
			puedo haber ocurrido, por favor vuelva a enviar su solicitud. Mejor suerte la próxima vez! </p> 
		
		<p>Exception Name:<s:property value="exception" /></p> 
		<p>Que hizo mal?: <s:property value="exceptionStack" /></p> 
		
		<h5>Tambien, porfavor confirmar que su conexion de internet este funcionando antes de contactarnos. Gracias.</h5>
	</body>
	
</html>
