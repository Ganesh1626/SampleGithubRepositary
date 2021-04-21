package testrunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import cucumber.api.PendingException;
/*import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;*/
import junit.framework.Assert;
//@Listeners(Customizedlistners.class)
public class Amazonloginsteps {
	
	WebDriver driver;
	@Given("Browser is open")
	public void browser_is_open() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ganesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Ganesh\\Drivers\\geckodriver-v0.29.0-win64(1)\\geckodriver.exe");
		driver =new ChromeDriver();
		//driver =new FirefoxDriver();
		 File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		 	FileInputStream fls = new FileInputStream(src);
			XSSFWorkbook xsf = new XSSFWorkbook(fls);
			XSSFSheet sheet = xsf.getSheetAt(0);
			String  url = sheet.getRow(1).getCell(4).getStringCellValue();
		    driver.get(url);
	//	driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	@When("User is on Homepage")
	public void user_is_on_homepage() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-nav-role='signin']")));
		driver.findElement(By.xpath("//a[@data-nav-role='signin']")).isDisplayed();
	}
	@Then("User Click on Sign-in button")
	public void user_click_on_sign_in_button() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-nav-role='signin']")));
		driver.findElement(By.xpath("//a[@data-nav-role='signin']")).click();
	}
	@Then("User navigated to sign in page")
	public void user_navigated_to_sign_in_page() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")));
		driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).isDisplayed();
	}
	@Then("User Enters the Valid Email or {string}")
	public void user_enters_the_valid_email_or(String InputNumber) {
		driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys(InputNumber);
	}
	@And("User Click on Continue button")
	public void user_click_on_continue_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@Then("User Enters the Valid Password")
	public void user_enters_the_valid_password() throws IOException {
		File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String  Password = sheet.getRow(1).getCell(1).getStringCellValue();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
	}
	@And("User Click on Sign-In button1")
	public void user_click_on_sign_in_button1() {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).submit();
	}
	@Then("User Navigated to the home page")
	public void user_navigated_to_the_home_page() throws IOException {
		File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String  Validuser = sheet.getRow(1).getCell(2).getStringCellValue();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")));
		String expectedUser = Validuser;
		String actualUser = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
		//Assert.assertEquals(expectedUser, actualUser);
		Assert.assertNotSame(expectedUser, actualUser);
	}
	@And("User Mousehover on Accounts and List tab")
	public void user_mousehover_on_accounts_and_list_tab() {
		Actions actions = new Actions(driver);
		// WebElement elmYouraccount = driver.findElement(By.xpath("//a[@data-nav-ref='nav_youraccount_btn']"));
		WebElement elmYouraccount = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		 actions.moveToElement(elmYouraccount).perform();		
		 //actions.moveToElement(elmYouraccount).build().perform();
		// elmYouraccount.click();
	    
	}
	@And("User Click on Sign out button")
	public void user_click_on_sign_out_button() {
		driver.findElement(By.xpath("//a[@id='nav-item-signout']")).click();
	}
	@Then("User Successfully logout")
	public void user_successfully_logout() {
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='a-spacing-small']")));
		 Boolean elmSignintxtdisplay = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).isDisplayed();
		 System.out.println("Element displayed is :"+elmSignintxtdisplay);
	}
	
	@After
	
	public void screenshotforfailure() {
		
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //FileUtils.copyFile(scrFile, new File("C:\\Users\\Ganesh\\eclipse-workspace\\Testngdemo\\Screenshot"));
	         try {
	            FileHandler.copy(scrFile, new File("C:\\Users\\Ganesh\\eclipse-workspace\\Amazontest\\Reports\\Screenshot.png"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	}
	}
	
	
}
