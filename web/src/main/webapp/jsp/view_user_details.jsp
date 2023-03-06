<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:directive.page contentType="text/html; charset=UTF-8" />--%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/jsp/index_logged.jsp">Home</a>
        </li>

        <a class="nav-link" href="<%= request.getContextPath() %>/logout">Logout</a>
    </ul>
</header>

<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Email</th>
        <th scope="col">Дата рождения</th>
        <th scope="col">Телефон</th>
        <th scope="col">роль</th>
    </tr>
    </thead>
    <tbody>


    </tbody>
</table>

<jsp:include page="/jsp/_footer.jsp"/>