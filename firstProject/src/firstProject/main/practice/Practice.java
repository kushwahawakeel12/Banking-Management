package firstProject.main.practice;
public class Practice {
    // Instance variables
//    private String name;
//    private int age;

    // Constructor
//    public Practice(String name, int age) {
//        // Using 'this' to refer to instance variables
//        this.name = name;
//        this.age = age;
//    }

    // Method to display student details
    public void display(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method to test the class
    public static void main(String[] args) {
    	Practice Practice1= new Practice();
    	Practice1.display("Alice", 20);

        
    }
}
