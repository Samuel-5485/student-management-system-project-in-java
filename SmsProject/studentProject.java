//package Inheritance.SmsProject;

//1.Create an abstract class
abstract class Student{
   //attribute
   private String name;
   private int age;
   private String studentId;

   //Constructor
   Student(String name, int age, String studentId){
    
    setName(name);
    setAge(age);
    setStudentId(studentId);
    }
    abstract double calculateFee();
    abstract void displayType();


    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if (age >=16){
           this.age = age;
        }
             else{
                    System.out.println("you have to 16 years old or above!");
             }   
    }
    public void setStudentId(String studentId){
        if (studentId == null){
            System.out.println("Student Id cann't be empty!");
        }else{ 
        this.studentId = studentId;
        }
    }
    //getters
    public String getName(){
        return name;
    }
    public int getAge(){
       return age;
    }
    public String getStudentId(){
        return studentId;

    }

}
//2.Create an interface Reportable
interface Reportable{
    void generateReport();
}
//3.Create subclasses
//a
class UndergraduateStudent extends Student implements Reportable{
    //extra attribute
    int creditHours;
   UndergraduateStudent(String name, int age, String studentId, int creditHours){
        super(name, age, studentId);
        this.creditHours = creditHours;
        System.out.println("Name: " + name + " , " + age + " , " + studentId + " , " + creditHours);

   }

    @Override
   double calculateFee(){
        return creditHours * 450;
    }
    @Override
    void displayType(){
        System.out.println("Undergraduate Student"); 

    }
    @Override
   public void generateReport(){

    }
}
//b
class GraduateStudent extends Student implements Reportable{
    boolean isResearchStudent;

    //constructor
    public GraduateStudent(String name, int age, String studentId, boolean isResearchStudent) {
        super(name, age, studentId);
        this.isResearchStudent = isResearchStudent;
        System.out.println("Name: " + name + " , " + age + " , " + studentId + " , " + isResearchStudent);
    }
     @Override
   double calculateFee(){
        if(isResearchStudent){
            return 3000;
        }else{
            return 4500;
        }
    }
    @Override
    void displayType(){
        System.out.println("Graduate Student");
    }
    @Override
   public void generateReport(){

    }
}
//c
class OnlineStudent extends Student implements Reportable{
    double discount;

    public OnlineStudent(String name, int age, String studentId, double discount) {
        super(name, age, studentId);
        this.discount = discount;
        System.out.println("Name: " + name + " , " + age + " , " + studentId + " , " + discount);

    }

     @Override
   double calculateFee(){
      return 5000 - (5000 * discount);
    }
    @Override
    void displayType(){
        System.out.println("Online Student");
    }
    @Override
   public void generateReport(){
        System.out.println("Report is generating...");
    }
}
public class studentProject {
    public static void main(String[] args) {
        //create an array
        Student[] students = {
            new UndergraduateStudent("Samuel", 22, "UGR/77190/17", 3),
            new GraduateStudent("Lelisa", 26, "UGR/12342/14", true),
            new OnlineStudent("John", 24, "PGR/3453/17", 5436.13)
        };
        for(Student student : students){
            student.calculateFee();
            System.out.println("Fee: " + student.calculateFee());
            student.displayType();
            ((Reportable)student).generateReport(); 
            System.out.println("-------------");
        }
    }
}
