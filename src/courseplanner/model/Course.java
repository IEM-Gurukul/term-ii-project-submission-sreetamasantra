package courseplanner.model;

import java.util.*;
import courseplanner.exception.PrerequisiteNotMetException;

public abstract class Course {

    protected String courseId;
    protected String title;
    protected int credits;
    protected int capacity;
    protected int enrolledStudents;
    protected String schedule;
    protected Set<String> prerequisites;

    public Course(String courseId, String title, int credits, int capacity, String schedule) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
        this.prerequisites = new HashSet<>();
    }

    public String getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public String getSchedule() { return schedule; }
    public int getCredits() { return credits; }
    public int getCapacity() { return capacity; }
    public int getEnrolledStudents() { return enrolledStudents; }

    public void incrementEnrollment() {
        enrolledStudents++;
    }

    public void addPrerequisite(String courseId) {
        prerequisites.add(courseId);
    }

    public Set<String> getPrerequisites() {
        return prerequisites;
    }

    public abstract boolean validateRegistration(Student student)
            throws PrerequisiteNotMetException;
}