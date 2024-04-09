package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    //Constructors
    public HomePage(WebDriver givenDriver){
        super(givenDriver);

    }
    //Locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    //Methods

    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }
}
