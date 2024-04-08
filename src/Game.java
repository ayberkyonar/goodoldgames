import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private String naam;
    private double prijs;
    private int korting;
    private Genre genre;
    private ArrayList<Review> reviews = new ArrayList<>();

    public String getNaam() {
        return this.naam;
    }

    public Game (String naam, double prijs, Genre genre){
        this.naam = naam;
        this.prijs = prijs;
        this.genre = genre;
    }

    public Game (String naam, double prijs, Genre genre, int korting){
        this(naam, prijs, genre);
        this.korting = korting;
    }

    public Game() {
    }

    public Genre getGenre() {
        return genre;
    }

    public void toonGame() {
        System.out.println(this.naam);

        if (this.korting > 0) {
            double kortingBedrag = this.prijs * (this.korting / 100.0);
            System.out.printf("€%.2f\n", this.prijs - kortingBedrag);
        } else {
            System.out.printf("€%.2f\n",this.prijs);
        }
    }

    public void toonKorting() {
        if (this.korting > 0) {
            System.out.println(this.naam);
            System.out.printf("€%.2f\n",this.prijs);
            System.out.println(this.korting + "%");
            double kortingBedrag = this.prijs * (this.korting / 100.0);
            System.out.printf("Prijs na korting: €%.2f\n", this.prijs - kortingBedrag);
            System.out.println();
        }
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public double getPrijs() {
        return this.prijs;
    }

    public void addReview (Review review) {
        reviews.add(review);
    }

    public ArrayList<Review> getReview() {
        return this.reviews;
    }


    public double getScore() {
        if (reviews.isEmpty()) {
            return 0;
        }

        double score = 0;
        for (Review review : reviews) {
            score += review.getGemiddelde();
        }
        return score / reviews.size();
    }

    public static void sortGamesByAverageScore(List<Game> games) {
        Collections.sort(games, Comparator.comparing(Game::getScore).reversed());
    }

}