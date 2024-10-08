// Abstract class
abstract class Animal {
    // Abstract method (no body)
    public abstract void sound();

    // Concrete method
    public void sleep() {
        System.out.println("The animal is sleeping");
    }
}

// Child class (concrete subclass)
class Dog extends Animal {
    // Implementing the abstract method
    @Override
    public void sound() {
        System.out.println("Woof");
    }

    // Adding a new method specific to Dog class
    public void fetch() {
        System.out.println("The dog fetches a ball");
    }
}

public class test {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound(); // Output: Woof
        myDog.sleep(); // Output: The animal is sleeping
        //myDog.fetch(); // Output: The dog fetches a ball
    }
}
