package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

public class SelendroidTest {
	private WebDriver driver;

	/**
	 * Setup the environment before testing
	 * 
	 * @throws Exception
	 */
	@BeforeSuite
	public void setUp() throws Exception {

		// Start selendroid-standalone during test
		SelendroidConfiguration config = new SelendroidConfiguration();

		// Add the selendroid-test-app to the standalone server
		config.addSupportedApp("src/test-apk/APP.apk");

		// start the standalone server
		SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
		selendroidServer.launchSelendroid();

		// Create the selendroid capabilities
		SelendroidCapabilities capa = new SelendroidCapabilities("APP_ID");

		// Specify to use selendroid's test app
		// capa.setAut("io.selendroid.testapp:0.16.0");

		// Specify to use the Android device API 19
		// capa.setPlatformVersion(DeviceTargetPlatform.ANDROID22);

		// Don't request simulator, use real device
		capa.setEmulator(false);

		// capa.wait(10000000);

		// Create instance of Selendroid Driver
		driver = new SelendroidDriver(capa);

	}
	
	@Test
	public void firstTest() throws Exception {

		// Print the log
		System.out.print("Start executing test");
		
	}
	
	
	/**
	 * Stop the Selendroid driver
	 * 
	 */
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}
