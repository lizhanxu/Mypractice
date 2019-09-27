###SQL语句分类：
    DML(Data Manipulation Language,数据操作语言) insert、update、delete
    DDL(Data Definition Language,数据定义语言) create、alter、drop、truncate(截断)
    DCL(Data Control Language,数据控制语言) grant、revoke
    事务控制语句：commit、rollback、savepoint

    SQL语句的关键字不区分大小写

###truncate关键字——截断某个表
    删除该表里的全部数据，但保留表结构，比delete更快
    使用：truncate 表名

###JDBC常用接口和类
    DriverManager   用于管理JDBC驱动的服务类，主要用于获取Connection对象
    Connection      代表数据库连接对象，每个Connection代表一个物理连接会话
    Statement(不允许使用占位符?)       用于执行SQL语句的工具接口
    
    PreparedStatement(使用占位符?,带参数SQL)  
        预编译的Statement对象，是Statement的子接口，它允许数据库预编译SQL语句(这些SQL语句通常带有参数)，
        以后每次只改变SQL命令的参数，避免每次都需要编译SQL语句，性能更好。
        可以防止SQL注入。
        占位符不能用来代替表名、列名等数据库对象，或者SQL关键字，只能代替普通值
        
    CallableStatement 调用存储过程
    
    ResultSet       结果集对象，在逻辑结构上类似于一个表

###JDBC编程步骤：
    ①加载数据库驱动
    ②通过DriverManager获取数据库连接
    ③通过Connection对象创建Statement对象
    ④使用Statement执行SQL语句，得到结果集
    ⑤操作结果集
    ⑥回收数据库资源(所有用到的资源，包括Connection、Statement、ResultSet)

###正确关闭数据库资源的姿势：
    ①手动逐一关闭所有资源
    ②利用try(...)的自动关闭