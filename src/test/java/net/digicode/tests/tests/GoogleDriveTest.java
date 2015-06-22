package net.digicode.tests.tests;

import net.digicode.tests.steps.DriveSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yecht.Data;

/**
 * Created by WWW on 21.06.2015.
 */
@RunWith(SerenityRunner.class)
public class GoogleDriveTest extends BaseTest{
    private final String folderName = "Movie" + System.currentTimeMillis();

    @Steps
    DriveSteps driveSteps;

    @Before
    public void login(){
        loginSteps.login(user);
    }

    @Test
    public void createFolderTest(){
        driveSteps.open();
        driveSteps.click_new_button();
        driveSteps.select_folder_item();
        driveSteps.type_folder_name(folderName);
        driveSteps.click_create_button();
        driveSteps.verify_folder_exists(folderName);
    }

    @After
    public void deleteFolder(){
        driveSteps.delete_folder(folderName);
    }

}
