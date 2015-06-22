package net.digicode.tests.tests;

import model.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by WWW on 21.06.2015.
 */
@RunWith(SerenityRunner.class)
public class GmailLoginTest extends BaseTest{

    @Test
    public void loginTest(){
        loginSteps.open_login_page();
        loginSteps.enter_email(user.getEmail());
        loginSteps.click_next_button();
        loginSteps.uncheckSignedIn();
        loginSteps.enter_password(user.getPassword());
        loginSteps.click_submit_password();
        loginSteps.verify_user_logged_in(user);
    }

}
