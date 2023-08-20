import com.workintech.library.model.LibrarySystem;
import com.workintech.library.model.Reader;
import java.util.Scanner;

public class Entry{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();
        Reader reader = null; // Kullanıcının login işlemi sonucu atanacak

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Register
                System.out.println("Enter your name:");
                String name = scanner.nextLine();

                System.out.println("Enter your id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                reader = new Reader(id, name, 3); // Reader sınıfının doğru constructor'ını kullanmalısınız
                System.out.println("Registration successful!");
            } else if (choice == 2) {
                // Login
                if (reader != null) {
                    System.out.println("Enter your name:");
                    String enteredName = scanner.nextLine();

                    System.out.println("Enter your id:");
                    int enteredId = scanner.nextInt();
                    scanner.nextLine();

                    if (reader.authenticate(enteredName, enteredId)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed! Incorrect username or ID.");
                    }
                } else {
                    System.out.println("Please register first.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }
}
