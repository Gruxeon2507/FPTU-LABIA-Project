<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>

    <body>
        <style>
            table {
                width: 35%;
                text-align: left;
                font-family: Arial, Helvetica, sans-serif;
                text-indent: 3px;
            }

            table, tr, td {
                border-bottom: solid 2px whitesmoke;
                border-collapse: collapse;
            }

            #bot {
                font-size: 22px;
                font-weight: bold;
            }

            #header {
                background-color: #0099ff;
                font-size: 20px;
            }

            #header td{
                border-right: 2px solid white;
            }
            .list-semester{
                display: flex;
            }
        </style>
        <div class="list-semester">
            <ul>
                <c:forEach items="${semesters}" var="s" varStatus="index">
                    <li> <a href="gradeReport?semesterId=${s.semesterId}">${s.semesterName}</a></li>
                    </c:forEach> 
            </ul>
            <%
      String semesterId = request.getParameter("semesterId");
            %>
            <ul>
                <c:forEach items="${courses}" var="c" varStatus="index">
                    <li> <a href="gradeReport?semesterId=<%=semesterId%>&courseId=${c.courseId}">${c.courseId}</a></li>
                    </c:forEach> 
            </ul>
            <table>
                <tr id = "header">
                    <td>GRADE CATEGORY</td>
                    <td>GRADE ITEM</td>
                    <td>WEIGHT</td>
                    <td>VALUE</td>

                </tr>
                <c:forEach items="${grades}" var="g" varStatus="index">

                    <tr>
                        <td>${g.gradeCategory.gradeCategoryName}</td>
                        <td>${g.gradeCategory.gradeItemName}</td>
                        <td>${g.gradeCategory.weight} %</td>
                        <td>${g.gradeValue}</td>
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
                <tr id="bot" style = "border-top: solid 8px whitesmoke">
                    <td>COURSE TOTAL </td>
                    <td>AVERAGE</td>

                    <td>
                        <fmt:formatNumber value="${sum}" pattern="#,##0.0" />
                    </td>
                </tr>
                <tr id="bot">
                    <td></td>
                    <td>STATUS</td>
                    <td>
                        <c:choose>
                            <c:when test="${sum >= 5 and finalgrade >= 4}">
                                <p style="color: green">PASSED</p>
                            </c:when>
                            <c:when test="${(sum < 5 and sum > 0) or (finalgrade < 4 and finalgrade > 0)}">
                                <p style="color: red">NOT PASSED<p>
                                </c:when>
                                <c:when test="${sum == 0}">
                                <p style="color: red">NOT PASSED<p>
                                </c:when>
                            </c:choose>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
