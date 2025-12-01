//package Inheritance.Project;
//superclass
class People{
    String name;
    int age;
    
    //Constructor
    People(String name, int age){
        this.name = name;
        this.age = age;

    }
    //superclass method
    void info(){
    //    System.out.println("Name: " + name);
      //  System.out.println("Age: " + age);
    }

}
//2nd class
class Student extends People{
    char grade;

    //constructor
    Student(String name, int age, char grade){
        super(name, age);
        this.grade = grade;
    }
    @Override
    void info(){
        
        System.out.println("Person: " + name +"," + " Age: " + age + "," + " Grade: " + grade);
    }
}
//3rd class
class Teacher extends People{
    String subject;
    //constructor
    Teacher(String name, int age, String subject){
        super(name, age);
        this.subject = subject;

    }
    @Override
    void info(){
        
        System.out.println("Person: " + name + "," + " Age: " + age + "," + " Subject: " + subject);
    }
}
//4th class
class Admin extends People{
    String role;
    //constructor
    Admin(String name, int age, String role){
        super(name, age);
        this.role = role;

    }
    @Override
    void info(){
       
        System.out.println("Person: " + name + "," + " Age: " + age + "," + " Role: " + role);
    }
}
public class Management{
    public static void main(String[] args) {
        //create an array of person:
      People[] person = {
        new Student("Sami", 22, 'A'),
        new Teacher("Wakjira", 35, "Oop"),
        new Admin("Kena", 34, "Data Base Adminstrator")
      };
      
for(People p : person){
        p.info();
      }
         
    }
    
}
