
class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    public void wagTail() {
        System.out.println("Tail is wagging.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
    public void purr() {
        System.out.println("Purring softly.");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        // Polymorphic behavior: calling overridden methods
        animal1.makeSound(); // Output: Woof! Woof!
        animal2.makeSound(); // Output: Meow! Meow!

        // Uncommenting the following lines will result in a compilation error
        // animal1.wagTail(); // Error: wagTail() is not a method of Animal class
        // animal2.purr(); // Error: purr() is not a method of Animal class

        // However, you can achieve specific behaviors by casting
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;
            dog.wagTail(); // Valid
        }

        if (animal2 instanceof Cat) {
            Cat cat = (Cat) animal2;
            cat.purr(); // Valid
        }
    }
}
