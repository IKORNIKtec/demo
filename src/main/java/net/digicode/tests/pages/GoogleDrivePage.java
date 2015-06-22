package net.digicode.tests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("https://drive.google.com")
public class GoogleDrivePage extends GmailBasePage {
    private String FOLDER_LOCATOR = "//*[contains(@class,'a-v')]//*[@aria-label='%s']";
    @FindBy(xpath="//*[@aria-label='New']")
    private WebElement newButton;

    // TODO : find stable locator
    //@FindBy(xpath="//*[@role='menu']/div[contains(.,'Folder')])")
    @FindBy(xpath="//*[contains(@class,'a-D-P')]")
    private WebElement folderItem;

    @FindBy(xpath = "//*[contains(@class,'kb-r-Mj f-Wh')]")
    private WebElement folderName;

    @FindBy(xpath = "//button[@name='ok']")
    private WebElement createButton;

    public void clickNewButton(){
        newButton.click();
    }

    public void clickFolderMenu(){
        folderItem.click();
    }

    public void typeFolderName(String value){
        folderName.sendKeys(value);
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public void deleteFolder(String value) {
        Actions actions = new Actions(getDriver());
        String locator = String.format(FOLDER_LOCATOR, value);
        element(locator).waitUntilVisible();
        WebElementFacade folder = find(org.openqa.selenium.By.xpath(locator));
        actions.contextClick(folder).perform();
        actions.sendKeys(Keys.END).sendKeys(Keys.ENTER).build().perform();
    }

    public boolean isFolderExist(String value) {
        String locator = String.format(FOLDER_LOCATOR, value);
        waitForPresenceOf(locator);
        return findAll(org.openqa.selenium.By.xpath(locator)).size()>0;
    }

}