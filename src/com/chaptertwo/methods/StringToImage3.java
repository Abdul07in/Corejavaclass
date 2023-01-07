import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StringToImage3 {
    public static void main(String[] args) {
        String filePath = "f.txt";
        File file1 = new File(filePath);
        String[] text = new String[100];
        String line;
        int count = 0;
        try {
            Scanner scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                text[count] = line;
                count++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Set image width and height
        int width = 1920;
        int height = 1080;

        // Create a BufferedImage object
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the graphics object for the image
        Graphics2D g2d = image.createGraphics();

        // Enable anti-aliasing for text
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Set the background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Set the font and color for the text
        g2d.setFont(new Font("Arial", Font.PLAIN, 18));
        g2d.setColor(Color.BLACK);

        // Draw the text on the image
        int x = 10, y = 50, n = 0;
        while (count > 0) {
            if (text[n] != null) g2d.drawString(text[n], x, y);
            y += 50;
            n++;
            count--;
        }

        // Dispose the graphics object
        g2d.dispose();

        // Save the image to a file
        File file = new File("image.png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}