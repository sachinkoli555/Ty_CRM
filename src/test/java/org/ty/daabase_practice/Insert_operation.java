package org.ty.daabase_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Insert_operation {

	public static void main(String[] args) throws SQLException {
		Driver dbdriver = new Driver();
		Connection connection = null;
		try {
			DriverManager.registerDriver(dbdriver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement statement = connection.createStatement();
			String query = "insert into employee values"
					+ "(103,'rama',1234,'mysore')";
			int res = statement.executeUpdate(query);
			if(res != 0 )
				System.out.println("record inserted");
			}
		finally{
			connection.close();
			
			
		}
	}

}
