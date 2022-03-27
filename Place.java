import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Zuerst wird geprüft, ob der Autor der Nachricht gerade am Zug ist.
 * Danach wird aus der Eingabe die absolute Position im Spielfeld berechnet.
 * Als letztes wird über Spielstatus die place Methode von Board aufgerufen.
 * 
 * @author Miep_HD
 * @version 27.03.2022
 */
public class Place
{
    public String place(String message, MessageReceivedEvent event) {
        String antwort;
        String eingabe;
        char buchstabe;
        int buchstabenziffer;
        int ziffer;
        int number;
        antwort = null;
        if (!((Spielstatus.turn.equals("p1") && event.getAuthor().getId().equals(Spielstatus.player1))  || (Spielstatus.turn.equals("p2") && event.getAuthor().getId().equals(Spielstatus.player2)))) { 
            return "Du bist nicht an der Reihe";
        } 
        eingabe = message.split(" ", 2)[1];
        buchstabe = eingabe.charAt(0);
        buchstabenziffer = buchstabe - 65;
        System.out.println("Zahl für Buchstabe " + buchstabe + ": " + buchstabenziffer);
        ziffer = eingabe.charAt(1) - 49;
        System.out.println("Zahl ist: " + ziffer);
        number = ziffer * 9 + buchstabenziffer;
        System.out.println("Extrahierte Zahl: " + number);
        antwort = Spielstatus.board.place(number, event);
        return antwort;
    }
}
