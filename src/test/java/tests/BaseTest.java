package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.out.println("Before Suite Annotation");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void init() {
        System.out.println("Before Method Annotation");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
