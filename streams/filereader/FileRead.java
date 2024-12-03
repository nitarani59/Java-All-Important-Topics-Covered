package streams.filereader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) throws IOException {
        FileReader fileReader;
        FileWriter fileWriter;

        {
            try {
                fileReader = new FileReader("filereader/Welcome.txt");
                fileWriter = new FileWriter("filereader/Welcome-copy.txt");
                int data;
                while ((data = fileReader.read()) != -1) {
                    System.out.print(data);
                    fileWriter.write((char)data);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileWriter.close();
            fileReader.close();
        }

    }
}
