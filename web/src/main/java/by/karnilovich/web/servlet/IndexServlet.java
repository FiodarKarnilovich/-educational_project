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
import static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER;
import static javax.swing.text.html.CSS.getAttribute;

@WebServlet(name = "IndexServlet", urlPatterns = "")
public class IndexServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(IndexServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String forwardJsp = req.getSession().getAttribute(LOGGED_IN_USER) == null ?
//                INDEX_JSP : "/jsp/index_logged.jsp";

        LOGGER.debug(req.getAttribute(LOGGED_IN_USER) != null ?
              "user logged - true" : "user logged - false");
       req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
 //       resp.sendRedirect(INDEX_JSP);
   }
}
