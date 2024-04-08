import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist(){
        provideEmail("habtom.fesseha@testpro.io");
        providePassword("Econ@99336");
        clickLoginBtn();
        openPlaylist();
        clickOnDeletePlaylistBtn();
        getDeletedPlaylistMsg();
        String expectedDeletedPlaylistMsg ="Deleted playlist \"Homework20.\"";

        Assert.assertEquals(getDeletedPlaylistMsg(),expectedDeletedPlaylistMsg);

    }
    public void openPlaylist(){
        WebElement playlist=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(17)")));
        playlist.click();
    }
    public void clickOnDeletePlaylistBtn(){
        WebElement deletePlaylistBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();

    }
    public String getDeletedPlaylistMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
