package courseplanner.model;

import courseplanner.exception.PrerequisiteNotMetException;

public class LabCourse extends Course {

    private int labSlots;

    public LabCourse(String courseId, String title, int credits, int capacity, int labSlots, String schedule) {
        super(courseId, title, credits, capacity, schedule);
        this.labSlots = labSlots;
    }

    @Override
    public boolean validateRegistration(Student student) throws PrerequisiteNotMetException {

        for (String pre : prerequisites) {
            if (!student.getCompletedCourses().contains(pre)) {
                throw new PrerequisiteNotMetException("Missing prerequisite: " + pre);
            }
        }
        return true;
    }
}