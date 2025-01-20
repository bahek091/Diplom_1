import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)

public class BunParametrizedTest {
    private final String name;
    private final float price;

    private final Bun bun;

    public BunParametrizedTest(String name, float price){
        bun = new Bun(name,price);
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters(name = "name = {0}, price = {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"", Float.NaN},
                {"Bread Bread Bread Bread Bread Bread", -1f},
                {null, 0},
                {"!@#$%^&*()_-=", 3.40282346638528860e+38f},
                {"   ", Float.MIN_VALUE},
        };
    }

    @Test
    public void shouldReturnCorrectBunNameTest(){
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void shouldReturnCorrectBunPriceTest(){
        Assert.assertEquals(price, bun.getPrice(), BaseTest.FLOAT_DELTA);
    }

}
