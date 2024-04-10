import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlaylistName="Homework21";
    @Test
    public void renamePlaylist()  {
        String updatedPlaylistSuccessMsg="Updated playlist \"Homework21.\"";
        provideEmail("habtom.fesseha@testpro.io");
        providePassword("Econ@99336");
        clickLoginBtn();

        doubleClickOnSelectedPlaylist();


        enterNewPlaylistName();

        getUpdatedPlaylistNameSuccessMsg();

        Assert.assertEquals(getUpdatedPlaylistNameSuccessMsg(),updatedPlaylistSuccessMsg);
    }
    public void doubleClickOnSelectedPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement playlistField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

        playlistField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistField.sendKeys(newPlaylistName);
        playlistField.sendKeys(Keys.ENTER);
    }
    public String getUpdatedPlaylistNameSuccessMsg(){
        WebElement notification=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
