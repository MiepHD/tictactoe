import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * Wird beim Start ausgeführt
 * Diese Klasse meldet sich bei Discord mit einem Token an, das als erstes Argument übergeben wird
 * Setzt debug auf true, falls im zweiten Argument verlangt, um weiterführende Informationen während des Ablaufs auszugeben.
 * Erstellt Objekt von Spielstatus
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */

public class Start {
    static boolean debug;
    static String token;
    static Spielstatus spiel;
    static String[] arguments;
    public static void main(String[] args) throws Exception {
        arguments = args;
        System.out.println("Anmelden mit Token " + args[0] + "...");
        token = args[0];
        JDA jda = JDABuilder.createDefault(token).build();
        System.out.println("Erfolgreich angemeldet\nErstelle EventListener");
        jda.addEventListener(new MyEventListener());
        System.out.println("EventListener erfolgreich erstellt");
        if (args.length >= 2) {
            if (args[1] == "true") {
                boolean debug = true;
                System.out.println("Debug-Modus eingeschaltet");
            } else {
                boolean debug = false;
            }
        }
        spiel = new Spielstatus();
    }
    public static void restart() {
        spiel = null;
        try {
            main(arguments);
        } catch (Exception exception) {
            
        }
    }
}