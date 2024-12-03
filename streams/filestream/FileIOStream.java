package streams.filestream;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis;
        FileOutputStream fos;
        {
            try {
                fis = new FileInputStream("filereader/image.jpg");
                fos = new FileOutputStream("filestream/image-copy.jpg");
                int character;
                while ((character = fis.read()) != -1) {
                    fos.write((byte)character);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            fis.close();
            fos.close();
        }
    }
}
