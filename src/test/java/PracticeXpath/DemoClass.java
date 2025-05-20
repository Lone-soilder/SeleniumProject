package PracticeXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.openqa.selenium.By.*;

public class DemoClass {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://selectorshub.com/xpath-practice-page/");

        //   //div/label[contains(text(),"Mobile Number")]//following::input[@name='mobile number']
        //  //h3[starts-with(text(),"Useful")]/following::div/button[@class="dropbtn"]
        //  //div[@class='imso_mh__scr-sep']/child::div[1]//div[1]/div[@class='imspo_mh_cricket__score-major']

        //driver.findElement(By.xpath("//div[@class='imso_mh__scr-sep']/child::div[1]//div[1]/div[@class='imspo_mh_cricket__score-major']")).getText();

        By toDoListXpath = xpath("//div[starts-with(@class,\"elementor-widget\")]/child::ul/li");

        List<WebElement> toDoList = driver.findElements(toDoListXpath);

        for(WebElement element: toDoList){
            System.out.println(element.getText());
        }

        if (toDoList != null) {
            driver.close();
            driver.quit();
        }
    }
}
