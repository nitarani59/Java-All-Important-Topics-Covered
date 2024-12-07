package mutithreadingHandsOn;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadingFileWithoutMultithreading {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        readFile("mutithreadingHandsOn/Greetings.txt");
        readFile("mutithreadingHandsOn/Welcome.txt");
        readFile("mutithreadingHandsOn/Greetings.txt");
        readFile("mutithreadingHandsOn/Welcome.txt");
        readFile("mutithreadingHandsOn/Greetings.txt");
        readFile("mutithreadingHandsOn/Welcome.txt");
        readFile("mutithreadingHandsOn/Greetings.txt");
        readFile("mutithreadingHandsOn/Welcome.txt");
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken " + (endTime - startTime));
    }

    private static void readFile(String fileName) throws IOException {
        FileInputStream fileInputStream = null;
        StringBuilder content = new StringBuilder();

        try {
            fileInputStream = new FileInputStream(fileName);
            int data;
            while ((data = fileInputStream.read()) != -1) {
                content.append((char) data);
            }
            writeFile(content.toString().getBytes(StandardCharsets.UTF_8), "new"+(fileName.split("/")[1]));
        }
        finally {
            fileInputStream.close();
        }
    }

    private static void writeFile(byte[] data, String fileName) throws IOException {
        FileOutputStream fileOutputStream = null;
        System.out.println(data);
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(data);
        }
        finally {
            fileOutputStream.close();
        }
    }
}
