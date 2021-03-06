<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        #table{
        width: 50%;
        border-collapse: collapse;
        }
        td{
        padding: 3px;
        border: 1px solid black;
        }
    </style>
</head>
<body>

    <h3>Create new student</h3>

    <form method="post" action="">
        <label><input type="text" name="name" value="Enter name"></label>
        <label><input type="text" name="surname" value="Enter surname"></label>
        <label><input type="text" name="patronymic" value="Enter patronymic"></label>
        <label><input type="date" name="dateOfBorn"></label>
        <label><input type="text" name="group" value="Enter group"></label>
        <input type="submit" value="save" name="save">
    </form>

    <h3>You can view list of students</h3>
    <table id="table">
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>patronymic</th>
            <th>dateOfBorn</th>
            <th>group</th>
        </tr>

        <c:forEach var="studentList" items="${requestScope.studentList}">
            <tr>
                <td><c:out value="${studentList.name}"/></td>
                <td><c:out value="${studentList.surname}"/></td>
                <td><c:out value="${studentList.patronymic}"/></td>
                <td><c:out value="${studentList.dateOfBorn}"/></td>
                <td><c:out value="${studentList.group}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
