package courseplanner.model;

import java.util.*;

public class Student extends User {
    private List <Course> registeredCourses;
    private int totalCredits;

    public Student(String userId, String name, String email) {
        super(userId, name, email);
        this.registeredCourses = new ArrayList<>();
        this.totalCredits = 0;
    }

    public List <Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public int getTotalCredits() {
        return totalCredits;
    }
}
