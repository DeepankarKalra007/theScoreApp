package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class EmailSignUpPage extends BaseFunctions {
    public EmailSignUpPage() {
        super();
        PageFactory.initElements(appiumDriver, this);
    }

    public static By maybeLaterBtn = MobileBy.id("com.fivemobile.thescore:id/btn_secondary");

    public void clickOnMaybeLaterBtn() {
        mobileElementClick(maybeLaterBtn);
    }

}
