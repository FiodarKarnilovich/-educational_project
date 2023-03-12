package by.karnilovich.web.servlet;

import by.karnilovich.web.util.PersonUtil;
import by.karnilovich.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.servlet.AuthFilter.*;


@WebServlet(name = "UserRegistrationServlet", urlPatterns = WEB_USER_REGISTRATION)
public class UserRegistrationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UserRegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String birthDay = req.getParameter("birthDay");
        final String phoneNumber = req.getParameter("phoneNumber");

        Person person = new Person(firstName, lastName, email, password, birthDay, phoneNumber, "ROLE_USER");
        PersonUtil.addPersonToList(person);

        LOGGER.info("User '{}' added in app", person.getEmail());
        resp.sendRedirect(req.getContextPath() + WEB_LOGIN);

    }
}
