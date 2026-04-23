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

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String author = request.getParameter("author");
        String content = request.getParameter("content");

        PrintWriter out = response.getWriter();

        if (title == null || title.isEmpty() ||
            content == null || content.isEmpty()) {

            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Error: Title and Content cannot be empty!</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h2>Diary Submitted Successfully</h2>");
        out.println("<p><strong>Title:</strong> " + title + "</p>");
        out.println("<p><strong>Date:</strong> " + date + "</p>");
        out.println("<p><strong>Author:</strong> " + author + "</p>");
        out.println("<p><strong>Content:</strong><br>" + content + "</p>");
        out.println("<br><a href='index.html'>Write Another Diary</a>");
        out.println("</body></html>");
    }
}
