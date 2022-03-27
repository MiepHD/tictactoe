import java.util.ArrayList;

/**
 * berechneStart
 * target = 0..8
 * startfeld = 0..80
 * spalte = 0..2
 * zeile = 0..2
 * Berechnet den absoluten Wert(startfeld) des Feldes, das links oben in dem größeren Feld(target) ist.
 * 
 * finde
 * Findet heraus in welchem Feld die eingegebene Nummer liegt.
 * Wird genutzt zur Berechnung des Startfeldes aus der absoluten Zahl (bei Input: gruppe = feldgruppen)
 * Auch genutzt,um festzustellen in welchem Feld sich die Zahl befindet (bei Input gruppen = map_feldgruppen)
 * 
 * @author Miep_HD
 * @version 27.03.2022
 */
public class Feld
{
    public static int finde(int number, ArrayList<ArrayList<Integer>> gruppe) {
        System.out.println ("Möglichkeiten: " + gruppe);
        for (int i = 0; i <= 8; i++) {
            if (gruppe.get(i).contains(number)) {
                return i;
            }
        }
        System.out.println("Keine Übereinstimmung gefunden");
        return -1;
    }
    public static int berechneStart(int target) {
        int spalte;
        int zeile;
        int startfeld;
        spalte = target % 3;
        System.out.println(target + " ist in Spalte " + spalte);
        zeile = (target - spalte) / 3;
        System.out.println(target + " ist in Zeile " + zeile);
        startfeld = zeile * 27 + spalte * 3;
        System.out.println("Das Startfeld ist: " + startfeld);
        return startfeld;
    }
}
