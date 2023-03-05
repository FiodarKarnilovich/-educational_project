package by.karnilovich.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(AuthFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("--- auth filter  ---");

        // оперделить урлы которые нужно сразу проходить без аутентификации
        // --> пропускать дальше
        // иначе проверяем есть ли параметр в сессии (не NULL)
        // есть --> пропускать дальше
        // NULL --> редирекд на логин с сообщением "нет сессии" или еще что-то"
        ((HttpServletResponse)servletResponse).sendRedirect("?");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
