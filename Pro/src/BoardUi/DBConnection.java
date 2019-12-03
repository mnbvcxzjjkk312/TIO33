package BoardUi;

import java.sql.*;


public class DBConnection
{
	static String url = "jdbc:oracle:thin:@192.168.0.94:1521:XE";
	static String user = "project3", pwd = "Abcd1234";
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success.");
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() throws SQLException
	{
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
}
