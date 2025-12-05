import java.util.ArrayList;
import java.util.List;

abstract class Student{
    private String name;
    private int id;
    private String departement;

    public Student(String n, int i, String d) {
        setName(n);
        setId(i);
        setDepartement(d);

    }
    public void setName(String n){
        name = n;
    }
    public void setId(int i){
        id = i;
    }
    public void setDepartement(String d){
        departement = d;
    }
        //getter
        public String getName(){
            return name;
        }
        public int getId(){
            return id;
        }
        public String getDepartement(){
            return departement;
        }

        //Abstract method
    
    abstract double calculateFee();

    //Display Student info
    
   public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Departement: " + getDepartement());
        System.out.println("Fee: " + calculateFee());
    }
}

//2.Registration interface
interface Registration{
    void registerCourse(String course);
    void showCourses();  //to display registered courses
}
//2.Undergraduate student
class UndergraduateStudent extends Student implements Registration{
    private double creditHours;
    private List<String> courses = new ArrayList<>();

    public UndergraduateStudent(String n, int i, String d, double Chr) {
        super(n, i, d);
        creditHours = Chr;
    }

    @Override
    double calculateFee() {
        return creditHours*100; //fee per credit hour
    }
    
    public void registerCourse(String course){
        courses.add(course);
        System.out.println(course + " Registered for Undergraduate Students.");
    }

    @Override
    public void showCourses(){
        System.out.println("Undergraduate Student Courses: " + courses);
    }
}
//4.
class PostGraduateStudent extends Student implements Registration{
   private boolean researchStudent;
   private List<String> courses = new ArrayList<>();

   public PostGraduateStudent(String n, int i, String d, boolean Rst){
    super(n, i, d);
    researchStudent = Rst;
   }

    @Override
    double calculateFee(){
        if (researchStudent){
            return 3000;
        }else{
            return 3500;
        }
    }
    @Override
   public void registerCourse(String course){
        courses.add(course);
        System.out.println(course + " Registered for Postgraudate Student");

    }
    @Override
   public void showCourses(){
        System.out.println("Postgraduate Student Courses: " + courses);
    }

}

class ScholarshipStudent extends Student implements Registration{
    private double discountPercentage;
    private int creditHours;
    private List<String> courses = new ArrayList<>();
   
   ScholarshipStudent(String n, int i, String d, double dP, int Chr){
        super(n, i, d);
        discountPercentage = dP;
        creditHours = Chr;

    }
    @Override
    public double calculateFee(){
        double originalFee = creditHours * 450;
        return originalFee - (originalFee * discountPercentage / 100);
    }
    
    
   public void registerCourse(String course){
        courses.add(course);
        System.out.println(course + "Registered for Scholarship Student");
    }
    @Override
    public void showCourses(){
        System.out.println("Scholarshop Student Courses: " + courses);
    }

}
//6. main class

public class studentManagement{
    public static void main(String[] args) {
        //create student objects
        Student[] students = {
            new UndergraduateStudent("Sami", 123, "Cs", 3),
            new PostGraduateStudent("Abdi", 43, "Cottom", true),
            new ScholarshipStudent("John", 32, "IT", 3245.1, 3)
        };

          // Register som courses
          ((Registration)students[0]).registerCourse("Math");
          ((Registration)students[0]).registerCourse("Static");
          ((Registration)students[1]).registerCourse("Digital logic design");
          ((Registration)students[1]).registerCourse("Oop");
            
          //Display info and courses
        for(Student st : students){
            st.displayInfo();
            ((Registration) st).showCourses();
            System.out.println("------------------");
            //st.calculateFee();
           // st.displayInfo();
            

        }
    }
}