package com.example.diary;

import jakarta.servlet.ServletContext;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DiaryUtil {

    // Get real storage path inside Tomcat
    private static String getDir(ServletContext context) {
        String path = context.getRealPath("/WEB-INF/data");
        File dir = new File(path);

        if (!dir.exists()) {
            dir.mkdirs(); // create folder automatically
        }
        return path;
    }

    // Save diary
    public static void save(ServletContext context, String title, String content, String ip) throws Exception {
        long time = System.currentTimeMillis();
        String name = time + ".txt";

        FileWriter fw = new FileWriter(getDir(context) + "/" + name);
        fw.write("Time: " + format(time) + "\n");
        fw.write("IP: " + ip + "\n");
        fw.write("Title: " + title + "\n");
        fw.write("Content:\n" + content);
        fw.close();
    }

    // List files (SAFE)
    public static List<String> list(ServletContext context) {
        File folder = new File(getDir(context));
        File[] files = folder.listFiles();

        List<String> list = new ArrayList<>();

        if (files != null) {
            for (File f : files) {
                list.add(f.getName());
            }
        }

        list.sort(Collections.reverseOrder());
        return list;
    }

    // Read file
    public static String read(ServletContext context, String name) throws Exception {
        return new String(Files.readAllBytes(
                Paths.get(getDir(context) + "/" + name)
        ));
    }

    // Update diary
    public static void update(ServletContext context, String name, String title, String content) throws Exception {
        FileWriter fw = new FileWriter(getDir(context) + "/" + name);
        fw.write("Updated Time: " + format(System.currentTimeMillis()) + "\n");
        fw.write("Title: " + title + "\n");
        fw.write("Content:\n" + content);
        fw.close();
    }

    // Delete diary
    public static void delete(ServletContext context, String name) {
        new File(getDir(context) + "/" + name).delete();
    }

    // Format time
    private static String format(long t) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t));
    }
}