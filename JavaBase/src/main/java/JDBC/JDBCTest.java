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
        Connection conn;
        Statement stmt;
        ResultSet rs;
        initParams("JavaBase/src/main/java/JDBC/mysql.ini");
        try {
            Class.forName(driver);//①加载数据库驱动，需要引入mysql-connector-java包(在Maven中添加依赖)
            conn = DriverManager.getConnection(url,
                    username, password);//②通过DriverManager获取数据库连接
            stmt = conn.createStatement();//③通过Connection对象创建Statement对象
            rs = stmt.executeQuery("select * from jdbctest");//④使用Statement执行SQL语句，并得到结果集
            while (rs.next()) {//⑤操作结果集
                System.out.println(rs.getInt(1)+"  "
                +rs.getString(2)+" "
                +rs.getString(3));
            }
//            conn.close();//⑥回收数据库资源
//            stmt.close();
//            rs.close();
            close(conn,stmt,rs);//⑥回收数据库资源
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取属性文件初始化属性
     * @param paramFile
     */
    public static void initParams(String paramFile) {
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
     * ②利用try(...)的自动关闭
     * @param conn
     * @param stmt
     * @param rs
     */
    private static void close(Connection conn,Statement stmt,ResultSet rs) {
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
