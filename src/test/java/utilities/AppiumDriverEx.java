package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {

    public static AppiumDriver<MobileElement> getAppiumDriver() {

        //Driver instance
        AppiumDriver<MobileElement> appiumDriver = null;

        try {
            //Set DesiredCapabilities to sent to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            //Tried initially with pixel fold emulator, and kept getting stuck at tailored content page, as was unable to scroll down and see it, screen would freeze as back button on the emulator device would nto work either
            //Because of above mentioned, created a new logic and page object class for Tailored Content Page and used that logic to reset app and re run it with different league selection
//            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"emulator-5556");
            desiredCapabilities.setCapability("appPackage", "com.fivemobile.thescore");
            desiredCapabilities.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

//            Below capability is used to install the apk file to the connected device for the first time
            desiredCapabilities.setCapability("app", "C:\\Users\\deepu\\IdeaProjects\\Appium-TheScoreApp\\src\\test\\resources\\theScore.apk");

            //Setup the Appium server url to connect to
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return appiumDriver;
    }
}
