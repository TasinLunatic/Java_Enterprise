package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<div class='login-card'>");

        out.println("<h1>Diary List</h1>");

        // User info
        if (username != null) {

            out.println("<p class='subtitle'>Welcome, <b>"
                    + username + "</b></p>");

            out.println("<a href='logout' " +
                    "style='color:red;text-decoration:none;font-weight:bold;'>");
            out.println("Logout</a><br><br>");

        } else {

            out.println("<p class='subtitle'>Please login first.</p>");

            out.println("<a href='login.html' " +
                    "style='text-decoration:none;color:#243b55;font-weight:bold;'>");
            out.println("Login</a><br><br>");
        }

        // Diary List
        out.println("<ul style='list-style:none;'>");

        out.println("<li style='background:#f1f1f1;" +
                "padding:15px;margin:10px 0;border-radius:10px;'>");

        out.println("Diary Record 1");

        // Delete button only after login
        if (username != null) {

            out.println("<button style='margin-left:15px;" +
                    "padding:8px 14px;" +
                    "border:none;" +
                    "border-radius:8px;" +
                    "background:red;" +
                    "color:white;" +
                    "cursor:pointer;'>");

            out.println("Delete</button>");
        }

        out.println("</li>");

        out.println("<li style='background:#f1f1f1;" +
                "padding:15px;margin:10px 0;border-radius:10px;'>");

        out.println("Diary Record 2");

        if (username != null) {

            out.println("<button style='margin-left:15px;" +
                    "padding:8px 14px;" +
                    "border:none;" +
                    "border-radius:8px;" +
                    "background:red;" +
                    "color:white;" +
                    "cursor:pointer;'>");

            out.println("Delete</button>");
        }

        out.println("</li>");

        out.println("</ul>");

        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}