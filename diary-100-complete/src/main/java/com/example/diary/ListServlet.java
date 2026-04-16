package com.example.diary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("<title>Diary List</title></head><body>");

        out.println("<div class='container'>");
        out.println("<h1>📔 Diary List</h1>");
        out.println("<a href='add.html' class='add-btn'>+ Add Diary</a>");

        try {
            List<String> files = DiaryUtil.list(getServletContext());

            if (files.isEmpty()) {
                out.println("<p>No diary entries found.</p>");
            }

            for (String f : files) {
                out.println("<div class='card'>");
                out.println("<h3>" + f + "</h3>");

                out.println("<div class='actions'>");
                out.println("<a href='view?name=" + f + "'>View</a>");
                out.println("<a href='edit?name=" + f + "'>Edit</a>");
                out.println("<a href='delete?name=" + f + "' onclick='return confirm(\"Delete?\")'>Delete</a>");
                out.println("</div>");

                out.println("</div>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e + "</p>");
        }

        out.println("</div></body></html>");
    }
}