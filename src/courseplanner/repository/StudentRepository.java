package courseplanner.repository;

import courseplanner.model.Student;

import java.io.*;

public class StudentRepository {

    public void saveStudent(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
        } catch (IOException e) {
            System.out.println("Error saving student data");
        }
    }

    public Student loadStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            return (Student) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
