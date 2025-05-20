package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

    public static WebDriver setUpDriver(  String browserName ) {
        System.out.println("browser name is " + browserName);
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        return driver;
    }
}
