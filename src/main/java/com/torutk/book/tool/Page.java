package com.torutk.book.tool;

import java.io.PrintWriter;

public class Page {
    public static void header(PrintWriter out) {
        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>Servlet/JSP Sample Programs Refined</title>
                </head>
                <body>
                <header>
                <h1>JSP Sample Programs Refined</h1>
                </header>
                <main>
                """);
    }

    public static void footer(PrintWriter out) {
        out.println("""
                </main>
                <footer>
                <p>「基礎からのサーブレット/JSP 第5版」</p>
                </footer>
                </body>
                </html>
                """);
    }
}
