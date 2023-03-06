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
            <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/jsp/index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/jsp/contacts.jsp">Contacts</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/jsp/show_list_cars.jsp">Rental Cars</a>
        </li>
            <a class="nav-link" href="<%= request.getContextPath() %>/jsp/login.jsp">Login</a>
    </ul>
</header>
