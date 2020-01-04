
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	private void doLogin() {
		navigateToURL("http://www.pioneercoders.com");
		/*
		driver.findElement(By.className("login-btn")).click();
		driver.findElement(By.name("userName")).sendKeys("staticsatish@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		 */
		WebElement loginButton = getElementByClassName("login-btn");
		loginButton.click();
		
		WebElement userNameInput = getElementByName("userName");
		userNameInput.sendKeys("staticsatish@gmail.com");
		
		WebElement pwdInput = getElementByName("password");
		pwdInput.sendKeys("123456");
		  
		waitForElementToLoad(100);
		WebElement loginSubmitButton = getElementById("login-btn");
		loginSubmitButton.click();
	}
	
	
	@Test
	public void loginWithValidCredintiolsTest() {
		runBeforeTestMethod(); 
		doLogin();
		waitForElementToLoad(5000);
		String userName = driver.findElement(By.id("login-btn")).getText();
		Assert.assertTrue(userName != null || userName != "");
		runAfterTestMethod();
	}
	
	@Test
	public void logout() {
		runBeforeTestMethod();
		doLogin();
		waitForElementToLoad(5000);
		String userName = driver.findElement(By.id("login-btn")).getText();
		boolean isLoginButtonDisplayed =  driver.findElement(By.id("login-btn")).isDisplayed();
		Assert.assertTrue(isLoginButtonDisplayed);
		runAfterTestMethod();
	}
	
}
