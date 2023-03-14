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

import static by.karnilovich.web.util.WebAttributes.INDEX_JSP;
import static by.karnilovich.web.util.WebAttributes.WEB_LOGOUT;


@WebServlet(name = "LogOutServlet", urlPatterns = WEB_LOGOUT)
public class LogOutServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LogOutServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LOGGER.info("User logout");
        session.invalidate();
        LOGGER.info("session closed");
        req.getRequestDispatcher(INDEX_JSP)
                .forward(req, resp);
    }
}
