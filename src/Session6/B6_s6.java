package Session6;

public class B6_s6 {
    public static class Users{
        private int id;
        private String username;
        private String password;
        private String email;

        public Users(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPass(password);
            setEmail(email);
        }
        public void setPass(String password) {
            if (password.length() >= 0 && password != null&& !password.trim().isEmpty()) {
                this.password = password;
            } else {
                System.out.println("Mật khẩu không được để trống.");
            }
        }
        public void setEmail(String email){
            if (email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")&& !email.trim().isEmpty()) {
                this.email = email;
            } else {
                System.out.println("Email không hợp lệ.");
            }
        }
        public void hienThiThongTin() {
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
            System.out.println("---------------------------");
        }
    }
    public static void main(String[] args) {
        Users u1 = new Users(1, "luyen", "123456", "luyen@gmail.com");
        u1.hienThiThongTin();

        u1.setEmail("luyen123gmail.com");
        u1.setPass("");
        u1.setEmail("luyen123@gmail.com");
        u1.hienThiThongTin();
    }
}
