package org.ty.daabase_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data_from_propertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro = new Properties();
		pro.load(file);

		

		pro.setProperty("username", "sachin");
		String url = pro.getProperty("username");
		System.out.println(url);

	}

}
