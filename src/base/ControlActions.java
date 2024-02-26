package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ConstantFilePath;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropOperation;

public abstract class ControlActions {

	static protected WebDriver driver;
	private static PropOperation prop;

	static public void LaunchBrowser() {

		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		prop = new PropOperation(ConstantFilePath.ENV_FILEPATH);
		driver = new ChromeDriver(options);
		driver.get(prop.getValue("url"));
		driver.manage().window().maximize();
	}

	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement e = null;
		switch (locatorType.toUpperCase()) {

		case "XPATH":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				e = driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				e = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			else
				e = driver.findElement(By.id(locatorValue));
			break;
		case "NAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				e = driver.findElement(By.name(locatorValue));
			break;
		case "LINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			else
				e = driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIALLINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			else
				e = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASSNAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			else
				e = driver.findElement(By.className(locatorValue));
			break;
		case "TAGNAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			else
				e = driver.findElement(By.tagName(locatorValue));
			break;
		default:
			System.out.println("Incorrect locator type used");
		}
		return e;

	}

	public static void closeBrowser() {
		driver.quit();
	}

}
