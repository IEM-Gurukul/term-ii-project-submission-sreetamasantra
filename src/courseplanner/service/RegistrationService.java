package courseplanner.service;

import courseplanner.model.*;
import courseplanner.exception.*;

public class RegistrationService {

    private static final int MAX_CREDITS = 20;

    public void registerCourse(Student student, Course course)
            throws CreditLimitExceededException,
                   PrerequisiteNotMetException,
                   CourseCapacityFullException,
                   TimeTableConflictException,
                   DuplicateCourseException {

        // Duplicate check
        if (student.isAlreadyRegistered(course)) {
            throw new DuplicateCourseException("Already registered!");
        }

        // Credit limit check
        if (student.getTotalCredits() + course.getCredits() > MAX_CREDITS) {
            throw new CreditLimitExceededException("Credit limit exceeded!");
        }

        // Prerequisite check
        course.validateRegistration(student);

        // Capacity check
        if (course.getEnrolledStudents() >= course.getCapacity()) {
            throw new CourseCapacityFullException("Course full!");
        }

        // Time conflict check
        for (Course registered : student.getRegisteredCourses()) {
            if (registered.getSchedule().equals(course.getSchedule())) {
                throw new TimeTableConflictException(
                        "Conflict with " + registered.getTitle());
            }
        }

        // Register
        student.registerCourse(course);
        course.incrementEnrollment();
    }

    public void dropCourse(Student student, Course course)
            throws CourseNotRegisteredException {

        if (!student.getRegisteredCourses().contains(course)) {
            throw new CourseNotRegisteredException("Not registered!");
        }

        student.dropCourse(course);
    }

    public void viewAcademicPlan(Student student) {

        System.out.println("\n--- Academic Plan ---");

        if (student.getRegisteredCourses().isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course c : student.getRegisteredCourses()) {
                System.out.println(c.getCourseId() + " - " + c.getTitle());
            }
        }

        System.out.println("Total Credits: " + student.getTotalCredits());
    }
}