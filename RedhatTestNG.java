package week6.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RedhatTestNG extends CommonTest {
	
	@BeforeClass
	public void setValues() {
		filename="RedhatRegistration";
		
	}
  @Test(dataProvider="supplyData")
  public void RedhatRegistration(String uname, String pwd, String mail, String phno) throws InterruptedException {
	//  ChromeDriver driver = new ChromeDriver();
//		driver.get("https://sso.redhat.com");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.id("rh-registration-link")).click();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("user.attributes.phoneNumber")).sendKeys(phno);
		Thread.sleep(2000);
		driver.findElement(By.id("regform-submit")).click();
		String text = driver.findElement(By.xpath("//div[@aria-label='Info Alert']//h4")).getText();
		String actualText="Verification email sent";
		if(text.contains(actualText)) {
			System.out.println("The account is registered successfully for "+uname);
		}
		else {
			System.out.println("Account not registered succesfully");
		}
		System.out.println(driver.getTitle());
	//	driver.close();
		
  }
}
