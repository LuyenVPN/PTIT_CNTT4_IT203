package Session7;
import java.util.ArrayList;

public class B6_s7 {
    public static class User {
        public final int id;
        public String username;
        public String password;

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }

        public String toString() {
            return "User[id=" + id + ", name=" + username + "]";
        }
    }
    public static class UserManager {
        public static ArrayList<User> users = new ArrayList<>();

        public static void addUser(User u) {
            users.add(u);
        }

        public static boolean checkLogin(String username, String password) {
            for (User u : users) {
                if (u.username.equals(username) && u.password.equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        User u1 = new User(1, "dev_a", "123456");
        User u2 = new User(2, "dev_b", "abcdef");
        User u3 = new User(3, "dev_c", "999999");

        UserManager.addUser(u1);
        UserManager.addUser(u2);
        UserManager.addUser(u3);

        System.out.println(UserManager.checkLogin("dev_a", "123456")); // true
        System.out.println(UserManager.checkLogin("dev_b", "sai"));    // false

        // u1.id = 999; // ❌ lỗi vì id là final
    }
}
