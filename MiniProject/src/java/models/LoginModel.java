/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Statement;

/**
 *
 * @author afroj
 */
public class LoginModel implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        try (PrintWriter out = response.getWriter()) {
            String logemail = request.getParameter("logemail");
            String logpass = request.getParameter("logpassword");
            MyDao m1 = new MyDao();
            Statement st = m1.getStatement();
            String query = "SELECT password,status,role_id FROM login_table WHERE(email='" + logemail + "')";
            ResultSet rs = m1.fetchData(st, query);
            String query1="INSERT INTO login_tracking_info(email,login_time,logout_time,status)VALUES('"+logemail+"',NOW(),NULL,0)"; 
           // String password="";
            //int m=0;
          //  while (rs.next()) {
                if (!rs.next()) {
                    request.setAttribute("error", "Not Register pls Register !");
                    request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
                } else {
                    String password= rs.getString("password");
                    int m = rs.getInt("status");
                    int role=rs.getInt("role_id");
                    if (!password.equals(logpass)) {
                        request.setAttribute("error", "Wrong Password !");
                        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
                    } else if (m == 0) {
                        request.setAttribute("error", "Pleas Verify Your Email");
                        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
                    }else if(role==2){
                            m1.storeData(st, query1);
                            HttpSession sess=request.getSession(true);
                            sess.setAttribute("lemail",logemail);
                        request.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(request, response);
                    }else {
                       // Cookie ck1 = new Cookie("lemail",request.getParameter("logemail"));
                        //response.addCookie(ck1);
                        m1.storeData(st, query1);
                        HttpSession sess=request.getSession(true);
                        sess.setAttribute("lemail",logemail);
                        request.getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(request, response);

                    }
                }
            //}

            // out.println(logemail);
            //out.println(logpass);
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

}
