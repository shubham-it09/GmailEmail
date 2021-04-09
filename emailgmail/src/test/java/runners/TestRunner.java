package runners;
import java.io.File;
import com.cucumber.listener.Reporter;
import org.testng.annotations.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import dataProvider.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
				glue= {"stepDefinitions"},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				tags="@gmail",
				monochrome = true
				
		)

public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	//getting this particular class and all the properties mentioned in the cucumberoptions annotation
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	//runs after setupclass method(above) it is taking data provider name as featutre which is mentioned below feature method
		@Test(dataProvider = "features")
		public void feature(CucumberFeatureWrapper cucumberFeature )
		{
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		}
		
		@DataProvider
		public Object[][] features()
		{
			System.out.println("features are" +testNGCucumberRunner.provideFeatures());
			
//			Object test[][]=testNGCucumberRunner.provideFeatures();
//			
//			for(int i=0;i<test.length;i++)
//			{
//				for(int j=0;j<test.length;j++)
//				{
//					System.out.println("feature is "+test[i][j]);
//				}
//			}
			
			return testNGCucumberRunner.provideFeatures();
			
		}	
		@AfterClass(alwaysRun=true)
		public static void writeExtentReport() {
			ConfigFileReader configFileReader = new ConfigFileReader();
			 Reporter.loadXMLConfig(new File(configFileReader.getReportConfigPath()));
			 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		     Reporter.setSystemInfo("Selenium", "3.7.0");
		     Reporter.setSystemInfo("Maven", "3.5.2");
		     Reporter.setSystemInfo("Java Version", "1.8.0_151");	    			
		}
		@AfterClass(alwaysRun=true)
		public void tearDownClass() {
			
			testNGCucumberRunner.finish();
		}
}
