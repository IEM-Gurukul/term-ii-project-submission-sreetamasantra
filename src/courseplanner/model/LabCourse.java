package courseplanner.model;

public class LabCourse extends Course {

    private int labSlots;

    public LabCourse (String courseId, String title, int credits, int capacity, int labSlots) {
        super (courseId, title, credits, capacity);
        this.labSlots=labSlots;
   }

   @Override
   public boolean validateRegistration(Student student) {
    return labSlots > 0;
   }
    
}
