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
                <th>CurriculumName</th>
                <th>GroupName</th>
                <th>CourseId</th>
                <th></th>
            </tr>
            <c:forEach items="${students}" var="s" varStatus="index">
                 <c:forEach items="${s.grade}" var="ss">
                    <tr>
                        <th>${index.index}</th>
                        <th>${s.studentId}</th>
                    <th>${ss.semester.semesterId}</th>
                    <th>${ss.gradeCategory.course.courseId}</th>
                    <th>${ss.gradeCategory.course.courseName}</th>
                    <th>${ss.gradeCategory.gradeCategoryName}</th>
                    <th>${ss.gradeCategory.gradeItemName}</th>
                    <th>${ss.gradeCategory.weight}</th>
                    <th>${ss.gradeValue}</th>
                    
                </tr>
                            </c:forEach> 
            </c:forEach> 
        </table>
    </body>
</html>
