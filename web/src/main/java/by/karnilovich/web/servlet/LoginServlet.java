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
        final String email=req.getParameter("email");
        final String password=req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        if (email.isEmpty() || password.isEmpty()) {
            writer.println("Please, Enter login and password");
            session.setAttribute(email, "not logged");
        } else {
            writer.println("All right");
            session.setAttribute(email, email);
        }


        //session.invalidate();
        session.setMaxInactiveInterval(24*60*60);

    }
}
