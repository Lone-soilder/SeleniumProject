package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	WebDriver driver;
	
	public Home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By signUpBtn = By.xpath("//*[text()=' Signup / Login']");
	
	public String getUrlHomePage() {
		return driver.getCurrentUrl();
	}
	public void clickOnSignup() {
		driver.findElement(signUpBtn).click();
	}
	
	public void clickOnDeleteAccount() {
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
		 try {
			 deleteBtn.click();
		 }catch (Exception e) {
			// TODO: handle exception
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
				deleteBtn.click();
		}
		
	}
	
}
