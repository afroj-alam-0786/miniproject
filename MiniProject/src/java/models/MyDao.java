/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.sql.*;
/**
 *
 * @author afroj
 */
public class MyDao implements Serializable{
     Statement stmt;
        public Statement getStatement()throws ClassNotFoundException,SQLException{
            String url="jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false&allowPublicKeyRetrieval=true";
            String user="afroj@localhost";
            String pass="admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            stmt=con.createStatement();
            return stmt;
        
        }
        public boolean storeData(Statement st,String query)throws SQLException{
            return st.execute(query);
        }
        public ResultSet fetchData(Statement st,String query)throws SQLException{
           return st.executeQuery(query);
        }

    
}
