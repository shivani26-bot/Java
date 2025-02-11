public class WrapperExample {
    public static void main(String[] args) {
        // int a = 10;
        // int b = 20;

        // // Integer num = new Integer(45);
        // // Integer class is declared as final in it's internal implementation
        // Integer num = 45; // creates an object, we have methods on available on nums
        // now

        // swap(a, b);// it will not swap a, b as they are passed by value to the swap
        // function
        // System.out.println(a + " " + b); // 10 20

        // Integer c = 30;
        // Integer d = 40;
        // swap2(c, d);
        // System.out.println(c + " " + d);

        // declare final variables with capital letters
        // final int bonus = 2;
        // bonus = 3; // error , we can't modify it

        // final A shivani = new A("Shivani kumari");
        // shivani.name = "Shruti kumari"; // allowed
        // // when a non primitive is final, we can't reassign it
        // // shivani = new A("new object"); // not allowed

        // A obj;
        // for (int i = 0; i < 1000000; i++) {
        // obj = new A("random name");
        // }
        // same reference variable is used to create 1000000 object, and we know that a
        // refernce variable can only point to one object
        // internally
        // obj will point to first object, then second , then third object and so
        // on...and other object previous to current object will be destroyed
        // for ex: if obj is pointing to 4th object then all the other objects 1,2,3
        // will be destroyed or freed from the memory by garbage collector

        A obj = new A("selena");
        System.out.println(obj); // prints has value A@5d22bbb7
    }

    static void swap(int a, int b) {
        // here a and b is in scope of this function only, and it gets swapped here only
        // and it's not in reference the elements passed as parameter while calling the
        // function
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b); // 20 10
    }

    static void swap2(Integer c, Integer d) {
        // here a and b is in scope of this function only, and it gets swapped here only
        // and it's not in reference the elements passed as parameter while calling the
        // function
        Integer temp = c;
        c = d;
        d = temp;
        System.out.println(c + " " + d); // 20 10
    }
}

// This is because when we pass primitive values, java only follows pass by
// value and there is no concept of pass by reference
// but when we pass objects, reference value is passed

class A {
    // final variables must be initialized while declaration
    // final int num; //error

    // final gurantees the immutability only when instance variables are primitive
    // data type
    // if instance variable is of reference type, has final modifier then value of
    // that instance variable will never change, it will always refer to same object
    // but value of object can change

    // final Student student1 = new Student();
    // student1.name="shivani"//allowed
    // student1=other_object; //not allowed

    final int num = 10;
    String name;

    // constructor
    public A(String name) {
        // System.out.println("object created");
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{name='" + name + "'}";
    }
    // we can have differenct finalize method for different classes
    // when any object of class A is destroyed or freed from memory then this
    // finalize is called

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
