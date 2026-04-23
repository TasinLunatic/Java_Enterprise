package com.example.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/diary")
public class DiaryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Encoding
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Get data
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String author = request.getParameter("author");
        String content = request.getParameter("content");

        PrintWriter out = response.getWriter();

        // Start HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Diary Result</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        // Validation
        if (title == null || title.isEmpty() ||
                content == null || content.isEmpty()) {

            out.println("<div class='result'>");
            out.println("<h3 class='error'>Error: Title and Content cannot be empty!</h3>");
            out.println("<br><a href='index.html'>Go Back</a>");
            out.println("</div>");

        } else {

            out.println("<div class='result'>");
            out.println("<h2>Diary Submitted Successfully</h2>");
            out.println("<p><strong>Title:</strong> " + title + "</p>");
            out.println("<p><strong>Date:</strong> " + date + "</p>");
            out.println("<p><strong>Author:</strong> " + author + "</p>");
            out.println("<p><strong>Content:</strong><br>" + content + "</p>");
            out.println("<br><a href='index.html'>Write Another</a>");
            out.println("</div>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}