import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import io.qameta.allure.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.WebElement;

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

    @Step("Заполнение фамилии")
    public void imputFirstName(String firstNameV) {
        driver.findElement(firstName).sendKeys(firstNameV);
    }
    @Step("Заполнение имени")
    public void imputLastName(String lastNameV) {
        driver.findElement(lastName).sendKeys(lastNameV);
    }
    @Step("Заполнение email")
    public void imputUserEmail(String userEmailV) {
        driver.findElement(userEmail).sendKeys(userEmailV);
    }
    @Step("Выбор пола")
    public void clickCheckBoxMale() {
        Duration duration = Duration.ofSeconds(10); //Pflf
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxMale));
        driver.findElement(checkBoxMale).click();
    }
    @Step("Заполение номера")
    public void imputUserNumber() {
        driver.findElement(userNumber).sendKeys("9605270537");
    }
    @Step("Нажать на дату рождения")
    public void clickDateOfBirthInput() {
        driver.findElement(dateOfBirthInput).click();
    }
    @Step("Нажать на список месяцев")
    public void clickSelectMounth() {
        driver.findElement(selectMounth).click();
    }
    @Step("Выбор месяца")
    public void clickMounth() {
        driver.findElement(mounth).click();
    }
    @Step("Нажать на список годов")
    public void clickSelectYear() {
        driver.findElement(selectYear).click();
    }
    @Step("Выбор года")
    public void clickYear() {
        driver.findElement(year).click();
    }
    @Step("Выбор дня")
    public void clickDay() {
        driver.findElement(day).click();
    }
    @Step("Заполнить предмет")
    public void imputSubject() {
        driver.findElement(subject).sendKeys("Предмет");
    }
    @Step("Выбор хобби")
    public void clickHobbies() {
        WebElement element = driver.findElement(hobbies);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    @Step("Загрузка файла")
    public void inputFile() throws URISyntaxException {
//        ClassLoader classLoader = Locators.class.getClassLoader();
//        URL resourceUrl = classLoader.getResource("JAVA.docx");
//        File fileF = new File(resourceUrl.toURI());
//        String filePath = fileF.getAbsolutePath();
//        System.out.println(filePath);
//        driver.findElement(file).sendKeys(filePath);


        try {
            // Определяем место для сохранения файла (например, в папке target)
            File targetDir = new File("target/test-files");
            targetDir.mkdirs();
            File outputFile = new File(targetDir, "JAVA.docx");

            // Копируем файл из ресурсов
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("JAVA.docx")) {
                Files.copy(inputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            // Загружаем файл
            driver.findElement(file).sendKeys(outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file from resources", e);
        }
    }
    @Step("Выбор штата")
    public void clickSelectState() {
        driver.findElement(selectState).sendKeys("NCR", Keys.ENTER);
    }
    @Step("Выбор города")
    public void clickCity() {
        driver.findElement(city).sendKeys("del", Keys.ENTER);
    }
    @Step("Нажать на кнопку submit")
    public void clickSubmit() {
        driver.findElement(submit).click();
    }

    public static void takeScreenshot(WebDriver driver, String name) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        }
    }
}
