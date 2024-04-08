import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameGemiddelde {

    // Deze test draagt bij aan het correct tonen van de gemiddelde score die een game heeft behaald
    // op basis van gemiddelde score van de reviews die een gebruiker geeft aan de desbetreffende game.


    @Test
    public void testGameGemiddelde(){
        //Arrange
        Game gtav = new Game();
        Review review2 = new Review (gtav,"prima",7,8,9 );
        Review review3 = new Review (gtav,"irritante game met hinderlijke storyline", 3,5,3 );

        //Act
        gtav.addReview(review2);
        gtav.addReview(review3);

        //Assert
        assertEquals(5.833333333333333, gtav.getScore());



    }



}
