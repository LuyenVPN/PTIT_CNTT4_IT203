package Session6;

public class B5_s6 {
    public static class Book{
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public void displayInfo() {
            System.out.println("Title: " + title + ", Author: " + author);
        }

    }
    public static void main(String[] args) {
        Book book1 = new Book("Không làm mà đòi có ăn", "Huấn 9 ngón");
        Book book2 = new Book("Thịt Luộc Và Rau Luộc", "Luyendz");
        book1.displayInfo();
        book2.displayInfo();
    }
}
// không có this thì dữ liệu sẽ là null