import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StringToImage {
  public static void main(String[] args) {
    String text = "This is the text that will be converted to an image.";
    
    // Set image width and height
    int width = 600;
    int height = 200;
    
    // Create a BufferedImage object
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
    // Get the graphics object for the image
    Graphics g = image.getGraphics();
    
    // Set the background color
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    
    // Set the font and color for the text
    g.setFont(new Font("Arial", Font.PLAIN, 18));
    g.setColor(Color.BLACK);
    
    // Draw the text on the image
    g.drawString(text, 10, 30);
    
    // Save the image to a file
    File file = new File("image.png");
    try {
      ImageIO.write(image, "png", file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
