package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.exception.*;

import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student("S1", "Sreetama Santra", "sreetamasantra@gmail.com");
        student.addCompletedCourse("C0");

        Course c1 = new CoreCourse("C1", "Data Structures", 4, 2, "Mon-10AM");
        Course c2 = new ElectiveCourse("C2", "AI", 3, 2, "Tue-2PM");
        Course c3 = new LabCourse("C3", "Java Lab", 2, 1, "Wed-12PM", 5);

        c1.addPrerequisite("C0");

        Map<String, Course> courseMap = new HashMap<>();
        courseMap.put("C1", c1);
        courseMap.put("C2", c2);
        courseMap.put("C3", c3);

        RegistrationService service = new RegistrationService();

        int choice;

        do {
            System.out.println("\n COURSE MENU ");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Course c : courseMap.values()) {
                        System.out.println(c.getCourseId() + " - " + c.getTitle());
                    }
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    String id = sc.next();

                    Course selected = courseMap.get(id);

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