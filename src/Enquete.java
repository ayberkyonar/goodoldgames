import java.util.ArrayList;

public class Enquete {

    private ArrayList<Vraag> vragen = new ArrayList<>();

    public void toonVragen () {

        for (int i = 0; i < vragen.size(); i++) {
            vragen.get(i).toonVraag();
        }
        
    }

    public void addVraag (Vraag vraag) {
        this.vragen.add(vraag);
    }

    public void removeVraag (Vraag vraag) {
        this.vragen.remove(vraag);
    }

}
