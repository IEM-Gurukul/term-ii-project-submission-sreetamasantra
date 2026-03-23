package courseplanner.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Student extends User implements Serializable {

    private List<Course> registeredCourses;
    private List<String> completedCourses;
    private int totalCredits;

    // Constructor
    public Student(String userId, String name, String email) {
        super(userId, name, email);
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.totalCredits = 0;
    }

    // Get registered courses
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    // Get completed courses
    public List<String> getCompletedCourses() {
        return completedCourses;
    }

    // Add a completed course
    public void addCompletedCourse(String courseId) {
        completedCourses.add(courseId);
    }

    // Get total credits
    public int getTotalCredits() {
        return totalCredits;
    }

    // Update total credits when registering a course
    public void addCredits(int credits) {
        totalCredits += credits;
    }
}