import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test

    public void deletePlaylist() throws InterruptedException {
        //navigateToPage();
        provideEmail("habtom.fesseha@testpro.io");
        providePassword("Econ@99336");
        clickOnLoginBtn();
        openPlaylist();
        clickDeletePlaylistBtn();

        String expectedDeletedPlaylistMessage="Deleted playlist \"Homework19.\"";
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedDeletedPlaylistMessage);


    }
    public void openPlaylist() throws InterruptedException {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(17)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();

    }
}
