package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Read session
        HttpSession session = request.getSession(false);

        if (session != null) {

            // Destroy session
            session.invalidate();
        }

        // Redirect to diary page
        response.sendRedirect("diary");
    }
}