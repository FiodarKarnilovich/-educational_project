<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>index</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<%--https://www.teahub.io/photos/full/19-198007_audi-r8-black-red.jpg--%>
<%--${pageContext.request.contextPath}/img/home-img.jpg--%>

<body style="background-image: url(https://www.teahub.io/photos/full/19-198007_audi-r8-black-red.jpg);
      height: 100vh;
      background-size: cover;
      background-repeat: no-repeat;
      background-position: center center;">

<header>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/web/jsp/index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/contacts.html">Contacts</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/showlistcars/1.html">Rental Cars</a>
        </li>
        <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login.html">Login</a>
        </li>

    </ul>
</header>

<jsp:include page="_footer.jsp"/>
