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
        String input = scanner.nextLine();

        boolean validInput = false;
        while (!validInput) {
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

                this.addVraag(meerkeuzeVraag);

                validInput = true;
            } else if (input.equals("2")) {
                System.out.println("Geef de vraag een titel:");
                String titel = scanner.nextLine();

                OpenVraag openVraag = new OpenVraag(titel);

                this.addVraag(openVraag);

                validInput = true;
            }
        }
    }

    public void addVraag (Vraag vraag) {
        this.vragen.add(vraag);
    }

    public void removeVraag (Vraag vraag) {
        this.vragen.remove(vraag);
    }

}
