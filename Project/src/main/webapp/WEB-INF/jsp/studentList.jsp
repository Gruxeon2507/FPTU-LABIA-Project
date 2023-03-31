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
                <c:forEach items="${s.account.account_Role}" var="ss" >
                <c:forEach items="${ss.role.role_Feature}" var="sss" >
                    <tr>
                    <th>${index.index+1}</th>
                    <th>${s.studentId}</th>
                    <th>${s.studentName}</th>
                    <th>${s.curriculum.curriculumName}</th>
                    <th>${sss.feature.featureId}</th>
                    <th>${sss.feature.featureName}</th>
                    <th>${sss.feature.url}</th>
                    
                    
                </tr>
                </c:forEach> 
                </c:forEach> 
            </c:forEach> 
        </table>
    </body>
</html>
