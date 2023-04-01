<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="../login">
            <label>Username: </label>
            <input type="text" id="username" name="username">
            <label>Password</label>
            <input type="password" id="password" name="password">
            <button type="submit">Login</button>
        </form>
        ${errorLogin}
    </body>
</html>
