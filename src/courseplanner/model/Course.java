package courseplanner.model;

public abstract class Course {
    protected String courseId;
    protected String title;
    protected int credits;
    protected int capacity;

    public Course(String courseId, String title, int credits, int capacity) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.capacity = capacity;
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
    
    public abstract boolean validateRegistration(Student student);
}
