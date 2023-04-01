<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        Student: 
        <ul>
            <li><a href="/student/gradeReport">Grade Report</a></li>
             <li><a href="/student/curriculumReport">Academic Transcript</a></li>
        </ul>
        <br>
        Instructor:
        <ul>
            <li><a href="/instructor/insertGrade">Insert / Update Grade/</a></li>
        </ul>
        <br>
        <a href="/logout">Logout</a>
    </body>
</html>
