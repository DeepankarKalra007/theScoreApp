package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BaseFunctions {

    public static AppiumDriver<MobileElement> appiumDriver; //created object for Appium Driver
    Properties prop;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;

//    public static int n = 0;
    //Above variable was initialized to capture whether we see the tailored content popUp or not, with new emulator, this concept is not required

    protected void hardwait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeMobileSession() {
        logMessage("*********************** Mobile Session Started ****************************");
        //AppiumDriverEx class was used to setup and initialize appiumDriver, because it is best to keep the setup separate
        //Created object of AppiumDriverEx to get the appiumDriver
        //Because of below line, any other class that extends BaseFunctions, and tries to call appiumDriver, it will get a null value
        //However, it will have the appiumDriver instance
        //We get the instance of appiumDriver from AppiumDriverEX class, if any other class extends BaseFunctions Class, it will have the same appiumDriver instance, but it will not be able to initialize it again
        //if we called this function in any other class, then it would have created another instance AppiumDriver, and the older instance would have been lost
        appiumDriver = new AppiumDriverEx().getAppiumDriver();
    }

    public static void closeMobileSession() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            logMessage("*********************** Mobile Session closed *****************************");
        }
    }

    public static void logMessage(String msg) {
        Reporter.log(msg, true);
    }

    public void waitForMobileElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void mobileElementClick(By elementToken) {
        waitForMobileElementToBeVisible(elementToken);
        hardwait(1);
        appiumDriver.findElement(elementToken).click();
    }

    protected WebElement mobileElement(By elementToken) {
        waitForMobileElementToBeVisible(elementToken);
        hardwait(1);
        return appiumDriver.findElement(elementToken);
    }

    protected void mobileElementSendKeys(By elementToken, String text) {
        waitForMobileElementToBeVisible(elementToken);
        appiumDriver.findElement(elementToken).sendKeys(text);
    }

    protected String mobileElementGetText(By elementToken) {
        waitForMobileElementToBeVisible(elementToken);
        return appiumDriver.findElement(elementToken).getText();
    }

    protected void mobileElementScrollIntoView(String visibleText) {
        appiumDriver
                .findElement(MobileBy
                        .AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
    }

    protected void mobileElementScrollIntoViewHorizontal(String visibleText) {
        appiumDriver
                .findElement(MobileBy
                        .AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
    }

    public List<MobileElement> mobileElementList(By elementToken) {
        List<MobileElement> listOfMobileElements = appiumDriver.findElements(elementToken);
        return listOfMobileElements;
    }

    public void swipe() {
        touchAction = new TouchAction(appiumDriver);
        //Get the mobile screen sizes
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 15 * screenHeight / 100;
        int yEndPoint = yStartPoint;//316,490    448,998

        //Perform the touch actions
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

    }

    public void swipeRight(int times) {
        swipe();
        for (int initTime = 0; initTime < times; initTime++) {
            touchAction
                    .press(endPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(startPoint).release()
                    .perform();
        }
    }

    public void swipeLeft(int times) {
        swipe();
        for (int initTime = 0; initTime < times; initTime++) {
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(endPoint).release()
                    .perform();
        }
    }
}

