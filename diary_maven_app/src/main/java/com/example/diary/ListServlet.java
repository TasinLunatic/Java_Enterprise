package com.example.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

  // Get data folder
  String path = getServletContext().getRealPath("/data");
  File dir = new File(path);

  // Create folder if not exists
  if (!dir.exists()) {
   dir.mkdirs();
  }

  File[] files = dir.listFiles();

  // Sort by latest (newest first)
  if (files != null) {
   Arrays.sort(files, (a, b) -> Long.compare(
           Long.parseLong(b.getName().replace(".txt", "")),
           Long.parseLong(a.getName().replace(".txt", ""))
   ));
  }

  // Output HTML
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();

  out.println("<link rel='stylesheet' href='css/style.css'>");

  out.println("<div class='navbar'>📔 My Diary App</div>");
  out.println("<div class='container'>");

  out.println("<h1>Diary List</h1>");

  if (files != null && files.length > 0) {
   for (File file : files) {
    String name = file.getName();

    out.println("<div class='diary-item'>");
    out.println("<strong>" + name + "</strong>");

    out.println("<div class='actions'>");
    out.println("<a href='view?file=" + name + "'>View</a>");
    out.println("<a href='edit?file=" + name + "'>Edit</a>");
    out.println("<a href='delete?file=" + name + "'>Delete</a>");
    out.println("</div>");

    out.println("</div>");
   }
  } else {
   out.println("<p>No diary entries yet.</p>");
  }

  out.println("<a href='add.html' class='add-btn'><button>Add New Diary</button></a>");
  out.println("</div>");
 }
}