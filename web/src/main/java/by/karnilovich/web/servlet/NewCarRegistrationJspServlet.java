package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.util.WebAttributes.CAR_REG;
import static by.karnilovich.web.util.WebAttributes.CAR_REGISTRATION_JSP;


@WebServlet(name = "NewCarRegistrationJspServlet", urlPatterns = CAR_REG)
public class NewCarRegistrationJspServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(NewCarRegistrationJspServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.debug(" -> new_car_registration.jsp");
        req.getRequestDispatcher(CAR_REGISTRATION_JSP).forward(req, resp);

    }
}
