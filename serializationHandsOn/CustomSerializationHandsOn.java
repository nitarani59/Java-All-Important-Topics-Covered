package serializationHandsOn;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomSerializationHandsOn implements Serializable {
        private static final long serialVersionUID = 1L;
        private transient Address address;
        private Person person;

        // setters and getters


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Serial
        private void writeObject(ObjectOutputStream oos)
                throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(address.getHouseNumber());
        }

        @Serial
        private void readObject(ObjectInputStream ois)
                throws ClassNotFoundException, IOException {
            ois.defaultReadObject();
            Integer houseNumber = (Integer) ois.readObject();
            Address a = new Address();
            a.setHouseNumber(houseNumber);
            this.setAddress(a);
        }

    @Test
    public void whenCustomSerializingAndDeserializing_ThenObjectIsTheSame()
            throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(20);
        p.setName("Joe");

        Address a = new Address();
        a.setHouseNumber(1);

        CustomSerializationHandsOn e = new CustomSerializationHandsOn();
        e.setPerson(p);
        e.setAddress(a);

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        CustomSerializationHandsOn e2 = (CustomSerializationHandsOn) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(e2.getPerson().getAge() == e.getPerson().getAge());
//        assertTrue(e2.getAddress().getHouseNumber() == e.getAddress().getHouseNumber());
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomSerializationHandsOn  e = new CustomSerializationHandsOn();
        e.whenCustomSerializingAndDeserializing_ThenObjectIsTheSame();
    }
}
class Address {
    private Integer houseNumber;

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}

class Person implements Serializable {
    private String name;
    private int age;
    private Address address;
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
