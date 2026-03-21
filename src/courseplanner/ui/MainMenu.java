package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.exception.*;

public class MainMenu {

    public static void main(String[] args) {

        // Create student
        Student s = new Student("S1", "Sreetama Santra", "sreetama@gmail.com");

        // Simulate completed courses
        s.addCompletedCourse("C0");  // prerequisite satisfied for c1

        // Create courses (with schedule)
        Course c1 = new CoreCourse("C1", "Data Structures", 4, 2, "Mon-10AM");
        Course c2 = new ElectiveCourse("C2", "Artificial Intelligence", 3, 2, "Tue-2PM");
        Course c3 = new LabCourse("C3", "Java Lab", 2, 1, "Mon-10AM", 5); // same time as c1

        // Add prerequisites
        c1.addPrerequisite("C0");   // student HAS this → allowed
        c2.addPrerequisite("C99");  // student DOES NOT have → will fail

        // Create service
        RegistrationService service = new RegistrationService();

        try {
            // Should succeed
            service.registerCourse(s, c1);

            // Should fail (prerequisite not met)
            service.registerCourse(s, c2);

            // Should fail (timetable conflict with c1)
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

        // Display total credits
        System.out.println("\n Total Credits: " + s.getTotalCredits());
    }
}