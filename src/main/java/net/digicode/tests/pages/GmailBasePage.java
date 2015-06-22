package net.digicode.tests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://mail.google.com")
public class GmailBasePage extends PageObject {

    @FindBy(xpath="//a[contains(@href,'https://accounts.google.com/SignOutOptions')]")
    private WebElement userInfo;

    @FindBy(xpath="//a[contains(@href,'https://mail.google.com/mail/logout')]")
    private WebElement signOutButton;

    public void clickUserInfo(){
        userInfo.click();
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }

    public String getUserInfo() {
        return userInfo.getText();
    }
}