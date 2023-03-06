package elementrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSlider {
WebDriver driver;
GeneralUtilities gu = new GeneralUtilities();
public MobileSlider(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//nav/ul/li[11]/a/p")
WebElement mobileslider;
@FindBy(xpath="//h1[@class='m-0 text-dark']")
WebElement title;

@FindBy(xpath="//table/tbody/tr[1]/td[2]/a/span")
WebElement status;

@FindBy(xpath="//table/tbody/tr[1]/td[3]/a[1]/i")
WebElement edit;

@FindBy(xpath="//input[@id='main_img']")
WebElement choosefile;

@FindBy(xpath="//button[@class='btn btn-danger']")
WebElement update;

@FindBy(xpath="//table/tbody/tr[1]/td[1]/img")
WebElement checkimage;
@FindBy(xpath="//div/div/div/ul/li")
WebElement msg;

public String getTitle()
{
	//mobileslider.click();
	//return title.getText();
	gu.getClickElement(mobileslider);
	return gu.getElementText(title);
	}
public  String statusCheck()
{
	//mobileslider.click();
	//return status.getText();
	gu.getClickElement(mobileslider);
	return gu.getElementText(status);
}
public boolean imageCheck(String s) throws InterruptedException
{
	
	//mobileslider.click();
	gu.getClickElement(mobileslider);
	//edit.click();
	gu.getClickElement(edit);
	gu.sendKey(choosefile,s);
	//choosefile.sendKeys(s);
	//Thread.sleep(3000);
	gu.mediumDelay(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
	jse.executeScript("arguments[0].click();", update);
	//update.click();
	
	//return msg.getText();
	return checkimage.isDisplayed();
}
public String wrongimageCheck(String s) throws InterruptedException
{
	gu.getClickElement(mobileslider);
	gu.getClickElement(edit);
	gu.sendKey(choosefile,s);
	gu.mediumDelay(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
	jse.executeScript("arguments[0].click();", update);
	//update.click();
	
	//return msg.getText();
	return gu.getElementText(msg);
	
}
}