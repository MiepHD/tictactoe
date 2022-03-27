import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.*;
/**
 * Ordnet die empfangene Nachricht einem Befehl zu.
 * Erstellt daraufhin entsprechendes Objekt und ruft verlangte Methode auf.
 * Mögliche Befehle sind:
 * *exit
 * *tictactoe bzw. *ttt
 * *p
 * *abbrechen (Zukünftig)
 * *help (Zukünftig)
 * *freigeben (Zukünftig)
 * *anleitung (Zukünftig)
 * *toggledarkmode (Zukünftig)
 * 
 * @author Miep_HD
 * @version 27.03.2022
 */
public class Main
{
    public String onMessage(String message, MessageReceivedEvent event) {
        String antwort = null;
        if (message.startsWith("*exit")) {
            System.out.println("Beende Bot");
            System.exit(0);
        }
        System.out.println(message);
        if (message.startsWith("*tictactoe") || message.startsWith("*ttt")) {
            TicTacToe tictactoe = new TicTacToe();
            antwort = tictactoe.ticTacToe(message, event);
            return antwort;
        }
        if (message.startsWith("*p")) {
            Place place = new Place();
            antwort = place.place(message, event);
            return antwort;
        }
        return antwort;
    }
}