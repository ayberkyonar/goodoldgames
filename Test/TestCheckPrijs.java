import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckPrijs {

    //Door deze test toe te voegen, wordt de functionaliteit
    // van het ophalen van de prijs toegepast. Dit is belangrijk omdat het
    // ervoor zorgt dat de prijs die is ingesteld in de constructor van het Game-object
    // correct wordt gereturned door de getPrijs()-method.

    @Test
    public void testPrijs() {
        // Arrange
        Genre genre1 = new Genre("Open world");
        Game gameTest = new Game("Pac-Man3", 100, genre1);

        // Act
        double prijs = gameTest.getPrijs();


        // Assert
        assertEquals(100, prijs, 0.01);
    }
}
