package com.example.diary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {

  DiaryUtil.delete(
          getServletContext(),
          req.getParameter("name")
  );

  resp.sendRedirect("list");
 }
}