package net.digicode.tests.steps;

import net.digicode.tests.pages.GoogleDrivePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.assertTrue;

public class DriveSteps extends ScenarioSteps {

    GoogleDrivePage drivePage;

    @Step
    public void open() {
        drivePage.open();
    }

    @Step
    public void click_new_button() {
        drivePage.clickNewButton();
    }

    @Step
    public void select_folder_item() {
        drivePage.clickFolderMenu();
    }

    @Step
    public void type_folder_name(String value) {
        drivePage.typeFolderName(value);
    }

    @Step
    public void click_create_button() {
        drivePage.clickCreateButton();
    }

    @Step
    public void verify_folder_exists(String folderName) {
        boolean isFolderExist = drivePage.isFolderExist(folderName);
        String message = String.format("Folder '%s' doesn't exist", folderName);
        assertTrue(message, isFolderExist);
    }

    @Step
    public void delete_folder(String folderName){
        drivePage.deleteFolder(folderName);
    }

}