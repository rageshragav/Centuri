package Risk_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import objectrepository.CenturiAdminPage;
import objectrepository.CenturiLoginPage;

public class Login {
	public static  WebDriver driver;
	WebDriverWait wait ;
public void userlogin() throws InterruptedException {
	
	  
	 CenturiLoginPage clp = new CenturiLoginPage(driver, wait);
	 	
	 clp.user().sendKeys("james");
	 Thread.sleep(1000);
	clp.waitForVisibilityOfElementsignin().click();
	// clp.signinbutton().click();
	}

	@BeforeTest
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://demo-centuri.conevo.in/");
		 driver.manage().window().maximize();
		
		 wait = new WebDriverWait(driver, 160);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		 userlogin();
		/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		  
		 CenturiLoginPage clp = new CenturiLoginPage(driver);
		 	
		 clp.user().sendKeys("james");
		 Thread.sleep(1000);
		 clp.signinbutton().click();*/
		
		 
		 
	}


}
