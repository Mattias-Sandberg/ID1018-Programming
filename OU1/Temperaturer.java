import java.util.*;     // Scanner, Locale

class Temperaturer
{
    public static void main (String[] args)
    {
    System.out.println ("TEMPERATURER\n");
    // inmatningsverktyg
    Scanner in = new Scanner (System.in);
    in.useLocale (Locale.US);

    // mata in uppgifter om antalet veckor och antaletmätningar
    System.out.print ("antalet veckor: ");
    int    antalVeckor = in.nextInt ();
    System.out.print ("antalet mätningar per vecka: ");
    int    antalMatningarPerVecka = in.nextInt();

    // plats att lagra temperaturer
    double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
    // mata in temperaturerna
    for (int vecka = 1; vecka <= antalVeckor; vecka++){
            System.out.println ("temperaturer -vecka " + vecka+ ":");
            for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
            t[vecka][matning] = in.nextDouble ();
    }
        System.out.println ();

        // visa temperaturerna
        System.out.println ("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++){
            for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
            System.out.print (t[vecka][matning] + " ");
            System.out.println ();
        }

            System.out.println ();

            // den minsta,den största och medeltemperaturen–veckovis
            double[]    minT = new double[antalVeckor + 1];
            double[]    maxT = new double[antalVeckor + 1];
            double[]    sumT = new double[antalVeckor + 1];
            double[]    medelT = new double[antalVeckor + 1];

            int matning;
        //den minsta temperaturen per vecka
           for (int vecka = 1; vecka <= antalVeckor; vecka++){
             minT[vecka] = t[vecka][1];
             for (int mata = 2; mata <= antalMatningarPerVecka; mata++){
                if (t[vecka][mata] < minT[vecka]){
                   minT[vecka] = t[vecka][mata];
               }
           }
        }
            //den största temperaturen per vecka
            for (int vecka = 1; vecka <= antalVeckor; vecka++){
                maxT[vecka] = t[vecka][1];
                for (int mata = 2; mata <= antalMatningarPerVecka; mata++){
                    if (t[vecka][mata] > maxT[vecka]){
                        maxT[vecka] = t[vecka][mata];
                    }
                }
            }

            //räkna summan för temperaturerna per vecka
            for (int vecka = 1; vecka <= antalVeckor; vecka++){
                sumT[vecka] = t[vecka][1];
                for (int mata = 2; mata <= antalMatningarPerVecka; mata++)
                {
                    sumT[vecka] += t[vecka][mata];
                }
            }

            //räkna medeltemperaturen per vecka
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
            }

            //skriv ut minsta temperatur per vecka
            System.out.println("De lägsta temperaturerna");
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                System.out.print(minT[vecka] + " ");
                System.out.println(" ");
            }

            //skriv ut största temperaturen per vecka
            System.out.println("De största temperaturerna");
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                System.out.print(maxT[vecka] + " ");
                System.out.println(" ");
            }

            //Skriv ut summan av temperaturerna per vecka
            System.out.println("Summan av temperaturerna");
            for(int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                System.out.print(sumT[vecka] + " ");
                System.out.println(" ");
            }

            //skriv ut medelvärdet per vecka
            System.out.println("Medelvärdet av temperaturerna");
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                System.out.print(medelT[vecka] + " ");
                System.out.println(" ");
            }

            // den minsta, den största och medeltemperaturen hela mätperioden
            double    minTemp = minT[1];
            double    maxTemp = maxT[1];
            double    sumTemp = sumT[1];
            double    medelTemp = 0;

            //minsta temperaturen hela mätperioden
            for (int vecka = 2; vecka <= antalVeckor; vecka ++)
            {
                if(minT[vecka] < minTemp)
                {
                    minTemp = minT[vecka];
                }
            }
            //största temperaturen hela mätperioden
            for (int vecka = 2; vecka <= antalVeckor; vecka++)
            {
                if (maxT[vecka] > maxTemp)
                {
                    maxTemp = maxT[vecka];
                }
            }
            //summa hela mätperioden
            for (int vecka = 2; vecka <= antalVeckor; vecka++)
            {
              sumTemp += sumT[vecka];
            }
            //medelvärde för hela mätperioden
             medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);
            //vissa den minsta, den störtsa och medeltemperaturen i hela mätperioden

            //visa minsta temperaturen för hela mätperioden
            System.out.println("Den lägsta temperaturen för hela mätperioden " + minTemp);
            //visa högsta temperaturen för hela mätperioden
            System.out.println("Den högsta temperaturen för hela mätperioden " + maxTemp);
            //visa medeltemperaturen för hela mätperioden
            System.out.println("Medeltemperaturen för hela mätperioden " + medelTemp);
            //Summan för hela mätperioden
            System.out.println("Summan för hela mätperioden " + sumTemp);

            in.close();
    }
}
