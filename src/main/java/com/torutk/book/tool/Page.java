package com.torutk.book.tool;

import java.io.PrintWriter;

public class Page {
    public static void header(PrintWriter out) {
        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>Servlet/JSP Sample Programs</title>
                </head>
                <body>
                """);
    }

    public static void footer(PrintWriter out) {
        out.println("""
                </body>
                </html>
                """);
    }
}
