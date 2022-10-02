import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestsIngredient {

    @Test
    public void getNameVerify() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"nameTest", 100.00F);
        assertEquals("nameTest", ingredient.getName());
    }

    @Test
    public void getNameVerifyNull() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,null, 100.00F);
        assertNull(ingredient.getName());
    }

    @Test
    public void getPriceVerify() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"nameTest", 100.00F);
        assertEquals(100.00F, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getPriceVerifyNull() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"nameTest", 0.00F);
        assertEquals(0.0, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getTypeVerifySAUCE() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"nameTest", 100.00F);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void getTypeVerifyFILLING() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"nameTest", 100.00F);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
