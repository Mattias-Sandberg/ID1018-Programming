import java.util.*;     // Scanner, Locale

public class BestamDenKortasteVagen //klassens namn
{


  public static void main(String[] args)
  {
    // Tar in uppgifter
   java.util.Scanner    in = new java.util.Scanner (System.in);

   double[] distance1 = new double[3];
   double[][] distance2 = new double[3][4];
   double[] distance3 = new double[4];


    // mata in längder mellan x och u
   for (int i=0; i<distance1.length; i++)
   {
     System.out.println("Ange distans mellan Zon1 och u" + (i + 1));
     distance1[i] = in.nextDouble();
   }

   for (int i=0; i<distance1.length; i++)
   {
     for (int j=0; j<distance3.length; j++)
     {
       // mata in längder mellan u och station v
       System.out.println("Ange distans mellan station u" + (i + 1) + " och station v" + (j+1));
       distance2[i][j] = in.nextDouble();
     }
   }

   for (int i=0; i<distance3.length; i++)
   {
     // mata in längder mellan v och station y
     System.out.println("Ange distans mellan v" + (i + 1) + " och Zon 4");
     distance3[i] = in.nextDouble();
   }
   // printar ut kombinationen av det kortaste stationerna
   int[] stations = DenKortasteVagen.mellanstationer(distance1,distance2,distance3);
   System.out.println("Första stationen är U: " + (stations[0] + 1) + " Och andra stationen är V: " + (stations[1] + 1));

   // printar ut den kortaste vägen mellan stationerna.
   double shortestDistance = DenKortasteVagen.langd(distance1,distance2,distance3);
   System.out.println("Kortaste distansen är " + shortestDistance);
  }
}
