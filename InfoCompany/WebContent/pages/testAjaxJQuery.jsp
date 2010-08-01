<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html> 
   <head> 
      <sj:head compressed='false'/> 
      <script> 
         window.setTimeout(function() { 
            $.publish('timesUp'); 
         }, 5000); 
      </script> 
   </head> 
   <body>	
         <sj:form submitTopics="timesUp" targetId="result" validate="true" action="calculateProduct"> 
            Integer A: <input type="text" name="integerA" value="10"/> 
            Integer B: <input type="text" name="integerB" value="4"/> 
         </sj:form> 
         Delayed Result: <sj:textfield id="result" name="integerC" cssStyle="color:red"/> 
   </body> 
</html> 
