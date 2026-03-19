package courseplanner.ui;

import courseplanner.model.*;

public class MainMenu {
    public static void main(String[] args) {
        Student s = new Student("S1", "Sreetama Santra", "sreetama.santra@gmail.com");
        Course c1= new CoreCourse("C1", "Data Structures", 4, 50);
        Course c2= new ElectiveCourse("C2", "Artificial Intelligence", 3, 40);
        Course c3= new LabCourse("C3", "Advanced Programming Lab", 2, 30, 10);

        System.out.println(c1.getTitle());
        System.out.println(c2.getTitle());
        System.out.println(c3.getTitle());
    }
}
