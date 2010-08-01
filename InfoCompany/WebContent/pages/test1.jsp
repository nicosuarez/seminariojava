<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts2-jquery-tags" %>

<html> 
   <head> 
      <sj:head compressed='false' enableCharting="true"/> 
   </head> 
   <body>
   
    <s:form action="pages/TestAjaxAction">
   	  	<s:textfield name="username" label="Username"/>
   	  	<s:password name="password" label="Password"/>
   		<s:submit/>
	</s:form>
   
	<div id="formResult"><p>Echo : <s:property value="echo"/></p></div>
    
    <sj:form id="form" action="simpleechoAction">
        <fieldset>
            <legend>AJAX Form</legend>
	        <sj:textfield name="password" label="Echo" />
	        <div>
	            <sj:submit targets="formResult" />
				<s:url id="simpleecho" value="simpleechoAction"/>
	            <sj:submit href="%{simpleecho}" targets="formResult" value="AJAX Submit 2" />
	        </div>
        </fieldset>
    </sj:form>
     
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
   
   
    </body> 
</html> 