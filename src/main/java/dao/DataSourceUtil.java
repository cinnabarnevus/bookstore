package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceUtil
{
	private static Connection conn = null;
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	//静态代码块在类被加载的时候运行，而且只运行一次，并且优先于各种代码块以及构造函数
	static
	{
		ResourceBundle resource = ResourceBundle.getBundle("jdbc");
		driverClassName = resource.getString("driveClassName");
		url = resource.getString("url");
		username = resource.getString("username");
		password = resource.getString("password");
	}
	public static Connection initConn()
	{
		try
		{
			System.out.println("driverClassName="+driverClassName);
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("conn="+conn);
			if(conn!=null)
				System.out.println("数据库连接成功！");
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("数据库加载失败！");
		}
		return conn;
	}

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
