import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class RegistrationTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(RegistrationTest.class);
    //-Dbrowser (параметры браузера) -Doption (стратегия загрузки страницы)
    String env = System.getProperty("browser", "chrome");
    String st = System.getProperty("option", "NORMAL");

    @BeforeEach
    public void setUp() {
        logger.info("Браузер = " + env);
        logger.info("Стратегия загрузки страницы = " + st);
        driver = WebDriverFactory.getDriver(env.toLowerCase(), st.toUpperCase());
        logger.info("Драйвер запущен");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }

    @Test
    public void positiveTest() {
        //Попытка пройти регистрацию с реальными данными, с положительным результатом
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Открыта страница https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameTextBox.sendKeys("Андрей");

        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameTextBox.sendKeys("Чернецов");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailTextBox.sendKeys("theseord@mail.ru");

        WebElement maleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        maleGenderRadio.click();

        WebElement femaleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
        //femaleGenderRadio.click();

        WebElement otherGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Other']"));
        //otherGenderRadio.click();

        WebElement mobileTextBox = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileTextBox.sendKeys("9608776366");

        WebElement dobTextBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dobTextBox.click();
        WebElement monthSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        monthSelector.click();
        monthSelector.sendKeys("April");
        monthSelector.click();
        WebElement yearSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        yearSelector.click();
        yearSelector.sendKeys("1999");
        yearSelector.click();
        WebElement daySelector = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, April 2nd, 1999']"));
        daySelector.click();

        WebElement sportHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        //sportHobbiesCheckBox.click();

        WebElement readingHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        readingHobbiesCheckBox.click();

        WebElement musicHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        musicHobbiesCheckBox.click();

        js.executeScript("window.scrollBy(0, 300);");

        WebElement stateMenu = driver.findElement(By.xpath("//div[@id='state']"));
        stateMenu.click();
        WebElement stateChoose = driver.findElement(By.xpath("//div[contains(text(),'NCR')]"));
        stateChoose.click();

        WebElement cityMenu = driver.findElement(By.xpath("//div[@id='city']"));
        cityMenu.click();
        WebElement cityChoose = driver.findElement(By.xpath("//div[contains(text(),'Noida')]"));
        cityChoose.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void buggyTest() {
        //Попытка пройти регистрацию, с, как мне кажется, невозможными данными, но с положительным результатом
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Открыта страница https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameTextBox.sendKeys("!@#$%^&");

        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameTextBox.sendKeys("!@#$%^&");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailTextBox.sendKeys("123@123.com");

        WebElement maleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        //maleGenderRadio.click();

        WebElement femaleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
        //femaleGenderRadio.click();

        WebElement otherGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Other']"));
        otherGenderRadio.click();

        WebElement mobileTextBox = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileTextBox.sendKeys("00000000000");

        WebElement dobTextBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dobTextBox.click();
        WebElement monthSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        monthSelector.click();
        monthSelector.sendKeys("July");
        monthSelector.click();
        WebElement yearSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        yearSelector.click();
        yearSelector.sendKeys("2100");
        yearSelector.click();
        WebElement daySelector = driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, July 15th, 2100']"));
        daySelector.click();

        WebElement sportHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        //sportHobbiesCheckBox.click();
        WebElement readingHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        //readingHobbiesCheckBox.click();

        WebElement musicHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        //musicHobbiesCheckBox.click();

        js.executeScript("window.scrollBy(0, 300);");

        WebElement stateMenu = driver.findElement(By.xpath("//div[@id='state']"));
        stateMenu.click();
        WebElement stateChoose = driver.findElement(By.xpath("//div[contains(text(),'Rajasthan')]"));
        stateChoose.click();

//        WebElement cityMenu = driver.findElement(By.xpath("//div[@id='city']"));
//        cityMenu.click();
//        WebElement cityChoose = driver.findElement(By.xpath("//div[contains(text(),'Jaipur')]"));
//        cityChoose.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void emptyTest() {
        //Попытка пройти регистрацию без ввода каких-либо данных
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Открыта страница https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 300);");

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wrongCityTest() {
        //Попытка пройти регистрацию с ошибкой соответствия штата и города
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Открыта страница https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameTextBox.sendKeys("Андрей");

        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameTextBox.sendKeys("Чернецов");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailTextBox.sendKeys("theseord@mail.ru");

        WebElement maleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        //maleGenderRadio.click();

        WebElement femaleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Female']"));

        WebElement otherGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Other']"));

        WebElement mobileTextBox = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileTextBox.sendKeys("9608776366");

        WebElement dobTextBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dobTextBox.click();
        WebElement monthSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        monthSelector.click();
        monthSelector.sendKeys("April");
        monthSelector.click();
        WebElement yearSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        yearSelector.click();
        yearSelector.sendKeys("1999");
        yearSelector.click();
        WebElement daySelector = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, April 2nd, 1999']"));
        daySelector.click();

        WebElement sportHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));

        WebElement readingHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        readingHobbiesCheckBox.click();

        WebElement musicHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        musicHobbiesCheckBox.click();

        js.executeScript("window.scrollBy(0, 300);");

        WebElement stateMenu = driver.findElement(By.xpath("//div[@id='state']"));
        stateMenu.click();
        WebElement stateChoose = driver.findElement(By.xpath("//div[contains(text(),'Rajasthan')]"));
        stateChoose.click();
        //Попытка выбрать город, которого нет в штате Rajasthan
        //Ожидание: Тест падает, поскольку в штате Rajasthan нет города Agra
        WebElement cityMenu = driver.findElement(By.xpath("//div[@id='city']"));
        cityMenu.click();
        WebElement cityChoose = driver.findElement(By.xpath("//div[contains(text(),'Agra')]"));
        cityChoose.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void negativeTest() {
        //Попытка зафейлить регистрацию везде, где только можно (исключая город, тест просто упадет, если попытаться зафейлить там)
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Открыта страница https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        //firstNameTextBox.sendKeys("Андрей");

        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        //lastNameTextBox.sendKeys("Чернецов");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailTextBox.sendKeys("123123");

        WebElement maleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        //maleGenderRadio.click();

        WebElement femaleGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
        //femaleGenderRadio.click();

        WebElement otherGenderRadio = driver.findElement(By.xpath("//label[normalize-space()='Other']"));
        //otherGenderRadio.click();

        WebElement mobileTextBox = driver.findElement(By.xpath("//input[@id='userNumber']"));
        mobileTextBox.sendKeys("AAAAAAAAAAAAAAAAAAAA");

//        WebElement dobTextBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
//        dobTextBox.click();
//        WebElement monthSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//        monthSelector.click();
//        monthSelector.sendKeys("April");
//        monthSelector.click();
//        WebElement yearSelector = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//        yearSelector.click();
//        yearSelector.sendKeys("1999");
//        yearSelector.click();
//        WebElement daySelector = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, April 2nd, 1999']"));
//        daySelector.click();

        WebElement sportHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        //sportHobbiesCheckBox.click();

        WebElement readingHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        readingHobbiesCheckBox.click();

        WebElement musicHobbiesCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        musicHobbiesCheckBox.click();

        js.executeScript("window.scrollBy(0, 300);");

        WebElement stateMenu = driver.findElement(By.xpath("//div[@id='state']"));
        stateMenu.click();
        WebElement stateChoose = driver.findElement(By.xpath("//div[contains(text(),'NCR')]"));
        stateChoose.click();

        WebElement cityMenu = driver.findElement(By.xpath("//div[@id='city']"));
        cityMenu.click();
        WebElement cityChoose = driver.findElement(By.xpath("//div[contains(text(),'Noida')]"));
        cityChoose.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
