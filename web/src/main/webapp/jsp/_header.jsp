<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static by.karnilovich.web.util.WebAttributes.LOGGED_IN_USER" %>
<%@ page import="static by.karnilovich.web.util.WebAttributes.WEB_VIEW_USER_DETAILS" %>
<%@ page import="static by.karnilovich.web.util.WebAttributes.*" %>
<%@ page import="by.karnilovich.entity.person.Person" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
    <% Person person = (Person) request.getSession().getAttribute(LOGGED_IN_USER);%>
    <ul class="nav justify-content-end">

        <li class="nav-item">
            <a class="nav-link"    href= <%= person != null ?
                (person.getRole().equals("ROLE_ADMIN") ?
                    request.getContextPath() +  WEB_ADMIN : request.getContextPath()
            ) :  request.getContextPath()
            %>
            >hi, <%= request.getSession().getAttribute(LOGGED_IN_USER) != null ?
                    request.getSession().getAttribute("userName") : "guest" %> </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href= <%= request.getSession().getAttribute(LOGGED_IN_USER) != null ?
                    request.getContextPath() +  WEB_VIEW_USER_DETAILS : "" %>>
                <%= request.getSession().getAttribute(LOGGED_IN_USER) != null ?
                        "Profile" : "" %></a>
        </li>

        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/contacts">Contacts</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/showlistcars">Rental Cars</a>
        </li>
        <a class="nav-link" href= <%= request.getSession().getAttribute(LOGGED_IN_USER) != null ?
                request.getContextPath() + "/logout" : request.getContextPath() + "/login" %>>
            <%= request.getSession().getAttribute(LOGGED_IN_USER) != null ?
                    "Logout" : "Login" %></a>
    </ul>
</header>
