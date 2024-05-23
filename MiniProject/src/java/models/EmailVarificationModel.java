/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.servlet.ServletContext;
import java.sql.Connection;
import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author afroj
 */
public class EmailVarificationModel implements ModelInterface{
    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response,ServletContext context) {
        try (PrintWriter out = response.getWriter()) {
            String em = request.getParameter("email");
             MyDao m1 = new MyDao();
            Statement st = m1.getStatement();
            String query="UPDATE login_table SET status=1 WHERE (email='"+em+"')";
            m1.storeData(st, query);
            out.println("verified successfully");
        }  catch (Exception ex) {
                ex.printStackTrace();
        }
    }
}
