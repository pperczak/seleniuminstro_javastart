import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void testDodawania_OK() {

        int expected_result = 3;
        assertEquals(calculator.add(1,2),expected_result);
    }
    //@Test
    public void testDodawania_NOK() {
        assertEquals(calculator.add(3,22),100);
    }

    @Test
    public void testDodawania_OK_assertTrue() {
        assertTrue(calculator.add(100,200) == 300);
    }

    @Test
    public void testDodawania_OK_assertFalse() {
        assertFalse(calculator.add(14,26) ==100);
    }
}
