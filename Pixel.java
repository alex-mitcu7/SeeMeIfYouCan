public class Pixel
{
  private static int alpha;
  private static int blue;
  private static int green;
  private static int red;

  public Pixel (int alphaGiven, int blueGiven, int greenGiven, int redGiven)
  {
    alpha = alphaGiven;
    blue = blueGiven;
    green = greenGiven;
    red = redGiven;
  }

  public int getAlpha ()
  {
    return alpha;
  }

    public int getBlue ()
  {
    return blue;
  }

  public int getGreen ()
  {
    return green;
  }

  public int getRed ()
  {
    return red;
  }

  public void setAlpha (int newAlpha)
  {
    alpha = newAlpha;
  }

  public void setBlue (int newBlue)
  {
    blue = newBlue;
  }

  public void setGreen (int newGreen)
  {
    green = newGreen;
  }

  public void setRed (int newRed)
  {
    red = newRed;
  }

  public String toString()
  {
    return "Pixel with properties R " + red + " G " + green + " B " + blue;
  }
}
