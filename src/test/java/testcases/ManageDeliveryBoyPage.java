package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementrepository.DeliveryBoyPage;
import elementrepository.LoginPage;

public class ManageDeliveryBoyPage extends BaseClass {
	LoginPage lp;
	DeliveryBoyPage dp;

	@Test
	public void verifyingResetButtonColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		dp = new DeliveryBoyPage(driver);
		String actual = dp.rebuttonColorCheck();
		System.out.println(actual);
		String expected = "rgba(255, 193, 7, 1)";
		Assert.assertEquals(actual, expected,Constant.bgcolorerrormsg);

	}

	@Test(groups = { "SmokeTest" })
	public void passwordToolTipValidation() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		dp = new DeliveryBoyPage(driver);
		String actual = dp.tooltipValidation();
		System.out.println(actual);
		String expected = "Show Details";
		// Assert.assertEquals(actual, expected,"title is not matching");
		Assert.assertEquals(actual, expected, Constant.titleErrormsg);

	}

	@Test(groups = { "SmokeTest" })
	public void passwordNameValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		dp = new DeliveryBoyPage(driver);
		String actual = dp.nameVerification();
		System.out.println(actual);
		String expected = "password1";
		// Assert.assertEquals(actual,expected,"Name is not matching"); }
		Assert.assertEquals(actual, expected, Constant.nameerrormsg);
	}

	@Test(groups = { "SmokeTest" })
	public void searchnameVallidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		dp = new DeliveryBoyPage(driver);
		String actual = dp.nameVallidation();
		System.out.println(actual);
		String expected = "Megha";
		// Assert.assertEquals(actual,expected,"Name is not matching");
		Assert.assertEquals(actual, expected, Constant.nameerrormsg);
	}
@Test
public void manageSearchButtonClickable()
{
	lp = new LoginPage(driver);
	lp.presteps();
	dp = new DeliveryBoyPage(driver);
	boolean actual=dp.searchbuttonClickable();
	boolean exp=true;
	Assert.assertEquals(actual,exp,Constant.ClickError);
}
}