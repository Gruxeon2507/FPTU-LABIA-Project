<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Name = ${name} Age=${age}</h1>
        <table>
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Name</th>
                <th>UserId</th>
            </tr>
            <c:forEach items="${instructors}" var="s" varStatus="index">
                <tr>
                <th>${index.index+1}</th>
                <th>${s.instructorId}</th>
                <th>${s.instructorName}</th>
                <th>${s.account.password}</th>
                </tr>
        
            </c:forEach> 
        </table>
    </body>
</html>
