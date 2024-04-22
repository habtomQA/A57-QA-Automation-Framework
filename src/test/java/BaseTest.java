import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver=null;



//Setting up WebDriverManager for chrome before the test suite runs
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    //Method to set up WebDriver with chrome options before each test method.
@BeforeMethod
@Parameters("baseUrl")
public void launchBrowser(String baseUrl){
        //Configuring chrome options for local testing
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--incognito","--start-maximized","-lang=en","--remote-allow-origins=*");

        driver=new ChromeDriver(options);
        //configuring implicit wait for the driver and navigating to the specified URL.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage(baseUrl);

}
    public void navigateToPage(String baseUrl) {
        driver.get(baseUrl);

    }
    //Method for performing login action with provided email and password.
    public void login(String email, String password){
        //Locating email, password, and login button elements and performing login action.
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /*public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }*/
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}