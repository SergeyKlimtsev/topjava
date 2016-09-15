<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11.09.2016
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://example.com/functions" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<table>
    <tr>
        <th>Date Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Exceed</th>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <tr <c:if test="${meal.exceed}">style="color: red"</c:if>>
            <th>${f:fmtLocalDateTime(meal.dateTime, "dd-MM-yyyy HH:mm:ss")}</th>
            <th>${meal.description}</th>
            <th>${meal.calories}</th>
            <th>${meal.exceed}</th>
            <th><a href="edit?editMeal=true&id=${meal.id}">Edit</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
