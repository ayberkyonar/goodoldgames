import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScore {

    @Test
    public void testScore(){
        //Arrange
        Game minecraft = new Game();
        Review review2 = new Review("leuke game met goede storyline", 7,8,9 );


        //Act
        minecraft.addReview(review2);


        //Assert
        assertEquals(8, minecraft.getScore());


    }

}
