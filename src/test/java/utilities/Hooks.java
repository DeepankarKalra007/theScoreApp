package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Hooks extends BaseFunctions {

    @BeforeTest
    public void before() {
        initializeMobileSession();
    }

    @AfterTest
    public void setUpAfter() {
        closeMobileSession();
    }
}
