package org.ty.daabase_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase_operation {

	public static void main(String[] args) throws SQLException {

		Driver dbdriver = new Driver();
		Connection connection = null;
		try {
			DriverManager.registerDriver(dbdriver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from employee");
			while(result.next())
				System.out.println(result.getString("emp_name"));

		} finally {
			connection.close();
		}
	}

}
