public class Game {
    private String naam;
    private double prijs;
    private int korting;

    public Game (String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;

    }

    public Game (String naam, double prijs, int korting){
        this(naam, prijs);
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


