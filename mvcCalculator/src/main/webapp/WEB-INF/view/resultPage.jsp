<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}

button
{
    border-width: 2px;
    border-style: outset;
    border-color: /*Insert a darker version of your button color here*/
}


</style>
</head>
<body>
<div>
<h2> icr7 Calculator</h2>
<h4> fill details to calculate </h4>
<br>
<form action="processCal" name="resultCal" method="GET">
<input type="text" name="t1"
    placeholder="<%=request.getAttribute("num1")%>"/><br><br>
    
 
   <b style="color:DarkMagenta;">+</b><input type="radio" name="opt" value="+">
   
  
  &emsp;<b style="color:DarkMagenta;">-</b><input type="radio" name="opt" value="-">
   
   
   &emsp;<b style="color:DarkMagenta;">*</b><input type="radio" name="opt" value="*">

   
   &emsp;<b style="color:DarkMagenta;">/</b><input type="radio" name="opt" value="/">
<br><br>
    
<input type="text" name="t2"
    placeholder="<%=request.getAttribute("num2")%>"/><br><br>


   
    
<input type="submit" value="calculate" placeholder ="="/>



</form>
<%=request.getAttribute("num1")%> <%=request.getAttribute("opt")%> <%=request.getAttribute("num2")%>
= <%=request.getAttribute("output")%>

<script>
document.resultCal.opt[<%=request.getAttribute("symbolNum")%>].checked=true;

</script>

</body>
</html>