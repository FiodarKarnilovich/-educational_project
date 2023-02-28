package by.karnilovich.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username=req.getParameter("username");
        final String password=req.getParameter("password");

        PrintWriter writer = resp.getWriter();

        if (username.isEmpty() || password.isEmpty()) {
            writer.println("Please, Enter login and password");
        } else {
            writer.println("All right");
        }

        HttpSession session = req.getSession();
        //session.invalidate();
        session.setMaxInactiveInterval(24*60*60);

    }
}
