/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author afroj
 */
public class GetState implements ModelInterface{

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
     
        try{
             String em=request.getParameter("country_code");
             System.out.println(em);
             String query="SELECT  *FROM state WHERE(country_code='"+em+"')";
             MyDao m1 = new MyDao();
             Statement st = m1.getStatement();
             ResultSet rs = m1.fetchData(st, query);
             JSONObject obj=new JSONObject();
             JSONArray list=new JSONArray();
             while(rs.next()){
                 JSONObject temp=new JSONObject();
                 temp.put(rs.getInt("state_id"),rs.getString("state_name"));
                 list.add(temp);   
                // out.println(rs.getString("state_name"));
             }
             obj.put("states",list);
             String str=obj.toJSONString();
             System.out.println(str);
             response.getWriter().write(str);
             // /request.setAttribute("states", str);
             
        }catch(Exception e){
        e.printStackTrace();
    }
    }
    
}
