import java.util.ArrayList;

/**
 * Spiel
 * Diese Methode prüft, ob der Player mit dem übergebenen Symbol gewonnen hat.
 * 
 * Kleinfeld
 * Diese prüft, ob der Player mit dem übergebenen Symbol ein kleines Feld gewonnen hat.
 * 
 * 
 * @author Miep_HD 
 * @version 27.03.2022
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
            if (Spielstatus.board.getBoard().get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(0))) == symbol) {
                if (Spielstatus.board.getBoard().get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(1))) == symbol) {
                    if (Spielstatus.board.getBoard().get(startfeld + map_feldgruppen.get(0).get(winningconditions.get(i).get(2))) == symbol) {
                        System.out.println("Kleines Feld gewonnen");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
