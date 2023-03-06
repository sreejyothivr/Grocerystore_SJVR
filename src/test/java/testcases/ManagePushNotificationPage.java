package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementrepository.LoginPage;
import elementrepository.PushNotificationPage;

public class ManagePushNotificationPage extends BaseClass {

	LoginPage lp;
	PushNotificationPage pp;

	@Test
	public void pTextVerrification() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		pp.clickpnotification();
		String actual = pp.textverrification();
		System.out.println(actual);
		String expected = "Push Notifications";
		Assert.assertEquals(actual, expected, Constant.titleErrormsg);
	}

	@Test
	public void manageBgcolorVerrification() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		String actual = pp.bgcolorverrification();
		System.out.println(actual);
		String expected = "rgba(23, 162, 184, 1)";
		Assert.assertEquals(actual, expected, Constant.bgcolorerrormsg);

	}

	@Test
	public void pnotificationmsgverrification() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		String actual = pp.messageVerrification("sample", " sample1");
		Thread.sleep(2000);
		System.out.println(actual);
		String expected = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actual, expected, "Constant.titleErrormsg");
	}

	@Test(groups = { "SmokeTest" })
	public void testexcelmessageVerrification() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		String actual = pp.excelmessageVerrification();
		Thread.sleep(2000);
		System.out.println(actual);
		String expected = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actual, expected, "Constant.titleErrormsg");
	}

	@Test(groups = { "SmokeTest" })
	public void titleVerrification() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		String actual = pp.titleVerrification();
		String exp = "Dashboard | 7rmart supermarket";
		Assert.assertEquals(actual, exp, Constant.titleErrormsg);
	}

	@Test
	public void manageptittleVerrifiction() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		Thread.sleep(3000);
		pp = new PushNotificationPage(driver);
		String actual = pp.ptittleVerrification();
		String exp = "Push Notifications";
		Assert.assertEquals(actual, exp, Constant.titleErrormsg);
	}
}
