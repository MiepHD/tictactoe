import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Klasse versendet Nachrichten
 * sendTemporaryMessage sendet eine Nachricht, die es wieder löscht, bevor die nächste versendet wird
 * sendMessage versendet ausschließlich eine Nachricht
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */
public class Nachricht
{
    static MessageReceivedEvent old_event;
    public static void sendTemporary(MessageReceivedEvent event, String antwort) {
        if (old_event != null) {
            old_event.getMessage().delete().queue();
        }
        old_event = event;
        event.getChannel().sendMessage(antwort).queue();
    }
    public static void send(MessageReceivedEvent event, String antwort) {
        event.getChannel().sendMessage(antwort).queue();
    }
}