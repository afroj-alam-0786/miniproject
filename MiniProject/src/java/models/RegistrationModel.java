/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author afroj
 */
public class RegistrationModel implements ModelInterface {

    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        try (PrintWriter out = response.getWriter()) {
            String mn = request.getParameter("mobileno");
            String em = request.getParameter("email");
            String pass = request.getParameter("password");
            String fn = request.getParameter("firstname");
            String ln = request.getParameter("lastname");
            String dob = request.getParameter("dob");
            String gn = request.getParameter("gender");
            String query = "SELECT max(uid) FROM user_table";
            MyDao m1 = new MyDao();
            int rid = 1;
            Statement st = m1.getStatement();
            String query1 = "INSERT INTO login_table(email,password,status,role_id)VALUES('" + em + "','" + pass + "','" + 0 + "','" + rid + "')";
            m1.storeData(st, query1);
            int id = 0;
            ResultSet rs = m1.fetchData(st, query);
            while (rs.next()) {
                id = rs.getInt("max(uid)");
                id++;
            }
            int m = 2;
            if (gn.equals("male")) {
                m = 1;
            }
            String query2 = "INSERT INTO user_table(uid,firstname,lastname,dob,mobileno,gender,email)VALUES('" + id + "','" + fn + "','" + ln + "','" + dob + "','" + mn + "','" + m + "','" + em + "')";
            m1.storeData(st, query2);
            MailSender ms = new MailSender();
            ms.sendMail(em);
            request.getRequestDispatcher("/afterlogin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // request.getRequestDispatcher("/afterlogin.jsp").forward(request,response);
    }

}
