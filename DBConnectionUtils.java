package com.sathya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtils
{
	public static Connection createConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","praveen","tiger");
			
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}
