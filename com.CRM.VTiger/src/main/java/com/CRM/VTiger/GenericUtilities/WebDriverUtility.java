package com.CRM.VTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the window
	 * 
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is related to implicitlyWait duration
	 * 
	 * @param driver
	 */
	public void impWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.implicitwaitduration));
	}

	/**
	 * This method is help us to get visibility of element from explicitWait
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.explicitwaitsuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is help us to know wheather the element is clickable from
	 * explicitWait
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.explicitwaitsuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to chech wheather any alert popup is present in
	 * particular window or not.
	 * 
	 * @param driver
	 */
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.explicitwaitsuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This method is used to handle the dropdown with index value
	 * 
	 * @param element
	 * @param indexNo
	 */
	public void handleDropdown(WebElement element, int indexNo) {
		Select s = new Select(element);
		s.selectByIndex(indexNo);
	}

	/**
	 * This method is used to handle the dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to handle the dropdown by visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to click on OK on alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to click on CANCEL on alert popup
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used get text present in alert popup
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to switch the driver focus from main page to frame by
	 * index no.
	 * 
	 * @param driver
	 * @param indexNo
	 */
	public void frameByIndex(WebDriver driver, int indexNo) {
		driver.switchTo().frame(indexNo);
	}

	/**
	 * This method is used to switch the driver focus from main page to frame by
	 * name or id attribute value.
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void frameByNameorId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch the driver focus from main page to frame by
	 * WebElement reference.
	 * 
	 * @param driver
	 * @param element
	 */
	public void frameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch the driver focus from any child frame to
	 * immediate parent frame.
	 * 
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch the driver focus from any child frame to main
	 * parent frame.
	 * 
	 * @param driver
	 */
	public void mainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to move the mouse cursor to required web element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to right click on the required web element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method is used to right click any where in the web page.
	 * 
	 * @param driver
	 */
	public void rightClickAnyWhere(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method is used to double click any where in the web page.
	 * 
	 * @param driver
	 */
	public void doubleClickAnyWhere(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method is used to double click on the required web element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to drag and drop the element by source and destination.
	 * 
	 * @param driver
	 * @param srcElement
	 * @param destElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement destElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();
	}

	/**
	 * This method is used to switch the driver focus to any new window
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void windowHandling(WebDriver driver, String partialTitle) {
		// Fetch all window id's
		Set<String> allId = driver.getWindowHandles();

		// Navigate to each window
		for (String id : allId) {
			String currentTitle = driver.switchTo().window(id).getTitle();

			if (currentTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to take screenshot for entire web page.
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String screenshotForEntireWebPage(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		JavaUtility ju = new JavaUtility();
		String currentDate = ju.modifiedDate();

		File dest = new File("./screenshots/" + currentDate + screenshotName + ".png");
		FileHandler.copy(src, dest);

		// extent report
		return dest.getAbsolutePath();// extent report
	}

	/**
	 * This method is used to take screenshot for particular web element.
	 * 
	 * @param element
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String screenshotForWebElement(WebElement element, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) element;
		File src = ts.getScreenshotAs(OutputType.FILE);

		JavaUtility ju = new JavaUtility();
		String currentDate = ju.modifiedDate();

		File dest = new File("./screenshots/" + currentDate + screenshotName + ".png");
		FileHandler.copy(src, dest);

		// extent report
		return dest.getAbsolutePath();
	}

	/**
	 * This method is used to upload the file
	 * 
	 * @param path
	 * @param element
	 */
	public void fileUpload(String path, WebElement element) {
		File f = new File(path);
		String absPath = f.getAbsolutePath();
		element.sendKeys(absPath);
	}

	/**
	 * This method is used to scroll the web page until a particular web element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollTheWebpage(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int Y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0," + Y + ")", element);
	}

}
