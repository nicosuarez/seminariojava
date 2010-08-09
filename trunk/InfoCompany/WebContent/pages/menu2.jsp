<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	  <ul>
	      <li><a href="<s:url action='getAllCompanies' namespace='/pages/secure'/>">Companies</a></li>
	      <li><a href="<s:url action='LoginAction' namespace='/pages/'/>">Login</a></li>
	      <li><a href="<s:url action='UserCreateForm' namespace='/pages/'/>">Registrarse</a></li>
      </ul>
</body>
</html>