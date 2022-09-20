package org.ty.daabase_practice;

import org.testng.annotations.Test;

public class TestNGPractice1 {

	@Test(dependsOnMethods = "step2Test")
	public void step1Test() {
		System.out.println("scrpit 1");
	}

	@Test
	public void step2Test() {
		System.out.println("scrpit 2");

	}
}
