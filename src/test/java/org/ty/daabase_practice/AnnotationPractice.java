package org.ty.daabase_practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice {

	@Test
	@BeforeSuite()
	public void suiteSetUp() {
		System.out.println("before suits");
	}
	@Test
	@AfterClass()
	public void afterClass() {
		System.out.println("after class");
	}
	@Test
	@BeforeClass
	public void classSetUp() {
		System.out.println("before class");
	}
}
