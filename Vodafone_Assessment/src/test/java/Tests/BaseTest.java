package Tests;

import Data.LoadProperties;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    public static SoftAssert softassert;
    public static String UserName= LoadProperties.UserData.getProperty("UserName");
    public static String Password= LoadProperties.UserData.getProperty("Password");
    @BeforeClass
    public static void SetupChromeDriver()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");


        softassert=new SoftAssert();
       WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.demoblaze.com/");
    }

    @AfterClass
    public static void QuitTest()
    {
        driver.quit();
    }
}
