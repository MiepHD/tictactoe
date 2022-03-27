import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Klasse versendet Nachrichten
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */
public class Versenden
{
    static MessageReceivedEvent old_event;
    public static void sendTemporaryMessage(MessageReceivedEvent event, String antwort) {
        if (old_event != null) {
            old_event.getMessage().delete().queue();
        }
        old_event = event;
        event.getChannel().sendMessage(antwort).queue();
    }
    public static void sendMessage(MessageReceivedEvent event, String antwort) {
        event.getChannel().sendMessage(antwort).queue();
    }
}