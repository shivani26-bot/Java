import java.util.Arrays;

public class Oops {
    public static void main(String[] args) {

        Student student1;
        student1 = new Student();
        student1.changeName("John");
        student1.greeting();
        System.out.println(student1.rollno);
        System.out.println(student1.name);
        System.out.println(student1.marks);

        Student student2 = new Student(15, "shivani", 86.5f);
        System.out.println(student2.rollno);
        System.out.println(student2.name);
        System.out.println(student2.marks);

        Student random = new Student(student2);
        System.out.println(random.rollno);
        System.out.println(random.name);
        System.out.println(random.marks);

        Student random2 = new Student();
        System.out.println(random2.rollno);
        System.out.println(random2.name);
        System.out.println(random2.marks);

        Student one = new Student();
        Student two = one;
        one.name = "something";
        System.out.println(two.name);// something
    }
}

class Student {
    int rollno; // bydefault value will be 0
    String name; // for class String bydefault value will be null
    float marks = 100; // bydefault value will be 0.0

    // we need a way to add the values of the above properties object by object
    // we need one word to access every object

    void greeting() {
        // System.out.println("Hello! My name is " + name); //this is also correct
        System.out.println("Hello! My name is " + this.name); // but this is preferred method
    }

    void changeName(String newName) {
        // name = newName; // this is also correct
        this.name = newName;
    }

    // constructor that takes values from another object
    Student(Student other) {
        this.name = other.name; // random.name= student2.name
        this.rollno = other.rollno;
        this.marks = other.marks;
    }

    // constructor
    // no return type, similar to the class name
    // Student() {
    // this.rollno = 13;
    // this.name = "shivani";
    // this.marks = 88.5f;
    // }

    Student() {
        // this variable can also helps in calling a constructor from another
        // constructor
        // internally: new Student(13, "default person", 100.0f)
        this(13, "default person", 100.0f);
    }

    // Student arpit= new Student(17,"arpit",89.7f);
    // here this will be replaced with arpit
    Student(int rollno, String name, float marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
}
