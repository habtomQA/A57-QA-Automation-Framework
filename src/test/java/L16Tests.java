import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class L16Tests extends BaseTest{


    @Test(enabled = false,description = "Test skipped for a moment.")
    public void loginEmptyEmailPassword(String baseURL) {
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        String url ="BaseURL";
        driver.get(url);
        // Assert.assertEquals(driver.getCurrentUrl(),url);
        //driver.quit();

        WebElement emailField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys("");


        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");


        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();

    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url="BaseURL";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalidemail@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$tStudent");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);

        driver.quit();

    }

    @Test
    public void loginValidEmailPassword(String email, String password){
       // navigateToPage(String url);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();

        WebElement avatarIcon =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }




    @Test
    public void loginInvalidEmailPassword(String baseURL){
        //navigateToPage(String url);
        String url="BaseURL";
        provideEmail("invalidemail@class.com");
        providePassword("te$tStudent");
        clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }



  /*  public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

   /* public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void clickOnLoginBtn(){
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }*/

}
