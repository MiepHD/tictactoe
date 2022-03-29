import net.dv8tion.jda.api.entities.*;
import java.util.ArrayList;

/**
 * Hält lediglich die Informationen über das Spiel.
 * 
 * turn
 * Diese Variable enthält zu Anfang nichts.
 * Später enthält turn entweder "p1" oder "p2" für Player eins oder zwei.
 * 
 * player1 bzw. player2
 * Diese enthalten die ID des jeweiligen Players.
 * 
 * begonnen
 * Dies zeigt lediglich, ob gerade ein Spiel läuft
 * 
 * board
 * Dies gibt allen Zugriff auf das Objekt der Klasse Board
 * 
 * data
 * Dies speichert den Score jedes Spielers
 * Beispiel:
 * [636229819620655134, 2, 947761983623667712, 5]
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */

public class Spielstatus {
    static String turn;
    static String player1;
    static String player2;
    static boolean begonnen;
    static Board board;
    static Nachricht nachricht;
    static ArrayList<Long> data;
    public Spielstatus() {
        turn = "";
        board = new Board();
        ArrayGenerator generate = new ArrayGenerator();
        data = new ArrayList<Long>();
    }
}
