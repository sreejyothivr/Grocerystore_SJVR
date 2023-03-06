package elementrepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
public class DeliveryBoyPage {
WebDriver driver;
GeneralUtilities gu=new GeneralUtilities();
	public DeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement manageDboy;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a\r\n")
			WebElement password;
	//@FindBy(xpath="//table/tbody/tr[1]/td[7]/div/a/i[@class='fa fa-angle-double-down']")
	//WebElement password;
	@FindBy(xpath="//table/tbody/tr[2]/td/div/div/span")
	WebElement showpassword;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(id="ut")
	WebElement email;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	
	WebElement searchbutton2;
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement searchname;
	public String rebuttonColorCheck()
{
		//manageDboy.click();
		gu.getClickElement(manageDboy);
		
//return resetbutton.getCssValue("background-color");
		return gu.getStylePropertyvalidation(resetbutton,"background-color");
		}
	public String tooltipValidation() throws InterruptedException
	{
			//manageDboy.click();
		gu.getClickElement(manageDboy);
			//Thread.sleep(3000);
		gu.mediumDelay(3000);
			//password.click();
	//return  password.getAttribute("title");
			return gu.getToolTip(password);
			}
	public String nameVerification()
	{
			//manageDboy.click();
		gu.getClickElement(manageDboy);
			//password.click();
		gu.getClickElement(password);
			//showpassword.click();
		gu.getClickElement(showpassword);
	//return  showpassword.getText();
		return gu.getElementText(showpassword);
			}
	public String nameVallidation()
	{
		//manageDboy.click();
		gu.getClickElement(manageDboy);
		//searchbutton.click();
		gu.getClickElement(searchbutton);
		gu.sendKey(email,"megha.123@gmail.com");
		//email.sendKeys("megha.123@gmail.com");
		//searchbutton2.click();
		gu.getClickElement(searchbutton2);
		//return searchname.getText();
		return gu.getElementText(searchname);
	}
	public boolean searchbuttonClickable()
	{
		gu.getClickElement(manageDboy);
	return gu.isClickable(searchbutton);
}
}
