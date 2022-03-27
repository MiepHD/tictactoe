import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse BigBoard.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BigBoard
{
    static ArrayList<String> bigboard = ArrayGenerator.bigBoard();
    public static void unentschieden(int startfeld, String kreis, String kreuz, int target) {
        int besetzt = 0;
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                int zielfeld = startfeld + x + y * 9;
                if (Board.board.get(zielfeld) == kreis || Board.board.get(zielfeld) == kreuz) {
                    besetzt++;
                }
            }
        }
        if (besetzt == 9) {
            bigboard.set(target, "/");
        }
    }
    public static void update(int target) {
        if (Spielstatus.turn == "p1") {
            bigboard.set(target, "p2");
            Board.symbol = "p2";
        } else {
            bigboard.set(target, "p1");
            Board.symbol = "p1";
        }
    }
}
