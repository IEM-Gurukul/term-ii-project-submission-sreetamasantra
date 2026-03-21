package courseplanner.model;

public class CoreCourse extends Course {
    public CoreCourse(String courseId, String title, int credits, int capacity, String schedule) {
        super(courseId, title, credits, capacity, schedule);
    }

    @Override
    public boolean validateRegistration(Student student) {
        for (String prereq : prerequisites) {
            if (!student.getCompletedCourses().contains(prereq)) {
                return false; // prerequisite not met
            }
        }
        return true; // all prerequisites met
    }
    
}
