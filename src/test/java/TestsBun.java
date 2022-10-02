import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestsBun {

    @Test
    public void getNameVerify() {
        Bun bun = new Bun("nameTest", 100.00F);
        assertEquals("nameTest", bun.getName());
    }

    @Test
    public void getNameVerifyNull() {
        Bun bun = new Bun(null, 100.00F);
        assertNull(bun.getName());
    }

    @Test
    public void getPriceVerify() {
        Bun bun = new Bun("nameTest", 100.00F);
        assertEquals(100.00F, bun.getPrice(), 0.0);
    }

    @Test
    public void getPriceVerifyNull() {
        Bun bun = new Bun("nameTest", 0.0F);
        assertEquals(0.0, bun.getPrice(), 0.0);
    }
}
