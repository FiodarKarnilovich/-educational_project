package by.karnilovich.web.filter;

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
import static by.karnilovich.web.util.WebAttributes.*;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);


    public static final List<String> NO_AUTH_URLS  = List.of(
            INDEX_MAIN, WEB_SHOW_LIST_CARS, WEB_LOGIN, WEB_CONTACTS,
            WEB_SHOW_LIST_CARS, WEB_USER_REGISTRATION, WEB_LOGOUT);


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
                req.setAttribute(EXTRA_MESSAGE, "Данная страница для авторизованных пользователей.");
                req.getRequestDispatcher(LOGIN_JSP)
                        .forward(servletRequest, servletResponse);
            }
        }
    }
}
