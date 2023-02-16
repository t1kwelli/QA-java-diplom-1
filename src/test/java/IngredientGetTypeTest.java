import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {

    private final IngredientType ingredientType;
    private final IngredientType expectedIngredientType;


    public IngredientGetTypeTest(IngredientType ingredientType, IngredientType expectedIngredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getIngredientData () {
        return new Object[][]{
                {IngredientType.SAUCE, IngredientType.SAUCE},
                {IngredientType.FILLING, IngredientType.FILLING},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "hot sauce", 100);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(expectedIngredientType, actualIngredientType);
    }
}
