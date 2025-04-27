package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

	WebDriver driver;
	
	public SignUp(WebDriver driver){
		this.driver = driver;
	}
	
	//xpath("//*[@id='days']"
	
	public void selectDateofbirth(String date , String month , String year) {
		WebElement day = driver.findElement(By.id("days"));	
		Select days = new Select(day);
		days.selectByValue(date);
		
		WebElement monthOption = driver.findElement(By.id("months"));
		Select monthOptions = new Select(monthOption);
		monthOptions.selectByVisibleText(month);
		
		WebElement yearOption = driver.findElement(By.id("years"));
		Select yearOptions = new Select(yearOption);
		yearOptions.selectByValue(year);	
	}
	
	
	
	By title1 = By.xpath("//input[@id= 'id_gender1' ]");
	By title2 = By.xpath("//input[@id= 'id_gender2' ]");
	
	By password = By.xpath("//input[@id= 'password']");
	
	//Address field information last_name
	
	By firstName = By.xpath("//input[@id= 'first_name']");
	By lastName = By.xpath("//input[@id= 'last_name']");
	By company = By.xpath("//input[@id= 'company']");
	By address = By.xpath("//input[@id= 'address1']");
	By address2 = By.xpath("//input[@id= 'address2']"); 
	By state = By.xpath("//input[@id = 'state']");
	By city = By.xpath("//input[@id= 'city']");
	By zipcode = By.xpath("//input[@id= 'zipcode']");
	By mobileNumber = By.xpath("//input[@id= 'mobile_number']");
	
	By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
	
	public void fillAllFields() {
		
		driver.findElement(title1).click();
		driver.findElement(password).sendKeys("@Kunu7381");
		driver.findElement(firstName).sendKeys("Biswajit");
		driver.findElement(lastName).sendKeys("Sahoo");
		driver.findElement(company).sendKeys("Wipro");
		driver.findElement(address).sendKeys("Puri");
		driver.findElement(address2).sendKeys("Bengaluru");
		
		WebElement country = driver.findElement(By.id("country"));
		Select countryOptions = new Select(country);
		countryOptions.selectByVisibleText("India");
		
		driver.findElement(state).sendKeys("Odisha");
		driver.findElement(city).sendKeys("Puri-1");
		driver.findElement(zipcode).sendKeys("752001");
		driver.findElement(mobileNumber).sendKeys("7381669979");
		selectDateofbirth("15", "January" , "2000");
	}
	
	public void createAccount() {
		driver.findElement(createAccountButton).click();
		
	}
}
