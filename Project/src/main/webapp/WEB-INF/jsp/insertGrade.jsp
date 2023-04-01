<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${groups}" var="g" varStatus="index">
                <li><a href="insertGrade?groupId=${g.groupId}&courseId=${g.course.courseId}">${g.groupName} - ${g.course.courseId} - ${g.course.courseName}</a></li>
                </c:forEach> 
                <%
                        String groupId1 = request.getParameter("groupId");
                        String courseId1 = request.getParameter("courseId");
                %>
        </ul>

        <form method="get" action="insertGrade">
            <input type="text" name="groupId" value="<%=groupId1%>">
            <input type="text" name="courseId" value="<%=courseId1%>">
            <select name="gradeCategoryId">
                <c:forEach items="${gradeCategorys}" var="gc">
                    <option value="${gc.gradeCategoryId}">${gc.gradeItemName}</option>
                </c:forEach>
            </select>
            <button type="submit">Find</button>
        </form>
        <form method="post" action="insertGrade">
            <table>
                <tr>
                    <th>No</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>GradeValue</th>
                </tr>
                <c:forEach items="${students}" var="s" varStatus="index">
                    <tr>
                        <th>${index.index+1}</th>
                        <th>${s.studentId}</th>
                    <input type="hidden" name="studentId" value="${s.studentId}">
                    <th>${s.studentName}</th>
                        <c:forEach items="${s.grade}" var="sg" varStatus="index">
                            <c:if test="${sg.student.studentId eq s.studentId}">
                            <th><input type="number" name="gradeValue" step="any" value="${s.grade[0].gradeValue}"></th>
                            </c:if>
                        </c:forEach> 
                    </tr>
                </c:forEach> 
            </table>
            <button type="submit">Submit Grade</button>
        </form>
    </body>
</html>
