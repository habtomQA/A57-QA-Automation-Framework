import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.FileLockInterruptionException;
import java.util.UUID;

public class ProfileTest extends BaseTest{
    @Test
    public void changeProfileName()throws InterruptedException {
        //Login To Koel
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(2000);
        //click on avatar Icon to navigate to profile
        clickOnAvatarIcon();
        Thread.sleep(2000);
        //Generate a random name
        String randomName=generateRandomName();
        System.out.println("Random name is: "+randomName);
        //current password
        provideCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        //Provide new generated name
        provideProfileName(randomName);
        Thread.sleep(2000);
        //click on save button
        clickOnSaveBtn();
        Thread.sleep(2000);
        //Assertion, actual Vs expected
        WebElement actualProfileName=driver.findElement(By.cssSelector("a.view-profile>span"));
        Thread.sleep(2000);
        Assert.assertEquals(actualProfileName.getText(),randomName);


    }
    public void clickOnAvatarIcon(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("_","");
        //adkskldjsad23dmdj
    }
    public void provideCurrentPassword(String currentPassword){
        WebElement profileName = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);

    }
    public void provideProfileName(String newProfileName){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(newProfileName);
    }
    public void clickOnSaveBtn(){
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
        saveBtn.click();
    }
}
