import java.util.ArrayList;
import java.util.Scanner;

public class Enquete {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Vraag> vragen = new ArrayList<>();

    public void toonVragen () {
        for (int i = 0; i < vragen.size(); i++) {
            vragen.get(i).toonVraag();
        }
    }

    public void createVraag () {
        System.out.println("Wat voor type vraag wil jij toevoegen?\n");
        System.out.println("1. Meerkeuze Vraag");
        System.out.println("2. Open Vraag");

        boolean validInput = false;
        while (!validInput) {

            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Geef de vraag een titel:");
                String titel = scanner.nextLine();
                System.out.println("Geef de eerste optie voor de vraag:");
                String keuze1 = scanner.nextLine();
                System.out.println("Geef de tweede optie voor de vraag:");
                String keuze2 = scanner.nextLine();
                System.out.println("Geef de derde optie voor de vraag:");
                String keuze3 = scanner.nextLine();

                MeerkeuzeVraag meerkeuzeVraag = new MeerkeuzeVraag(titel, keuze1, keuze2, keuze3);

                System.out.println("Wilt u een vervolgvraag toevoegen voor optie 1? (J/N)");
                boolean vervolgInput1 = false;
                while (!vervolgInput1) {
                    String vervolgVraagKeuze = scanner.nextLine();
                    if(vervolgVraagKeuze.toLowerCase().equals("j")){
                        meerkeuzeVraag.createBonusVraag(0);
                        vervolgInput1 = true;
                    } else if (vervolgVraagKeuze.toLowerCase().equals("n")) {
                        vervolgInput1 = true;
                    } else {
                        System.out.println("Voer iets geldigs in (J/N):");
                    }
                }

                System.out.println("Wilt u een vervolgvraag toevoegen voor optie 2? (J/N)");
                boolean vervolgInput2 = false;
                while (!vervolgInput2) {
                    String vervolgVraagKeuze = scanner.nextLine();
                    if(vervolgVraagKeuze.toLowerCase().equals("j")){
                        meerkeuzeVraag.createBonusVraag(1);
                        vervolgInput2 = true;
                    } else if (vervolgVraagKeuze.toLowerCase().equals("n")) {
                        vervolgInput2 = true;
                    } else {
                        System.out.println("Voer een geldig invoer in");
                    }
                }

                System.out.println("Wilt u een vervolgvraag toevoegen voor optie 3? (J/N)");
                boolean vervolgInput3 = false;
                while (!vervolgInput3) {
                    String vervolgVraagKeuze = scanner.nextLine();
                    if(vervolgVraagKeuze.toLowerCase().equals("j")){
                        meerkeuzeVraag.createBonusVraag(2);
                        vervolgInput3 = true;
                    } else if (vervolgVraagKeuze.toLowerCase().equals("n")) {
                        vervolgInput3 = true;
                    } else {
                        System.out.println("Voer een geldig invoer in (J/N): ");
                    }
                }

                this.addVraag(meerkeuzeVraag);

                validInput = true;
            } else if (input.equals("2")) {
                System.out.println("Geef de vraag een titel:");
                String titel = scanner.nextLine();

                OpenVraag openVraag = new OpenVraag(titel);

                this.addVraag(openVraag);

                validInput = true;
            } else {
                System.out.println("Voer een geldig invoer in (1/2)");
            }
        }
    }

    public void addVraag (Vraag vraag) {
        this.vragen.add(vraag);
    }

}
