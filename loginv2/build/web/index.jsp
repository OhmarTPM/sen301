<%-- 
    Document   : index
    Created on : Nov 12, 2018, 12:47:12 AM
    Author     : Abuoma Offia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="/loginv2/login" method="post">
            Enter UserId <input type="text" name="loginYsg.username"/><br/>
            Enter Password <input type="password" name="loginYsg.pass"><br/>
            <input type="submit" value="Login">
        </form>
    </body>
</html>