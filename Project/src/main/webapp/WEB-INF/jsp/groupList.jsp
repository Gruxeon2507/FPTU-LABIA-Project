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
                <th>CourseName</th>
                <th>InstructorId</th>
            </tr>
            <c:forEach items="${groups}" var="g" varStatus="index">
                <tr>
                    <th>${index.index+1}</th>
                    <th>${g.groupId}</th>
                    <th>${g.groupName}</th>
                    <th>${g.course.courseName}</th>
                    <th>${g.instructor.instructorId}</th>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
