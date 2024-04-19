package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class CommonActionsPage extends BaseFunctions {
    public CommonActionsPage() {
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

    public static By actionBtn = MobileBy.id("com.fivemobile.thescore:id/action_button_text");

    public void clickOnActionButton() {
        mobileElementClick(actionBtn);
    }
}
