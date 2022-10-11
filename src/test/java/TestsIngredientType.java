import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestsIngredientType {

    private final IngredientType checkedType;
    private final String expectedString;

    public TestsIngredientType(IngredientType checkedType, String expectedString) {
        this.checkedType = checkedType;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void enumIngredientTypeVerify() {
        assertEquals(IngredientType.valueOf(expectedString), checkedType);
    }
}
