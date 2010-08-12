<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Top TEN 
    <br/>
</h2>
<ul>
    <li>
       	<s:url id="rankingByScore" action="RankingAction" namespace="/pages">
       		<s:param name="criteria">RATING</s:param>
		</s:url>
		<s:a href="%{rankingByScore}">Mejores calificadas</s:a>
    </li>        	
    <li>
		<s:url id="rankEnv" action="RankingAction" namespace="/pages">
       		<s:param name="criteria">ENVIROMENT</s:param>
		</s:url> 	     
        <a href="<s:property value="%{rankEnv}"/>" >Mejor ambiente laboral</a>
    </li> 
    <li>
         <s:url id="rankBenefits" action="RankingAction" namespace="/pages">
       		<s:param name="criteria">BENEFITS</s:param>
		</s:url> 
        <a href="<s:property value="%{rankBenefits}"/>">Mas beneficios</a>
    </li>
    <li>
        <s:url id="rankGrowth" action="RankingAction" namespace="/pages">
       		<s:param name="criteria">GROWTH</s:param>
		</s:url>     
        <!--<a href="<s:property value="%{rankGrowth}"/>">Crecimiento profesional</a>-->
        <a href="#">Crecimiento profesional</a>
    </li>
    <li>    
        <a href="#">Puestos mejores pagos</a>
    </li>    
</ul>