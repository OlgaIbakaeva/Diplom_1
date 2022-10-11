import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class TestsBurger {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient testFilling1, testFilling2, testSauce1, testSauce2;

    @Before
    public void testDataWithMock() {
        // объявляем, что здесь будут использоваться моки
        MockitoAnnotations.openMocks(this);
        // создаем объект класса Burger
        burger = new Burger();
        // создаем тестовый список ингредиентов
        burger.bun = bun;
        burger.ingredients.add(testFilling1);
        burger.ingredients.add(testFilling2);
        burger.ingredients.add(testSauce1);
        burger.ingredients.add(testSauce2);
        /* получился бургер
            - bun,
            - testFilling1,
            - testFilling2,
            - testSauce1,
            - testSauce2,
            - bun
         */
        // делаем стабы методов для объекта класса Bun
        Mockito.when(bun.getName()).thenReturn("test bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        // делаем стабы методов для объектов класса Ingredient
        Mockito.when(testFilling1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testFilling2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testSauce1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(testSauce2.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(testFilling1.getName()).thenReturn("Filling 1");
        Mockito.when(testFilling2.getName()).thenReturn("Filling 2");
        Mockito.when(testSauce1.getName()).thenReturn("Sauce 1");
        Mockito.when(testSauce2.getName()).thenReturn("Sauce 2");

        Mockito.when(testFilling1.getPrice()).thenReturn(200F);
        Mockito.when(testFilling2.getPrice()).thenReturn(300F);
        Mockito.when(testSauce1.getPrice()).thenReturn(50F);
        Mockito.when(testSauce2.getPrice()).thenReturn(70F);
    }

    @Test
    public void setBunsVerify() {
        burger.bun.name = "test bun";
        burger.bun.price = 100F;
        burger.setBuns(bun);
        Assert.assertEquals("test bun", burger.bun.name);
        Assert.assertEquals(100F, burger.bun.price, 0.0F);
    }

    @Test
    public void addIngredientInListOfIngredients1() {
        int i = burger.ingredients.size();
        burger.addIngredient(testFilling1);
        Assert.assertEquals(i+1, burger.ingredients.size());
    }

    @Test
    public void addIngredientInListOfIngredients2() {
        int i = burger.ingredients.size();
        burger.addIngredient(testFilling1);
        Assert.assertEquals(testFilling1, burger.ingredients.get(i));
    }

    @Test
    public void removeIngredientFromListOfIngredients1() {
        int i = burger.ingredients.size();
        burger.removeIngredient(0);
        Assert.assertEquals(i-1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientFromListOfIngredients2() {
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(testFilling1));
    }


    @Test
    public void moveIngredientInListOdIngredients() {
        /* начальный порядок ингредиентов
            - testFilling1,
            - testFilling2,
            - testSauce1,
            - testSauce2
         */
        burger.moveIngredient(2, 0);
        burger.moveIngredient(3, 2);
        /* измененный порядок ингредиентов
            - testSauce1,
            - testFilling1,
            - testSauce2,
            - testFilling2,
         */
        Assert.assertEquals(testSauce1, burger.ingredients.get(0));
        Assert.assertEquals(testFilling1, burger.ingredients.get(1));
        Assert.assertEquals(testSauce2, burger.ingredients.get(2));
        Assert.assertEquals(testFilling2, burger.ingredients.get(3));
    }

    @Test
    public void getPriceEqualSumPriceOfIngredients() {
        // формула: priceOfBun * 2 + ∑ priceOfIngredient
        Assert.assertEquals(820F, burger.getPrice(), 0.0F);
    }

    @Test
    public void getReceiptReturnsAllIngredientsString() {
        String expectedReceipt = String.format("(==== %s ====)%n", "test bun") + String.format("= %s %s =%n", "filling", "Filling 1") +
                String.format("= %s %s =%n", "filling", "Filling 2") +
                String.format("= %s %s =%n", "sauce", "Sauce 1") +
                String.format("= %s %s =%n", "sauce", "Sauce 2") +
                String.format("(==== %s ====)%n", "test bun") +
                String.format("%nPrice: %f%n", 820.0F);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @After
    public void testDataClean() {
        burger.bun = null;
        burger.ingredients.clear();
    }
}
