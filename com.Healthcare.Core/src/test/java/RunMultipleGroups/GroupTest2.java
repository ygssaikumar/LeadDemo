package RunMultipleGroups;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GroupTest2 {
  @Test(groups="smoke",priority=0)
  public void Login_Account() {
	  System.out.println("Account login");
  }
  @Test(groups="smoke",priority=1)
  public void checkMail() {
	  Assert.assertEquals("OrangeHRM", "OrangeHRM");
	  System.out.println("Checking mail into the inbox");
  }
  @Test(groups="sanity",priority=2)
  public void check_Draft() {
	  System.out.println("checking draft");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Test");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Test");
  }
  

}
