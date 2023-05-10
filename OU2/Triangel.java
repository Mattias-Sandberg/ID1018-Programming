import java.util.*;     // Scanner, Locale

public class Triangel //klassens namn
{
  //räkna omkrets med sidorna
  public static double omkrets (double sida1, double sida2, double sida3)
  {
    return sida1 + sida2 + sida3;
  }
  //räkna area med bas och höjd
  public static double area (double bas, double höjd)
  {
    return ((bas * höjd)/2);
  }
  //räkna area med sidor
  public static double areasidor (double sida1, double sida2, double sida3)
  {
    double p = ((sida1 + sida2 + sida3)/2);
    return Math.sqrt(p*(p-sida1)*(p-sida2)*(p-sida3));
  }
  //räkna bisektris
  public static double bisektris (double b, double c, double alfa)
  {
    double p = 2 * b * c * Math.cos (alfa / 2);
    double bis = p / (b + c);

    return bis;
  }
  //räkna radie av cirkeln i triangel
  public static double radieC (double sida1, double sida2, double sida3)
  {
    double area1 = areasidor(sida1, sida2, sida3);
    double omkrets1 = omkrets(sida1, sida2, sida3);

    return (2 * area1) / (omkrets1);
  }
  //räkna radien på cirkeln runt triangeln
  public static double radieCC (double sida1, double sida2, double sida3)
  {
    double area1 = areasidor(sida1, sida2, sida3);

    return (sida1 * sida2 * sida3) / (4 * area1);
  }
}
