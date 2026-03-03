package Session16;
import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Model {
    public static class Pet {
        private String id;
        private String name;
        private String species;
        private int age;
        private double price;
        private String ownerId;

        public Pet(String id, String name, String species, int age, double price) {
            this.id = id;
            this.name = name;
            this.species = species;
            this.age = age;
            this.price = price;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public String getSpecies() { return species; }
        public int getAge() { return age; }
        public double getPrice() { return price; }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    ", age=" + age +
                    ", price=" + price +
                    '}';
        }
    }

    public static class Customer {
        private String id;
        private String name;
        private String phone;

        public Customer(String id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "ID: " + id +
                    " | Tên: " + name +
                    " | SĐT: " + phone;
        }
    }

    public static class ServiceRecord {
        private Pet pet;
        private String serviceType;

        public ServiceRecord(Pet pet, String serviceType) {
            this.pet = pet;
            this.serviceType = serviceType;
        }

        @Override
        public String toString() {
            return   pet.getName() + " - " + serviceType;
        }
    }

    public static class ActionLog {
        private String description;
        private LocalDateTime time;

        public ActionLog(String description) {
            this.description = description;
            this.time = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return "[" + time + "] " + description;
        }
    }
}
