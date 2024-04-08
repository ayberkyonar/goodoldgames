import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScore {


    //Deze test is van waarde door te controleren of de aangemaakte Game Object
    // de gemiddelde score correct berekent van de reviews die aan het spel
    // zijn toegevoegd. Dit zorgt ervoor dat de gebruiker de correcte score te zien krijgt.


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
