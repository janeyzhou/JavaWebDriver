package TestNGFrameWork;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {

	
	@Test (groups = "depends", dependsOnGroups = "book")	
	public void dependsGroups(){
		System.out.println("Depends on groups book");
	}
	
	@Test (groups = "depends", dependsOnMethods = "dependsGroups")
	public void dependsMethods(){
		System.out.println("Depends on methods dependsGroups");
	}
	
		@Test (groups = "testCase")
		public void testCase1(){
			System.out.println("Test Case 1");
		}
		
		@Test (groups = "testCase")
		public void testCase2(){
			System.out.println("Test Case 2");
		}
		
		@Test (groups = "car")
		public void car(){
			System.out.println("Car");
		}
		
		@Test (groups = {"car", "book"})
		public void carBook(){
			System.out.println("Car Book");
		}
		
		@BeforeTest
		public void beforeTest(){
			System.out.println("Before Test");
		}
		
		@AfterTest
		public void afterTest(){
			System.out.println("After Test");
		}
		
		@BeforeMethod
		public void beforeMethod(){
			System.out.println("Before Method");
		}
		
		@AfterMethod
		public void afterMethod(){
			System.out.println("After Method");
		}
		
		@BeforeClass
		public void beforeClass(){
			System.out.println("BeforeClass");
		}
		
		@AfterClass
		public void afterClass(){
			System.out.println("After Class");
		}
		

		@Test (groups = "Sequence", priority = 1)
		public void one(){
			System.out.println("one");
		}
		
		
		@Test (groups = "Sequence", priority = 2)
		public void two(){
			System.out.println("two");
		}
		
		@Test (groups = "Sequence", priority = 3, enabled = false )
		public void three(){
			System.out.println("three");
		}
		
		@Test (groups = "Sequence", priority = 4)
		public void four(){
			System.out.println("four");
		}


}
