package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Expediaflpage {
		WebDriver driver;
		
		By flight=By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]/a/span");
		By fromclick= By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div/div/div[1]/button");
		By whereleavingfrom= By.xpath("//*[@id=\"location-field-leg1-origin\"]");
		//By brussel=By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/section/div/div[2]/div/ul/li[1]/div/button");
		By toclick=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div/div/div[1]/button");	
		By goingto = By.xpath("//*[@id=\"location-field-leg1-destination\"]");
		//By newyork=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/section/div/div[2]/div/ul/li[1]/div/button");
		By traveller=By.xpath("//*[@id=\"adaptive-menu\"]/button");
		By adults= By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[1]/div/button[2]/span");
		By child= By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[2]/div/button[2]/span");
		By childage=By.xpath("//*[@id=\"child-age-input-0-0\"]");
		By economy= By.xpath("//*[@id=\"preferred-class-input-trigger\"]");
		By firstclass= By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[4]/span");
		By searchbutton=By.xpath("//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button");
		By departing=By.xpath("//*[@id='d1-btn']");
		By returning=By.xpath("//*[@id='d2-btn']");
		By departingmonth=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2");
		By nxtbtnmonthdeparting=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]");
		By departingdate=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
		By dpdonebtn=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button");
		By returningmonth=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/h2");
		By nxtbtnmonthreturn=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/button[2]");
		By returndate=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");
		By rtdonebtn=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/button");
		

		
		public Expediaflpage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		
		public void flightoptionselection()
		{
			driver.findElement(flight).click();
		}
		
		public void Leavingfrom() 
		{
			driver.findElement(fromclick).click();
		}
		
		public void Currentlocation(String FromLoc)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//driver.findElement(fromclick).sendKeys(FromLoc);
			//driver.findElement(brussel).click();
			
			WebElement br = driver.findElement(whereleavingfrom);
			br.sendKeys(FromLoc);
			br.sendKeys(Keys.ENTER);
	
		}
		
		public void Goingto()
		{
			driver.findElement(toclick).click();
		}
		
		public void Destination(String ToLoc)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement br = driver.findElement(goingto);
			br.sendKeys(ToLoc);
			br.sendKeys(Keys.ENTER);
			
		}
		
		
		public void Traveller()
		{
			driver.findElement(traveller).click();
		}
		
		public void Adult()
		{
			driver.findElement(adults).click();
		}
		
		public void Childen(int Age)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(child).click();
			driver.findElement(childage).click();
			
			Select se = new Select(driver.findElement(childage));
			se.selectByIndex(Age);	
		}
		
		
		public void Economysellect()
		{
			driver.findElement(economy).click();
			
		}
		
		public void Firstclassclcik()
		{
			
			driver.findElement(firstclass).click();
		}
		
		
		public void departingdatepicker(String Mnth1,String daten1)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(departing).click();
		
		while(true)//month
		{
		WebElement month=driver.findElement(departingmonth);
		String month1=month.getText();
		if(month1.equals(Mnth1))
		{
			System.out.println(month1);
			break;
		}
		else
		{
			driver.findElement(nxtbtnmonthdeparting).click();
		}
		}
		//date
		List<WebElement> alldate= driver.findElements(departingdate);
		for(WebElement dateelement:alldate)
		{
			String date=dateelement.getAttribute("data-day");
			System.out.println(date);
			if(date.equals(daten1))
			{
				dateelement.click();
				System.out.println("date selected");
			}
			
		}
		}
		
		public void Returningdatepicker(String Mnth2,String daten2)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(returning).click();
		while(true)//month
		{
		WebElement month=driver.findElement(returningmonth);
		String month2=month.getText();
		if(month2.equals(Mnth2))
		{
			System.out.println(month2);
			break;
		}
		else
		{
			driver.findElement(nxtbtnmonthreturn).click();
		}
		}
		//date
		List<WebElement> alldater= driver.findElements(returndate);
		for(WebElement dateelement:alldater)
		{
			String date=dateelement.getAttribute("data-day");
			System.out.println(date);
			if(date.equals(daten2))
			{
				dateelement.click();
				System.out.println("date selected");
			}
			
		}
		}

	
		public void dpdone()
		{
			driver.findElement(dpdonebtn).click();
			
		}
		
		public void rtdone()
		{
			driver.findElement(rtdonebtn).click();
		} 
				
		public void Searchbuttonclick()
		{
			driver.findElement(searchbutton).click();
		}
	
		}

	

