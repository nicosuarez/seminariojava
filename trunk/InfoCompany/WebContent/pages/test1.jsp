<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html> 
   <head> 
       <sj:head/>
       <script type="text/javascript">
	       $.subscribe('hideTarget', function(event, data) {
	   			$('#'+event.originalEvent.targets).delay(2000).hide("blind", 2500);
	   		});
       </script>
   </head> 
   <body>
	
	<div id="content">
		<div id="formResult" >
			<p>Ingreso div: <s:property value="password"/></p>
		</div>
		
		<div id="formResult1" >
			<p>Ingreso div1: <s:property value="password"/></p>
		</div>
		
		<s:form action="pages/TestAjaxAction">
	   	  	<s:textfield name="username" label="Username"/>
	   	  	<s:password name="password" label="Password"/>
	   		<s:submit/>
		</s:form>
		
		<s:form id="form" action="simpleechoAction">
	        <fieldset>
	            <legend>AJAX Form</legend>
		        <div>
		        	<sj:textfield name="password" label="Nombre: "/>
					<s:url id="simpleecho" value="simpleechoAction"/>
		            <sj:submit href="%{simpleecho}" targets="content,formResult" effect="slide" effectMode="blind" onEffectCompleteTopics="hideTarget" indicator="indicator" 
                	button="true">Ajax Submit</sj:submit>
		            <sj:a id="ajaxlink" href="%{simpleecho}" targets="content" >Run Ajax in Action </sj:a>
		        </div>
	        </fieldset>
   		 </s:form>
   	</div>
   	
  	<div id="formResult" >
		<p>Ingreso div: <s:property value="password"/></p>
	</div>
   	
   	

    
    
<!-- 
     <div id="div1">Div 1</div>
    	<s:url id="ajaxTest" value="TestAjaxAction"/>
    	<sj:a id="link1" href="%{ajaxTest}" target="div1" >Update Content</sj:a>
     <br/>
     
      <sj:accordion options="{active: false,collapsible:true, autoHeight:false }"> 
         <sj:accordionItem title="Accordion Menu"> 
            <sj:a href="accordion.action" targets="components" indicatorId="loadIndicator">Accordion Sample</sj:a> 
         </sj:accordionItem> 
         <sj:accordionItem title="Anchor"> 
            <sj:a href="anchor.action" targets="components" indicatorId="loadIndicator">Anchor Sample 1</sj:a> 
         </sj:accordionItem> 
         <sj:accordionItem title="Datepicker"> 
            <sj:a href="datepicker.action" targets="components" indicatorId="loadIndicator">Datepicker Samples</sj:a> 
         </sj:accordionItem>	
      </sj:accordion> 
   
   		<sj:chart data="chartData" showBars="true,false,false" 
     showPoints="false,true,false" showLines="false,true,true" 
     labels="Series 1, Series 2, Series 3" showLegend="true" 
     cssStyle="height: 300px" yAxis1Label="y1 Axis" xAxis1Label="x1 Axis"/>
   
    Enter String: <sj:textfield onChangeTopics="textfieldUpdated" id="textfield1" name="echo"/>	
      Reversed String: <sj:textfield reloadTopics="textfieldUpdated" src="TestAjaxAction" elementIds="textfield1"/> 
   -->
   
    </body> 
</html> 