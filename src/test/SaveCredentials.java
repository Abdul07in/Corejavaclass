import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SaveCredentials {
    public static void main(String[] args) {
        // Get the username and password from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Hash the password using a secure hash function
        String hashedPassword = hashPassword(password);

        // Save the username and hashed password to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt", true))) {
            writer.write("\n");
            writer.write(username);
            writer.newLine();
            writer.write(hashedPassword);
            System.out.println("Credentials saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving credentials: " + e.getMessage());
        }
    }

    // Hashes the given password using the SHA-256 algorithm
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
