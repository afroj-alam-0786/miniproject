/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.ResultSet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Statement;

/**
 *
 * @author afroj
 */
public class LogOutModel implements ModelInterface {

    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext ctxt) {
        try {
            MyDao m1 = new MyDao();
            Statement st = m1.getStatement();
            HttpSession sess = request.getSession(false);
            //System.out.println(sess.getAttribute("lemail"));
            String lemail = (String) sess.getAttribute("lemail");
            String query = "UPDATE login_tracking_info SET logout_time=NOW(),status=1 WHERE (email='" + lemail + "'&& status=0)";
            m1.storeData(st, query);
            sess.invalidate();
            if (request.getSession(false) == null) {
                System.out.println("Session Null");
                //System.out.println(sess.getAttribute("lemail"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
