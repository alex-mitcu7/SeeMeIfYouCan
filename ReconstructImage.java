import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;


public class ReconstructImage 
{
  public static BufferedImage reconstruct(int[] array, int h, int w) throws IOException
  {
    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    
    int iterator = 0;
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++)
      {
        image.setRGB(j, i, array[iterator]);
        iterator++;
      }

    File outputfile = new File("recontructedImage.png");
    ImageIO.write(image, "png", outputfile);   

    return image;
  }  
}