<%-- 
    Document   : login
    Created on : 15 Nov 2021, 19:54:15
    Author     : janvier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
             <%@include file="/WEB-INF/css/styles.css"%>
      </style>
    </head>
    <body>
        <div class="container">
        <div class="form_container">
            <div class="title">
                <h2>Login Form</h2>
            </div>

            <form action="Authenticate" method="POST" class="forms">

		    <div class="grid-col-2">
                      <span><i class="fa fa-user"></i></span>
                       <input type="text" placeholder="Username" name="username" />
                    </div>
                   <div class="grid-col-2">
                        <span><i class="fa fa-lock"></i></span>
                        <input type="password" placeholder="password" name="password"/>
                     </div>
                             
                  <input class="btn" type="submit" value="Login" />

           
                </form>
            </div>
        </div>
        
    </body>
</html>
