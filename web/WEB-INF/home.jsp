<%-- 
    Document   : home
    Created on : Oct 5, 2020, 11:34:36 AM
    Author     : 831690
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${user.username}.
        <br>
        <form action="login" method="get" >
            <input type="submit" value="Logout">
            <input type="hidden" name="logout" value="true">
        </form>
    </body>
</html>
