package testPackage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	WebDriver driver;
	JavascriptExecutor jsExecutor;
		public LoginPage (WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.jsExecutor = (JavascriptExecutor) driver;
		}
		
		@FindBy(xpath = "//input[@id='userEmail']")
		WebElement userEmail;
		
		@FindBy(xpath = "//input[@id='userPassword']")
		WebElement userPassword;
		
		@FindBy(xpath = "//input[@id='login']")
		WebElement login;
		
		@FindBy(xpath = "//button[contains(@class,'btn-primary') and contains(text(),'Checkout')]")
	    List<WebElement> checkoutButtons;
		
		@FindBy(xpath = "(//select[contains(@class,'input')])[1]")
	    WebElement dropdown;
		
		@FindBy(xpath = "(//select[contains(@class,'input')])[2]")
	    WebElement dropdown2;
		
		@FindBy(xpath = "(//input[@type='text'])[2]")
	    WebElement inputField2;

	    @FindBy(xpath = "(//input[@type='text'])[3]")
	    WebElement inputField3;

	    @FindBy(xpath = "(//input[@type='text'])[4]")
	    WebElement inputField4;

	    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
	    WebElement submitButton;
	    
	    @FindBy(xpath = "(//input[contains(@class,'text-validated')])[3]")
	    WebElement inputField5;
	    
	    @FindBy(xpath = "//section[contains(@class,'list-group')]/button/span")
	    List<WebElement> dynamicDropdownOptions;
	    
	    @FindBy(xpath = "//a[contains(@class,'action__submit')]")
	    WebElement submitButton2;
	    
	    @FindBy(xpath = "//*[@class='hero-primary']")
	    WebElement completionMessage;

	    @FindBy(xpath = "(//button[contains(@class,'btn-primary')])[1]")
	    WebElement downloadButton;
		
	    
		public void simpleLogin(String enterEmail, String enterPassword)
		{
			userEmail.sendKeys(enterEmail);
			userPassword.sendKeys(enterPassword);
			login.click();
		}
		
		public void openSite()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		
		public void handleOptions(WebDriverWait wait) throws InterruptedException {
	        List<WebElement> allOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'mb-3')]")));
	        for (WebElement option : allOptions) {
	            if (option.getText().contains("ZARA COAT 3")) {
	                option.findElement(By.xpath("//button[contains(@class,'w-10')]")).click();
	            }
	            
	            Thread.sleep(2000);
	            
	            if (option.getText().contains("ADIDAS ORIGINAL")) {
	                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'w-10')])[2]")));
	                button.click();
	        }
	    }
	}
		

		
		public void clickThirdButtonWithDelay(WebDriverWait wait) throws InterruptedException {
	        Thread.sleep(2000);
	        WebElement thirdButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'btn-custom')])[3]")));
	        thirdButton.click();
	        Thread.sleep(2000);
	    }
		
		
		public void scrollToMiddleOfPage() {
	        long pageHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
	        jsExecutor.executeScript("window.scrollTo(0, " + pageHeight / 3 + ")");
	    }
	
		
		public void clickCheckoutButton() throws InterruptedException {
	        for (WebElement co : checkoutButtons) {
	            if (co.getText().contains("Checkout")) {
	                Thread.sleep(2000);
	                co.click();
	                break; // Assuming there's only one Checkout button, exit loop after clicking
	            }
	        }
	    }

		
		public void selectDropdownOption(String optionText) {
	        Select opselect = new Select(dropdown);
	        opselect.selectByVisibleText(optionText);
	    }

		
		public void selectSecondDropdownOption(String optionText) throws InterruptedException {
	        Thread.sleep(1000);
	        Select opselect2 = new Select(dropdown2);
	        opselect2.selectByVisibleText(optionText);
	    }
		
		
		public void enterTextInField2(String text) {
	        inputField2.sendKeys(text);
	    }

	    public void enterTextInField3(String text) {
	        inputField3.sendKeys(text);
	    }

	    public void enterTextInField4(String text) {
	        inputField4.sendKeys(text);
	    }

	    public void clickSubmitButton() {
	        submitButton.click();
	    }
	    
	    
	    public void enterTextInInputField3(String text) throws InterruptedException {
	        Thread.sleep(3000);
	        inputField5.sendKeys(text);
	    }
	    
	    
	    public void selectDynamicDropdownOption(String optionText) {
	        for (WebElement option : dynamicDropdownOptions) {
	            if (option.getText().contains(optionText) && option.getText().startsWith(optionText)) {
	                option.click();
	                break; 
	            }

	        }
	    }
	    
	    
	   
	    public void clickSubmitButton2() {
	        submitButton2.click();
	    }
	    
	    
	    public void downloadReceipt() throws InterruptedException {
	        Thread.sleep(3000);
	        String completed = completionMessage.getText();
	        System.out.println(completed + " downloaded your receipt");
	        downloadButton.click();
	    }
	    
	    
	    public void takeScreenshotAndClose(String screenshotPath) throws IOException, InterruptedException {
	        File sShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(sShot, new File(screenshotPath));
	        Thread.sleep(2000);
	        driver.close();
	    }
	    
	    
	    
	    
	}
	
	
	
	
	
	
	

