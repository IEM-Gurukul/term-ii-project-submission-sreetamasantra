package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.repository.*;
import courseplanner.exception.*;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student("S1", "Sreetama Santra", "sreetama@gmail.com");
        Admin admin = new Admin("A1", "Admin", "admin@gmail.com");

        CourseRepository repo = new CourseRepository();
        RegistrationService service = new RegistrationService();

        int choice;

        do {
            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Course (Admin)");
            System.out.println("2. View Courses");
            System.out.println("3. Register Course (Student)");
            System.out.println("4. Remove Course (Admin)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Course ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    sc.nextLine();

                    Course course = new CoreCourse(id, title, credits, capacity, "TBA");
                    admin.addCourse(repo, course);

                    break;

                case 2:
                    System.out.println("\nAvailable Courses:");
                    admin.viewCourses(repo);
                    break;

                case 3:
                    System.out.print("Enter Course ID to register: ");
                    String courseId = sc.nextLine();

                    try {
                        Course c = repo.getCourse(courseId);

                        if (c == null) {
                            System.out.println("Course not found!");
                        } else {
                            service.registerCourse(student, c);
                            System.out.println("Registered successfully!");
                        }

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4:
                    System.out.print("Enter Course ID to remove: ");
                    String removeId = sc.nextLine();

                    admin.removeCourse(repo, removeId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}