package streams.serialization;

import java.io.*;

public class DserializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        fileInputStream = new FileInputStream("serialization/emp.ser");
        objectInputStream = new ObjectInputStream(fileInputStream);
        Student s = new Student(2,"n", 8, 7,7);
        long serialVersionUID = ObjectStreamClass.lookup(s.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID " + serialVersionUID);
        Object data = objectInputStream.readObject();
        Student std = (Student) data;

        System.out.println(std.toString());

        objectInputStream.close();
        fileInputStream.close();
    }
}
