package Test.Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName CalculateAutoTest
 * @Description IDEA自动生成单元测试，方法体为空，需要自己填充
 * @Date 2019/10/23 0:48
 * @Created by lizhanxu
 */
public class CalculateAutoTest {

    private Calculate calculate;

    @Before
    public void setUp() throws Exception {
        calculate = new Calculate();
    }

    @After
    public void tearDown() throws Exception {
        calculate = null;
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