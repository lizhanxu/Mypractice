package Test.Junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName CalculateTest
 * @Description
 * @Date 2019/10/23 0:15
 * @Created by lizhanxu
 */
public class CalculateTest {

    private Calculate calculate;

    @Before
    public void setUp() throws Exception {
        calculate = new Calculate();
    }

    @Test
    public void add() {
        assertEquals(8,calculate.add(3,5));
    }

    @Test
    public void subtract() {
        assertEquals(7,calculate.subtract(10,3));
    }

    @Test
    public void multiply() {
        assertEquals(30,calculate.multiply(5,6));
    }

    @Test
    public void divide() {
        assertEquals(3,calculate.divide(6,2));
    }
}
