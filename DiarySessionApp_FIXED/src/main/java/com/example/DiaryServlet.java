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

        // Read session
        HttpSession session = request.getSession(false);

        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        out.println("<html>");

        out.println("<head>");
        out.println("<title>Diary List</title>");

        // Connect CSS
        out.println("<link rel='stylesheet' href='style.css'>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<div class='login-card'>");

        out.println("<h1>Diary List</h1>");

        // BEFORE LOGIN
        if (username == null) {

            out.println("<p class='subtitle'>Please login first</p>");

            out.println("<a href='login.html' " +
                    "style='text-decoration:none;" +
                    "font-weight:bold;" +
                    "color:#243b55;'>");

            out.println("Login</a><br><br>");

        } else {

            // AFTER LOGIN
            out.println("<p class='subtitle'>Welcome, <b>"
                    + username + "</b></p>");

            // USERNAME DISPLAY
            out.println("<a href='logout' " +
                    "style='text-decoration:none;" +
                    "font-weight:bold;" +
                    "color:red;'>");

            out.println("Logout</a><br><br>");
        }

        // Diary Record 1
        out.println("<div style='background:#f1f1f1;" +
                "padding:15px;" +
                "margin:10px 0;" +
                "border-radius:10px;'>");

        out.println("Diary Record 1");

        // DELETE BUTTON VISIBLE AFTER LOGIN
        if (username != null) {

            out.println("<button style='margin-top:10px;'>");
            out.println("Delete");
            out.println("</button>");
        }

        out.println("</div>");

        // Diary Record 2
        out.println("<div style='background:#f1f1f1;" +
                "padding:15px;" +
                "margin:10px 0;" +
                "border-radius:10px;'>");

        out.println("Diary Record 2");

        if (username != null) {

            out.println("<button style='margin-top:10px;'>");
            out.println("Delete");
            out.println("</button>");
        }

        out.println("</div>");

        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}