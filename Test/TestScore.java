import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScore {

    @Test
    public void testScore(){
        //Arrange
        Game minecraft = new Game();
        Review review2 = new Review(minecraft, "leuke game", 8,9, 7 );


        //Act
        minecraft.addReview(review2);


        //Assert
        assertEquals(8, minecraft.getScore());


    }

}
