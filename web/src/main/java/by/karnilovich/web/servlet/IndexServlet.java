package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.karnilovich.web.servlet.AuthFilter.INDEX_JSP;
import static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER;

@WebServlet(name = "IndexServlet", urlPatterns = "")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String forwardJsp = req.getSession().getAttribute(LOGGED_IN_USER) == null ?
                INDEX_JSP : "/jsp/index_logged.jsp";

        req.getRequestDispatcher(forwardJsp).forward(req, resp);
    }
}
