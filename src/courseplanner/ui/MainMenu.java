package courseplanner.ui;

import courseplanner.model.*;

public class MainMenu {
    public static void main(String[] args) {
        Student s= new Student("S1", "Sreetama Santra", "sreetama.santra@gmail.com");
        CoreCourse c = new CoreCourse("C1", "Advanced Programming", 4, 50);
        System.out.println("Student: " + s.getName());
        System.out.println("Course: " + c.getTitle());
    }
}