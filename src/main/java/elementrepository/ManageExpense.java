package elementrepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileHandling;
import utilities.GeneralUtilities;
import utilities.Synchronisation;

public class ManageExpense {
WebDriver driver;
FileHandling fl;
Synchronisation s=new  Synchronisation();
GeneralUtilities gu=new GeneralUtilities();
public  ManageExpense(WebDriver driver)
{
	this.driver=driver;
	
		PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
WebElement manageex;
@FindBy(xpath="//div/nav/ul/li[2]/ul[2]/li/a/p")
WebElement manageexp;
@FindBy(xpath="//a[@class=\'btn btn-rounded btn-primary\']")
WebElement search;
@FindBy(xpath="//a[@class=\'btn btn-rounded btn-danger\']")
WebElement neww;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm'][1]/tbody[1]/tr[1]/td[9]/a[1]/i[1]")
WebElement changebutton;
@FindBy(xpath="//input[@class='form-control date']")
WebElement datepicker;
@FindBy(xpath="//button[normalize-space()='Update']")
WebElement update;
@FindBy(xpath="//input[@type='file']")
WebElement choosefile;
@FindBy(xpath="//section/div[2]/div/div")
WebElement msg;
public void clickManageEx()
{
	//manageex.click();
	gu.getClickElement(manageex);
	//manageexp.click();
	s.Elementvisible(driver,"//div/nav/ul/li[2]/ul[2]/li/a/p");
	gu.getClickElement(manageexp);
}
public String searchButtonColorCheck()
{
	clickManageEx();
	return gu.getStylePropertyvalidation(search,"color");
	//return search.getCssValue("color"); 
	//#1f2d3d;//class="btn btn-rounded btn-danger"
	}

public String newButtonTextCheck() throws InterruptedException
{
	gu.mediumDelay(300);
	clickManageEx();
	return gu.getElementText(neww);
	//return neww.getText();//#1f2d3d;//class="btn btn-rounded btn-danger"
	}

public boolean calenderfunction(String exyr,String exmonth,String exdate)
{
	clickManageEx();
	changebutton.click();
	datepicker.click();
	 while(true)
     {
     String monthyr=driver.findElement(By.xpath("//div[2]/div[1]/table/thead/tr[2]/th[2]")).getText();
     String arr[]=monthyr.split(" ");
     String month=arr[0];
     String year=arr[1];
     if(month.equalsIgnoreCase(exmonth) && year.equalsIgnoreCase(year))
     		break;
     else
     driver.findElement(By.xpath("//div[2]/div[1]/table/thead/tr[2]/th[3]")).click();
     }
     List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='table-condensed']/tbody/tr/td"));
		for(WebElement ele:alldates)
		{
			String date=ele.getText();
			if(date.equalsIgnoreCase(exdate))
			{
				ele.click();
			}
		}

    
    
return datepicker.isEnabled();

}
    
public String imageUpload(String s) throws InterruptedException
{
	clickManageEx();
	//changebutton.click();
	gu.getClickElement(changebutton);
	gu.sendKey(choosefile,s);
	//choosefile.sendKeys(s);
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
	jse.executeScript("arguments[0].click();", update);
	//update.click();
	
	//return msg.getText();
	return gu.getElementText(msg);
}
public String imageuploading(String s) throws AWTException, InterruptedException
{
	clickManageEx();
	gu.getClickElement(changebutton);
	Thread.sleep(4000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)");
	fl=new FileHandling();
	fl.fileUpload(s,choosefile,driver);
	jse.executeScript("arguments[0].click();", update);
	return gu.getElementText(msg);
	
}
}