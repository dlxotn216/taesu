<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <h1>Manage Accounts</h1>
    ${account.userId}의 회원정보<br><br><br>

    <input type="hidden" id="userId" value="${account.userId}"></input>
    <span>${account.userName}</span><br>
    <span>${account.userEmail}</span><br>
    <span>${account.requestDate}</span><br>
    <span>${account.authName}</span><br>

    계정허가
    <select id="permitSelect">
        <c:choose>
            <c:when test="${account.permit == 'Y'}">
                <option value="Y" selected>허가</option>
                <option value="N">미허가</option>
            </c:when>
            <c:otherwise>
                <option value="Y">허가</option>
                <option value="N" selected>미허가</option>
            </c:otherwise>
        </c:choose>
    </select>
    <br>

    권한
    <select id="authoritiesSelect">
        <c:forEach var="authority" items="${authorities}">
            <c:choose>
                <c:when test="${account.authName == authority.authName}">
                    <option value="${authority.authName}" selected>${authority.authName}</option>
                </c:when>
                <c:otherwise>
                    <option value="${authority.authName}">${authority.authName}</option>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </select>
    <br><br>

    <button id="update">수정</button>
    <button id="cancel">뒤로</button>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#update").click(function(){
            var data = {
                "permit": $("#permitSelect").val(),
                "authName": $("#authoritiesSelect").val()
            }
            var userId= $("#userId").val();
            $.ajax({
                type:"PUT",
                url:"/master/account/user/"+userId,
                headers:{
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data),
                success: function(res){
                    console.log("DEBUG call update user authority and permit : "+res);
                }
            })
        });
    })

</script>