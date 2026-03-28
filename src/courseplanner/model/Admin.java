package courseplanner.model;

import courseplanner.repository.CourseRepository;

public class Admin extends User {

    public Admin(String userId, String name, String email) {
        super(userId, name, email);
    }

    public void addCourse(CourseRepository repo, Course course) {
        repo.addCourse(course);
        System.out.println("Course added: " + course.getTitle());
    }

    public void removeCourse(CourseRepository repo, String courseId) {
        repo.removeCourse(courseId);
        System.out.println("Course removed: " + courseId);
    }

    public void viewCourses(CourseRepository repo) {
        for (Course c : repo.getAllCourses()) {
            System.out.println(c.getCourseId() + " - " + c.getTitle());
        }
    }
}