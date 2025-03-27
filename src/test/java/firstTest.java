import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import io.qameta.allure.*;

public class firstTest {
    WebDriver driver;
    Locators locators;
    RandomUtils randomUtils;


    @BeforeTest
    public void before() throws URISyntaxException {
        ClassLoader classLoader = Locators.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("IEDriverServer.exe");
        File fileF = new File(resourceUrl.toURI());
        String filePath = fileF.getAbsolutePath();
        System.setProperty("WebDriver", filePath);
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless", "--disable-gpu");
WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        locators = new Locators(driver);
    }

    @Test(priority = 0, description = "Тестовый тест тестович")
    @Description("Тестовое описание")
    @Owner("Ананов Егор")
    @Severity(SeverityLevel.BLOCKER)
    public void firstTest() throws URISyntaxException {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String email = faker.internet().emailAddress();
        driver.get("https://demoqa.com/automation-practice-form");
        locators.imputFirstName(firstName);
        locators.imputLastName(lastName);
        locators.imputUserEmail(email);
        locators.clickCheckBoxMale();
        locators.imputUserNumber();
        locators.clickDateOfBirthInput();
        locators.clickSelectMounth();
        locators.clickMounth();
        locators.clickSelectYear();
        locators.clickYear();
        locators.clickDay();
        locators.imputSubject();
        locators.clickHobbies();
        locators.inputFile();
        locators.clickSelectState();
        locators.clickCity();
        locators.clickSubmit();
    }


}
