import java.util.ArrayList;
import java.util.List;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * zeichneBoard
 * Erstellt aus dem board einen Text, der versendet werden kann und gibt diesen zurück.
 * 
 * generiereBoard
 * Generiert das Board. (Beinhaltet nur grüne Felder)
 * 
 * place
 * 
 * 
 * placeSymbol
 * Setzt Symbol bei number.
 * 
 * zeichneGreen
 * Zeichnet das ausgewählte große Feld (target) grün
 * 
 * allGreen
 * Zeichnet alles Grün, falls das Zielfeld bereits belegt ist.
 * 
 * feldFaerben
 * Färbt das gewonnene Feld mit der entsprechenden Farbe ein
 * 
 * @author Miep_HD
 * @version 28.03.2022
 */

public class Board
{
    private ArrayList<String> board;
    private boolean egal;
    private String green;
    private String white;
    private String kreis;
    private String kreuz;
    private String symbol;
    private ArrayList<String> zahlen;
    private ArrayList<ArrayList<Integer>> feldgruppen;
    private ArrayList<ArrayList<Integer>> map_feldgruppen;
    private ArrayList<ArrayList<Integer>> winningconditions;
    private BigBoard bigboard;
    public Board() {
        zahlen = ArrayGenerator.zahlen();
        egal = false;
        board = new ArrayList<String>();
        green = ":green_square:";
        white = ":white_large_square:";
        kreis = ":o2:";
        kreuz = ":regional_indicator_x:";
        symbol = "";
        bigboard = new BigBoard();
        feldgruppen = ArrayGenerator.feldgruppen();
        map_feldgruppen = ArrayGenerator.mapFeldgruppen();
        winningconditions = ArrayGenerator.winningConditions();
    }
    public ArrayList<String> getBoard() {
        return board;
    }
    public void setSymbol(String arg) {
        if (arg.equals("p1")) {
            symbol = "p1";
        } else if (arg.equals("p2")) {
            symbol = "p2";
        } else if (arg.equals("")) {
            symbol = "";
        } else {
            System.out.println("Falsches Symbol festgelegt");
        }
    }
    public String toggledarkmode() {
        if (board == null) {
            if (white.equals(":white_large_square:")) {
                white = ":black_large_square:";
            } else {
                white = ":white_large_square:";
            }
        } else {
            return "Der Modus ist nur änderbar, solange kein Spiel läuft.";
        }
        return null;
    }
    public String zeichneBoard() {
        System.out.println("Board: " + board);
        int i = 0;
        int row = 2;
        String spielfeld_text = ":black_large_square::regional_indicator_a::regional_indicator_b::regional_indicator_c::regional_indicator_d::regional_indicator_e::regional_indicator_f::regional_indicator_g::regional_indicator_h::regional_indicator_i:\n:one:";
        System.out.println("Zeichne Board");
        for (String x : board) {
            if (Mathe.istTeilerVon(i + 1, 9)) {
                System.out.println("Erstelle Zeilenumbruch");
                spielfeld_text = spielfeld_text + x + "\n" + zahlen.get(row);
                row++;
            } else {
                spielfeld_text = spielfeld_text + x;
            }
            i++;
        }
        if (Start.debug == true) System.out.println("Board erstellt\nBoard ist: " + spielfeld_text);
        return spielfeld_text;
    }
    public void generiereBoard() {
        for (int i = 0; i <= 80; i++) {
             board.add(green);
             egal = true;
        }
    }
    public String place(int number, MessageReceivedEvent event) {
        String antwort = null;
        if (board.get(number) == green) {
            int target = Feld.finde(number, feldgruppen);
            zeichneGreen(target);
            symbol = placeSymbol(number);
            int new_target = Feld.finde(number, map_feldgruppen);
            int startfeld = Feld.berechneStart(new_target);
            boolean kleinfeldgewonnen = false;
            boolean spielgewonnen = false;
            if (Gewonnen.Kleinfeld(startfeld, map_feldgruppen, winningconditions, symbol)) {
                bigboard.update(new_target);
                if (target == new_target) {
                    allGreen();
                }
                feldFaerben(startfeld);
                String spielfeld_text = "";
                if (Gewonnen.Spiel(bigboard.getBigboard(), winningconditions, symbol)) {
                    spielfeld_text = zeichneBoard();
                    Spielstatus.nachricht.send(event, spielfeld_text);
                    if (Spielstatus.player1 != Spielstatus.player2) {
                        Punkte.berechne(symbol, event, bigboard.getBigboard());
                    }
                }
            }
            if (!kleinfeldgewonnen) {
                bigboard.unentschieden(startfeld, kreis, kreuz, target);
            }
            int besetzt = 0;
            if (!spielgewonnen) {
                antwort = zeichneBoard();
                for (String element : bigboard.getBigboard()) {
                    if (element != "p0") {
                        besetzt++;
                    }
                }
                if (besetzt == 9) {
                    Spielstatus.nachricht.send(event, antwort);
                    Spielstatus.nachricht.send(event, "Unentschieden!");
                    Start.restart();
                    return null;
                } else {
                    Spielstatus.nachricht.sendTemporary(event, antwort);
                    return null;
                }
            }
        } else {
            return "Feld "+ number +" nicht auswählbar. \n Board: " + board.get(number);
        }
        return antwort;
    }
    public String placeSymbol(int number) {
        if (Spielstatus.turn == "p1") {
            board.set(number, kreis);
            Spielstatus.turn = "p2";
            System.out.println("@<" + Spielstatus.player2 + "> ist nun an der Reihe");
            return kreis;
        } else {
            board.set(number, kreuz);
            Spielstatus.turn = "p1";
            System.out.println("@<" + Spielstatus.player1 + " ist nun an der Reihe");
            return kreuz;
        }
    }
    public void allGreen() {
        for (int i = 0; i <= 80; i++) {
            if (board.get(i) == white) {
                board.set(i, green);
            }
        }
    }
    public void feldFaerben(int startfeld) {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                int zielfeld = startfeld + x + y * 9;
                if (board.get(zielfeld) == white || board.get(zielfeld) == green) {
                    if (Spielstatus.turn == "p2") {
                        board.set(zielfeld, ":red_square:");
                    } else {
                        board.set(zielfeld, ":blue_square:");
                    }
                }
            }
        }
    }
    public void zeichneGreen(int target) {
        int startfeld = Feld.berechneStart(target);
        if (bigboard.getBigboard().get(target) == "p0") {
            for (int i = 0; i <= 80; i++) {
                if (board.get(i) == green) {
                    board.set(i, white);
                }
            }
            for (int x = 0; x <= 2; x++) {
                for (int y = 0; y <= 2; y++) {
                    int zielfeld = startfeld + x + y * 9;
                    if (board.get(zielfeld) == white) {
                        board.set(zielfeld, green);
                    }
                }
            }
        } else {
            for (int i = 0; i <= 80; i++) {
                if (board.get(i) == white) {
                    board.set(i, green);
                }
            }
        }
    }
}
