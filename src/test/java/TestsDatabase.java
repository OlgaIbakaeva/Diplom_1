import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import java.util.List;

public class TestsDatabase {
    Database database = new Database();

    @Test
    public void availableBunsReturnListOfBuns() {
        List<Bun> buns = database.availableBuns();
        
        assertEquals("black bun", buns.get(0).name);
        assertEquals(100F, buns.get(0).price, 0.0);
        
        assertEquals("white bun", buns.get(1).name);
        assertEquals(200F, buns.get(1).price, 0.0);
        
        assertEquals("red bun", buns.get(2).name);
        assertEquals(300F, buns.get(2).price, 0.0);
    }

    @Test
    public void availableIngredientsReturnListOfIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        
        assertEquals(IngredientType.SAUCE, ingredients.get(0).type);
        assertEquals("hot sauce", ingredients.get(0).name);
        assertEquals(100F, ingredients.get(0).price, 0.0);
        
        assertEquals(IngredientType.SAUCE, ingredients.get(1).type);
        assertEquals("sour cream", ingredients.get(1).name);
        assertEquals(200F, ingredients.get(1).price, 0.0);
        
        assertEquals(IngredientType.SAUCE, ingredients.get(2).type);
        assertEquals("chili sauce", ingredients.get(2).name);
        assertEquals(300F, ingredients.get(2).price, 0.0);

        assertEquals(IngredientType.FILLING, ingredients.get(3).type);
        assertEquals("cutlet", ingredients.get(3).name);
        assertEquals(100F, ingredients.get(3).price, 0.0);

        assertEquals(IngredientType.FILLING, ingredients.get(4).type);
        assertEquals("dinosaur", ingredients.get(4).name);
        assertEquals(200F, ingredients.get(4).price, 0.0);

        assertEquals(IngredientType.FILLING, ingredients.get(5).type);
        assertEquals("sausage", ingredients.get(5).name);
        assertEquals(300F, ingredients.get(5).price, 0.0);
    }
}
