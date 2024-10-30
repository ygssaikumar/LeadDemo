package RunMultipleGroups;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GroupTest1 {
  @Test(groups="sanity",priority=1)
  public void checkPromosions() {
	  System.out.println("checking promotions");
  }
  @Test(groups="sanity",priority=2)
  public void checkAccountDetailes() {
	  System.out.println("checking account detailes");
  }
  @Test(groups="smoke",priority=2)
  public void composeMail() {
	  Assert.assertEquals("OrangeHRM","OrangeHRM");
		System.out.println("Send a Mail ");

  }
	@Test(groups = "sanity",priority=3)
	public void logout_Account() {
	System.out.println("Account Logout");
	}

  @Test(groups = "smoke",priority=3)
	public void deleteMail() {
	System.out.println("Delete a Mail");
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
