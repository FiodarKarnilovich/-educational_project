package by.karnilovich.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.karnilovich.web.servlet.LoginServlet.LOGGED_IN_USER;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);
    public static final String INDEX_JSP = "/web/jsp/index.jsp";
    public static final String CONTACTS_JSP = "/web/jsp/contacts.jsp";
    public static final String SHOW_LIST_CARS_JSP = "/web/jsp/show_list_cars.jsp";
    public static final String LOGIN_JSP = "/web/jsp/login.jsp";
    public static final String USER_REGISTRATION_JSP = "/web/jsp/user_registration.jsp";
    public static final String WEB_LOGIN = "/web/login";
    public static final String WEB_LOGOUT = "/web/logout";
    public static final String WEB_USER_REGISTRATION = "/web/userregistration";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("--- auth filter  ---");
        {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            HttpSession session = req.getSession();
            String requestURI = req.getRequestURI();


            if (requestURI.equals(INDEX_JSP) ||
                    requestURI.equals(CONTACTS_JSP) ||
                    requestURI.equals(SHOW_LIST_CARS_JSP) ||
                    requestURI.equals(LOGIN_JSP) ||
                    requestURI.equals(USER_REGISTRATION_JSP) ||
                    requestURI.equals(WEB_LOGIN) ||
                    requestURI.equals(WEB_USER_REGISTRATION)) {
                LOGGER.debug(" registration no required-  " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (requestURI.equals(WEB_LOGOUT)) {
                LOGGER.debug(" if (for logout) " + requestURI);
                session.invalidate();
                res.sendRedirect(INDEX_JSP);
            } else if ((session != null) && (session.getAttribute(LOGGED_IN_USER) != null)) {
                LOGGER.debug(" registration with login " + requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                LOGGER.debug("Not authorisation. Redirect to login page " + requestURI);
                res.sendRedirect(LOGIN_JSP);
            }
        }
    }
}
