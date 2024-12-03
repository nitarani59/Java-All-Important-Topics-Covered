package streams.serialization;

import java.io.*;

public class Student extends Department implements Serializable  {
    int id;
    String name;
    int age;
    transient int ssn;
    int b;


    public Student(int id, String name, int age, int ssn,int b) {
        super(1);
        this.id = id;
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
