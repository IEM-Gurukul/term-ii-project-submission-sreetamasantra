package courseplanner.model;

import courseplanner.repository.CourseRepository;

public class Admin extends User {

    public Admin(String userId, String name, String email) {
        super(userId, name, email);
    }

    public void addCourse(CourseRepository repo, Course course) {
        repo.addCourse(course);
    }

    public void removeCourse(CourseRepository repo, String courseId) {
        repo.removeCourse(courseId);
    }
}