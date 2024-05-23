<%-- 
    Document   : getcountries
    Created on : 28-Nov-2023, 8:09:08 PM
    Author     : afroj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<script src="async.js"></script>-->
    </head>
    <body>
        <form action="fc/?type=model&page=RegistrationModel" method="POST">
        <h1>Hello World!</h1>
        <select name="country" id="countryId"> <!-- onclick="getStates('countryId','stateId');"> -->
                <c:forEach var="country" items="${countries}">
                    <option value="${country.getCountryCode()}">${country.getCountryName()}</option>
                </c:forEach>
            </select>
            <select name="states" id="stateId" >
                <option>Select State</option>
            </select>
        <li><input type="submit" value="send"/></li>
        <script src="async.js"></script>
    </body>
</html>
