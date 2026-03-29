package courseplanner.repository;

import courseplanner.model.Course;
import java.util.*;

public class CourseRepository {

    private Map<String, Course> courseMap = new HashMap<>();

    public void addCourse(Course course) {
        courseMap.put(course.getCourseId(), course);
    }

    public void removeCourse(String courseId) {
        courseMap.remove(courseId);
    }

    public Course getCourse(String courseId) {
        return courseMap.get(courseId);
    }

    public Collection<Course> getAllCourses() {
        return courseMap.values();
    }
}