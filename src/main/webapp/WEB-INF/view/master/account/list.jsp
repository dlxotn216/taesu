<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Master Account List</h1>
<table>
    <tr>
        <th>UserId</th>
        <th>UserName</th>
        <th>UserEmail</th>
        <th>RequestDate</th>
        <th>AuthName</th>
        <th>Permit</th>
        <th>PermitDate</th>
        <th>Modify</th>
    </tr>
<c:forEach var="account" items="${accounts}">
    <tr>
        <td>${account.userId}</td>
        <td>${account.userName}</td>
        <td>${account.userEmail}</td>
        <td>${account.requestDate}</td>
        <td>${account.authName}</td>
        <td>${account.permit}</td>
        <td>${account.permitDate}</td>
        <th><a href="/master/account/manage/${account.userId}">수정</a></th>
    </tr>
</c:forEach>
</table>
