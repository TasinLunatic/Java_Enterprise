package com.example.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request initialized");
    }
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed");
    }
}
