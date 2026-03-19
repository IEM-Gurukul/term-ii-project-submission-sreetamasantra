package courseplanner.service;

import courseplanner.model.*;

public class RegistrationService {

    private static final int MAX_CREDITS = 20;

    public boolean registerCourse(Student student, Course course) {

        // Check credit limit
        if (student.getTotalCredits() + course.getCredits() > MAX_CREDITS) {
            System.out.println("Cannot register for " + course.getTitle() + ". Credit limit exceeded.");
            return false;
        }
        // Validate course-specific registration rules (Polymorphism)
        if (!course.validateRegistration(student)) {
            System.out.println("Course validation failed");
            return false;
        }

        // Register course
        student.getRegisteredCourses().add(course);
        System.out.println("Course registered successfully: " + course.getTitle());
        return true;
    }
}



