/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author afroj
 */
public class AsyncCheck implements ModelInterface{

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try (PrintWriter out = response.getWriter()){
            
          String em=request.getParameter("email");
          String query ="SELECT uid FROM user_table Where (email='"+em+"' OR mobileno='"+em+"')";
          MyDao m1 = new MyDao();
          Statement st = m1.getStatement();
          ResultSet rs = m1.fetchData(st, query);
          if(rs.next()){
             // out.println("Email already exist");
              request.setAttribute("exist", "Already Exist!");
              request.getRequestDispatcher("arequest.jsp").forward(request, response);
          }else{
             // out.println("proceed");
               request.setAttribute("exist", "Proceed");
              request.getRequestDispatcher("arequest.jsp").forward(request, response);
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
