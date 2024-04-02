public class Review {

    private String toelichting;
    private int gameplay;
    private int graphics;
    private int storyline;

    Review (String toelichting, int gameplay, int graphics, int storyline) {
        this.toelichting = toelichting;
        this.gameplay = gameplay;
        this.graphics = graphics;
        this.storyline = storyline;
    }

    public double getGemiddelde() {
        return (double) (this.gameplay + this.graphics + this.storyline) / 3;
    }

    public void toonReview () {
        System.out.println("Score gameplay: " + this.gameplay);
        System.out.println("Score graphics: " + this.graphics);
        System.out.println("Score storyline: " + this.storyline);
        System.out.println("Toelichting: ");
        System.out.println(toelichting);
    }
}
