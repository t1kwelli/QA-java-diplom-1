import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    Ingredient ingredientOne = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredientTwo = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

    Bun blackBun = new Bun("black bun", 100);

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Spy
    private Burger burgerSpy = new Burger();

    @Test
    @Description("Проверка метода получения цены бургера")
    public void getPriceTest () {
        float expectedPrice = 300;

        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    @Description("Проверка метода, который печатает чек с информацией о бургере")
    public void getReceiptTest() {
        String expectedReceipt = String.format("(==== white bun ====)%n" + "= sauce sour cream =%n" +
                "(==== white bun ====)%n" + "%n" + "Price: 500,000000%n");

        burgerSpy.addIngredient(ingredient);
        burgerSpy.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(burgerSpy.getPrice()).thenReturn(500F);

        String actualReceipt = burgerSpy.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    @Description("Проверка метода добавления ингредиента в бургер")
    public void addIngredientTest () {
        List <Ingredient> expectedIngredients = List.of(ingredientOne);

        burger.addIngredient(ingredientOne);
        List <Ingredient> actualIngredients = burger.ingredients;

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    @Description("Проверка метода удаления ингредиента из бургера")
    public void removeIngredientTest () {
        List <Ingredient> expectedIngredients = List.of(ingredientTwo);

        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.removeIngredient(0);

        List <Ingredient> actualIngredients = burger.ingredients;

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    @Description("Проверка метода перемещения ингредиента в бургере")
    public void moveIngredientsTest () {
        List <Ingredient> expectedIngredients = List.of(ingredientOne, ingredientTwo);

        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientOne);
        burger.moveIngredient(1, 0);

        List <Ingredient> actualIngredients = burger.ingredients;

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    @Description("Проверка метода выбора булочки для бургера")
    public void setBunsTest () {
        Bun expectedBun = blackBun;
        burger.setBuns(blackBun);
        Bun actualBun = burger.bun;

        assertEquals(expectedBun, actualBun);
    }
}
