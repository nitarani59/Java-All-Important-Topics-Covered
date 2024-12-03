package streams.bufferreader;

import java.io.*;

public class BufferRead {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        {
            try {
                fileReader = new FileReader("bufferreader/Welcome-.txt");
                fileWriter = new FileWriter("bufferreader/Welcome-copy.txt");
                bufferedReader = new BufferedReader(fileReader);
                bufferedWriter = new BufferedWriter(fileWriter);
                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    System.out.println(data);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            finally {
                fileReader.close();
                bufferedReader.close();
            }
        }
    }
}
