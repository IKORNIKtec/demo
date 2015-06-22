package net.digicode.tests.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://mail.google.com")
public class GmailLoginPage extends PageObject {

    @FindBy(id="Email")
    private WebElement emailField;

    @FindBy(id="Passwd")
    private WebElement passwordField;

    @FindBy(id="next")
    private WebElement nextButton;

    @FindBy(id="signIn")
    private WebElement signInButton;

    @FindBy(xpath="//*[contains(@class,'signin-card')]")
    private WebElement signInForm;

    @FindBy(id="PersistentCookie")
    private WebElement staySignedInChecjBox;



    public void enterEmail(String value) {
        emailField.sendKeys(value);
    }

    public void enterPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void submit() {
        signInButton.click();
    }

    public boolean isSignInPageDisplayed(){
        return signInForm.isDisplayed();
    }

    public void uncheckSignedIn(){
        if(staySignedInChecjBox.getAttribute("checked")!="false"){
            staySignedInChecjBox.click();
        }
    }

}