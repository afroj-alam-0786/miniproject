<%-- 
    Document   : error
    Created on : 10-Oct-2023, 11:25:08 AM
    Author     : afroj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error</h1>
        <%
            out.println(request.getAttribute("error"));
            %>
    </body>
</html>
