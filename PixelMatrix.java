import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PixelMatrix
{
  private Pixel[][] matrix;
  private BufferedImage image;
  final int width;
  final int height;

  public PixelMatrix(BufferedImage imageGiven)
  {
    image = imageGiven;
    width = image.getWidth();
    height = image.getHeight();
    constructMatrix(imageGiven);
  } // PixelMatrix;

  // Return the matrix of pixels
  public Pixel[][] returnMatrix()
  {
    return matrix;
  } // returnMatrix

  // Construct the matrix of type Pixel from the image
  private void constructMatrix(BufferedImage image)
  {

    matrix = new Pixel[height][width];

    // Array to hold the image pixels.
    final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

    // Initialise boolean variable to hold wether or not the image has alpha parameter.
    final boolean hasAlphaChannel = image.getAlphaRaster() != null;
    int pixelLength = 4;
    int alpha = 0;
    int increment = 1;

    // Check for alpha parameter.
    if (!hasAlphaChannel)
    {
      pixelLength = 3;
      alpha = 255;
      increment = 0;
    } // if

    int row = 0, col = 0;
    for (int pixel = 0; pixel < pixels.length; pixel += pixelLength)
    {
      // Initialize colors.
      if(pixelLength == 4)
        alpha = ((int) pixels[pixel] & 0xff); // alpha

      int blue = ((int) pixels[pixel + increment] & 0xff); // blue
      int green = ((int) pixels[pixel + increment + 1] & 0xff); // green
      int red = ((int) pixels[pixel + increment + 2] & 0xff); // red

      // Create new Pixel object.
      matrix[row][col] = new Pixel(alpha, blue, green, red);

      // Increment col and row.
      col++;
      if (col == width)
      {
        col = 0;
        row++;
      } // if
    } // for

  } // constructMatrix

  public int getWidth()
  {
    return width;
  } // getWidth

  public int getHeight()
  {
    return height;
  } // getHeight

} // class PixelMatrix
