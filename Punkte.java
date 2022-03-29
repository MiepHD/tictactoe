import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Punkte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkte {
    public static void berechne(String symbol, MessageReceivedEvent event, ArrayList<String> bigboard) {
        long p1_punkte;
        long p2_punkte;
        long p1_punkte_gesamt = 0;
        long p2_punkte_gesamt = 0;
        if (symbol == "p1") {
            Spielstatus.nachricht.send(event, "<@" + Spielstatus.player1 + "> hat gewonnen");
            p1_punkte = 6;
            p2_punkte = 0;
        } else {
            Spielstatus.nachricht.send(event, "<@" + Spielstatus.player2 + "> hat gewonnen");
            p2_punkte = 6;
            p1_punkte = 0;
        }
        for (String i: bigboard) {
            if (i == "p1") {
                p1_punkte = p1_punkte + 1;
            } else if (i == "p2") {
                p2_punkte = p2_punkte + 1;
            }
        }
        erstelleId(Spielstatus.player1);
        erstelleId(Spielstatus.player2);
        p1_punkte_gesamt = punkteHinzufuegen(p1_punkte);
        p2_punkte_gesamt = punkteHinzufuegen(p2_punkte);
        Spielstatus.nachricht.send(event, "Player eins hat " + p1_punkte + " Punkte erspielt und hat damit jetzt insgesamt " + p1_punkte_gesamt);
        Spielstatus.nachricht.send(event, "Player zwei hat " + p2_punkte + " Punkte erspielt und hat damit jetzt insgesamt " + p2_punkte_gesamt);
        Start.restart();
    }
    public static void erstelleId(String player) {
        if (!Spielstatus.data.contains(player)) {
            Spielstatus.data.add(Long.parseLong(player));
            long num = 0;
            Spielstatus.data.add(num);
        }
    }
    public static long punkteHinzufuegen(long punkte) {
        for (int i = 0; i <= Spielstatus.data.size(); i++) {
            if (Long.parseLong(Spielstatus.player1) == Spielstatus.data.get(i)) {
                Spielstatus.data.set(i + 1, Spielstatus.data.get(i + 1) + punkte);
                long punkte_gesamt = Spielstatus.data.get(i + 1);
                return punkte_gesamt;
            }
        }
        return -1;
    }
}
