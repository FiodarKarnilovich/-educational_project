package by.karnilovich.web.servlet;

import by.karnilovich.entity.person.Person;
import by.karnilovich.service.person.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

import static by.karnilovich.web.util.WebAttributes.VIEW_USER_DETAILS_JSP;
import static by.karnilovich.web.util.WebAttributes.WEB_VIEW_USER_DETAILS;

@WebServlet(name = "ViewUserDetailsServlet", urlPatterns = WEB_VIEW_USER_DETAILS)
public class ViewUserDetailsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ViewUserDetailsServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.debug(" -> view_user_details.jsp");
        String email = (String)req.getSession().getAttribute("email");
        List<Person> persons = PersonService.getPersonList();
        req.setAttribute("persons", persons);
        Person person = PersonService.findByEmail(email);
        req.setAttribute("person", person);
        req.getRequestDispatcher(VIEW_USER_DETAILS_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
