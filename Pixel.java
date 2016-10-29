public class Pixel
{
  private int alpha;
  private int blue;
  private int green;
  private int red;
  private int argb;

  public Pixel (int alphaGiven, int blueGiven, int greenGiven, int redGiven)
  {
    alpha = alphaGiven;
    blue = blueGiven;
    green = greenGiven;
    red = redGiven;
  } // Pixel

  public int getAlpha ()
  {
    return alpha;
  } // getAlpha

    public int getBlue ()
  {
    return blue;
  } // getBlue

  public int getGreen ()
  {
    return green;
  } // getGreen

  public int getRed ()
  {
    return red;
  } // getRed

  public int getArgb()
  {
    argb = 0;
    argb += (alpha << 24);
    argb += blue;
    argb += (green << 8);
    argb += (red << 16); 
    return argb;
  } // getArgb
  
  public void setAlpha (int newAlpha)
  {
    alpha = newAlpha;
  } // setAlpha

  public void setBlue (int newBlue)
  {
    blue = newBlue;
  } // setBlue

  public void setGreen (int newGreen)
  {
    green = newGreen;
  } // setGreen

  public void setRed (int newRed)
  {
    red = newRed;
  } // setRed

  public String toString()
  {
    return "Pixel with properties R " + red + " G " + green + " B " + blue;
  } // toString
} // class Pixel