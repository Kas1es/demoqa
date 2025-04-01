import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class firstTest {
    WebDriver driver;
    Locators locators;
    RandomUtils randomUtils;

    @BeforeMethod
    public void before() throws Exception {
     //    Настройка capabilities для браузера
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("127.0"); // или конкретная версия
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        selenoidOptions.put("enableLog", true);
        options.setCapability("selenoid:options", selenoidOptions);

        String selenoidUrl = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        driver = new  RemoteWebDriver(new URL(selenoidUrl), options);
        String url = System.getProperty("url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        locators = new Locators(driver);
    }


    @Test(priority = 0, description = "Тестовый тест тестович", groups = "TestTag")
    @Description("Тестовое описание")
    @Owner("Ананов Егор")
    @Severity(SeverityLevel.BLOCKER)
    public void firstTest()  throws Exception {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String email = faker.internet().emailAddress();
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
        //locators.inputFile();
        locators.clickSelectState();
        locators.clickCity();
        locators.clickSubmit();
        locators.takeScreenshot(driver, "Скрин");
    }
}
