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
                <th>No</th>
                <th>courseId</th>
                <th>courseName</th>
                <th>Semester</th>
                <th>GroupName</th>
                <th>StartDate</th>
                <th>EndDate</th>
                <th>Average Mark</th>
                <th>Status</th>
                <th></th>
            </tr>
            <c:forEach items="${curriculums[0].curriculum_Courses}" var="cuc" varStatus="index">
                <%--<c:forEach items="${cuc.course.group}" var="cuccg">--%>
                <tr>
                    <th>${index.index}</th>
                    <th>${cuc.course.courseId}</th>
                    <th>${cuc.course.courseName}</th>
                    <th>${cuc.course.group[0].groupName}</th>
                    <th>${cuc.course.gradeCategory[0].grade[0].semester.semesterName}</th>
                    <th>
                        <fmt:formatDate value="${cuc.course.gradeCategory[0].grade[0].semester.startDate}" pattern="dd/MM/yyyy" />
                    </th>
                    <th>
                        <fmt:formatDate value="${cuc.course.gradeCategory[0].grade[0].semester.endDate}" pattern="dd/MM/yyyy" />
                    </th>
                    <c:set var="sum" value="${0}"/>
                    <c:set var="finalweight" value="${0}"/>
                    <c:set var="finalgrade" value="${0}"/>

                    <c:forEach var="gradecate" items="${cuc.course.gradeCategory}">
                        <c:forEach var="gradev" items="${gradecate.grade}">
                            <c:if test="${gradev.student.studentId eq 'HE170907'}">
                                <c:if test="${gradecate.course.courseId ne cuc.course.courseId}">
                                    <c:set var="sum" value="${0}" />
                                </c:if>
                                <c:if test="${gradecate.course.courseId eq cuc.course.courseId}">
                                    <c:if test="${gradecate.gradeItemName eq 'Total' and (gradecate.gradeCategoryName eq 'Final exam' or gradecate.gradeCategoryName eq 'Final Exam')}">
                                        <c:set var="finalweight" value="${gradecate.weight}" />
                                        <c:set var="finalgrade" value="${gradev.gradeValue}" />
                                    </c:if>
                                    <c:if test="${gradecate.gradeItemName eq 'Total'}">
                                        <c:set var="sum" value="${sum + (gradecate.weight*gradev.gradeValue)}" />
                                    </c:if>
                                    <c:if test="${gradecate.gradeItemName eq 'Total' and (gradecate.gradeCategoryName eq 'Final exam Resit' or gradecate.gradeCategoryName eq 'Final Exam Resit') and gradev.gradeValue gt 0}">
                                        <c:set var="sum" value="${sum - (finalweight*finalgrade)}" />
                                        <c:set var="finalweight" value="${gradecate.weight}" />
                                        <c:set var="finalgrade" value="${gradev.gradeValue}" />
                                    </c:if>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </c:forEach>

                    <c:set var="sum" value="${sum div 100}" />

                    <th>
                        <fmt:formatNumber value="${sum}" pattern="#,##0.0" />
                    </th>
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
                <%--</c:forEach>--%> 
            </c:forEach> 
        </table>
    </body>
</html>
