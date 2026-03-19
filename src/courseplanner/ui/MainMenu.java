package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.exception.*;

public class MainMenu {

    public static void main(String[] args) {

        // Create a student
        Student s = new Student("S1", "Sreetama Santra", "sreetamasantra30@gmail.com");

        // Create courses
        Course c1 = new CoreCourse("C1", "Data Structures", 4, 50);
        Course c2 = new ElectiveCourse("C2", "Advanced Programming", 3, 40);
        Course c3 = new LabCourse("C3", "Advanced Programming Lab", 2, 30, 10);

        // Create service
        RegistrationService service = new RegistrationService();

        // Try registering courses
        try {
            service.registerCourse(s, c1);
            service.registerCourse(s, c2);
            service.registerCourse(s, c3);

        } catch (CreditLimitExceededException |
                 PrerequisiteNotMetException |
                 CourseCapacityFullException |
                 TimeTableConflictException e) {

            System.out.println(" Error: " + e.getMessage());
        }

        // Display registered courses
        System.out.println("\n Registered Courses:");
        for (Course c : s.getRegisteredCourses()) {
            System.out.println("- " + c.getTitle());
        }
    }
}