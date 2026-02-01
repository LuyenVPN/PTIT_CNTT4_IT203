package Session6;

public class B2_s6 {
    public static void main(String[] args) {
        Account tk1= new Account("luyendz","123456","luyendz@gmail.com");
        tk1.displayInfo();
        tk1.changePassword("654321");
        tk1.displayInfo();
    }

    public static class Account {
        private String username;
        private String password;
        private String email;

        public Account(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }
        public void changePassword(String newPassword){
            this.password = newPassword;
            System.out.println("Mật khẩu đã được thay đổi thành công.");
        }

        public void displayInfo(){
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: " + "********");
        }
    }
}
