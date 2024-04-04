import java.util.ArrayList;

public class Game {
    private String naam;
    private double prijs;
    private int korting;
    private Genre genre;
    private ArrayList<Review> reviews = new ArrayList<>();

    public Game (String naam, double prijs, Genre genre){
        this.naam = naam;
        this.prijs = prijs;
        this.genre = genre;
    }

    public Game (String naam, double prijs, Genre genre, int korting){
        this(naam, prijs, genre);
        this.korting = korting;
    }

    public Genre getGenre() {
        return genre;
    }

    public void toonGame() {
        System.out.println(this.naam);
        System.out.printf("€%.2f\n",this.prijs);
    }

    public void toonKorting() {
        if (this.korting > 0) {
            System.out.println(this.naam);
            System.out.printf("€%.2f\n",this.prijs);
            System.out.println("%" + this.korting);
            double kortingBedrag = this.prijs * (this.korting / 100.0);
            System.out.printf("Prijs na korting: €%.2f\n", this.prijs - kortingBedrag);
        }

    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void addReview (Review review) {
        reviews.add(review);
    }

    public double getScore () {
        double score = 0;
        for (int i = 0; i < reviews.size(); i++) {
            score += reviews.get(i).getGemiddelde();
        }
        return score / reviews.size();

    }

}