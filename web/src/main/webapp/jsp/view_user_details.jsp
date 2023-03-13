<%@ page import="by.karnilovich.service.person.PersonService" %>
<%@ page import="by.karnilovich.entity.person.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/_header.jsp"/>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%--<c:set value="${person}" var="person"/>--%>

<%-- хотелось бы вычитывать из одного обьекта--%>
<%--<%!--%>
<%--    Person person = PersonService.findByEmail(request.getSession().getAttribute("email"));--%>
<%--%>--%>

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

        <td></td>
        <td><%= ((Person) request.getAttribute("person")).getFirstName()%></td>
        <td><%= PersonService.findByEmail((String)request.getSession().getAttribute("email")).getLastName()%></td>
        <td><%= PersonService.findByEmail((String)request.getSession().getAttribute("email")).getEmail()%></td>
        <td><%= PersonService.findByEmail((String)request.getSession().getAttribute("email")).getBirthDay()%></td>
        <td><%= PersonService.findByEmail((String)request.getSession().getAttribute("email")).getPhoneNumber()%></td>
        <td><%= PersonService.findByEmail((String)request.getSession().getAttribute("email")).getRole()%></td>
    </tr>

    </tbody>
</table>

<jsp:include page="/jsp/_footer.jsp"/>