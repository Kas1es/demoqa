import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class firstTest {
    WebDriver driver;
    Locators locators;
    RandomUtils randomUtils;


    @BeforeTest
    public void before() {
        System.setProperty("WebDriver", "C:\\\\Users\\\\Egor\\\\IdeaProjects\\\\Progect\\\\driver\\\\IEDriverServer.exe");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
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
