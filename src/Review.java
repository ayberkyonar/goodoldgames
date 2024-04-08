public class Review {
    private Game game;
    private String toelichting;
    private int gameplay;
    private int graphics;
    private int storyline;

    Review(Game game, String toelichting, int gameplay, int graphics, int storyline) {
        this.game = game;
        this.toelichting = toelichting;
        this.gameplay = gameplay;
        this.graphics = graphics;
        this.storyline = storyline;
    }

    public double getGemiddelde() {
        if (this.gameplay == 0 && this.graphics == 0 && this.storyline == 0) {
            return 0.0;
        } else {
            return (double) (this.gameplay + this.graphics + this.storyline) / 3;
        }
    }

    public void toonReview() {
        System.out.println("Retro game: " + game.getNaam());
        System.out.println("Score gameplay: " + this.gameplay);
        System.out.println("Score graphics: " + this.graphics);
        System.out.println("Score storyline: " + this.storyline);
        System.out.println("Toelichting: " + this.toelichting);
        System.out.println();
    }

}
