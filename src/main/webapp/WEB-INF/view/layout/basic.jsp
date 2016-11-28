<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</head>
<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <tiles:insertAttribute name="header" />
        <main class="mdl-layout__content">
            <div class="page-content" style="min-height: 500px;"><!-- Your content goes here -->
                <tiles:insertAttribute name="body" />
            </div>
        </main>
    <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>