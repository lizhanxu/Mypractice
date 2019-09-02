package JavaReflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName TestPropertiesConfig
 * @Author lizhanxu
 * @Date 2019/8/20  17:52
 * @Version V1.0.0
 */
public class TestPropertiesConfig {
    public static void main(String[] args) throws Exception {
        Class reflectService = Class.forName(getValue("className"));
        Method method = reflectService.getMethod(getValue("methodName"));
        method.invoke(reflectService.newInstance());
    }

    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();//获取配置文件对象
        FileReader in = new FileReader("src\\JavaReflect\\properties.txt");
        properties.load(in);
        in.close();
        return properties.getProperty(key);

    }
}
