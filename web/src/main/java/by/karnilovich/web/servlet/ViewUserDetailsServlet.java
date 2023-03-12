package by.karnilovich.web.servlet;

import by.karnilovich.service.person.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.servlet.AuthFilter.*;

@WebServlet(name = "ViewUserDetailsServlet", urlPatterns = WEB_VIEW_USER_DETAILS)
public class ViewUserDetailsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ViewUserDetailsServlet.class);


    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.debug(" -> view_user_details.jsp");
        req.getRequestDispatcher(VIEW_USER_DETAILS_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // вопрос как передать отсюда данные в jsp
        // Person person = PersonService.findByEmail((String)req.getSession().getAttribute("email"));
    }
}
