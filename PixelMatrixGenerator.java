import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PixelMatrixGenerator 
{
  public static void main(String[] args) throws IOException 
  {
    // Initialise variable to hold the image.
    BufferedImage image = ImageIO.read(PixelMatrixGenerator.class.getResource(args[0]));
    
    // Array to hold the image pixels.
    final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    // Initialise the width and height of the image.
    final int width = image.getWidth();
    final int height = image.getHeight();
    // Initialise boolean variable to hold wether or not the image has alpha parameter.
    final boolean hasAlphaChannel = image.getAlphaRaster() != null;

    // Initialize the matrix.
    Pixel[][] pixelMatrix = new Pixel[height][width];
    
    // Check for alpha parameter.
    if (hasAlphaChannel) 
    {
      // If the alpha exist, initialize length with 4 (alpha, blue, green, red).
      final int pixelLength = 4;
      for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) 
      {
        // Initialize colors.
        int alpha = ((int) pixels[pixel] & 0xff); // alpha
        int blue = ((int) pixels[pixel + 1] & 0xff); // blue
        int green = ((int) pixels[pixel + 2] & 0xff); // green
        int red = ((int) pixels[pixel + 3] & 0xff); // red
        
        // Create new Pixel object.
        pixelMatrix[row][col] = new Pixel(alpha, blue, green, red);
        System.out.println(pixelMatrix[row][col].getBlue());
        // Increment col and row.
        col++;
        if (col == width) 
        {
          col = 0;
          row++;
        }
      }
    } 
    else 
    {
      // If the alpha doesn't exist, initialize length with 3 (blue, green, red).
      final int pixelLength = 3;
      for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) 
      {
        // Initialize colors.
        int alpha = 255; // alpha
        int blue = ((int) pixels[pixel] & 0xff); // blue
        int green = ((int) pixels[pixel + 1] & 0xff); // green
        int red = ((int) pixels[pixel + 2] & 0xff); // red
        
        // Create new Pixel object.
        pixelMatrix[row][col] = new Pixel(alpha, blue, green, red);
        // Increment col and row.
        col++;
        if (col == width) 
        {
          col = 0;
          row++;
        }
      }
    }
    System.out.println(pixelMatrix[10][15].getBlue());
    
  }
}