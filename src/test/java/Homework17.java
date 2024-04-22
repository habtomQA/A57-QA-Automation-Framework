import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String nameSong = "take my hand";
        String namePlaylist = "Homework17";
        String expectedSongAddedMessage = "Added 1 song into \"" + namePlaylist + ".\"";

        login("habtom.fesseha@testpro.io", "Econ@99336");
        Thread.sleep(2000);
        searchSong(nameSong);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist(namePlaylist);

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }
    public void searchSong(String nameSong) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(nameSong);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist(String playlistName) throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]"));
        playlist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}

