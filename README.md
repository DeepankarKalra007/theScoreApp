# Appium-The Score App
`This Appium, Selenium framework is based on Java along with Maven and TestNG`

# Short Description:
Built a Appium, Selenium, Java, Maven, TestNG framework. Followed Page Object model approach.
BaseFunctions class kept functions like click, getText, getElementList, etc that were used in other classes that will extend this class.
Created a Page Object class for every page/screen you see in the Score App, during the test case.
AppiumDriverEx class was created for solely setting capabilities and emulator or phone connection and to keep the instance of Appium driver consistant throughout the project.
PropertyFileHandler class was created to get the data from data.properties file which was further used in the test case.
SwipeAction logic was also created in BaseFunctions class to be able to swipe horizontally or vertically for the test case.
Logics were added for verification and multi selection of leagues and teams mentioned in the app.
Finally, run the automated test case from the ScoreApp test class.

# Prerequisites
1. Appium Desktop Client GUI Server
2. Appium Inspector
3. Appium Doctor (optional)
4. Java 8
5. Maven
6. Android Studio
7. IntelliJ or Eclipse IDE
8. Emulated device or Physical device

# Appium Desktop Client GUI Server Installation
1. Download the appium desktop client -> "Appium-Server-GUI-windows-1.22.3-4.exe"  
   Documentation -> http://appium.io/  
   Link -> https://github.com/appium/appium-desktop/releases
2. Download the exe file
3. Run the installer
4. Start appium through Appium GUI Server

# Appium Inspector Installation
1. Download the "Appium-Inspector-windows-2023.8.4.exe"  
   Link -> https://github.com/appium/appium-inspector/releases
2. Download the exe file
3. Run the installer
4. Start appium session through Appium Inspector app

# Appium Doctor Installation - (optional)
To check appium installation and dependencies
1.	`install appium-doctor`  
      Link -> https://github.com/appium/appium-doctor
2. `npm install appium-doctor -g`
3. `appium-doctor -h`  
   `appium-doctor --version`  
   `appium-doctor -android`

# Java 8 Installlation
Link -> https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html

# Maven Installation
Link -> https://maven.apache.org/download.cgi

# Android Studio Installation
Link -> https://developer.android.com/

# IntelliJ IDE Installation
Link -> https://www.jetbrains.com/idea/download/

# Eclipse IDE Installation
Link -> https://eclipseide.org/

# How To Connect emulated device On Windows
`Prerequisites:`
1. `Android Studio` installed on your system
2. `ANDROID_HOME`, `ANDROID_SDK_ROOT` is set in environment variables

`Things for emulated device setup: `
1. Make device ready, Start the avd session from android studio, Make the emulated device up.
2. Check adb devices for list of available devices in cmd  
   `adb devices`

# How To Connect physical device On Windows
`Prerequisites:`
1. Java installed on your system
2. `JAVA_HOME` is set in environment variables   
    `java --version`
3. An android mobile device
4. Connecting cable (For external device)
5. 200 MB ~ 1 GB free space

`Things for physical device setup: `
1. Make device ready, enable developer mode (Search for Build Number in settings, tap 5 times on Build Number to enable developer mode. Search for Developer Mode in settings, enable "USB debugging" ON)
2. Connect device to your computer system through USB cable
3. Check adb devices for list of available devices in cmd  
   `adb devices`
4. Get the appPackage, appActivity with the help of applications like APK info(available on Playstore)

# Framework setup
1. Create a Maven Project
2. Add Libraries/Dependencies in POM.xml file  
   `java-client -> "7.5.1"`,  
   `selenium-java -> "3.141.59"`,  
   `guava -> "30.1.1-jre"`,  
   `commons-lang3 -> "3.12.0"`,  
   `commons-io -> "2.8.0"`,  
   `testng -> "7.1.0"`,      
   `commons-configuration2 -> "2.9.0"`,   
   `poi -> "5.2.2"`,  
   `poi-ooxml -> "5.2.2"`,  
   `log4j-api -> "2.18.0"`,

3. Connect device  
   `adb devices`
4. Start appium server  
   `can be start via cmd line or via appium desktop client`
5. Add code to start automation on mobile device  
   `Set desired capabilities`  
   `deviceName`  
   `udid`  
   `platformName`  
   `platformVersion`  
   `appPackage`  
   `appActivity`
6. Appium Server URL(local Host) - http://127.0.0.1:4723/wd/hub

# Framework Description
This framework consist of packages such as `pages`, `testcases`, `utilities` and `resources`.  
`pages` consist of mobile pages for locating elements and performing actions.  
`testCases` consist of mobile related tests.  
`utilities` consist of Java classes such as `AppiumDriverEx` for appium driver session, `BaseFunctions` for defining basic framework functions, `Hooks` for Before and After test hooks, `PropertyFileHandler` for reading the properties file.  
`resources` consist of `data.properties` for test data and the `theScore.apk` file.

# How to Run the testcases
Open the `ScoreTest.java` class from package testCases, and run it as TestNG.