package by.karnilovich.web.servlet;

import by.karnilovich.service.person.PersonService;
import by.karnilovich.entity.person.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

import static by.karnilovich.web.util.WebAttributes.*;

@WebServlet(name = "LoginServlet", urlPatterns = WEB_LOGIN)
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = StringUtils.trimToEmpty(req.getParameter("extra_message"));
        switch (action) {
            case "successful_registration" -> req.setAttribute(EXTRA_MESSAGE, "Вы успешно зарегистрированы");
            case "no_authorized" -> req.setAttribute(EXTRA_MESSAGE, "Данная страница для авторизованных пользователей.");
            case "error_login" -> req.setAttribute(EXTRA_MESSAGE, "Ошибка при вводе данных аунтификации.");
            case "person_not_found" -> req.setAttribute(EXTRA_MESSAGE, "Пользователь не найден.");
        }

        req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        LOGGER.debug("Login attempt for '{}'", email);
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();



        if (StringUtils.isAnyBlank(email, password)) {
            session.setAttribute(EXTRA_MESSAGE, "error_login");
            resp.sendRedirect(req.getContextPath() + WEB_LOGIN + "?extra_message=error_login");

        } else {
            Person person = PersonService.getPersonList().stream()
                    .filter(p -> p.getEmail().equalsIgnoreCase(email))
                    .filter(p -> p.getPassword().equals(password))
                    .findFirst().orElse(null);
            if (person == null) {
                resp.sendRedirect(req.getContextPath() + WEB_LOGIN + "?extra_message=person_not_found");
            } else {
                LOGGER.info("User '{}' logged in into app", person.getEmail());
                //TODO forward to main page
                session.setAttribute(LOGGED_IN_USER, person);
                session.setAttribute("userName", person.getFirstName());
                session.setAttribute("email", person.getEmail());
                req.getRequestDispatcher(INDEX_JSP)
                        .forward(req, resp);
            }
        }

        session.setMaxInactiveInterval(24 * 60 * 60);

    }
}
