package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunctions;
import utilities.PropertyFileHandler;

public class HomePage extends BaseFunctions {

    String str = "";
    String str1 = "";
    String strTeam = "";

    public HomePage() {
        super();
        PageFactory.initElements(appiumDriver, this);
        //gets the instance of Appium Driver from super(BaseFunctions) class
    }

    public static By closePopUpBtn = MobileBy.id("com.fivemobile.thescore:id/dismiss_modal");
    //    public static By NHL_Hockey = MobileBy.xpath("//android.widget.TextView[@text='NHL']");
//    public static By NFL_Football = MobileBy.xpath("//android.widget.TextView[@text='NFL']");
//    public static By MLB_Baseball = MobileBy.xpath("//android.widget.TextView[@text='MLB']");
//    public static By NBA_Basketball = MobileBy.xpath("//android.widget.TextView[@text='NBA']");
//    public static By NCAA_Football = MobileBy.xpath("//android.widget.TextView[@text='NCAA']");
    //In below line, because AppiumDriver<MobileElement> is declared protected in utilities package, thus can't be accessed otherwise in Homepage in pages package
    //therefore changed in to public static in Base Functions
    //Also doing the above did not resolve the problem because we will need to call initializeMobileSession again, and that would create another instance of appiumDriver
    //therefore, we will need to create the below commented list in BaseFunctions only, and use a parameter to get the value
//    List<MobileElement> leagues = appiumDriver.findElements(MobileBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label']"));
    //Initially tried to use leagues and teams logic together, but teams all have TOR TOR TOR, so can not use Set for teams, but can use for leagues with scrollable horizontal
//Inital thought process to verify teams and leagues together
    //    public static By teamAndLeagues = MobileBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label']");
//    public static By teamAndLeagues2 = MobileBy.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label']");
    public static By teams = MobileBy.xpath("//android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/icon_team_logo']");
    public static By leagues = MobileBy.xpath("//android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/icon']");
    public static By teamName = MobileBy.id("com.fivemobile.thescore:id/team_name");
    public static By teamStatsTab = MobileBy.xpath("//android.widget.TextView[@text='TEAM STATS']");
    public static By teamStatsRankHeader = MobileBy.id("com.fivemobile.thescore:id/header_secondary_text");
    public static By leagueName = MobileBy.id("com.fivemobile.thescore:id/titleTextView");
    public static By backBtn = MobileBy.AccessibilityId("Navigate up");

    public void clickOnClosePopUpButton() {
        mobileElementClick(closePopUpBtn);
    }

    public void verifyYourFavouriteTeams() {
        for (int i = 0; i < mobileElementList(teams).size(); i++) {
            strTeam = strTeam + mobileElementList(teams).get(i).getText() + ",";
            mobileElementList(teams).get(i).click();
//                mobileElementGetText(teamName);
            //loop will run three times and compare the value sent from data.properties file with clicking on page and coming back to home page
            PropertyFileHandler.readProperty("team").contains(mobileElementGetText(teamName));
            mobileElementClick(teamStatsTab);
            waitForMobileElementToBeVisible(teamStatsRankHeader);
            mobileElement(teamStatsRankHeader).isDisplayed();
            mobileElementClick(backBtn);
        }
    }
    //Below function was initially designed to get all the teams and leagues from UI, store them in a string
    // add them in a string, separated by comma, then use string.split to put it into arraylists, add the arraylists
    //put them in a set, to remove the duplicates, but this approach stops because, teams have same name as TOR TOR TOR also
//    public void verifyYourFavouriteTeamAndLeagues(){
//        System.out.println("First for loop: ");
//        for(int i = 1; i < mobileElementList(teamAndLeagues).size(); i++) {
//            str = str + mobileElementList(teamAndLeagues).get(i).getText()+",";
//            System.out.println(mobileElementList(teamAndLeagues).get(i).getText());
//        }
//        swipeLeft(1);
////        mobileElementScrollIntoViewHorizontal("NHL");
//        System.out.println("After all the missing/hidden until scrolled to elements are visible: ");
//        hardwait(4);
//        for(int i = 1; i < mobileElementList(teamAndLeagues2).size(); i++) {
//            str1 = str1 + mobileElementList(teamAndLeagues2).get(i).getText() +",";
//            System.out.println(mobileElementList(teamAndLeagues2).get(i).getText());
//        }
//        hardwait(2);
//
//        System.out.println("STR: " + str);
//        System.out.println("STR1: " + str1);
//        str = str+str1;
//        System.out.println("Improved STR: " + str);
//    }

//    public void keepSwiping(){
//        swipe
//    }

    public void verifyYourFavouriteLeagues() {
        swipeLeft(1);
        for (int i = 0; i < mobileElementList(leagues).size(); i++) {
            mobileElementList(leagues).get(i).click();
            PropertyFileHandler.readProperty("league").contains(mobileElementGetText(leagueName));
            mobileElementClick(backBtn);
            hardwait(4);
            swipeLeft(1);
        }
    }
}
