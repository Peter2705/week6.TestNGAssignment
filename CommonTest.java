package week6.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommonTest {
	public ChromeDriver driver;
	public String filename;
//	@Parameters({"username","password"})
  @BeforeMethod
  public void preCondition() {
	  driver = new ChromeDriver();
	  driver.get("https://sso.redhat.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("rh-registration-link")).click();
  }
  
  @AfterMethod
  public void postCondition() {
	  driver.close();
  }
  
  @DataProvider(name="supplyData")
	public String[][] sendData() throws IOException {		
		ReadExcel exceldata=new ReadExcel();
		String[][] data = exceldata.readData(filename);
		return data;
	}
}
