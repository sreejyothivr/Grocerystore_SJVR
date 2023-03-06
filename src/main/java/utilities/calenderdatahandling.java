package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calenderdatahandling {
	
	public void callenderFunction(WebDriver driver,String x,String y,String z)
	{
	  String exyear=x;
  	String exmonth=y;
  	String exdate=z;

	WebElement date= driver.findElement(By.id("datepicker"));
	date.click();
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

}}
