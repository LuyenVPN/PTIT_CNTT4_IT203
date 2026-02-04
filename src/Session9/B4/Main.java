package Session9.B4;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        // animal.bark();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        }
    }
}
