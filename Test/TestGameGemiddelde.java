import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameGemiddelde {

    @Test
    public void testGameGemiddelde(){
        //Arrange
        Game gtav = new Game();
        Review review2 = new Review("leuke game met goede storyline", 7,8,9 );
        Review review3 = new Review("irritante game met hinderlijke storyline", 3,5,3 );

        //Act
        gtav.addReview(review2);
        gtav.addReview(review3);

        //Assert
        assertEquals(5.833333333333333, gtav.getScore());



    }



}
