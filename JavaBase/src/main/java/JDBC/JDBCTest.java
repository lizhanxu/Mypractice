package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCTest
 * @Author lizhanxu
 * @Date 2019/9/27  16:18
 * @Version V1.0.0
 */
public class JDBCTest {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    public static void main(String[] args) {
        JDBCTest jdbcTest = new JDBCTest();
        jdbcTest.initParams("JavaBase/src/main/java/JDBC/mysql.ini");
        try {
            Class.forName(driver);//①加载数据库驱动，需要引入mysql-connector-java包(在Maven中添加依赖)
            Connection conn = DriverManager.getConnection(url,
                    username, password);//②通过DriverManager获取数据库连接

            jdbcTest.queryUseStatement(conn);

            jdbcTest.insertUsePrepareStatement(conn);

            jdbcTest.updateUseCallableStatement(conn);

            jdbcTest.queryUseStatement(conn);

            jdbcTest.close(conn,null,null);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Statement试用
     * @param conn
     * @throws SQLException
     */
    private void queryUseStatement(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();//③通过Connection对象创建Statement对象
        ResultSet rs = stmt.executeQuery("select * from jdbctest");//④使用Statement执行SQL语句，并得到结果集
        while (rs.next()) {//⑤操作结果集
            System.out.println(rs.getInt(1)+"  "
                    +rs.getString(2)+" "
                    +rs.getString(3));
        }
//            conn.close();//⑥回收数据库资源
//            stmt.close();
//            rs.close();
        close(null,stmt,rs);//⑥回收数据库资源    此处Connection还要用，所以没有回收
    }

    /**
     * PrepareStatement试用
     * @param conn
     * @throws SQLException
     */
    private void insertUsePrepareStatement(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into jdbctest (username,password) values (?,?)");
        stmt.setString(1,"admin");
        stmt.setString(2,"admin");
        if (stmt.executeUpdate()>0) {
            System.out.println("Insert Success!");
        }
        close(null,stmt,null);
    }

    private void updateUseCallableStatement(Connection conn) throws SQLException{
        CallableStatement stmt = conn.prepareCall("{CALL update_pro(?,?)}");
        stmt.setString(1,"root");
        stmt.setString(2,"12345");
        stmt.execute();
        close(null,stmt,null);
    }

    /**
     * 读取属性文件初始化属性
     * @param paramFile
     */
    private void initParams(String paramFile) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(paramFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }

    /**
     * 数据库资源的正确关闭姿势
     * ①手动逐一关闭所有资源,如下close方法
     * ②利用try(...)的自动关闭----------优先使用
     * @param conn
     * @param stmt
     * @param rs
     */
    private void close(Connection conn,Statement stmt,ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
