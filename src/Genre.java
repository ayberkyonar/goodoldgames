public class Genre {

    private String naam;

    Genre (String naam) {
           this.naam = naam;
    }

    public Genre getGenre () {
        return this;
    }

    public void toonGenre () {
        System.out.println(this.naam);
    }
}
