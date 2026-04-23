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
        String mood = request.getParameter("mood");
        String weather = request.getParameter("weather");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Diary Result</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head><body>");

        if (title == null || title.isEmpty() ||
                content == null || content.isEmpty()) {

            out.println("<div class='result error-box'>");
            out.println("<h2>⚠ Error</h2>");
            out.println("<p>Title and Content cannot be empty!</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</div>");

        } else {

            out.println("<div class='result'>");
            out.println("<h1>📖 Diary Entry</h1>");

            out.println("<p><b>Title:</b> " + title + "</p>");
            out.println("<p><b>Date:</b> " + date + "</p>");
            out.println("<p><b>Author:</b> " + author + "</p>");
            out.println("<p><b>Mood:</b> " + mood + "</p>");
            out.println("<p><b>Weather:</b> " + weather + "</p>");
            out.println("<hr>");
            out.println("<p>" + content + "</p>");

            out.println("<br><a href='index.html'>➕ New Entry</a>");
            out.println("</div>");
        }

        out.println("</body></html>");
    }
}