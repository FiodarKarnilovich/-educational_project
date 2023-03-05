package by.karnilovich.web.servlet;

import by.karnilovich.web.util.PersonUtil;
import by.karnilovich.model.Person;
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

import static by.karnilovich.web.servlet.AuthFilter.LOGIN_JSP;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    public static final String LOGGED_IN_USER = "logged_in_user";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        LOGGER.debug("Login attempt for '{}'", email);
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();



        if (StringUtils.isAnyBlank(email, password)) {
            writer.println("Please, Enter login and password");
           // session.setAttribute(email, "logout");
            resp.sendRedirect(LOGIN_JSP);
        } else {
            Person person = PersonUtil.getPersonList().stream()
                    .filter(p -> p.getEmail().equalsIgnoreCase(email))
                    .filter(p -> p.getPassword().equals(password))
                    .findFirst().orElse(null);
            if (person == null) {
                writer.println("Invalid credentials. Please, Enter login and password again.");
            } else {
                LOGGER.info("User '{}' logged in into app", person.getEmail());
                //TODO forward to main page
                session.setAttribute(LOGGED_IN_USER, person);
                resp.sendRedirect("/web/jsp/index_logged.jsp");
            }
        }


        //session.invalidate();
        session.setMaxInactiveInterval(24 * 60 * 60);

    }
}
