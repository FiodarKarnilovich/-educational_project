package by.karnilovich.web.servlet;

import by.karnilovich.web.util.PersonUtil;
import by.kornilovich.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "UserRegistrationServlet", urlPatterns = "/userregistration")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String birthDay = req.getParameter("birthDay");
        final String phoneNumber = req.getParameter("phoneNumber");

        Person person = new Person(firstName, lastName, email, password, birthDay, phoneNumber);
        PersonUtil.addPersonToList(person);
        PrintWriter writer = resp.getWriter();
        writer.println("All right");

    }
}
