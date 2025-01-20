import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BaseTest {
    public final static float FLOAT_DELTA = 0.00001f;

    public final String objectName = "testName";
    public final float objectPrice = 5;
    public final IngredientType objectType = IngredientType.SAUCE;

    public Ingredient generateIngredient(){
        return new Ingredient(objectType, objectName, objectPrice);
    }

    public Bun generateBun(){
        return new Bun(objectName, objectPrice);
    }
}
