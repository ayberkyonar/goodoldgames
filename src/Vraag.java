import java.util.ArrayList;
import java.util.Scanner;

public abstract class Vraag {
    Scanner scanner = new Scanner(System.in);

    private String titel;
    private ArrayList<Antwoord> antwoorden = new ArrayList<>();

    Vraag (String titel) {
        this.titel = titel;
    }

    public void createAntwoord (String antwoord) {
        this.antwoorden.add(new Antwoord(antwoord));
    }

    public String getTitel() {
        return titel;
    }

    abstract public void toonVraag ();
}

class OpenVraag extends Vraag {

    OpenVraag (String titel) {
        super(titel);
    }

    @Override
    public void toonVraag() {
        System.out.println(this.getTitel());
        String input = scanner.nextLine();
        createAntwoord(input);
    }
}

class MeerkeuzeVraag extends Vraag {

    private String keuze1;
    private String keuze2;
    private String keuze3;
    private ArrayList<Vraag> bonusVragen = new ArrayList<>();


    MeerkeuzeVraag (String titel, String keuze1, String keuze2, String keuze3) {
        super(titel);
        this.keuze1 = keuze1;
        this.keuze2 = keuze2;
        this.keuze3 = keuze3;
    }

    @Override
    public void toonVraag() {
        System.out.println(this.getTitel());
        System.out.println("Kies uit:");
        System.out.println("1 " + this.keuze1);
        System.out.println("2 " + this.keuze2);
        System.out.println("3 " + this.keuze3);

        boolean exitEnquete = false;
        while (!exitEnquete){
            String input = scanner.nextLine();

            if (input.equals("1")) {
                createAntwoord(this.keuze1);
                if (!bonusVragen.isEmpty() && bonusVragen.get(0) != null) {
                    bonusVragen.get(0).toonVraag();
                }
                exitEnquete = true;
            } else if (input.equals("2")) {
                createAntwoord(this.keuze2);
                if (!bonusVragen.isEmpty() && bonusVragen.get(1) != null) {
                    bonusVragen.get(1).toonVraag();
                }
                exitEnquete = true;
            } else if (input.equals("3")) {
                createAntwoord(this.keuze3);
                if (!bonusVragen.isEmpty() && bonusVragen.get(2) != null) {
                    bonusVragen.get(2).toonVraag();
                }
                exitEnquete = true;
            } else {
                System.out.println("Vul een geldig getal in!");
            }
        }
    }

    public void createBonusVraag (int index) {
        System.out.println("Voer de vervolg vraag in:");
        String vraag = scanner.nextLine();
        OpenVraag openVraag = new OpenVraag(vraag);

        while (bonusVragen.size() <= index) {
            bonusVragen.add(null);
        }

        this.bonusVragen.add(index, openVraag);
    }
}
