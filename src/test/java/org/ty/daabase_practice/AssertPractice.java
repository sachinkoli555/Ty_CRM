package org.ty.daabase_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertPractice {

	@Test
	public void test1() {
	String actual1 = "Hi";
	String expected = "hi";
	Assert.assertTrue(actual1.equalsIgnoreCase(expected));
	}
}
