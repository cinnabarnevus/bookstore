package dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionPool{
    private static Connection conn = null;
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;
    static
    {
        ResourceBundle resource = ResourceBundle.getBundle("jdbc");
        driverClassName = resource.getString("driveClassName");
        url = resource.getString("url");
        username = resource.getString("username");
        password = resource.getString("password");
    }
    //使用阿里连接池
    public static Connection getConn() throws SQLException {
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setMaxActive(20);
        ds.setInitialSize(10);
        Connection conn=ds.getConnection();
        return conn;
    }
//使用C3P0连接池
//    public static Connection getConn() throws PropertyVetoException, SQLException {
//        ComboPooledDataSource ds=new ComboPooledDataSource();
//        ds.setDriverClass(driverClassName);
//        ds.setJdbcUrl(url);
//        ds.setUser(username);
//        ds.setPassword(password);
//        ds.setMaxPoolSize(20);
//        ds.setInitialPoolSize(10);
//        Connection conn=ds.getConnection();
//        Statement sta= (Statement) conn.createStatement();
//        ResultSet rs = sta.executeQuery("select * from tb_user");
//        while(rs.next()){
//            System.out.print("1:"+rs.getInt(1));
//            System.out.print("2:"+rs.getString(2));
//            System.out.print("3:"+rs.getString(3));
//            System.out.print("4:"+rs.getString(4));
//            System.out.print("5:"+rs.getString(5));
//            System.out.print("6:"+rs.getString(6));
//            System.out.println("\n");
//        }
//        return conn;
//    }
    public static void closeConn()
    {
        try
        {
            if (conn != null)
                conn.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
