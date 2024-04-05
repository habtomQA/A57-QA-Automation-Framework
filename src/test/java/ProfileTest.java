
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        //login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickOnLoginBtn();
        Thread.sleep(2000);
        //click on avatar icon to navigate to profile
        clickOnAvatarIcon();
        Thread.sleep(2000);
        //generate random name for profile
        String randomName = generateRandomName();
        Thread.sleep(2000);
        System.out.println("Random name is: "+randomName);
        Thread.sleep(2000);
        //provide current password
        provideCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        //provide new generated name
        provideProfileName(randomName);
        Thread.sleep(2000);
        //click on save button
        clickOnSaveBtn();
        Thread.sleep(2000);
        //Assertion (actual vs expected)

    }


    public void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");//adkskldjsad23dmdj
    }
    public void provideCurrentPassword(String currentPassword) {
        WebElement currentPasswordField= driver.findElement(By.cssSelector("input[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public void provideProfileName(String newProfileName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("input[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newProfileName);
    }
    public void clickOnSaveBtn() {
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
    }

}

