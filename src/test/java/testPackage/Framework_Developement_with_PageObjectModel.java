package testPackage;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework_Developement_with_PageObjectModel extends TestSetup {
    
	@BeforeMethod
    public void setUpTest() {
        setUp();
    }
    
    @Test
    public void testFrameworkDevelopment() throws InterruptedException, IOException {
        login.openSite();
        login.simpleLogin("dineshlee.xd@gmail.com", "Dinesh@1994");
        login.handleOptions(new WebDriverWait(driver, Duration.ofSeconds(10)));
        login.clickThirdButtonWithDelay(new WebDriverWait(driver, Duration.ofSeconds(10)));
        login.scrollToMiddleOfPage();
        login.clickCheckoutButton();
        login.selectDropdownOption("11");
        login.selectSecondDropdownOption("22");
        login.enterTextInField2("2024");
        login.enterTextInField3("credit card");
        login.enterTextInField4("Thankyou");
        login.clickSubmitButton();
        login.enterTextInInputField3("India");
        login.selectDynamicDropdownOption("India");
        login.clickSubmitButton2();
        login.downloadReceipt();
        String screenshotPath = "C:\\Users\\DELL\\eclipse-workspace\\SeleniuM\\screenshot\\completed.png";
        login.takeScreenshotAndClose(screenshotPath);
        File screenshotFile = new File(screenshotPath);
        assertTrue(screenshotFile.exists()); // Asserting that the screenshot file exists
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}