import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
   // public String url="https://qa.koel.app/";



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }
   /*@BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();

    }


}
   public void navigateToPage(){

        driver.get(url);
    }*/
    @DataProvider(name="NegativeLoginTestData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail@class.com","invalid"},
                {"demo@class.com","invalid"},
                {"",""},
                {"invalidEmail@class.com","te$t$tudent"},


        };
    }
   @BeforeMethod
   @Parameters({"BaseURL"})
   public void launchBrowser(String baseURL){
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver =new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       //String url=BaseURL;
       navigateToPage(baseURL);

   }



public void navigateToPage(String url){

    driver.get(url);
}

    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginBtn(){
        WebElement submit= driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }
    @AfterMethod
    public void closeBrowser(){driver.quit();}

}
