// ShoppingCartServlet.java
// Tomcat 10+ uses jakarta.servlet package

package com.shopping;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Servlet Running</title>

                    <style>

                        body{
                            font-family: Arial;
                            background:#f4f6f9;
                            text-align:center;
                            padding-top:100px;
                        }

                        .box{
                            background:white;
                            width:400px;
                            margin:auto;
                            padding:40px;
                            border-radius:10px;
                            box-shadow:0 0 10px rgba(0,0,0,0.1);
                        }

                        h1{
                            color:#3498db;
                        }

                    </style>

                </head>

                <body>

                    <div class="box">

                        <h1>Shopping Cart Servlet</h1>

                        <p>Tomcat 10+ Servlet is running successfully.</p>

                    </div>

                </body>
                </html>
                """);
    }
}