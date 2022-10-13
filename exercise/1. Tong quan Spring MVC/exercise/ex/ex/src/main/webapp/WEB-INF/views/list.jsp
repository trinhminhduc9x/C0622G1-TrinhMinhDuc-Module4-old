<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
<%--    <link rel="stylesheet" type="text/css" href="css/style.css">--%>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/" method="post">


        <input type="number" name="usd" value="${usd}"> USD <br> <br>
        <input type="submit" value="Convert">
        <p>USD: ${usd}</p>
        <p>VND: ${vnd}</p>


<%--    <label>Rate: </label><br/>--%>
<%--    <input type="text" name="rate" placeholder="RATE" value="${rate}"/><br/>--%>
<%--    <label>USD: </label><br/>--%>
<%--    <input type="text" name="usd" placeholder="USD" value="${usd}"/><br/>--%>
<%--    <input type = "submit" id = "submit" value = "Converter"/>--%>
</form>
</body>
</html>