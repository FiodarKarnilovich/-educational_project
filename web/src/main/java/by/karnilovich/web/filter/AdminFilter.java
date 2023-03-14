package by.karnilovich.web.filter;

import by.karnilovich.entity.person.Person;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import static by.karnilovich.web.util.WebAttributes.LOGGED_IN_USER;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin")
public class AdminFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AdminFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LOGGER.debug(" -> admin filter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String requestURI = req.getRequestURI();

        String requestURL = requestURI.replaceFirst(req.getContextPath(), "");

        Person person = (Person) req.getSession().getAttribute(LOGGED_IN_USER);
        if (person.getRole().equals("ROLE_ADMIN")) {
            LOGGER.debug("Authorization with ROLE_ADMIN " + requestURI);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            LOGGER.debug("User is not authorized. Redirect to login page " + requestURI);
            res.sendError(403);
//            req.getRequestDispatcher(LOGIN_JSP)
//                    .forward(servletRequest, servletResponse);
        }
    }
}
