package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.exception.*;

import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student("S1", "Sreetama Santra", "sreetamasantra30@gmail.com");

        // Predefined courses
        Course c1 = new CoreCourse("C1", "Discrete Mathematics", 4, 2, "Mon-10AM");
        Course c2 = new ElectiveCourse("C2", "Artificial Intelligence & Machine learning", 3, 2, "Tue-2PM");
        Course c3 = new LabCourse("C3", "Advanced Programming (OOPS) Lab", 2, 1, "Wed-12PM", 5);

        // Add prerequisite
        c1.addPrerequisite("C0");

        // Student completed courses
        student.addCompletedCourse("C0");

        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);

        RegistrationService service = new RegistrationService();

        int choice;

        do {
            System.out.println("\n COURSE REGISTRATION MENU ");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (Course c : courseList) {
                        System.out.println(c.getCourseId() + " - " + c.getTitle() + " (" + c.getSchedule() + ")");
                    }
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    String id = sc.next();

                    Course selected = null;
                    for (Course c : courseList) {
                        if (c.getCourseId().equals(id)) {
                            selected = c;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println(" Course not found!");
                        break;
                    }

                    try {
                        service.registerCourse(student, selected);
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nRegistered Courses:");
                    for (Course c : student.getRegisteredCourses()) {
                        System.out.println("- " + c.getTitle());
                    }
                    System.out.println("Total Credits: " + student.getTotalCredits());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}