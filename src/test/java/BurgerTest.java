import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest{
    private Burger burger;
    public final float expectedPrice = 15;

    @Mock
    Bun bun;

    @Spy
    private Ingredient ingredient = generateIngredient();

    @Spy
    private Ingredient secondIngredient = generateIngredient();

    @Before
    public void setUp(){
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void shouldSetBunTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(objectName);
        Assert.assertEquals(burger.bun.getName(), objectName);
    }

    @Test
    public void shouldAddIngredientTest(){
        int initialIngredientCount = burger.ingredients.size();
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(initialIngredientCount + 1, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredientTest(){
        burger.addIngredient(secondIngredient);
        int initialIngredientCount = burger.ingredients.size();
        burger.removeIngredient(initialIngredientCount-1);
        Assert.assertEquals(initialIngredientCount - 1, burger.ingredients.size());
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(initialIngredientCount - 1).isEqualTo(burger.ingredients.size());
            softAssertions.assertThat(burger.ingredients.contains(secondIngredient)).isFalse();
        });
    }

    @Test
    public void shouldMoveIngredientTest(){
        burger.addIngredient(secondIngredient);
        int initialSize = burger.ingredients.size();
        Mockito.when(secondIngredient.getName()).thenReturn(objectName);

        burger.moveIngredient(initialSize - 1, 0);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(initialSize).isEqualTo(burger.ingredients.size());
            softAssertions.assertThat(burger.ingredients.get(0).getName()).isEqualTo(objectName);
        });
    }

    @Test
    public void shouldReturnCalculatedPrice(){
        Mockito.when(bun.getPrice()).thenReturn(objectPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(objectPrice);
        Assert.assertEquals(expectedPrice, burger.getPrice(), FLOAT_DELTA);
    }

    @Test
    public void shouldReturnReceiptTest(){
        float expectedPrice = 2*objectPrice+objectPrice;
        StringBuilder expectedString =
                new StringBuilder(String.format("(==== %s ====)%n", objectName));
        expectedString.append(String.format("= %s %s =%n", objectType.toString().toLowerCase(),
                objectName));
        expectedString.append(String.format("(==== %s ====)%n", objectName));
        expectedString.append(String.format("%nPrice: %f%n", expectedPrice));

        Mockito.when(bun.getName()).thenReturn(objectName);
        Mockito.when(bun.getPrice()).thenReturn(objectPrice);
        Mockito.when(ingredient.getName()).thenReturn(objectName);
        Mockito.when(ingredient.getPrice()).thenReturn(objectPrice);
        Mockito.when(ingredient.getType()).thenReturn(objectType);
        Assert.assertEquals(expectedString.toString(), burger.getReceipt());
        System.out.println(expectedString);
        System.out.println(burger.getReceipt());
    }

}
