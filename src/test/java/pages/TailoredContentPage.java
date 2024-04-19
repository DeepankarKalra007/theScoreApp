package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class TailoredContentPage extends BaseFunctions {
    public TailoredContentPage() {
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

    public static By tailoredContentLabel = MobileBy.xpath("//*[@text='Tailored Content']");
    public static By maybeLaterBtn = MobileBy.id("com.fivemobile.thescore:id/btn_disallow");

    public void verifyTailoredContentLabel() {
        if (mobileElement(tailoredContentLabel).isDisplayed()) {
//            hardwait(30);
//            n = 1; // This variable is declared in BaseFunctions for logic purpose
//            appiumDriver.resetApp(); //to reopen app and reset the app from beginning only if the app has not reached the Home Page point, in that case we will need to clear data for the app
            mobileElementClick(maybeLaterBtn);
        }
    }
}
