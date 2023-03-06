package elementrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
	GeneralUtilities gu=new GeneralUtilities();
	WebDriver driver;
	ExcelRead excelUtility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	
	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement verificationOfRememberCheckBox;
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;
	
	public void getUserName(String username) {
		//userName.sendKeys(username);
		gu.sendKey(userName,username);
	}
	

	
	public void getPassWord(String password1) {
		//password.sendKeys(password1);
		gu.sendKey(password,password1);
		
	}

	public void clickSignin() {
	//signin.click();
	gu.getClickElement(signin);
		
	}

	
	public String profileVerification() {
		//return profileName.getText();
		//using general utility
		return gu.getElementText(profileName);
	}
		
	public List<String> getLoginDetails() {
		excelUtility = new ExcelRead();
		String p = System.getProperty("user.dir") + "//src//main//resources//Excelfiles//Testdata.xlsx";

				List<String> excelList = excelUtility.readDataFromExcel("Sheet1",p);
		return excelList;
	}
	 public boolean getRememberMe()
	 {
		// return verificationOfRememberCheckBox.isSelected();
		 return gu.isSelectable(verificationOfRememberCheckBox);
	 }

	 


	

	

	public void presteps() {
		getUserName("admin");
		getPassWord("admin");
		clickSignin();
	}

	
}

