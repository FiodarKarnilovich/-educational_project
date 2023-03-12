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

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);
    public static final String INDEX_MAIN = "/";
    public static final String INDEX_JSP = "/jsp/index.jsp";
    public static final String CONTACTS_JSP = "/jsp/contacts.jsp";
    public static final String SHOW_LIST_CARS_JSP = "/jsp/show_list_cars.jsp";
    public static final String LOGIN_JSP = "/jsp/login.jsp";
    public static final String USER_REGISTRATION_JSP = "/jsp/user_registration.jsp";
    public static final String WEB_LOGIN = "/login";
    public static final String WEB_CONTACTS = "/contacts";
    public static final String WEB_SHOW_LIST_CARS = "/showlistcars";
    public static final String WEB_USER_REGISTRATION = "/userregistration";
    public static final String USER_REG = "/userreg";

    public static final String WEB_LOGOUT = "/logout";
    public static final String VIEW_USER_DETAILS_JSP = "/jsp/view_user_details.jsp";
    public static final String WEB_VIEW_USER_DETAILS = "/viewuserdetails";
    public static final String WEB_ADMIN = "/admin";
    public static final String ADMIN_JSP = "/jsp/admin.jsp";

    public static final List<String> NO_AUTH_URLS  = List.of(
            INDEX_MAIN, INDEX_JSP, CONTACTS_JSP, SHOW_LIST_CARS_JSP, WEB_SHOW_LIST_CARS, LOGIN_JSP, USER_REG,
            USER_REGISTRATION_JSP, WEB_LOGIN, WEB_CONTACTS, WEB_SHOW_LIST_CARS, WEB_USER_REGISTRATION, WEB_LOGOUT);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if (true) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }

        LOGGER.debug("--- auth filter  ---");
        {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            HttpSession session = req.getSession();
            String requestURI = req.getRequestURI();

            String requestURL = requestURI.replaceFirst(req.getContextPath(), "");

            if (requestURL.startsWith("/jsp/")) {
                res.sendError(404);
                return;
            }

            if (NO_AUTH_URLS.contains(requestURL) || requestURL.startsWith("/img/")) {
                LOGGER.debug("Authentication is no required-  " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else if ((Objects.nonNull(session)) && (req.getSession().getAttribute(LOGGED_IN_USER) != null)) {
                LOGGER.debug("Authentication with login " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                LOGGER.debug("User is not authenticated. Redirect to login page " + requestURI);
                req.getRequestDispatcher(LOGIN_JSP)
                        .forward(servletRequest, servletResponse);
            }
        }
    }
}
