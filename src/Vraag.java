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

    public void addAntwoord (Antwoord antwoord) {
        this.antwoorden.add(antwoord);
    }

    public String getTitel() {
        return titel;
    }

    abstract public void toonVraag ();
}

class OpenVraag extends Vraag{

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
    ArrayList<Vraag> bonusVragen = new ArrayList<>();


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
        System.out.println(this.keuze1);
        System.out.println(this.keuze2);
        System.out.println(this.keuze3);

        System.out.println(this.getTitel());
        String input = scanner.nextLine();
        createAntwoord(input);
    }
}

class BonusVraag extends Vraag {

    BonusVraag (String titel) {
        super(titel);
    }

    @Override
    public void toonVraag() {
        System.out.println(this.getTitel());
        String input = scanner.nextLine();
        createAntwoord(input);
    }
}
