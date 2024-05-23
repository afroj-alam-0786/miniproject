<%-- 
    Document   : adminjsp
    Created on : 26-Dec-2023, 5:09:21 PM
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
        <h1>TIME CHART!</h1>
            <div class="form-group m-0">
    </div>
    
    <div>
        <canvas id="mycanvas" width=" 1000" height=" 1000"></canvas>
    </div>

    <script>
        let jsonData = ${data};
        let total_time = 0;
        
        for (let user of jsonData) {
            total_time+=user.total_login_time;
        }
        console.log(total_time);

        let ctx = document.querySelector("#mycanvas").getContext("2d");
        let currentAngle = -0.5 * Math.PI;

        for (let data of jsonData) {
            let sliceAngle = (data.total_login_time/total_time)*2*Math.PI;
            
            let color = getRandomColor();
            
            ctx.beginPath();
            ctx.arc(300, 300, 300, currentAngle, currentAngle + sliceAngle);
            ctx.lineTo(300, 300);
            ctx.fillStyle = color;
            ctx.fill();
            
            drawArrow(300, 300, 310, currentAngle + 0.5 * sliceAngle, color);
            writeUsername(300, 300, 290, currentAngle+0.5*sliceAngle, data.email);
            currentAngle += sliceAngle;
        }

        function getRandomColor() {
            return '#' + Math.floor(Math.random()*16777215).toString(16);
        }

        function drawArrow(x, y, radius, angle, color) {
            ctx.fillStyle = color;
            ctx.beginPath();
            ctx.moveTo(x, y);
            ctx.lineTo(x + radius * Math.cos(angle), y + radius * Math.sin(angle));
            ctx.lineTo(x + radius * Math.cos(angle + 0.05), y + radius * Math.sin(angle + 0.05));
            ctx.lineTo(x, y);
            ctx.fill();
        }

        function writeUsername(x, y, radius, angle, username) {
            ctx.fillStyle = 'black';
            ctx.font = '12px Arial';
            ctx.fillText(username, x + radius * Math.cos(angle), y + radius * Math.sin(angle));
        }
    </script>
    </body>
</html>
