<%-- 
    Document   : user
    Created on : 12-Oct-2023, 11:25:44 AM
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
        <h1>User Login Success!</h1>
             <h1>User Login Success!</h1>
             <a href="http://localhost:8080/MiniProject/fc/?type=model&page=LogOutModel">Log Out</a>
             <%
                 HttpSession sess=request.getSession(false);
                 out.println(sess.getAttribute("lemail"));
                 %>
    </body>
</html>
