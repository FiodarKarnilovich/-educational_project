package by.karnilovich.web.servlet;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.person.Person;
import by.karnilovich.service.auto.AutoService;
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

@WebServlet(name = "NewCarRegistrationServlet", urlPatterns = WEB_CAR_REGISTRATION)
public class NewCarRegistrationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(NewCarRegistrationServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String autoBrand = req.getParameter("autoBrand");
        final String autoModel = req.getParameter("autoModel");
        final String colourAuto = req.getParameter("colourAuto");
        final String transmissionAuto = req.getParameter("transmissionAuto");
        final Integer yearAuto = Integer.parseInt(req.getParameter("yearAuto"));
        final Double priceAuto = Double.parseDouble(req.getParameter("priceAuto"));

        Auto auto = new Auto(autoBrand, autoModel, colourAuto, transmissionAuto, yearAuto, priceAuto);
        AutoService.addAutoToList(auto);

        LOGGER.info("Auto '{}' '{}' added in app", auto.getAutoBrand(), auto.getAutoModel());
        resp.sendRedirect(req.getContextPath() + SHOW_LIST_CARS_JSP);

    }
}
