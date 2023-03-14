package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import static by.karnilovich.web.util.WebAttributes.ADMIN_JSP;
import static by.karnilovich.web.util.WebAttributes.WEB_ADMIN;

@WebServlet(name = "AdminServlet", urlPatterns = WEB_ADMIN)
public class AdminServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.debug(" -> admin.jsp");
        req.getRequestDispatcher(ADMIN_JSP).forward(req, resp);

    }
}
