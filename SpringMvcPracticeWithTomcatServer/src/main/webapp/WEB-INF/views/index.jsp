<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>This is home page</h1>
    <h1>called from home controller</h1>
    <%
    String name = (String) request.getAttribute("name");
    Integer id = (Integer)request.getAttribute("id");
    List<String> friends= (List<String>)request.getAttribute("f");
    %>

    <h1>Name is <%= name %> </h1>
    <h1>Id is <%= id %> </h1>

    <%
     for(String s: friends){
     out.println(s);
     }
    %>

     <ul>
            <%
                if (friends != null) {
                    for (String friend : friends) {
                        out.println("<li>" + friend + "</li>");
                    }
                } else {
                    out.println("<li>No friends found.</li>");
                }
            %>
        </ul>

</body>
</html>
