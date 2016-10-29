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
    int pixelLength = 4;
    int alpha = 0;

    // Initialize the matrix.
    Pixel[][] pixelMatrix = new Pixel[height][width];

    // Check for alpha parameter.
    if (!hasAlphaChannel)
    {
      pixelLength = 3;
      alpha = 255;
    } // if

    int row = 0, col = 0;
    for (int pixel = 0; pixel < pixels.length; pixel += pixelLength)
    {
      // Initialize colors.
      if(pixelLength == 4)
        alpha = ((int) pixels[pixel] & 0xff); // alpha

      int blue = ((int) pixels[pixel + 1] & 0xff); // blue
      int green = ((int) pixels[pixel + 2] & 0xff); // green
      int red = ((int) pixels[pixel + 3] & 0xff); // red

      // Create new Pixel object.
      pixelMatrix[row][col] = new Pixel(alpha, blue, green, red);

      // Increment col and row.
      col++;
      if (col == width)
      {
        col = 0;
        row++;
      } // if
    } // for

    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        System.out.println(pixelMatrix[i][j]);
  } // main
} // class PixelMatrixGenerator
