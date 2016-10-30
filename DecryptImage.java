import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;


// Decrypt the message from an image
public class DecryptImage
{
  public static String fire(String pathToImage) throws IOException
  {
    BufferedImage image = ImageIO.read(PixelMatrixTest.class.getResource(pathToImage));
    PixelMatrix matrix = new PixelMatrix(image);
    int height = matrix.getHeight();
    int width = matrix.getWidth();
    Pixel[][] originalMatrix = matrix.returnMatrix();
    String message = EncryptMessage.decryptMessage(originalMatrix, height, width);
    return message;
  } // fire
}
