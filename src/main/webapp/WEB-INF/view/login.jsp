<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>
    Login View
</h1>
<c:if test="${param.error == true}">
    <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
</c:if>


<form action="/loginprocess" method="post">
    <input type="text" name="id" placeholder="계정" required="required"/>
    <input type="password" name="passwd" placeholder="암호" required="required"/>
    <input type="submit" value="로그인"/>
</form>