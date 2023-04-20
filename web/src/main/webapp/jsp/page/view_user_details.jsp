<%@ page import="by.karnilovich.entity.person.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<c:set value="${person}" var="person"/>--%>
<c:set var="person" value='${requestScope.person}' />
<%--<c:set var="person" value='${requestScope["person"]}' />--%>


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
    <tr>
<%--        <% Person person = (Person) request.getAttribute("person"); %>--%>

        <td></td>
        <td><c:out value="${person.firstName}"/></td>
        <td><c:out value="${person.lastName}"/></td>
        <td><c:out value="${person.email}"/></td>
        <td><c:out value="${person.birthDay}"/></td>
        <td><c:out value="${person.phoneNumber}"/></td>
        <td><c:out value="${person.role}"/></td>
<%--        <td></td>--%>
<%--        <td><%= person.getFirstName()%>--%>
<%--        </td>--%>
<%--        <td><%= person.getLastName()%>--%>
<%--        </td>--%>
<%--        <td><%= person.getEmail()%>--%>
<%--        </td>--%>
<%--        <td><%= person.getBirthDay()%>--%>
<%--        </td>--%>
<%--        <td><%= person.getPhoneNumber()%>--%>
<%--        </td>--%>
<%--        <td><%= person.getRole()%>--%>
<%--        </td>--%>
<%--    </tr>--%>

    </tbody>
</table>

<jsp:include page="/jsp/_footer.jsp"/>