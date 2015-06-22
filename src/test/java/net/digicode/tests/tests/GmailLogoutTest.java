package net.digicode.tests.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.GmailUtils;

import static org.junit.Assume.assumeTrue;

/**
 * Created by WWW on 21.06.2015.
 */
@RunWith(SerenityRunner.class)
public class GmailLogoutTest extends BaseTest{

    @Before
    public void login(){
       loginSteps.login(user);
    }

    @Test
    public void logoutTest(){
        loginSteps.logout();
        loginSteps.verify_user_sign_out(user);
    }

}
