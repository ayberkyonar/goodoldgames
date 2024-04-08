import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckPrijs {

    @Test
    public void testPrijs() {
        // Arrange
        Genre genre1 = new Genre("Open world");
        Game gameTest = new Game("Pac-Man3", 45.95, genre1);

        // Act: er is geen actie nodig, aangezien het effect van de korting automatisch wordt toegepast bij het maken van het Game-object.


        // Assert
        assertEquals(45.95, gameTest.getPrijs(), 0.01);
    }
}
