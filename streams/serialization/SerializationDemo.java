package streams.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        fileOutputStream = new FileOutputStream(new File("serialization/emp.ser"));
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Student st = new Student(1, "Nita",  2, 12345, 1);
        long serialVersionUID = ObjectStreamClass.lookup(st.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID " + serialVersionUID);
        objectOutputStream.writeObject(st);
    }
}
