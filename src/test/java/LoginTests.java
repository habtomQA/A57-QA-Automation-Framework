import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginTests extends BaseTest{
    @Test
    public void loginEmptyEmailPasswordTest() {
        LoginPage loginPage=new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("Econ@99336");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just Testing Console");

        //step 6: close browser
        driver.quit();
    }
    @Test

    public void loginValidEmailPasswordTest(){
LoginPage loginPage = new LoginPage(driver);
HomePage homePage = new HomePage(driver);

loginPage.provideEmail("habtom.fesseha@testpro.io");
loginPage.providePassword("Econ@99336");
loginPage.clickSubmitBtn();
       //Before avatarIcon was declared at the HomePage
      // WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        //After avatarIcon was declared at the HomePage
        Assert.assertTrue(homePage.getUserAvatar.isDisplayed());

        //step 6: close browser
        driver.quit();
    }

    @Test
    public void loginInvalidEmailPasswordTest()  {
        //pre-condition
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("invalidemail@class.com");
        loginPage.providePassword("Econ@99336");
        loginPage.clickSubmitBtn();




        //step 5: expected vs actual
        Assert.assertEquals(driver.getCurrentUrl(),url);

        //step 6: close browser
        driver.quit();


    }
}