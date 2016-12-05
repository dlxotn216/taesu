<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #account-list-table{
        width:100%;
        font-size: 12px;
    }
    #account-list-table td, #account-list-table th{
        text-align: center;
        height: 40px;
    }
    #account-list-table th{
        color: #91ced4;
        font-size:13px;
    }
    #account-list-table tr:hover{
        opacity: 0.5;
        cursor: pointer;
    }
    #account-list-table tr:nth-child(even){
        background-color: aliceblue;
    }
    @media screen and (max-width: 700px) {
        table, tr, td {
            display: block;
        }

        td:first-child {
            position: absolute;
            top: 50%;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            width: 100px;
        }
        td:not(:first-child) {
            clear: both;
            margin-left: 100px;
            padding: 4px 20px 4px 90px;
            position: relative;
            text-align: left;
        }
        td:not(:first-child):before {
            color: #91ced4;
            content: '';
            display: block;
            left: 0;
            position: absolute;
            font-weight: bold;
        }
        td:nth-child(2):before {
            content: 'UserName:';
        }
        td:nth-child(3):before {
            content: 'UserEmail:';
        }
        td:nth-child(4):before {
            content: 'RequestDate';
        }
        td:nth-child(5):before {
            content: 'AuthName:';
        }
        td:nth-child(6):before {
            content: 'Permit:';
        }
        td:nth-child(7):before {
            content: 'PermitDate:';
        }
        td:nth-child(8):before {
            content: 'Modify:';
        }

        tr {
            padding: 10px 0;
            position: relative;
        }
        tr:first-child {
            display: none;
        }
    }

</style>

<h1>Master Account List</h1>
<table id="account-list-table" class="afternoon-session">
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
        <td>${account.requestDate.toString().substring(0, 10)}</td>
        <td>${account.authName}</td>
        <td>${account.permit}</td>
        <td>${account.permitDate == NULL ? '.' : account.permitDate.toString().substring(0, 10)}</td>
        <td><a class="btn btn-danger btn-xs" href="/master/account/manage/${account.userId}">수정</a></td>
    </tr>
</c:forEach>
</table>
