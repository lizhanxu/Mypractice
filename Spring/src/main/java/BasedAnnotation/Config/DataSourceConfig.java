package BasedAnnotation.Config;

import JDBC.JDBCTest;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName DataSourceConfig
 * @Description
 * @Date 2019/10/9 21:36
 * @Created by lizhanxu
 */
@Configuration//作用同@Component,@Component的别名
public class DataSourceConfig {

    /**
     * 需要先将DataSourceConfig注入到Bean中，@Bean才能把方法的返回值注入IOC容器
     * @ Bean通常和@Configuration配合使用
     */
    @Bean
    public DataSource getDataSource() {
        BasicDataSource ds = null;
        JDBCTest jdbcTest = new JDBCTest();
        Properties props = jdbcTest.getParams("JavaBase/src/main/java/JDBC/mysql.ini");
        try {
            ds = (BasicDataSource)BasicDataSourceFactory.createDataSource(props);
            ds.setInitialSize(5);
            ds.setMaxActive(10);
            ds.setMaxIdle(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
