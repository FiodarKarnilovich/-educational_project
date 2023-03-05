package by.karnilovich.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("--- auth filter  ---");
        {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            HttpSession session = req.getSession();
            String requestURI = req.getRequestURI();


            if (requestURI.equals("/web/jsp/index.jsp") || requestURI.equals("/web/jsp/contacts.jsp") ||
                    requestURI.equals("/web/jsp/show_list_cars.jsp") || requestURI.equals("/web/jsp/login.jsp") ||
                    requestURI.equals("/web/jsp/user_registration.jsp")  ) {
                LOGGER.debug(" 1 if -  "+requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
            } else if ((requestURI.equals("/web/jsp/index_logged.jsp") || requestURI.equals("/web/jsp/view_user_details.jsp")
                    || requestURI.equals("/web/login") || requestURI.equals("/web/userregistration")) ||
                        ((session != null) && (session.getAttribute("LOGGED_IN_USER") != null))) {
                LOGGER.debug(" 2 if "+requestURI);
                filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    LOGGER.debug("3 else "+requestURI);
                    res.sendRedirect("/web/jsp/login.jsp");
                }
                // оперделить урлы которые нужно сразу проходить без аутентификации
                // --> пропускать дальше
                // иначе проверяем есть ли параметр в сессии (не NULL)
                // есть --> пропускать дальше
                // NULL --> редирекд на логин с сообщением "нет сессии" или еще что-то"
//            ((HttpServletResponse) servletResponse).sendRedirect("/web/login.jsp");
//            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
