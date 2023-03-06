package by.karnilovich.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);
    public static final String INDEX_JSP = "/jsp/index.jsp";
    public static final String CONTACTS_JSP = "/jsp/contacts.jsp";
    public static final String SHOW_LIST_CARS_JSP = "/jsp/show_list_cars.jsp";
    public static final String LOGIN_JSP = "/jsp/login.jsp";
    public static final String USER_REGISTRATION_JSP = "/web/jsp/user_registration.jsp";
    public static final String WEB_LOGIN = "/login";
    public static final String WEB_LOGOUT = "/logout";
    public static final String WEB_USER_REGISTRATION = "/userregistration";

    public static final List<String> NO_AUTH_URLS  = List.of(
            INDEX_JSP, CONTACTS_JSP, SHOW_LIST_CARS_JSP, LOGIN_JSP, USER_REGISTRATION_JSP, WEB_LOGIN, WEB_USER_REGISTRATION); //todo

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (true) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        LOGGER.debug("--- auth filter  ---");
        {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            HttpSession session = req.getSession();
            String requestURI = req.getRequestURI();

//            res.sendError(404);
            String requestURL = requestURI.replaceFirst(req.getContextPath(), "");

            if (NO_AUTH_URLS.contains(requestURL)) {
                LOGGER.debug("Authentication is no required-  " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else if ((Objects.nonNull(session)) && (session.getAttribute(LOGGED_IN_USER) != null)) {
                LOGGER.debug("Authentication with login " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                LOGGER.debug("User is not authenticated. Redirect to login page " + requestURI);
                req.setAttribute(",", "");
                req.getRequestDispatcher(LOGIN_JSP)
                        .forward(servletRequest, servletResponse);
            }
        }
    }
}
