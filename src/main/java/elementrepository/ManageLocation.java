package elementrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.Synchronisation;

public class ManageLocation {
	WebDriver driver;
	Synchronisation s = new Synchronisation();
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocation(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul/li[9]/a/p")
	WebElement manageloc;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']")
	WebElement edit;
	@FindBy(id = "country_id")
	WebElement dropdp;
	@FindBy(id = "st_id")
	WebElement dropdownp;
	@FindBy(id = "location")
	WebElement loc;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") //// div[2]/div/div
	WebElement alert;
	@FindBy(xpath = "//table/tbody/tr[20]/td[4]")
	WebElement amt;
	@FindBy(xpath = "//table/tbody/tr[2]/td[5]/a/span")
	WebElement status;
	@FindBy(id = "delivery")
	WebElement charge;
	@FindBy(xpath = "//h1[normalize-space()='List Locations']")
	WebElement listtittle;

	public String stateEdition() {
		// manageloc.click();
		gu.getClickElement(manageloc);
		// edit.click();
		gu.getClickElement(edit);
		gu.getClickElement(dropdp);
		gu.selectFuncbyViText(dropdp, "United Kingdom");
		gu.selectFuncbyViText(dropdownp, "Bristol");
		loc.clear();
		gu.sendKey(loc, "kerala");
		gu.sendKey(charge, "1000");
		gu.getClickElement(update);
		return gu.getElementText(alert);
		/*
		 * dropdp.click(); Select s=new Select(dropdp);
		 * s.selectByVisibleText("United Kingdom"); Select s1=new Select(dropdownp);
		 * s1.selectByVisibleText("Bristol"); loc.clear();
		 * 
		 * loc.sendKeys("kerala"); charge.sendKeys("1000");
		 * 
		 * update.click(); return alert.getText();
		 */
	}

	public String amoundverrification() {
		//manageloc.click();
		gu.getClickElement(manageloc);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)");
		//return amt.getText();
		return gu.getElementText(amt);
	}

	public String statusVerrification() {
		//manageloc.click();
		//return status.getText();
		gu.getClickElement(manageloc);
		return gu.getElementText(status);
	}

	public String listTittleVerrification() {
		gu.getClickElement(manageloc);
		return gu.getElementText(listtittle);
	}

}