/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author afroj
 */
public class GetCountries implements ModelInterface {

    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
       
   try{
       MyDao m1=new MyDao();
        Statement st=m1.getStatement();
        String query="SELECT *FROM country";
        ResultSet rs=m1.fetchData(st,query);
        List<Country> countries=new ArrayList<>();
        while(rs.next()){
            String countryCode=rs.getString("country_code");
             String countryName=rs.getString("country_name");
             //out.println(countryCode);
             //out.println(countryName);
             Country country=new Country();
             country.setCountryCode(countryCode);
             country.setCountryName(countryName);
             
             countries.add(country);
        }    
        request.setAttribute("countries", countries);
        request.getRequestDispatcher("/WEB-INF/pages/address.jsp").forward(request, response);
        
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
}
