package Test_Cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test_annotation {
  @Test
  public void f1() {
	  System.out.println("Mthode f1");
  }
  @Test
  public void f2() {
	  System.out.println("Mthode f2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Mthode beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Mthode afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Mthode beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Mthode afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Mthode beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Mthode afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Mthode beforeSuite");
  }
  

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Mthode afterSuite");
  }

}
