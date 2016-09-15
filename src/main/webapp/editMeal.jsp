<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13.09.2016
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://example.com/functions" %>
<html>
<head>
    <title>Edit meal</title>
</head>
<body>
<form method="post" action="edit">
    <input type="text" name="editMeal" value="true" hidden>
    <input type="number" name="id" hidden value="${meal.id}">
    <table>
        <tr>
            <td><input type="text" value="${meal.description}" name="description"/></td>
            <td>description</td>
        </tr>
        <tr>
            <td>
                <input type="number" value="${meal.calories}" name="calories"/>
            </td>
            <td>
                Calories
            </td>
        </tr>
        <tr>
            <td>
                <input type="datetime" value="${f:fmtLocalDateTime(meal.dateTime, "HH:mm dd.MM.yyyy")}"
                       name="dateTime"/>
            </td>
            <td>DateTime</td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"/></td>

        </tr>
    </table>
</form>
</body>
</html>
