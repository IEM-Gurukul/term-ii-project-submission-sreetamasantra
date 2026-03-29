package courseplanner.model;

import courseplanner.exception.PrerequisiteNotMetException;

public class CoreCourse extends Course {

    public CoreCourse(String courseId, String title, int credits, int capacity, String schedule) {
        super(courseId, title, credits, capacity, schedule);
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
