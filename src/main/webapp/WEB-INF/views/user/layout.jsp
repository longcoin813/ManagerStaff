<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title>PM</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/css.css">
    <link rel="stylesheet" href="/static/css/style.css">
</head>

<body>
<div class="wrapper d-flex align-items-stretch">
    <!-- MENU -->
    <jsp:include page="layout/menu.jsp"/>
    <div id="content" class="p-4 p-md-5">
        <%--        HEARD--%>
        <jsp:include page="layout/header.jsp"/>
        <%--        BODY--%>
        <tiles:insertAttribute name="body"/>
    </div>
</div>


<script src="/static/js/application.js"></script>
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>