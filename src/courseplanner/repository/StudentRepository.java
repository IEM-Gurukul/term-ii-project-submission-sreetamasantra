package courseplanner.repository;

import courseplanner.model.Student;
import java.io.*;
import java.util.*;

public class StudentRepository {

    private Map<String, Student> studentMap = new HashMap<>();

    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(studentMap);
        } catch (IOException e) {
            System.out.println("Error saving students");
        }
    }

    public void loadAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            studentMap = (Map<String, Student>) ois.readObject();
        } catch (Exception e) {
            studentMap = new HashMap<>();
        }
    }

    public void addStudent(Student s) {
        studentMap.put(s.getUserId(), s);
    }

    public Student getStudent(String id) {
        return studentMap.get(id);
    }
}