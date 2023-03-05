package by.karnilovich.web.servlet;

import by.kornilovich.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person attribute = (Person) req.getSession().getAttribute(LoginServlet.LOGGED_IN_USER);
    }
}
