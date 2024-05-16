package serializationHandsOn;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializationHandsOn implements Serializable {

        private static final long serialVersionUID = 1L;
        static String country = "ITALY";
        private int age;
        private String name;
        transient int height;

        // getters and setters

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializationHandsOn person = new SerializationHandsOn();
        person.whenSerializingAndDeserializing_ThenObjectIsTheSame();
    }
// The test below shows an example of saving an object of type Person to a local file, and then reading the value back in:
    @Test
    public void whenSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
        SerializationHandsOn person = new SerializationHandsOn();
        person.setAge(20);
        person.setName("Joe");
        person.setHeight(180);
        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.json");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile.json");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializationHandsOn p2 = (SerializationHandsOn) objectInputStream.readObject();
        objectInputStream.close();
        assertTrue(p2.getAge() == person.getAge());
        assertTrue(p2.getName().equals(person.getName()));
        assertTrue(p2.getHeight() == 0);
    }
}
