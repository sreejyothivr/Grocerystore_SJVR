package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageLocation;

public class ManageLocationPage extends BaseClass {
	LoginPage lp;
	ManageLocation mp;

	
	  @Test public void manageState()
	  { 
		  lp = new LoginPage(driver); lp.presteps();
	  mp = new ManageLocation(driver); String actual = mp.stateEdition();
	System.out.println(actual);
	  String expected="×\n"
	  		+ "Alert!\n"
	  		+ "Location Created Successfully";
	 Assert.assertEquals(actual, expected,Constant.titleErrormsg); }
	 
  @Test
  public void amountVerrification()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mp=new ManageLocation(driver);
	  String actual=mp.amoundverrification();
	  System.out.println(actual);
	  String exp="₹250";
	  Assert.assertEquals(actual, exp,Constant.SelectError);
  }
  @Test
  public void manageStatusVerrification()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mp=new ManageLocation(driver);
	  String actual=mp.statusVerrification();
	  System.out.println(actual);
	  String exp="Active";
	  Assert.assertEquals(actual, exp,Constant.StatusError);
  }
  @Test
  public void managelistTittleVerrification()
  {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  mp=new ManageLocation(driver);
	  String actual=mp.listTittleVerrification();
	  System.out.println(actual);
	  String exp="List Locations";
	  Assert.assertEquals(actual, exp,Constant.titleErrormsg);
  }
}
