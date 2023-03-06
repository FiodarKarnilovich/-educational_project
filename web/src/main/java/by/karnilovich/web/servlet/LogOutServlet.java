package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.servlet.AuthFilter.INDEX_JSP;
import static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER;

@WebServlet(name = "LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UserRegistrationServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LOGGER.info("User logout");
        session.invalidate();
        LOGGER.info("session closed");
        resp.sendRedirect(req.getContextPath() + INDEX_JSP);
//        req.getRequestDispatcher("").forward(req, resp);
    }
}
