import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest{

    //Test #1 contextual click
    //@Test
    public void playSong() throws InterruptedException{
        //Background steps
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        //chooseAllSongs
        chooseAllSongsList();
        Thread.sleep(5000);
        //contextual click on the first song
        contextClickOnFirstSong();
        Thread.sleep(5000);
        //click on play from the menu
        choosePlayOption();
        Thread.sleep(5000);
        Assert.assertTrue(isPlaying());

    }
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
    public void contextClickOnFirstSong()throws InterruptedException{
        WebElement firstSongElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));

        actions.contextClick(firstSongElement).perform();
    }
    public void choosePlayOption()throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }
    public boolean isPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
    //////////////////////////////
    /////////////////////////////
    //Test 2- Mouse HoverOverPlayButton
    //@Test
    public void hoverOverPlayButton(){
        //Background step(precondition)

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        //Hover and verify
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    //Test 3- WebElements (Count playlist)
   // @Test
    public void countSongsInPlaylist() {
        //Background step(precondition)

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();
        choosePlaylistByName("Playlist Demo");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
        //Verifies if the playlist details song count is equal to the retrieved number of songs
    }
    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }
    public int countSongs(){
        //count Songs Inside playlist
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        //retrieve playlist details from playlist header (displays number of songs in playlist)
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public void displayAllSongs(){
        //prints all songs inside the playlist for demo purposes
        List<WebElement>songList= driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }
///////////////////////////
    ///////////////////////
    //Test #4 Double click

    String newPlaylistName="Sample Edited Playlist";
   @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg="Updated playlist \""+newPlaylistName+".\"";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();

        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement playlistInputField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
