package courseplanner.model;

public abstract class Course {
    protected String courseId;
    protected String title;
    protected int credits;
    protected int capacity;
    protected int enrolledStudents;
    protected String schedule; // For future timetable conflict logic

    public Course(String courseId, String title, int credits, int capacity, String schedule) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
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
    
    public abstract boolean validateRegistration(Student student);
}
