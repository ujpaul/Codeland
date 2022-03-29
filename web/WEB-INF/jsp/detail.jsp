<%-- 
    Document   : detail
    Created on : 15 Nov 2021, 19:54:05
    Author     : janvier
--%>

<%@page import="com.example.model.UserModel"%>
<%@page import="example.db.CoreDB"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             <%@include file="/WEB-INF/css/styles.css"%>
      </style>
    </head>
    <body>
        <%
        Map<Integer,UserModel> user=new LinkedHashMap<Integer,UserModel>(); 
        user = CoreDB.getInstance().getData();
        String username=(String)session.getAttribute("username");
        for (Map.Entry<Integer, UserModel> entry : user.entrySet()) {  
            UserModel um = entry.getValue();
             if(username.equals(um.getUsername()) )

        %>
        <div class="info">            
                <%
                 out.println("<li>" +um.getFname() + "</li><li> " + um.getLname() + "</li><li>" + um.getUsername() 
                + "</li><li>" + um.getPhoneNumber() +"</li><li>" + um.getGender() +"</li><li>" + um.getUserRole()+"</li>");

            }
        %>
            </li>
        </div>
        

    </body>
</html>
