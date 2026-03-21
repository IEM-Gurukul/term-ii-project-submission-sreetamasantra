package courseplanner.model;

public class ElectiveCourse extends Course {
    public ElectiveCourse(String courseId, String title, int credits, int capacity, String schedule) {
        super (courseId, title, credits, capacity, schedule);
    }

    @Override
    public boolean validateRegistration(Student student) {
        return true; //electives are open to all 
    }
    
}
