import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private String enumItem;

    public IngredientTypeTest(String enumItem) {
        this.enumItem = enumItem;
    }

    @Parameterized.Parameters(name = "enumItem = {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void checkAllIngredientTypesExistsTest(){
        Assert.assertThat(IngredientType.valueOf(enumItem), notNullValue());
    }


}
