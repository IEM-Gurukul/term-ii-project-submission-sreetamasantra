package courseplanner.ui;

import courseplanner.model.*;
import courseplanner.service.*;

public class MainMenu {

    public static void main(String[] args) {

        Student s = new Student("S1", "Sreetama Santra", "sreetamasantra30@gmail.com");

        Course c1 = new CoreCourse("C1", "Data Structures", 4, 50);
        Course c2 = new ElectiveCourse("C2", "Advanced Programming", 3, 40);

        RegistrationService service = new RegistrationService();

        service.registerCourse(s, c1);
        service.registerCourse(s, c2);
    }
}