import org.openqa.selenium.*;
import java.io.File;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import io.qameta.allure.*;

public class Locators {
    WebDriver driver;


    Locators(WebDriver driver) {
        this.driver = driver;
    }
    //Локаторы
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By checkBoxMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]");
    By userNumber = By.id("userNumber");
    By dateOfBirthInput = By.id("dateOfBirthInput");
    By selectMounth = By.className("react-datepicker__month-select");
    By mounth = By.cssSelector("[value='11']");
    By selectYear = By.className("react-datepicker__year-select");
    By year = By.cssSelector("[value='2002']");
    By day = By.cssSelector("[aria-label='Choose Thursday, December 5th, 2002']");
    By subject = By.id("subjectsInput");
    By hobbies = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]");
    By file = By.className("form-control-file");
    By selectState = By.id("react-select-3-input");
    By city = By.id("react-select-4-input");
    By submit = By.id("submit");

    //Методы

    public void imputFirstName(String firstNameV) {
        driver.findElement(firstName).sendKeys(firstNameV);
    }

    public void imputLastName(String lastNameV) {
        driver.findElement(lastName).sendKeys(lastNameV);
    }

    public void imputUserEmail(String userEmailV) {
        driver.findElement(userEmail).sendKeys(userEmailV);
    }

    public void clickCheckBoxMale() {
        Duration duration = Duration.ofSeconds(10); //Pflf
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxMale));
        driver.findElement(checkBoxMale).click();
    }

    public void imputUserNumber() {
        driver.findElement(userNumber).sendKeys("9605270537");
    }

    public void clickDateOfBirthInput() {
        driver.findElement(dateOfBirthInput).click();
    }

    public void clickSelectMounth() {
        driver.findElement(selectMounth).click();
    }

    public void clickMounth() {
        driver.findElement(mounth).click();
    }

    public void clickSelectYear() {
        driver.findElement(selectYear).click();
    }

    public void clickYear() {
        driver.findElement(year).click();
    }
    public void clickDay() {
        driver.findElement(day).click();
    }
    public void imputSubject() {
        driver.findElement(subject).sendKeys("Предмет");
    }
    public void clickHobbies() {
        WebElement element = driver.findElement(hobbies);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }

    public void inputFile() throws URISyntaxException {
        ClassLoader classLoader = Locators.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("JAVA.docx");
        File fileF = new File(resourceUrl.toURI());
        String filePath = fileF.getAbsolutePath();
        System.out.println(filePath);
        driver.findElement(file).sendKeys(filePath);
    }
    public void clickSelectState() {
        driver.findElement(selectState).sendKeys("NCR", Keys.ENTER);
    }
    public void clickCity() {
        driver.findElement(city).sendKeys("del", Keys.ENTER);
    }
    public void clickSubmit() {
        driver.findElement(submit).click();
    }
}
