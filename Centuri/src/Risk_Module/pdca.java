package Risk_Module;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import objectrepository.CenturiAdminPage;
import objectrepository.CenturiLoginPage;

public class pdca extends Login {
	@Test
	//(dependsOnMethods = { "login" })
	public void pdca_availability() throws InterruptedException, IOException {
		 
		 CenturiAdminPage cap = new CenturiAdminPage(driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'START')]")));
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].click();",cap.adminstration());
		 Thread.sleep(2000);
		 cap.modules().click();
		 Thread.sleep(2000);
		 if(cap.pdcaicon().isDisplayed()) {
			 cap.pdcacheckbox().click();
			 cap.save().click();
		 }else {
			 System.out.println("icon not visible");
		 }
		 Thread.sleep(2000);
		 executor.executeScript("arguments[0].click();",cap.adminstration());
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Logga ut']")));
		 cap.logout().click();
		Thread.sleep(1000);
		WebElement signin = driver.findElement(By.xpath("//*[contains(text(),'Logga in')][1]"));
		signin.click();
		Thread.sleep(1000);
		//For comparing the actual and expected images
		/*File image = new File("/Users/conevo/eclipse-workspace/Centuri/images/expected.png");
		BufferedImage bfi = ImageIO.read(image);
		boolean status = Shutterbug.shootPage(driver).withName("actual").equals(bfi,0.1);
		Assert.assertTrue(status);*/
		Shutterbug.shootPage(driver).save("C:\\centuri\\screenshot\\");
		//*[text()='PDCA']
		boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='PDCA']")));
		Assert.assertTrue(status);
		
			
		
	}
	 
	
}
