package Session9.B1;

public class Person {
    protected String fullname;
    protected int age;

    public Person() {
    }

    public Person(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Họ tên: " + fullname);
        System.out.println("Tuổi: " + age);
    }
}
