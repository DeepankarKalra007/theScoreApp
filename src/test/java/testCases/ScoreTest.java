package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseFunctions;
import utilities.PropertyFileHandler;

public class ScoreTest extends BaseFunctions {

    GetStartedPage getStartedPageObj = new GetStartedPage();
    ChooseYourFavouriteLeaguePage leaguePageObj = new ChooseYourFavouriteLeaguePage();
    ChooseYourFavouriteTeamPage teamPageObj = new ChooseYourFavouriteTeamPage();
    CommonActionsPage actionPageObj = new CommonActionsPage();
    EmailSignUpPage signUpPageObj = new EmailSignUpPage();
    TailoredContentPage tailoredContentPageObj = new TailoredContentPage();
    HomePage homePageObj = new HomePage();

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
        initializeMobileSession();
    }

    @AfterMethod
    public void afterSetUp() {
        System.out.println("After Method");
        closeMobileSession();
    }

    @Test()
    public void userLogin() {

        actionPageObj.clickOnActionButton();
//      leaguePageObj.chooseYourFavouriteLeague("NHL Hockey"); //App breaks on setting up NHL Hockey
        leaguePageObj.chooseYourFavouriteLeague(PropertyFileHandler.readProperty("league"));
        actionPageObj.clickOnActionButton();
        tailoredContentPageObj.verifyTailoredContentLabel();

        //Built below concept because in pixel fold emulator, Tailored content page popup would show in automation run and not in manual testing
        //On changing the emulator figured that popup had other options and actions could be performed on it
        //Also tried to change the port for appium server as thought that this test had some finite number of runs allowed as per the app, as app might have some blocking automation feature
        //Also tried to change the apk file, version of the app
        //Because of above though process tried to use another emulator and could see the popup, which was a fix in itself
//        if(n == 1){  //If App breaks on setting up NHL Hockey
//            System.out.println("Value of n after tailored function: " + n);
//            actionPageObj.clickOnActionButton();
//
//            leaguePageObj.chooseYourFavouriteLeague(PropertyFileHandler.readProperty("leagueNew"));
//
//            actionPageObj.clickOnActionButton();
//        }
        //Commented above steps, because now we have the new emulator for a phone where the popUp loads

        teamPageObj.chooseYourFavouriteTeam(PropertyFileHandler.readProperty("team"));
        actionPageObj.clickOnActionButton();
        actionPageObj.clickOnActionButton();
        signUpPageObj.clickOnMaybeLaterBtn();
        homePageObj.clickOnClosePopUpButton();
        homePageObj.verifyYourFavouriteTeams();
        homePageObj.verifyYourFavouriteLeagues();

    }
}
