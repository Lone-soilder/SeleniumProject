package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreated {
	
	WebDriver driver;
	
	public AccountCreated(WebDriver driver) {
		this.driver = driver;
	}
	
	By continueBtn = By.xpath("//a[@data-qa ='continue-button']");
	
	public String getSuccessMessage() {
		return driver.findElement(By.xpath("//h2[@data-qa = 'account-created']")).getText();	
	}
	
	public void clickOnContinue() {
		
		//using external wait to avoid "element is not clickable issue" which doesn't work
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
		
		//I am going try using JS executor to scroll down the page
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
//		driver.findElement(continueBtn).click();
	}

}
