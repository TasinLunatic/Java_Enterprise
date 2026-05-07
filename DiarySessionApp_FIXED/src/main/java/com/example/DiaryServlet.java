package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/diary")
public class DiaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        out.println("<html>");

        out.println("<head>");
        out.println("<title>Smart Diary</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='navbar'>");
        out.println("<div class='logo'>Smart Diary</div>");

        out.println("<div class='user-area'>");

        if (username != null) {

            out.println("<span>Welcome, " + username + "</span>");

            out.println("<a class='logout-btn' href='logout'>Logout</a>");

        } else {

            out.println("<a class='login-link' href='login.html'>Login</a>");
        }

        out.println("</div>");
        out.println("</div>");

        out.println("<div class='container'>");

        out.println("<div class='diary-grid'>");

        for (int i = 1; i <= 6; i++) {

            out.println("<div class='diary-card'>");

            out.println("<h3>Diary Entry " + i + "</h3>");

            out.println("<p>This is a modern session-based diary application using Servlet and HttpSession technology.</p>");

            if (username != null) {
                out.println("<button class='delete-btn'>Delete</button>");
            }

            out.println("</div>");
        }

        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}