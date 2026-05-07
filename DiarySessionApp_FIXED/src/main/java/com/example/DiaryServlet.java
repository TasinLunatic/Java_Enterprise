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
        out.println("<title>Smart Diary Dashboard</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");

        out.println("<body>");

        // NAVBAR
        out.println("<div class='navbar'>");
        out.println("<div class='logo'>My Diary</div>");

        out.println("<div class='user-area'>");

        if (username != null) {

            out.println("<div class='profile-box'>");

            out.println("<div class='profile-avatar'>");
            out.println(username.substring(0,1).toUpperCase());
            out.println("</div>");

            out.println("<div class='profile-info'>");
            out.println("<h4>" + username + "</h4>");
            out.println("<p>Active User</p>");
            out.println("</div>");

            out.println("</div>");

            out.println("<a class='logout-btn' href='logout'>Logout</a>");
        } else {

            out.println("<a class='login-link' href='login.html'>Login</a>");
        }

        out.println("</div>");
        out.println("</div>");

        // HERO SECTION
        out.println("<div class='hero-section'>");

        if (username != null) {

            out.println("<h1>Welcome Back, " + username + " 👋</h1>");
            out.println("<p>Manage your daily memories and personal notes securely.</p>");

        } else {

            out.println("<h1>Smart Online Diary</h1>");
            out.println("<p>Login to access your private diary dashboard.</p>");
        }

        out.println("</div>");

        // DASHBOARD STATS
        if (username != null) {

            out.println("<div class='stats-container'>");

            out.println("<div class='stat-card'>");
            out.println("<h2>12</h2>");
            out.println("<p>Total Diaries</p>");
            out.println("</div>");

            out.println("<div class='stat-card'>");
            out.println("<h2>5</h2>");
            out.println("<p>This Week</p>");
            out.println("</div>");

            out.println("<div class='stat-card'>");
            out.println("<h2>100%</h2>");
            out.println("<p>Session Active</p>");
            out.println("</div>");

            out.println("</div>");
        }

        // DIARY SECTION
        out.println("<div class='container'>");

        out.println("<div class='section-title'>Recent Diary Entries</div>");

        out.println("<div class='diary-grid'>");

        for (int i = 1; i <= 6; i++) {

            out.println("<div class='diary-card'>");

            out.println("<div class='card-header'>");
            out.println("<span class='tag'>Personal</span>");
            out.println("<span class='date'>May " + (10 + i) + ", 2026</span>");
            out.println("</div>");

            out.println("<h3>Diary Entry " + i + "</h3>");

            out.println("<p>This is a secure session-based diary system developed using Java Servlet, HTML, CSS, and HttpSession technology.</p>");

            if (username != null) {
                out.println("<button class='delete-btn'>Delete Entry</button>");
            }

            out.println("</div>");
        }
        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}