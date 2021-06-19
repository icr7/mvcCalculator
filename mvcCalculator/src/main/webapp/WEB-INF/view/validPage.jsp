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
<h4>hi,
<%=request.getAttribute("username")%>  
<a href="ShowMyCalPage">Click here for calculation</a>  
</h4>
<br>

</div>
</body>
</html>