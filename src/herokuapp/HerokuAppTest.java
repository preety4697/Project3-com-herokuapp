package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HerokuAppTest {
    static String browser = "Chrome";
    static String baseurl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Set up the Chrome browser
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseurl);

        //open the url into the browser
        driver.get(baseurl);
        Thread.sleep(4000);

        //Maximize the browser
        driver.manage().window().maximize();

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        // Get the page source code
        System.out.println(driver.getPageSource());

        //Enter the email to email field
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        Thread.sleep(5000);

        //Enter the password to password field
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("SuperSecretPassword!");
        Thread.sleep(5000);

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(5000);

        //Get the current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        driver.navigate().refresh();

        //Close the browser
        driver.quit();






    }
}
