import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameTest () {
        String expectedName = "black bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest () {
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
