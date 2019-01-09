package iOS_Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class randomQA {
		
	DesiredCapabilities caps = new DesiredCapabilities();
	File iOS_app = new File("./APP_apk/Random_v8.0_apkpure.com.apk.ipa");
	String strIOSUdid = "dc32055c2a076cad92aac3ef29ab3f30a79e09c4";
	AppiumDriver<MobileElement> driver;
	@BeforeMethod
@Test
	public void verifyRandomQA() throws MalformedURLException, InterruptedException {
		String strIOSDeviceName = "Shahin";
		caps.setCapability("udid", strIOSUdid);
		caps.setCapability("deviceName", strIOSDeviceName + "(" + strIOSUdid + ")");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("No Reset", "true");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("appPackagae", iOS_app.getAbsolutePath());
		caps.setCapability("bundleId", "com.vasilchenko.randomfree");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("useNewWDA", "false");
		caps.setCapability("xcodeOrgId", "672XG8W726");
		caps.setCapability("xcodeSigningId", "iPhone Developer");
		driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		Thread.sleep(5000);
		
		//Verify Random
		driver.findElement(By.name("Random")).isDisplayed();
		//Generate Number
		driver.findElement(By.name("Generate number")).isDisplayed();
		driver.findElement(By.name("Generate number")).click();
		
		driver.findElement(By.name("Random number:")).isDisplayed();	
	
		driver.navigate().back();
	}
	
	@AfterMethod
	public void CloseDriver() throws InterruptedException {

		driver.quit();
	}
}