package utilities;

	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

	public class GeneralUtilities {

		public String getElementText(WebElement element) {
			String text = element.getText();
			return text;
		}

		public boolean isClickable(WebElement element) {
			boolean status = element.isEnabled();
			return status;
		}
		public boolean isSelectable(WebElement element) {
			boolean status = element.isSelected();
			return status;
		}

		public void sendKey(WebElement element, String s) {
			element.sendKeys(s);
		}
public String getStylePropertyvalidation(WebElement element,String att)
{
	return element.getCssValue(att);
}
		public String getToolTip(WebElement element) {
			return element.getAttribute("title");
		}

		public void getClickElement(WebElement element) {
			element.click();
		}

		public void mediumDelay(int x) throws InterruptedException {
			Thread.sleep(x);
		}

		public void selectFuncbyindex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);

		}

		public void selectFuncbyValue(WebElement element, String value) {
			Select select1 = new Select(element);
			select1.selectByValue(value);

		}
		public void selectFuncbyViText(WebElement element, String visisbletext) {
			Select select1 = new Select(element);
			select1.selectByVisibleText(visisbletext);

		}

		public String selectFuncbyVisibletext(WebElement element, String visisbletext) {
			Select select = new Select(element);
			select.selectByVisibleText(visisbletext);
			WebElement selectedValue = select.getFirstSelectedOption();
		return (selectedValue.getText());

		}

		public String FirstSelectedOption(WebElement element) {
			Select select1 = new Select(element);
			String firstoption = select1.getFirstSelectedOption().getText();
			return (firstoption);
		}

		public List getAllOptions(Select s) {

			List<WebElement> op = s.getOptions();

			return op;

		}
		List<String> list=new ArrayList();
		public List<String> addList(List<String>list,String s)
		{
			
	      list.add(s);
			return list;
		}
		public void alertHandlingaccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}

		public String alerttext(WebDriver driver) {
			return (driver.switchTo().alert().getText());
		}

		public void scrollDownOperation(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2500)");
		}
		public void fileUpload(String path, WebElement element, WebDriver driver) throws AWTException {
			Robot rob = new Robot();

			Actions a = new Actions(driver);
			a.moveToElement(element).click().perform();

			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rob.delay(250);

			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.delay(250);
			rob.keyRelease(KeyEvent.VK_ENTER);
		}
		public boolean checkCheckBoxSelected(WebElement element) {
			boolean select = element.isSelected();
			return select;

		}
		public boolean elementDisplayed(WebElement element) {
			boolean textDisplay = element.isDisplayed();
			return textDisplay;
		}

		
		public void dragandDrop(WebElement source, WebElement destination, WebDriver driver) {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, destination).perform();
		}
		//get text
		public boolean getElementTextList(List<WebElement> actuallist, String element) {

				boolean value = true;
				for (int i = 0; i < actuallist.size(); i++) {

					String text = actuallist.get(i).getText();

					if (!text.equals(element))

					{
						value = false;

					}
				}
		return value;
			}


		//list 
		public boolean compareLists(List<String> actuallist, List<String> expectedlist) {
				boolean value = true;
				for (int i = 0; i < actuallist.size(); i++) {
					if (!actuallist.get(i).equals(expectedlist.get(i))) {
						value = false;

					}
				}

				return value;
			}


	}


