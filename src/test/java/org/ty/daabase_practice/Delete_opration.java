package org.ty.daabase_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Delete_opration {

	public static void main(String[] args) throws SQLException {
		Driver dbdriver = new Driver();
		Connection connection = null;
		try {
			DriverManager.registerDriver(dbdriver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement statement = connection.createStatement();
			String query  = "delete from  employee where emp_id = 102 ";
			int res = statement.executeUpdate(query);
			System.out.println(res);
			if(res != 0 )
				System.out.println("data deleted");
			else
				System.out.println("its not deleted");
		}
			finally {
				connection.close();
			}
	}
}
