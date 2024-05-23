/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

/**
 *
 * @author afroj
 */
public class MailSender {
    public void sendMail(String emailto){
        String from="ansariafroj0078600@gmail.com";
        final String username="ansariafroj0078600";
        final String password="nnsmotjrlklpoezj";//app password generated
        Properties props=new Properties();
        props.put("mail.smtp.auth","true");//1
        props.put("mail.smtp.ssl.trust","smtp.gmail.com");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");//5
        Session session=Session.getInstance(props,new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        try{
            Message msg=new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailto));
            msg.setSubject("Welcomt to My App");
            msg.setText("Please veryfy by clicking here <a href='http://localhost:8080/MiniProject/fc/?type=model&page=EmailVarificationModel&email="+emailto+"'> Varyfy</a>");
            Transport.send(msg);
        }catch(MessagingException mex){
            mex.printStackTrace();
        }
    }
}
