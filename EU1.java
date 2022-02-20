// min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
import java.util.*;

// Lagt till Class och main.

public class EU1
{
	public static void main(String[] args) {


		        int[] sekvens = {5,4,6,8,5,4,3,8,9,10,17,43,22,67,34,23,2,4,67};
		        System.out.println (Arrays.toString (sekvens));
		        System.out.println();

		        int m = min(sekvens);
		        System.out.println("Det minsta elementet är " + m);
		        System.out.println();
    }
	public static int min (int[] element) throws IllegalArgumentException
	{
    if (element.length == 0)
        throw new IllegalArgumentException ("tom samling");

    // hör ihop med spårutskriften 2:
    // int    antalVarv = 1;

    int[]    sekvens = element;
    int      antaletPar = sekvens.length / 2;
    int      antaletOparadeElement = sekvens.length % 2;
    int      antaletTankbaraElement = antaletPar + antaletOparadeElement;
    int[]    delsekvens = new int[antaletTankbaraElement];
    int      i = 0;
    int      j = 0;
    // ändrade yttre while loop till antalerPar istället för sekvens.length för att inte loopa i oändlighet.
    while (antaletPar > 0)
    {
        // skilj ur en delsekvens med de tänkbara elementen
        i = 0;
        j = 0;
				//i denna while loop skapas paren och tar det minsta värderna
        while (j < antaletPar)
        {
            delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
            i += 2;
        }
        // ändrade IF satsen (ändrade till sekvens[antaletPar*2).
				// Om det finns ett oparat element tilldelas plats j värdet på antaletpar * 2.
        if (antaletOparadeElement == 1)
            delsekvens[j] = sekvens[antaletPar * 2];

        // utgå nu ifrån delsekvensen
        sekvens = delsekvens;
        antaletPar = antaletTankbaraElement / 2;
        antaletOparadeElement = antaletTankbaraElement % 2;
        antaletTankbaraElement = antaletPar + antaletOparadeElement;

        // spårutskrift 1 - för att följa sekvensen
        System.out.println (java.util.Arrays.toString (sekvens));
    }

    // sekvens[0] är det enda återstående tänkbara elementet
    // - det är det minsta elementet
    return sekvens[0];
	}
}
