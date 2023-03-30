<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Name</th>
                <th>Curriculum</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${courses}" var="c" varStatus="index">
                <c:forEach items="${c.gradeCategory}" var="cc"> 

                    <tr>
                        <th>${index.index+1}</th>
                        <th>${c.courseId}</th>
                        <th>${c.courseName}</th>
                        <th>${cc.gradeCategoryName}</th>
                        <th>${cc.gradeItemName}</th>
                        <th>${cc.weight}</th>
                    </tr>
                </c:forEach>
            </c:forEach> 
        </table>
    </body>
</html>
