package net.digicode.tests.steps;

import model.User;
import net.digicode.tests.pages.GmailLoginPage;
import net.digicode.tests.pages.GmailMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.Alert;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class LoginSteps extends ScenarioSteps {

    GmailLoginPage loginPage;
    GmailMainPage mainPage;

    @Step
    public void open_login_page() {
        loginPage.open();
    }

    @Step
    public void enter_email(String email) {
        loginPage.enterEmail(email);
    }

    @Step
    public void enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void click_next_button() {
        loginPage.clickNext();
    }

    @Step
    public void click_submit_password() {
        loginPage.submit();
    }

    @Step
    public void login(User user) {
        loginPage.open();
        loginPage.enterEmail(user.getEmail());
        loginPage.clickNext();
        loginPage.uncheckSignedIn();
        loginPage.enterPassword(user.getPassword());
        loginPage.submit();
    }

    @Step
    public void verify_user_logged_in(User user) {
        String email = user.getEmail();
        final String message = String.format("User %s not logged in", email);
        boolean isUserLoggenIn = mainPage.getUserInfo().contains(email);
        assertTrue(message, isUserLoggenIn);
    }

    @Step
    public void verify_user_sign_out(User user) {
        final String message = String.format("User %s is 'Sign in' but should be 'Sign out'", user.getEmail());
        boolean isUserSignedOut = loginPage.isSignInPageDisplayed();
        assertTrue(message, isUserSignedOut);
    }

    @Step
    public void logout() {
        mainPage.clickUserInfo();
        mainPage.clickSignOutButton();
        acceptAlertIfPresent();

    }
    @Step
    public void uncheckSignedIn() {
        loginPage.uncheckSignedIn();
    }

    private void acceptAlertIfPresent(){
        try {
            mainPage.getAlert().accept();
        }catch (Exception e){ }
    }
}