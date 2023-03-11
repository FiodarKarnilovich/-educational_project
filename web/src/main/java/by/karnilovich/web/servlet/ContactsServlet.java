package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.servlet.AuthFilter.*;

@WebServlet(name = "ContactsServlet", urlPatterns = WEB_CONTACTS)
public class ContactsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ContactsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(CONTACTS_JSP).forward(req, resp);
        LOGGER.debug(" -> contacts.jsp");
    }
}
