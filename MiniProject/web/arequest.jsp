<%-- 
    Document   : arequest
    Created on : 21-Nov-2023, 11:53:51 AM
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
        <%
            out.println(request.getAttribute("exist"));
            %>
    </body>
</html>
