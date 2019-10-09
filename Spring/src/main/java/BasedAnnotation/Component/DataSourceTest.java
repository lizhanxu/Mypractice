package BasedAnnotation.Component;

import JDBC.JDBCTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName DataSourceTest
 * @Description
 * @Date 2019/10/9 22:45
 * @Created by lizhanxu
 */
@Component
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    public void query() {
        JDBCTest jdbcTest = new JDBCTest();
        try {
            Connection conn = dataSource.getConnection();
            jdbcTest.queryUseStatement(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
