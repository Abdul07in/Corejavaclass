import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class RetrieveCredentials {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
                Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter no of Data to Recover : ");
            int i = sc.nextInt();
            while (i > 0) {
                String username = reader.readLine();
                System.out.println("Username: " + username);
                String password = reader.readLine();
                System.out.println("Password: " + password);
                i--;
            }

            // Print the retrieved username and password

        } catch (Exception e) {
            System.out.println("Error retrieving credentials: " + e.getMessage());
        }
    }
}
