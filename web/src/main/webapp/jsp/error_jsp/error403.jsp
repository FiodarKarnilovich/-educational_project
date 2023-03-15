<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 403</title>
    <img src="<%= request.getContextPath() %>/img/error403.jpg" alt="Error 403">
    <a href="<%= request.getContextPath() %>">
        <button class="btn btn-outline-danger">На заглавную страницу</button>
    </a>
</head>
</html>
