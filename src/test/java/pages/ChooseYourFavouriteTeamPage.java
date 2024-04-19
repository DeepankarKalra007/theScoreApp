package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

public class ChooseYourFavouriteTeamPage extends BaseFunctions {
    public ChooseYourFavouriteTeamPage() {
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

//    public static By continueBtn = MobileBy.xpath("//android.widget.TextView[@text='Continue']");

    public void chooseYourFavouriteTeam(String team) {

        String[] list = team.split(",");
        for (int i = 0; i < list.length; i++) {
            System.out.println("List is: " + list[i]);
            mobileElementClick(MobileBy.xpath("//android.widget.TextView[@text='" + list[i] + "']"));
        }
    }
//    public void clickOnContinueButton(){
    // put this function is base as all clickable buttons up until homePage have same xpath
//        mobileElementClick(continueBtn);
//    }
}
