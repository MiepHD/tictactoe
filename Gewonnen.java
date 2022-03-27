import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Gewonnen.
 * 
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Gewonnen
{
    public static boolean Spiel(ArrayList<String> bigboard, ArrayList<ArrayList<Integer>> winningconditions, String symbol) {
        for (int i = 0; i <= 7; i++) {
            if (bigboard.get(winningconditions.get(i).get(0)) == symbol) {
                if (bigboard.get(winningconditions.get(i).get(1)) == symbol) {
                    if (bigboard.get(winningconditions.get(i).get(2)) == symbol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean Kleinfeld(int startfeld, ArrayList<ArrayList<Integer>> map_feldgruppen, ArrayList<ArrayList<Integer>> winningconditions, String symbol) {
        for (int i = 0; i <= 7; i++) {
            if (Spielstatus.board.board.get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(0))) == symbol) {
                if (Spielstatus.board.board.get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(1))) == symbol) {
                    if (Spielstatus.board.board.get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(2))) == symbol) {
                        System.out.println("Kleines Feld gewonnen");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
