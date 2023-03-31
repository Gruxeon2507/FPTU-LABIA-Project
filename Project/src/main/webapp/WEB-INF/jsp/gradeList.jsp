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
                <th>GRADE CATEGORY</th>
                <th>GRADE ITEM</th>
                <th>WEIGHT</th>
                <th>VALUE</th>

            </tr>
            <c:forEach items="${grades}" var="g" varStatus="index">
               
                <tr>
                    <th>${g.gradeCategory.gradeCategoryName}</th>
                    <th>${g.gradeCategory.gradeItemName}</th>
                    <th>${g.gradeCategory.weight}</th>
                    <th>${g.gradeValue}</th>

                </tr>

            </c:forEach> 
        </table>
    </body>
</html>
