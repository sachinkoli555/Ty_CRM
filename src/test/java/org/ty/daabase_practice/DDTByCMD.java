package org.ty.daabase_practice;

import org.testng.annotations.Test;

import ty.crm.genricutility.WebDriverUtility;

public class DDTByCMD {

	@Test
	public void testCase1() {
		String browser = System.getProperty("b");
		String url = System.getProperty("u");

		System.out.println("borswer is =====> " + browser);
		System.out.println("url is =====> " + url);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.OpenBrowserWithApplication(browser, (long) 1000, url);

	}
}
