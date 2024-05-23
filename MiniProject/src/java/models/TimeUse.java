/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author afroj
 */
public class TimeUse implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        try (PrintWriter out = response.getWriter()) {
            String datachart = request.getParameter("datachart");
            System.out.println(datachart);
            MyDao m1 = new MyDao();
            Statement st = m1.getStatement();
            String query = "";
            if(!datachart.equals("cmonth")){
                query = "SELECT email, SUM(TIME_TO_SEC(TIMEDIFF(logout_time, login_time))) AS total_login_time "
                + "FROM login_tracking_info WHERE status = 1 AND MONTH(CURDATE()) = MONTH(login_time) GROUP BY email;";
        }else if(!datachart.equals("pmonth")){
                  query = "SELECT email, SUM(TIME_TO_SEC(TIMEDIFF(logout_time, login_time))) AS total_login_time "
                + "FROM login_tracking_info WHERE status = 1 AND MONTH(CURDATE() - INTERVAL 1 MONTH) = MONTH(login_time) GROUP BY email;";
        }else if(!datachart.equals("cyear")){
            query = "SELECT email, SUM(TIME_TO_SEC(TIMEDIFF(logout_time, login_time))) AS total_login_time "
                + "FROM login_tracking_info WHERE status = 1 AND YEAR(CURDATE()) = YEAR(login_time) GROUP BY email;";
        }else{
             query = "SELECT email, SUM(TIME_TO_SEC(TIMEDIFF(logout_time, login_time))) AS total_login_time "
                + "FROM login_tracking_info WHERE status = 1 AND YEAR(CURDATE() - INTERVAL 1 YEAR) = YEAR(login_time) GROUP BY email;";
        }
            ResultSet rs = m1.fetchData(st, query);
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                String email = rs.getString("email");
                long totalLoginTimeSeconds = rs.getLong("total_login_time");
                JSONObject userJson = new JSONObject();
                userJson.put("email", email);
                userJson.put("total_login_time", totalLoginTimeSeconds);
                jsonArray.add(userJson);
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("data", jsonArray.toJSONString());
            if (jsonArray.isEmpty()) {
                System.out.println("No data available");
            } else {
                request.getRequestDispatcher("/WEB-INF/pages/adminjsp.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
