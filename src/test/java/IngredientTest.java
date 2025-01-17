import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

public class IngredientTest extends BaseTest{
    private Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = generateIngredient();
    }

    @Test
    public void shouldReturnIngredietPriceTest(){
        Assert.assertEquals(objectPrice, ingredient.getPrice(), FLOAT_DELTA);
    }

    @Test
    public void shouldReturnIngredientNameTest(){
        Assert.assertEquals(objectName, ingredient.getName());
    }

    @Test
    public void shouldReturnIngredientTypeTest(){
        Assert.assertEquals(objectType, ingredient.getType());
    }
}
