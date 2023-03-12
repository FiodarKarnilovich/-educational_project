<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<jsp:include page="_header.jsp"/>

<h1> Введите данные новой машины </h1>

<form style="width: 50% ; margin-left: 10%" method="post" action="<%= request.getContextPath() %>/newcarregistration" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="autoPicture" class="form-label">Фото машины</label>
        <input type="file" name="autoPicture" class="form-control" id="autoPicture">
    </div>
    <!-- бренд авто -->
    <div class="mb-3">
        <label for="autoBrand" class="form-label">Бренд</label>
        <input type="text" name="autoBrand" class="form-control" id="autoBrand" aria-describedby="nameHelp">
        <div class="form-text">Введите бренд авто</div>
    </div>
    <!-- модель авто -->
    <div class="mb-3">
        <label for="autoModel" class="form-label">Модель</label>
        <input type="text" name="autoModel" class="form-control" id="autoModel" aria-describedby="nameHelp">
        <div class="form-text">Введите модель авто</div>
    </div>

    <!-- цвет авто -->
    <div class="mb-3">
        <label for="colourAuto" class="form-label">Цвет</label>
        <input type="text" name="colourAuto" class="form-control" id="colourAuto" aria-describedby="nameHelp">
        <div class="form-text">Введите цвет авто</div>
    </div>

    <!-- трансмиссия -->
    <div class="mb-3">
        <label for="transmissionAuto" class="form-label">Трансмиссия</label>
        <input type="text" name="transmissionAuto" class="form-control" id="transmissionAuto" aria-describedby="nameHelp">
        <div class="form-text">Введите трансмиссию</div>
    </div>
    <!-- год авто -->
    <div class="mb-3">
        <label for="yearAuto" class="form-label">Год</label>
        <input type="text" name="yearAuto" class="form-control" id="yearAuto" aria-describedby="nameHelp">
        <div class="form-text">Введите год авто</div>
    </div>

    <!-- цена авто -->
    <div class="mb-3">
        <label for="priceAuto" class="form-label">Цена</label>
        <input type="text" name="priceAuto" class="form-control" id="priceAuto" aria-describedby="nameHelp">
        <div class="form-text">Введите цену за сутки</div>
    </div>
    <button type="submit" class="btn btn-primary">Зарегистрировать</button>
</form>

<jsp:include page="_footer.jsp"/>