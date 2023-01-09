import java.io.FileInputStream;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("credentials.txt");
        try {
            int data = inputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputStream.read();
            }
        } finally {
            inputStream.close();
        }
    }
}