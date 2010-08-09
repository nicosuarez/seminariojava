<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:include page="/pages/head.jsp"></jsp:include>
    <body>
    	<jsp:include page="/pages/header.jsp"></jsp:include>
        <div id="page">
            <div id="content">
                <div id="latest-post" class="post">
                	<h2 class="title"><s:text name="label.userCreateForm.greeting"/></h2>
                    <div class="entry">
                        <p>						
							<s:form action="UserAction">
					    	  <s:textfield key="label.username" name="user.userName" required="true"/>
					    	  <s:password  key="label.password" name="user.password"/>
					    	  <s:textfield  key="label.email" name="user.email"/>
					    	  <s:textfield key="label.birthdayYear" name="user.birthdayYear"/>
					      	  <s:submit/>
							</s:form>	
							<s:actionerror />					
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
                <jsp:include page="/pages/sidebar.jsp"></jsp:include>
                <jsp:include page="/pages/divFooter.jsp"></jsp:include>
            </div> 
        </div> 
        <jsp:include page="/pages/footer.jsp"></jsp:include>
        <!-- end page -->
    </body>
</html>