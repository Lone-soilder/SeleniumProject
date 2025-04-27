package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount {

	WebDriver driver;
	
	public DeleteAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountDeleteMessage() {
		return driver.findElement(By.xpath("//h2[@data-qa ='account-deleted']")).getText();
	}
	
	public void clickContinue() {
		driver.findElement(By.xpath("//a[@data-qa ='continue-button']")).click(); 
	}
}
