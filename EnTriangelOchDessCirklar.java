import java.util.*;     // Scanner, Locale

public class EnTriangelOchDessCirklar //klassens namn
{
  public static void main(String[] args)
  {
    // inmatning
    Scanner in = new Scanner(System.in);
    System.out.println("skriv in dina sidor");

    double sida1 = in.nextDouble();
    double sida2 = in.nextDouble();
    double sida3 = in.nextDouble();

    //visa radien för innre cirkeln
    double radieInC = Triangel.radieC(sida1, sida2, sida3);
    System.out.printf("cirkelns radie är inne är: " + radieInC);
    System.out.println("");

    //visa radien för yttre cirkeln
    double radieUtC = Triangel.radieCC(sida1, sida2, sida3);
    System.out.printf("cirkelns radie utanför är: " + radieUtC);
  }
}
