package test.IntegrationTest;

import PageObject.LoginModal;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YugKabelTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    public static final String UG_URL = "https://yugkabel.ru/";

    @BeforeAll
    static void registerDrive() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 20);
        driver.get(UG_URL);
    }

    @Test
    @Description("negative login test")
    void negativeLoginTest() {
        driver.findElement(By.xpath("//div[@class='right']//a[.='Личный кабинет']")).click();
        new LoginModal(driver)
                .fillLogin("test")
                .fillPassword("test")
                .submitLogin();

        //TODO: добавить асерт на валидацию
    }

    @Test
    void authorisationTest() throws InterruptedException {
        login();

        //object not disable in DOM, until no working..
        //webDriverWait.until(ExpectedConditions.);
        //TODO: добавить неявное ожидание обьекта
        Thread.sleep(3000);
        //TODO: добавить кнопку выхода
    }

    @Test
    void testAuthCookie() throws InterruptedException {
        nonAuthorisationCookie();
        System.out.println(nonAuthorisationCookie());
        login();
        System.out.println("login ok");
        Thread.sleep(3000);
        authorisationCookie();
        System.out.println(authorisationCookie());
    }


    @Test
    void sectionCabelAndWireTest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//section//span[.='Кабель и провод']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//ul[@class='second-lvl']//a[.='Кабель NYM']")).click();
    }

    public static void authorisationWithCookie(Cookie NonAuthorisationCookie, Cookie authorisationCookie) {
        driver.manage().deleteCookie(NonAuthorisationCookie);
        driver.manage().addCookie(authorisationCookie);
        driver.navigate().refresh();
    }

    public static void login() {
        driver.findElement(By.xpath("//div[@class='right']//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//input[@data-placeholder='pokupatel@gmail.com']"))
                .sendKeys("zerggranat@gmail.com");
        driver.findElement(By.xpath("//input[1][@name='pass']")).sendKeys("Qwedsa1254");
        driver.findElement(By.xpath("//button[1][.='войти']")).click();

    }

    public Cookie nonAuthorisationCookie() {
        return driver.manage().getCookieNamed("PHPSESSID");
    }

    public Cookie authorisationCookie() {
        return driver.manage().getCookieNamed("PHPSESSID");
    }

    @AfterAll
    static void tearDown() {
        //driver.quit();
    }


}
