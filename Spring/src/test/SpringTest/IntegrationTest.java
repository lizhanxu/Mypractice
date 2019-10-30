package SpringTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName IntegrationTest
 * @Description
 * @Date 2019/10/23
 * @Created by lizhanxu
 */
@RunWith(SpringJUnit4ClassRunner.class)//用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，这里用SpringJUnit4ClassRunner作为Junit测试环境
@ContextConfiguration(classes = {TestConfig.class})//加载配置类或配置文件，配置容器
@ActiveProfiles("prod")//激活profile
public class IntegrationTest {
    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}
