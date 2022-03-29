import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Ordnet player1 und player2 die ID des jeweiligen Users zu.
 * Setzt turn auf p1 und gibt das Spielfeld zurück, indem es zeichneBoard() aus Board aufruft.
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */

public class TicTacToe
{
    private String antwort;
    public TicTacToe() {
        antwort = null;
    }
    public String ticTacToe(String message, MessageReceivedEvent event) {
        if (Spielstatus.player1 == null) {
            Spielstatus.player1 = event.getAuthor().getId();
            return "Player eins ist <@" + event.getAuthor().getId() + ">";
        } else if (Spielstatus.player2 == null) {
            Spielstatus.player2 = event.getAuthor().getId();
            antwort = "Player zwei ist <@" + event.getAuthor().getId() + ">";
            Spielstatus.nachricht.send(event, antwort);
            Spielstatus.begonnen = true;
            Spielstatus.board.generiereBoard();
            Spielstatus.turn = "p1";
            antwort = Spielstatus.board.zeichneBoard();
            return antwort;
        } else {
            return "Es sind bereits alle Plätze besetzt";
        }
    }
}
