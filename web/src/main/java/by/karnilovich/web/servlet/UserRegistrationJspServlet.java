package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

//import static by.karnilovich.web.servlet.AuthFilter.USER_REG;
import static by.karnilovich.web.servlet.AuthFilter.USER_REGISTRATION_JSP;

//@WebServlet(name = "UserRegistrationJspServlet", urlPatterns = USER_REG)
public class UserRegistrationJspServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UserRegistrationJspServlet.class);


}
