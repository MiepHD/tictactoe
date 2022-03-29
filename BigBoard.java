import java.util.ArrayList;

/**
 * Verwaltet das BigBoard.
 * Das BigBoard enthält die Information darüber wer welches Feld gewonnen hat.
 * unentschieden
 * Prüft, ob ein kleines Feld ein Unentschieden ist.
 * Wenn dies zutrifft, wird die Position auf / gesetzt.
 * 
 * update
 * Ordnet ein großes Feld einem Player zu.
 * 
 * @author Miep_HD 
 * @version 27.03.2022
 */
public class BigBoard
{
    private ArrayList<String> bigboard = ArrayGenerator.bigBoard();
    public void unentschieden(int startfeld, String kreis, String kreuz, int target) {
        int besetzt = 0;
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                int zielfeld = startfeld + x + y * 9;
                if (Spielstatus.board.getBoard().get(zielfeld) == kreis || Spielstatus.board.getBoard().get(zielfeld) == kreuz) {
                    besetzt++;
                }
            }
        }
        if (besetzt == 9) {
            bigboard.set(target, "/");
        }
    }
    public void update(int target) {
        if (Spielstatus.turn == "p1") {
            bigboard.set(target, "p2");
            Spielstatus.board.setSymbol("p2");
        } else {
            bigboard.set(target, "p1");
            Spielstatus.board.setSymbol("p1");
        }
    }
    public ArrayList<String> getBigboard() {
        return bigboard;
    }
}
