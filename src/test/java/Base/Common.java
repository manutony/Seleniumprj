package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Common {
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		driver.get("https://www.expedia.com/");	
		driver.manage().window().maximize();
	}
}

