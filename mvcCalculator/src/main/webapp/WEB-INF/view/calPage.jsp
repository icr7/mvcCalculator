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
<form action="processCal" name=resultCal method="GET">
<input type="text" name="t1"
    placeholder="1st number"/><br><br>

  <b style="color:DarkMagenta;">+</b><input type="radio" id="+" name="opt" value="+">
   
  
  &emsp;<b style="color:DarkMagenta;">-</b><input type="radio" id="-" name="opt" value="-">
   
   
   &emsp;<b style="color:DarkMagenta;">*</b><input type="radio" id="*" name="opt" value="*">

   
   &emsp;<b style="color:DarkMagenta;">/</b><input type="radio" id="/" name="opt" value="/">

<br><br>
  
<input type="text" name="t2"
    placeholder="2nd number"/><br><br>
   
    
<input type="submit" value="calculate" placeholder ="="/>

</form>
<script >
document.resultCal.opt[Math.floor(Math.random()*4)].checked=true;
</script>
</body>
</html>