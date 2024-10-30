package Healthcare.com.Healthcare.Core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class ParameterizedTesting {
  @Parameters({"browser"})
  @Test(priority=1)
  public void testCaseOne(String browser) {
	  System.out.println("browser name :-"+browser);
  }
  @Parameters({"username"})
  @Test(priority=2)
  public void testCaseTwo(String username) {
	  System.out.println("use id is  :-  "+username);
  }
  @Parameters({"password"})
  @Test(priority=3)
  public void testCaseThree(String password) {
	  System.out.println("password is  :-  "+password);
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class exicution");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class exicution");
  }
  

}
