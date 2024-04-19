package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class GetStartedPage extends BaseFunctions {

    public GetStartedPage() {
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

//    public static By getStartedBtn = MobileBy.id("action_button_text");
    // Since the above button is now kept in CommonActionsPage, there is no need for this entire class
//    public static By loginBtnSelByID = MobileBy.AccessibilityId("button-LOGIN");
//    public static By signUpBtnSelByXPATH = MobileBy.xpath("//*[@text='SIGN UP']");

//    public void clickOnGetStartedButton(){
//        mobileElementClick(getStartedBtn);
//    }
}
