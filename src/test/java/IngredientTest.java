import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceTest () {
        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest () {
        String expectedName = "hot sauce";
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }
}
