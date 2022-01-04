package test.IntegrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class UgKabelTest {
    public static WebDriver driver;
    public static final String UG_URL = "https://yugkabel.ru/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(UG_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteCookie(new Cookie("PHPSESSID", "G2OMYSB1rV9XmghE1oCtbuKd0WV9QJbU"));
        driver.manage().addCookie(new Cookie("PHPSESSID", "C7yFrMVh9NMXZE1GOSYE5MgBm3mVG7l1"));
        driver.navigate().refresh();

        //driver.findElement(By.xpath("//div[@class='right']//a[.='Личный кабинет']")).click();

        //login();

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//section//span[.='Кабель и провод']")))
                .build()
                .perform();

        driver.findElement(By.xpath("//ul[@class='second-lvl']//a[.='Кабель NYM']")).click();

        driver.quit();
    }

    public static void login(){
        driver.findElement(By.xpath("//input[@data-placeholder='pokupatel@gmail.com']"))
                .sendKeys("zerggranat@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='pass']")).sendKeys("Qwedsa1254");
        driver.findElement(By.xpath("//button[1][.='войти']")).click();
    }
}
