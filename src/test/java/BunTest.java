import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest extends BaseTest{


    private Bun bun;

    @Before
    public void setUp(){
        bun = generateBun();
    }

    @Test
    public void shouldReturnBunNameTest(){
        Assert.assertEquals(objectName, bun.getName());
    }

    @Test
    public void shouldReturnBunPriceTest(){
        Assert.assertEquals(objectPrice, bun.getPrice(), FLOAT_DELTA);
    }
}
