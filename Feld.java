import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Feld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
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
