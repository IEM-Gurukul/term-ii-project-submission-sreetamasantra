package courseplanner.model;

import java.util.List;

public class Admin extends User {

    public Admin(String userId, String name, String email) {
        super(userId, name, email);
    }

    // Admin can add courses
    public void addCourse(List<Course> courseList, Course course) {
        courseList.add(course);
    }
}

