<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Help Page</title>
</head>
<body>
<%
String name=(String)request.getAttribute("name");
Integer roll=(Integer)request.getAttribute("roll");
LocalDateTime date=(LocalDateTime)request.getAttribute("clock");
%>
    <h1>My name is <%= name%></h1>
    <h1>My roll is <%= roll%></h1>
    <h1>Todays time is <%= date.toString()%></h1>
</body>
</html>