package courseplanner.service;

import courseplanner.model.*;
import courseplanner.exception.*;

public class RegistrationService {

    private static final int MAX_CREDITS = 20;

    public void registerCourse(Student student, Course course)
            throws CreditLimitExceededException,
                   PrerequisiteNotMetException,
                   CourseCapacityFullException,
                   TimeTableConflictException {

        //1. Credit check
        if (student.getTotalCredits() + course.getCredits() > MAX_CREDITS) {
            throw new CreditLimitExceededException("Credit limit exceeded!");
        }

        // 2️. Course-specific validation (polymorphism)
        if (!course.validateRegistration(student)) {
            throw new PrerequisiteNotMetException("Prerequisites not satisfied!");
        }

        // 3. Capacity check
        if (course.getEnrolledStudents() >= course.getCapacity()) {
            throw new CourseCapacityFullException("Course capacity full!");
        }

        // 4. Time table conflict check
        for (Course registered : student.getRegisteredCourses()) {
            if (registered.getSchedule().equals(course.getSchedule())) {
                throw new TimeTableConflictException("Time table conflict with " + registered.getTitle());
            }
        }

        // 5. Register course
        course.incrementEnrollment();
        student.getRegisteredCourses().add(course);

        System.out.println("✅ Registered: " + course.getTitle());
    }
}