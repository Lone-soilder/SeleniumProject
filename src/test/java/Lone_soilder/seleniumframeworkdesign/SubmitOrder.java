package Lone_soilder.seleniumframeworkdesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

import org.junit.Assert;

public class SubmitOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-infobars");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		
		String productName = "Banarsi Saree";
		//implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//landing page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		
		//product catalog page
		ProductCatalogue productCatalogue = landingPage.loginApplication("biswajitsahoo2320@gmail.com","@Kunu7381");
		
		
		List<WebElement> products = productCatalogue.getProductList();
		
		WebElement prod =  products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		
		productCatalogue.addProductToCart(productName);
		
		//if some popup is coming as part of successful login/added to cart event 
		//and it disappear soon as a glimpse & you need to find it's id or locator by asking developer
		//we will use explicit wait to get it
		

		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
//		List<WebElement> cartProducts =driver.findElements(By.cssSelector(".cartSection h3"));
//		
//		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
//		
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		
		//check the product is there in the cart or not
		Assert.assertTrue(match); 
		
		// validation should not be inside page object class rather it should be in main class
		
		//if the product is available then check out.
		cartPage.goToCheckout();
		
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class , 'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action_submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
