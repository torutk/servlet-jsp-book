package com.torutk.book.tool;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;

/**
 * データベース bigdata テーブルへimportするためのデータをCSVファイルに生成する。
 *
 */
public class CreateCsv {
    private static long NUM_ROWS = 3_000_000_000L;

    private static void generateByPrintf() {
        for (long i = 0; i < NUM_ROWS; i++) {
            System.out.printf("%d, %010d\n", i, i);
            if (i % (NUM_ROWS / 100) == 0) {
                System.err.print('=');
            }
        }
    }

    private static void generateByPrintWriter(String file) throws IOException {
        try (PrintWriter pw = new PrintWriter(Paths.get(file).toFile())) {
            for (long i = 0; i < NUM_ROWS; i++) {
                pw.printf("%d, %010d\n", i, i);
                if (i % (NUM_ROWS / 100) == 0) {
                    System.err.print('=');
                }
            }
        }
    }

    private static void generateByBufferdWriter(String file) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(file))) {
            for (long i = 0; i < NUM_ROWS; i++) {
                bw.write(String.format("%d, %010d\n", i, i));
                if (i % (NUM_ROWS / 100) == 0) {
                    System.err.print('=');
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.err.println(ZonedDateTime.now() + " start to generate " + NUM_ROWS + " rows");
        if (args.length < 1) {
            generateByPrintf();
        } else {
            //generateByPrintWriter(args[0]);
            generateByBufferdWriter(args[0]);
        }
        System.err.println(ZonedDateTime.now() + " end");
    }
}
