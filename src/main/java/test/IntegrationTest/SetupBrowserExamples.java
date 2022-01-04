package test.IntegrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox")
                .addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
        driver.manage().window().setSize(new Dimension(300,300));
        Thread.sleep(5000);
        driver.quit();
    }
}
