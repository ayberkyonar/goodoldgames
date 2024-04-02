import java.util.ArrayList;

public class Game {
    private String naam;
    private double prijs;
    private int korting;
    private String genre;

    public Game (String naam, double prijs, String genre){
        this.naam = naam;
        this.prijs = prijs;
        this.genre = genre;
    }

    public Game (String naam, double prijs, String genre, int korting){
        this(naam, prijs, genre);
        this.korting = korting;
    }

    public void toonGame() {
        System.out.println(this.naam);
        System.out.println(this.prijs);

    }

    public void toonKorting() {
        System.out.println(this.naam);
        System.out.println(this.prijs);

        if (this.korting != -1) {
            System.out.println(this.korting);
        }
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

}


