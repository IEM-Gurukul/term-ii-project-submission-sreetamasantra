package courseplanner.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    protected String courseId;
    protected String title;
    protected int credits;
    protected int capacity;
    protected int enrolledStudents;
    protected String schedule; 
    protected List<String> prerequisites;

    public Course(String courseId, String title, int credits, int capacity, String schedule) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
        this.prerequisites = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }
    public String getTitle() {
        return title;
    }
    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void incrementEnrollment(){
        enrolledStudents++;
    }

    public String getSchedule() {
        return schedule;
    }

    public void addPrerequisite(String courseId) {
        prerequisites.add(courseId);
    }
    
    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public abstract boolean validateRegistration(Student student);
}
