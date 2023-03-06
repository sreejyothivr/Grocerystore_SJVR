package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementrepository.LoginPage;

public class LoginTestCase extends BaseClass {

	LoginPage lp;
	List<String> loginList;

	@DataProvider(name = "data")
	public Object[][] getUserData() {
		// return new Object[][] { { "admin", "admin" }, { "admin2", "admin3" }};//for
		// pass
		return new Object[][] { { "admin", "admin" } };
	}

	@Test(dataProvider = "data")
	public void verifyLoggedUsers(String username, String Password) throws InterruptedException {

		lp = new LoginPage(driver);

		lp.getUserName(username);
		lp.getPassWord(Password);
		lp.clickSignin();

		// lp.presteps();

		String actual = lp.profileVerification();
		System.out.println(actual);
		String expected = "Admin";
		Assert.assertEquals(expected, actual, Constant.nameerrormsg);

	}

	// @Test(retryAnalyzer = retryTest.RetryAnalyzer.class)
	@Test
	public void excelverifyLoggedUsers() {
		lp = new LoginPage(driver);

		// Test data from excel file stored in this list
		loginList = lp.getLoginDetails();

		lp.getUserName(loginList.get(0));
		lp.getPassWord(loginList.get(1));

		lp.clickSignin();

		// lp.presteps();

		String actual = lp.profileVerification();
		System.out.println(actual);
		String expected = "Admin";
		// String expected = "Admin2";
		Assert.assertEquals(expected, actual, Constant.titleErrormsg);

	}

	@Test
	public void verifyCheckBox() throws InterruptedException {
		lp = new LoginPage(driver);
		boolean actual = lp.getRememberMe();
		System.out.println(actual);
		boolean expected = false;
		Assert.assertEquals(actual, expected, Constant.SelectionError);
	}

}
