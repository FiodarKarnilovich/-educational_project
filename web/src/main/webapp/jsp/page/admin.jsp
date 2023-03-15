<%@ page import="static by.karnilovich.web.util.WebAttributes.WEB_CAR_REGISTRATION" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<H2>Страница админа</H2>

<a href="<%= request.getContextPath() + WEB_CAR_REGISTRATION%>">
    <button class="btn btn-outline-danger">Добавить авто</button>
</a>

</body>
</html>
