package by.karnilovich.web.servlet;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.service.auto.AutoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.karnilovich.web.util.WebAttributes.SHOW_LIST_CARS_JSP;
import static by.karnilovich.web.util.WebAttributes.WEB_SHOW_LIST_CARS;

@WebServlet(name = "ShowListCarsServlet", urlPatterns = WEB_SHOW_LIST_CARS)
public class ShowListCarsServlet extends HttpServlet {


    private static final Logger LOGGER = LogManager.getLogger(ShowListCarsServlet.class);
    private AutoService autoService = new AutoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            LOGGER.debug(" -> show_list_cars.jsp");
            List<Auto> autos = autoService.getAutoList();
            req.setAttribute("autos", autos);

            req.getRequestDispatcher(SHOW_LIST_CARS_JSP).forward(req, resp);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new UnavailableException(e.getLocalizedMessage());
        }


    }


}
