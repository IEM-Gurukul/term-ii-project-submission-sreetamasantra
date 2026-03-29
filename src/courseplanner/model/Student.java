package courseplanner.model;

import java.io.Serializable;
import java.util.*;

public class Student extends User implements Serializable {

    private List<Course> registeredCourses;
    private Set<String> completedCourses;
    private int totalCredits;

    public Student(String userId, String name, String email) {
        super(userId, name, email);
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new HashSet<>();
        this.totalCredits = 0;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public Set<String> getCompletedCourses() {
        return completedCourses;
    }

    public void addCompletedCourse(String courseId) {
        completedCourses.add(courseId);
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        totalCredits += course.getCredits();
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            totalCredits -= course.getCredits();
        }
    }

    public boolean isAlreadyRegistered(Course course) {
        return registeredCourses.contains(course);
    }
}