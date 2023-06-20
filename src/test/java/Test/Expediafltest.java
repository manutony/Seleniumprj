package Test;

//import java.time.Duration;

import org.testng.annotations.Test;

import Base.Common;
import Page.Expediaflpage;

public class Expediafltest extends Common{
	@Test
	public void Expediaflightcheck()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Expediaflpage ob=new Expediaflpage(driver);
		ob.flightoptionselection();
		ob.Leavingfrom();
		ob.Currentlocation("Brussels (BRU - Brussels-National)");
		ob.Goingto();
		ob.Destination("New York (NYC - All Airports)");
		ob.Traveller();
		ob.Adult();
		ob.Childen(2);
		ob.Economysellect();
		ob.Firstclassclcik();
		ob.departingdatepicker("July 2023","20");
		ob.dpdone();
		ob.Returningdatepicker("October 2023","7");
		ob.rtdone();
		ob.Searchbuttonclick();
		
	}

}
