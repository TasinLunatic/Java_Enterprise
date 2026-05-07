package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple login validation
        if ("admin".equals(username)
                && "123456".equals(password)) {

            // Create session
            HttpSession session = request.getSession();

            // Save username
            session.setAttribute("username", username);

            // Redirect after login
            response.sendRedirect("diary");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("""
                    <h2>Login Failed!</h2>
                    <a href='login.html'>Try Again</a>
                    """);
        }
    }
}
