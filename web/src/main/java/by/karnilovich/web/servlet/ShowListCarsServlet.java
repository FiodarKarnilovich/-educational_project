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

@WebServlet(name = "ShowListCarsServlet", urlPatterns = WEB_SHOW_LIST_CARS)
public class ShowListCarsServlet extends HttpServlet {


    private static final Logger LOGGER = LogManager.getLogger(ShowListCarsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(SHOW_LIST_CARS_JSP).forward(req, resp);
        LOGGER.debug(" -> show_list_cars.jsp");
    }
}
