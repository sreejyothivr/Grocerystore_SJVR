package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalenderUtility
{
	public void callenderFunction(WebDriver driver,String x,String y,String z)
	{
	  String exyear=x;
  	String exmonth=y;
  	String exdate=z;
 	WebElement datepicker= driver.findElement(By.id("datepicker"));
     datepicker.click();
     while(true)
     {
     String monthyr=	driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
     String arr[]=monthyr.split(" ");
     String month=arr[0];
     String year=arr[1];
     if(month.equalsIgnoreCase(exmonth) && year.equalsIgnoreCase(year))
     		break;
     else
     driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
     }
     List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement ele:alldates)
		{
			String date=ele.getText();
			if(date.equalsIgnoreCase(exdate))
			{
				ele.click();
			}
		}
	}
}
