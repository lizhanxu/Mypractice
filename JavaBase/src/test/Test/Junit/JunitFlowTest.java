package Test.Junit;

import org.junit.*;

/**
 * @ClassName JunitFlowTest
 * @Description Junit测试流程
 * @Date 2019/10/22 20:28
 * @Created by lizhanxu
 */
public class JunitFlowTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is beforeClass....");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is afterClass....");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("this is before....");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("this is after....");
    }

    @Test
    @Ignore
    public void test3() {
        System.out.println("this is test3....");
    }

    @Test
    public void test1() {
        System.out.println("this is test1....");
    }

    @Test
    public void test2() {
        System.out.println("this is test2....");
    }

}
