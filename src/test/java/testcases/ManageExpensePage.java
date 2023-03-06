package testcases;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageExpense;

public class ManageExpensePage extends BaseClass {

	LoginPage lp;
	ManageExpense mp;

	@Test
	public void manageResetButtonColorCheck() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageExpense(driver);
		String actual = mp.searchButtonColorCheck();
		System.out.println(actual);
		String expected = "rgba(255, 255, 255, 1)";
		Assert.assertEquals(actual, expected, Constant.bgcolorerrormsg);
	}

	@Test
	public void manageNewButtonTextCheck() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageExpense(driver);
		Thread.sleep(4000);
		String actual = mp.newButtonTextCheck();
		System.out.println(actual);
		String expected = "New";
		Assert.assertEquals(actual, expected, Constant.titleErrormsg);
	}

	
	
	/*
	 * @Test public void callenderHandling() { lp=new LoginPage(driver);
	 * lp.presteps(); mp=new ManageExpense(driver); boolean
	 * actual=mp.calenderfunction("2022","July","20");
	 * 
	 * boolean expected=true; Assert.assertEquals(actual,expected,"no match"); }
	 */

	@Test(groups = { "SmokeTest" })
	public void imageHandling() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageExpense(driver);

		String path = System.getProperty("user.dir") + "//src//main//resources//images//Screenshot (2).png";
		String actual = mp.imageUpload(path);
		System.out.println(actual);
		String expected = "×/n" + "Alert!/n" + " Expense Record Updated Successfully";
		Assertion softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected,Constant.titleErrormsg);

	}
	@Test
	public void imageuputilities() throws AWTException, InterruptedException
	{
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageExpense(driver);
		//String path = System.getProperty("user.dir") + prop.getProperty("imgPath1");
		String path = System.getProperty("user.dir") + "//src//main//resources//images//Screenshot (2).png";
		String actual=mp.imageuploading(path);
		System.out.println(actual);
		String expected = "×/n" + "Alert!/n" + " Expense Record Updated Successfully";
		Assertion softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected,Constant.titleErrormsg);
}
}