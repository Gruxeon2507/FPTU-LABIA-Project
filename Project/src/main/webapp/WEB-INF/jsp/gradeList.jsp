<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




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

            <c:set var="sum" value="${0}"/>
            <c:set var="finalweight" value="${0}"/>
            <c:set var="finalgrade" value="${0}"/>

            <c:forEach items="${grades}" var="g" varStatus="index">
                <c:if test="${g.gradeCategory.gradeItemName eq 'Total' and (g.gradeCategory.gradeCategoryName eq 'Final exam' or g.gradeCategory.gradeCategoryName eq 'Final Exam')}">
                    <c:set var="finalweight" value="${g.gradeCategory.weight}" />
                    <c:set var="finalgrade" value="${g.gradeValue}" />
                </c:if>
                <c:if test="${g.gradeCategory.gradeItemName eq 'Total'}">
                    <c:set var="sum" value="${sum + (g.gradeCategory.weight*g.gradeValue)}" />
                </c:if>
                <c:if test="${g.gradeCategory.gradeItemName eq 'Total' and (g.gradeCategory.gradeCategoryName eq 'Final exam Resit' or g.gradeCategory.gradeCategoryName eq 'Final Exam Resit') 
                              and g.gradeValue gt 0}">
                    <c:set var="sum" value="${sum - (finalweight*finalgrade)}" />
                    <c:set var="finalweight" value="${g.gradeCategory.weight}" />
                    <c:set var="finalgrade" value="${g.gradeValue}" />
                </c:if>
            </c:forEach> 

            <c:set var="sum" value="${sum div 100}"/>
            <tr>
                <th>Course Total </th>
                <th>Average</th>

                <th>
                    <fmt:formatNumber value="${sum}" pattern="#,##0.0" />
                </th>
            </tr>
            <tr>
                <th></th>
                <th>Status</th>
                <th>
                    <c:choose>
                        <c:when test="${sum >= 5 and finalgrade >= 4}">
                            <p>Passed</p>
                        </c:when>
                        <c:when test="${(sum < 5 and sum > 0) or (finalgrade < 4 and finalgrade > 0)}">
                            <p>Not Passed<p>
                            </c:when>
                            <c:when test="${sum == 0}">
                            <p>Not Started<p>
                            </c:when>
                        </c:choose>
                </th>
            </tr>
        </table>
    </body>
</html>
