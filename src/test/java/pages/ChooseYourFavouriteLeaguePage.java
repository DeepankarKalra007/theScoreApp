package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class ChooseYourFavouriteLeaguePage extends BaseFunctions {
    public ChooseYourFavouriteLeaguePage(){
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

//    public static By continueBtn = MobileBy.xpath("//android.widget.TextView[@text='Continue']");
    //Continue button is now kept in CommonActionsPage as Action Button, since its common in all pages
//    public static By NHL_Hockey = MobileBy.xpath("//android.widget.TextView[@text='NHL Hockey']");
//    public static By NFL_Football = MobileBy.xpath("//android.widget.TextView[@text='NFL Football']");
//    public static By MLB_Baseball = MobileBy.xpath("//android.widget.TextView[@text='MLB Baseball']");
//    public static By NBA_Basketball = MobileBy.xpath("//android.widget.TextView[@text='NBA Basketball']");
//    public static By NCAA_Football = MobileBy.xpath("//android.widget.TextView[@text='NCAA Football']");
//    using String array below, we can click with a generalized xpath rather than ones needed above.

//    public static By loginBtnSelByID = MobileBy.AccessibilityId("button-LOGIN");
//    public static By signUpBtnSelByXPATH = MobileBy.xpath("//*[@text='SIGN UP']");

//    public void chooseYourFavouriteLeague(String league1,league2,league3,league4,league5){
//        switch (league1,league2,league3,league4,league5){
//            case "NHL Hockey","NFL Football","MLB Baseball","NBA Basketball","NCAA Football": mobileElementClick(NHL_Hockey);
////            case "NFL Football": mobileElementClick(NFL_Football);
////            case "MLB Baseball": mobileElementClick(MLB_Baseball);
////            case "NBA Basketball": mobileElementClick(NBA_Basketball);
////            case "NCAA Football": mobileElementClick(NCAA_Football);
//        } // First though of using if else, for the clicks , but needed to build logic so that whatever user selects, we should be able to select all those teams

    public void chooseYourFavouriteLeague(String league){
//        league = "NHL Hockey,NFL Football,MLB Baseball,NBA Basketball,NCAA Football";
        //Intially used to enter the value, which now will come from LoginTest which will further get from properties file in above statement

        String[] list = league.split(",");
        for(int i = 0; i < list.length; i++) {
                System.out.println("List is: " + list[i]);
                mobileElementClick(MobileBy.xpath("//android.widget.TextView[@text='"+list[i]+"']"));
            }
        }

//    public void clickOnContinueButton(){
//        mobileElementClick(continueBtn);
//    }
}