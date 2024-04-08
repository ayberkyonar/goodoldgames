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

    public Game() {
    }

    public Genre getGenre() {
        return genre;
    }

    public void toonGame() {
        System.out.println(this.naam);
        System.out.printf("€%.2f\n",this.prijs);
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


