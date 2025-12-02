
//1.abstract class
abstract class LibraryItem{
    String title;
    String author;
    int Id;

    //Constructor
   LibraryItem(String title, String author, int Id){
        this.title = title;
        this.author = author;
        this.Id = Id;
   }
        abstract void borrowItem();  
        abstract void returnItem();
    
}
//2.Create an interface
interface Displayable{
    void displayDetails(); //method
}
//Create subclasses
//a.
class Book extends LibraryItem implements Displayable{
    //atribute
    int pages;

    Book(String title, String author, int Id, int p){
        super(title, author, Id);
        pages = p;

        System.out.println("Title: " + title + " , "  + author + " , "  + Id + " , " + pages);

    }
    @Override
    void borrowItem(){
        System.out.println("Book borrowed...");
    }
    @Override
    public void displayDetails(){
        System.out.println("Printing book details...");

        System.out.println("Title: " + title);
        System.out.println("author: " + author);
        System.out.println("Id: " + Id);
        System.out.println("Pages: " + pages);
    }
    @Override
    void returnItem(){
        System.out.println("Book returned...");
    }
    
}
//b
class Magazine extends LibraryItem implements Displayable{
    int issueNumber;

    //constructor
   public Magazine(String title, String author, int Id, int iN){
        super(title, author, Id);
        issueNumber = iN;
        System.out.println("Title:" + title + " , " + author + " , " + Id + " , " + issueNumber);

    }
    @Override
    void borrowItem(){
        System.out.println("Magazine borrowed...");

    }
    @Override
   public void displayDetails(){
        System.out.println("Printing magazine details...");
        System.out.println("Title: " + title);
        System.out.println("author: " + author);
        System.out.println("Id: " + Id);
        System.out.println("Issue Number: " + issueNumber);

    }
    @Override
    void returnItem(){
        System.out.println("Magazine returned...");
    }
}
//c
class DVD extends LibraryItem implements Displayable{
    double duration;

    public DVD(String title, String author, int Id, double d) {
        super(title, author, Id);
        duration = d;
         System.out.println("Title: " + title + " , " + author + " , " + Id + " , " + duration);
    }
    @Override
    void borrowItem(){
        System.out.println("DVD borrowed...");
    }
    @Override
   public void displayDetails(){
        System.out.println("Printing DVD details...");
     
        System.out.println("Title: " + title);
        System.out.println("author: " + author);
        System.out.println("Id: " + Id);
        System.out.println("Duration: " + duration);
    }
    @Override
    void returnItem(){
        System.out.println("DVD returned...");
    }

}
public class libraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] libraryies = {
            new Book("Mechanics", "Mechanicia", 12, 345),
            new Magazine("Java", "James", 23, 242),
            new DVD("Serway", "Chadwick", 12, 43.12)
        };
        for(LibraryItem item : libraryies){
            item.borrowItem();
            ((Displayable)item).displayDetails(); //cast to displayable - call displayDetails
            item.returnItem();
            System.out.println("-----------------");
        }
    }
}
