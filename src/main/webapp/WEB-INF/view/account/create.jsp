<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#createForm").submit(function(){

            var data = {
                "userId": $("input[name=userId]").val(),
                "userName": $("input[name=userName]").val(),
                "userEmail": $("input[name=userEmail]").val(),
                "passwd": $("input[name=passwd]").val()
            }
            alert(JSON.stringify(data));
            $.ajax({
                type:"POST",
                url:"/account",
                headers:{
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data),
                success:function(data){
                    console.log("DEBUG check :", data);
                    window.location.href="/";
                },
                fail: function(e){
                    console.log("DEBUGG error : ", e);
                }
            })

            return false;
        });
    })
</script>

<form id="createForm">
    <input type="text" name="userId" placeholder="user id" /><br>
    <input type="password" name="passwd" placeholder="user password" /><br>
    <input type="text" name="userName" placeholder="user name" /><br>
    <input type="text" name="userEmail" placeholder="user email" /><br>

    <input type="submit" value="전송" />
</form>

