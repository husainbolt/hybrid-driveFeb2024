package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ControlActions;

public class LoginPage extends ControlActions {
	
	public void login(String email, String password) {
		System.out.println("Step 1 - Enter Email Address");
		driver.findElement(By.id("userEmail")).sendKeys(email);
		
		System.out.println("Step 2 - Enter Password");
		driver.findElement(By.id("userPassword")).sendKeys(password);
		
		System.out.println("Step 3 - Clicked on Login Button");
		driver.findElement(By.id("login")).click();
	}
	
	public boolean isLoginSuccessfull() {
		WebElement loginMessage = getElement("XPATH", "//div[@aria-label='Login Successfully']", true);
		return loginMessage.isDisplayed();
	}
}
