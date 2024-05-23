<%-- 
    Document   : admin
    Created on : 12-Oct-2023, 11:26:08 AM
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
        <h1>Welcome To Admin!</h1>
        <form action="fc/?type=model&page=TimeUse"method="POST">
        <select name="datachart">
        <option value="ctoday">Current Month</option>
        <option value="pmonth">Previous Month</option>
        <option value="cyear">Current Year</option>
         <option value="pyear">Previous Year</option>
       <!-- <li>Gender<input type="radio" name="gender" value="male" required> Male  
                        <input type="radio" name="gender" value="female" required> Female</li>-->
        <li><input type="submit" value="Submit"/></li>
        </select>
          <!--<input type="text" name="firstname" placeholder="FirstName" required/><br>
          <li><input type="submit" value="login"/></li>-->
         </form>
             <a href="http://localhost:8080/MiniProject/fc/?type=model&page=LogOutModel">Log Out</a>
             <a href="http://localhost:8080/MiniProject/fc/?type=model&page=TimeUse">Time Use</a>
             
    </body>
</html>
