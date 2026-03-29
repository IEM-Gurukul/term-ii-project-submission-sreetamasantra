package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;
import courseplanner.repository.*;
import courseplanner.exception.*;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentRepository studentRepo = new StudentRepository();
        studentRepo.loadAll();

        CourseRepository repo = new CourseRepository();
        RegistrationService service = new RegistrationService();
        Admin admin = new Admin("A1", "Admin", "admin@gmail.com");

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student student = studentRepo.getStudent(id);

        if (student == null) {
            System.out.println("New student created!");
            student = new Student(id, "User", "email@gmail.com");
            studentRepo.addStudent(student);
        }

        int choice;

        do {
            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Register Course");
            System.out.println("4. Drop Course");
            System.out.println("5. View Academic Plan");
            System.out.println("6. Remove Course");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Course ID: ");
                        String cid = sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Credits: ");
                        int credits = sc.nextInt();

                        System.out.print("Enter Capacity: ");
                        int cap = sc.nextInt();
                        sc.nextLine();

                        Course newCourse = new CoreCourse(cid, title, credits, cap, "TBA");
                        admin.addCourse(repo, newCourse);

                        System.out.println("Course added successfully!");
                        break;

                    case 2:
                        System.out.println("\nAvailable Courses:");

                        if (repo.getAllCourses().isEmpty()) {
                            System.out.println("No courses available!");
                        } else {
                            for (Course course : repo.getAllCourses()) {
                                System.out.println(course.getCourseId() + " - " + course.getTitle());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Course ID: ");
                        String regId = sc.nextLine();

                        Course rc = repo.getCourse(regId);

                        if (rc == null) {
                            System.out.println("Course not found!");
                        } else {
                            service.registerCourse(student, rc);
                            System.out.println("Registered successfully!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Course ID: ");
                        String dropId = sc.nextLine();

                        Course dc = repo.getCourse(dropId);

                        if (dc == null) {
                            System.out.println("Course not found!");
                        } else {
                            service.dropCourse(student, dc);
                            System.out.println("Dropped successfully!");
                        }
                        break;

                    case 5:
                        service.viewAcademicPlan(student);
                        break;

                    case 6:
                        System.out.print("Enter Course ID: ");
                        String removeId = sc.nextLine();

                        admin.removeCourse(repo, removeId);
                        System.out.println("Course removed!");
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (DuplicateCourseException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (CreditLimitExceededException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (PrerequisiteNotMetException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (CourseCapacityFullException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (TimeTableConflictException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (CourseNotRegisteredException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }

        } while (choice != 7);

        studentRepo.saveAll();
        sc.close();
    }
}