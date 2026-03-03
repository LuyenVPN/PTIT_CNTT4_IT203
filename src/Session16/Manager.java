package Session16;
import Session16.Model.*;
import  java.util.*;
public class Manager {
    public static class ListManager<T> {
        protected List<T> items = new ArrayList<>();

        public void add(T item) {
            items.add(item);
        }

        public List<T> getAll() {
            return items;
        }
    }
    public static class PetManager extends ListManager<Pet> {

        public Pet findById(String id) {
            for (Pet pet : items) {
                if (pet.getId().equals(id)) {
                    return pet;
                }
            }
            return null;
        }

        public boolean deleteById(String id) {
            Pet pet = findById(id);
            if (pet != null) {
                items.remove(pet);
                return true;
            }
            return false;
        }
    }
    public static class CustomerManager {

        private Map<String, Customer> customerMap = new HashMap<>();

        public boolean add(Customer c) {
            if (customerMap.containsKey(c.getId())) return false;
            customerMap.put(c.getId(), c);
            return true;
        }

        public Customer findById(String id) {
            return customerMap.get(id);
        }

        public boolean findByPhone(String phone) {
            for (Customer c : customerMap.values()) {
                if (c.getPhone().equals(phone)) {
                    return true;
                }
            }
            return false;
        }

        public void displayAll() {
            customerMap.values().forEach(System.out::println);
        }
    }
    public static class SpaManager {

        private Queue<ServiceRecord> queue = new LinkedList<>();

        public void addToQueue(ServiceRecord record) {
            queue.offer(record);
        }

        public ServiceRecord serveNext() {
            return queue.poll();
        }
    }
    public static class LogManager {

        private Stack<ActionLog> stack = new Stack<>();

        public void log(String desc) {
            stack.push(new ActionLog(desc));
        }

        public void undo() {
            if (!stack.isEmpty()) {
                System.out.println("Undo: " + stack.pop());
            } else {
                System.out.println("Không có lịch sử");
            }
        }
    }

}
