<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.ServletRequest" %>
<%@ page import="jakarta.servlet.ServletResponse" %>
<%@ page import="static by.karnilovich.web.servlet.AuthFilter.NOT_AUTHENTICATED" %>
<%@ page import="static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsp/_header.jsp"/>

<section class="h-100 gradient-form" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card rounded-3 text-black">
                    <div class="row g-0">
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 mx-md-4">
                                <form name='f' action="<%= request.getContextPath() %>/login" method="post">
                                    <p><%= request.getAttribute(LOGGED_IN_USER) != null ?
                                            "Данная страница для авторизованных пользователей." : ""%></p>

                                    <p>Войдите в аккаунт</p>

                                    <div class="form-outline mb-4">
                                        <input type="email" name="email" id="email" class="form-control"
                                               placeholder="Введите email" />
                                        <label class="form-label" for="email">Email</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" name="password" id="password" class="form-control" />
                                        <label class="form-label" for="password">Password</label>
                                    </div>

                                    <div class="mt-4 pt-2">
                                        <input class="btn btn-primary btn-lg" type="submit" value="LogIn" />
                                    </div>
                                </form>

                                <div class="d-flex align-items-down justify-content-left pb-4">
                                    <p class="mb-0 me-2"><br>Нет аккаунта?</p>
                                </div>


                                <a href="<%= request.getContextPath() %>/userreg">
                                    <button class="btn btn-outline-danger">Регистрация</button>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/jsp/_footer.jsp"/>
