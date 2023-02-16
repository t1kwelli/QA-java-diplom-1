import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getNameData () {
        return new Object[][]{
                {"", -100},
                {null, 0},
                {"!@#$%^&*()_+", Float.MIN_VALUE},
                {"оченьдлинноеназваниебулки оченьдлинноеназваниебулки оченьдлинноеназваниебулки", Float.MAX_VALUE},
                {"Б", 100},
        };
    }

    @Before
    public void setUp () {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest () {
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getPriceTest () {
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, 0);
    }

}
