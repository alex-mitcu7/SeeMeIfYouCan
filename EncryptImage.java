import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EncryptImage
{
  public static void fire(String[] args) throws IOException
  {
    BufferedImage image = ImageIO.read(PixelMatrixTest.class.getResource(args[0]));
    PixelMatrix matrix = new PixelMatrix(image);
    int height = matrix.getHeight();
    int width = matrix.getWidth();
    Pixel[][] originalMatrix = matrix.returnMatrix();
    String message = args[1];
    Pixel[][] encryptedMatrix = new Pixel[height][width];

    // Keep track of the original matrix
    // This will later be removed
    for(int i = 0; i < height; i++)
      for(int j = 0; j < width; j++)
        {
          encryptedMatrix[i][j] = new Pixel(originalMatrix[i][j].getAlpha(),
                                            originalMatrix[i][j].getBlue(),
                                            originalMatrix[i][j].getGreen(),
                                            originalMatrix[i][j].getRed());
        }

    // Encrypt the message into the matrix
    EncryptMessage.encryptMessage(message, encryptedMatrix, height, width);

    // Transform the matrix of pixels into array of argb
    int[] argbArray = new int[height * width];
    for (int row = 0; row < height; row++)
      for (int col = 0; col < width; col++)
      {
        argbArray[row + col] = encryptedMatrix[row][col].getArgb();
      } // for

    BufferedImage reconstructedImage = ReconstructImage.reconstruct(argbArray, height, width);
  }
}
