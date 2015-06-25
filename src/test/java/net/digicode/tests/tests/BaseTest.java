package net.digicode.tests.tests;

import model.User;
import model.UserFactory;
import net.digicode.tests.steps.LoginSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.GmailUtils;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/**
 * Created by WWW on 21.06.2015.
 */
public abstract class BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public final User user = UserFactory.getExisingUser();

    @Managed
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public LoginSteps loginSteps;

    @Before
    public void createUser(){
        webdriver.manage().deleteAllCookies();
        final String email = user.getEmail();
        boolean isUserExist =  GmailUtils.isUserExist(email);
        logger.info("User '{}' {} Exist", email, isUserExist?"":"not");
        assumeTrue(String.format("User with email %s not exist", email), isUserExist);


        // TODO : will be implemented
        /*
        if (!isUserExist){
            GmailUtils.registerUser(user);
        }
          */
    }



}
