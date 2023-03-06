package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementrepository.DashBardPage;
import elementrepository.LoginPage;

public class DashBoardTestCases extends BaseClass{
  DashBardPage dp;
  
 LoginPage lp;
  @Test
 public void profNameVerrification() throws InterruptedException
 {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashBardPage(driver);
	 
 
 String actual=dp.verrifyprofile();
 String expected="Admin";
 
	Assert.assertEquals(actual, expected,Constant.nameerrormsg);
}
  @Test
public void colorverification()throws InterruptedException
{
	lp=new LoginPage(driver);
	  lp.presteps();
	 dp=new DashBardPage(driver);
	
	String actual=dp.gettingCssvalue();
	System.out.println(actual);
	String expected="rgba(0, 123, 255, 1)";
	
	Assert.assertEquals(actual, expected,Constant.bgcolorerrormsg);
	
			}
  
}
