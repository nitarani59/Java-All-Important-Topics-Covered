package multithreadingHandsOn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadingFileWithMultithreading {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            try {
                readFile("mutithreadingHandsOn/Greetings.txt");
                readFile("mutithreadingHandsOn/Greetings.txt");
                readFile("mutithreadingHandsOn/Greetings.txt");
                readFile("mutithreadingHandsOn/Greetings.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                readFile("mutithreadingHandsOn/Welcome.txt");
                readFile("mutithreadingHandsOn/Welcome.txt");
                readFile("mutithreadingHandsOn/Welcome.txt");
                readFile("mutithreadingHandsOn/Welcome.txt");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread1.start();

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