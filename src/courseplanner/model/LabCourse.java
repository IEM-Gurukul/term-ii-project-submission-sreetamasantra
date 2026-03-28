package courseplanner.model;

public class LabCourse extends Course {

    private int labSlots;

    public LabCourse(String courseId, String title, int credits, int capacity, int labSlots, String schedule) {
        super(courseId, title, credits, capacity, schedule);
        this.labSlots = labSlots;
    }

    @Override
    public boolean validateRegistration(Student student) {
        return true;
    }
}