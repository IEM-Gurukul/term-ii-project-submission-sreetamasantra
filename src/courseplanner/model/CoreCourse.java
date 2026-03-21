package courseplanner.model;

public class CoreCourse extends Course {
    public CoreCourse(String courseId, String title, int credits, int capacity, String schedule) {
        super(courseId, title, credits, capacity, schedule);
    }

    @Override
    public boolean validateRegistration(Student student) {
        // Core courses have no prerequisites, so any student can register
        return true; //for now
    }
    
}
