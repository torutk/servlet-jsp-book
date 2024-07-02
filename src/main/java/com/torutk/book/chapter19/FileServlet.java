package com.torutk.book.chapter19;

import com.torutk.book.tool.Page;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@WebServlet(urlPatterns = {"/torutk/chapter19/file"})
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Page.header(out);

        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/setting.txt");

        Properties prop = new Properties();
        try (Reader reader = new FileReader(path, StandardCharsets.UTF_8)) {
            prop.load(reader);
        }
        out.printf("<p>RealPath=%s</p>", path);
        for (String key : prop.stringPropertyNames()) {
            out.printf("<p>%s : %s</p>%n", key, prop.getProperty(key));
        }
        Page.footer(out);
    }
}
