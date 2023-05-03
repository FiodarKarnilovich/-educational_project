<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="autos" value='${requestScope.autos}' />


<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Бренд</th>
        <th scope="col">Модель</th>
        <th scope="col">Цвет</th>
        <th scope="col">Трансмиссия</th>
        <th scope="col">Год</th>
        <th scope="col">Цена</th>
    </tr>
    </thead>
<%--    <tbody>--%>

    <c:forEach items="${autos}" var="auto">

        <tr>
            <td><c:out value="${auto.id}"/></td>
            <td><c:out value="${auto.autoBrand}"/></td>
            <td><c:out value="${auto.autoModel}"/></td>
            <td><c:out value="${auto.colourAuto}"/></td>
            <td><c:out value="${auto.transmissionAuto}"/></td>
            <td><c:out value="${auto.yearAuto}"/></td>
            <td><c:out value="${auto.priceAuto}"/></td>
        </tr>

    </c:forEach>
<%--    </tbody>--%>
</table>

<jsp:include page="/jsp/_footer.jsp"/>
