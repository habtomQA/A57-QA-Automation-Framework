import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void loginValidEmailValidPassword()throws InterruptedException{
        //navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickOnLoginBtn();
        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
        System.out.println("Just testing console");
    }
   /* @Test
    public void loginValidEmailInvalidPassword()throws InterruptedException{
        //navigateToPage();
        provideEmail("demo@class.com");
        providePassword("invalid");
        clickOnLoginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just testing console");
    }
    @Test
    public void loginValidEmailEmptyPassword()throws InterruptedException{
        //navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickOnLoginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just testing console");
    }
    @Test
    public void loginEmptyEmailValidPassword()throws InterruptedException{
        //navigateToPage();
        provideEmail("");
        providePassword("te$t$tudent");
        clickOnLoginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just testing console");
    }*/
    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass =TestDataProvider.class)
    public void negativeLoginTest(String email, String password)throws InterruptedException{
        //navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickOnLoginBtn();
        Thread.sleep(2000);
        String url = "https://qa.koel.app/";
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just testing console");
    }
}
