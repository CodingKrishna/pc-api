import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class BaseTest extends TestCase{
		static WebDriver driver;
	
    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
    	System.out.println("BaseTest.runBeforeTestMethod()");
    	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
		driver.close();
		driver.quit();
		System.out.println("BaseTest.runAfterTestMethod()");
    }
    
    public void waitForElementToLoad(int waitTime){
    	try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void navigateToURL(String url){
    	driver.get(url);
    }
    
    public WebElement getElementById(String elementId){
    	return driver.findElement(By.id(elementId));
    }
   
    public WebElement getElementByClassName(String className){
    	return driver.findElement(By.className(className));
    }
    
    public WebElement getElementByName(String name){
    	return driver.findElement(By.name(name));
    }
    
}
