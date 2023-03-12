package by.karnilovich.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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
    }
}
