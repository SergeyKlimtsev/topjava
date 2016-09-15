<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 13.09.2016
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add meal</title>
</head>
<body>
<form method="post" action="edit">
    <input type="text" name="addMeal" value="true" hidden>
    <table>
        <tr>
            <td><input type="text" name="description"/></td>
            <td>description</td>
        </tr>
        <tr>
            <td>
                <input type="number" name="calories"/>
            </td>
            <td>
                Calories
            </td>
        </tr>
        <tr>
            <td>
                <input type="datetime" name="dateTime"/>
            </td>
            <td>DateTime</td>
        </tr>
        <tr>
            <td><input type="submit" value="add new meal"/></td>

        </tr>
    </table>
</form>
</body>
</html>
