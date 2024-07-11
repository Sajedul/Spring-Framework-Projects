<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h1>${Header}</h1>
<p>${Desc}</p>
<h1 style="color:green">${msg}</h1>
<hr>
    <h1> Hello ${user.name}</h1>
    <h1> Your Email addreass is: ${user.email}</h1>
    <h1> Your password is: ${user.password}</h1>
</body>
</html>